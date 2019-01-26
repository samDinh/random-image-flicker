package sdn.flicker.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import sdn.flicker.error.EmptyDirectoryException;

@Service
public class RandomFileFinderService {

//	private String root_directory = "D:\\Pictures\\references";
	private String root_directory = "D:\\Pictures\\references";
	

	public Path fetchRandomFilePath() throws IOException, EmptyDirectoryException {
		List<Path> fileList = getFileList(root_directory);
		fileList.removeIf(Files::isDirectory);
		if(fileList.isEmpty()) {
			throw new EmptyDirectoryException();
		}
		return getRandomFileFromList(fileList);
	}

	private List<Path> getFileList(String directory) throws IOException {
		List<Path> fileList = Files.list(Paths.get(directory)).collect(Collectors.toList());
		fileList.addAll(getFilesListFromAllSubDirectories(fileList));
		return fileList;
	}

	private List<Path> getFilesListFromAllSubDirectories(List<Path> fileList) {
		return fileList.stream()
		.filter(Files::isDirectory)
		.flatMap(path -> {
			try {
				return getFileList(path.toString()).stream();
			} catch (IOException e) {
				return Stream.of();
			}
		})
		.collect(Collectors.toList());
	}

	private Path getRandomFileFromList(List<Path> fileList) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(fileList.size());
		return fileList.get(randomIndex).toAbsolutePath();
	}

	public byte[] fetchRandomFileData() throws IOException, EmptyDirectoryException {
		return Files.readAllBytes(fetchRandomFilePath());
	}

	public void setRoot_directory(String root_directory) {
		this.root_directory = root_directory;
	}
}
