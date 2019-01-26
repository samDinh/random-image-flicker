package sdn.flicker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sdn.flicker.error.EmptyDirectoryException;
import sdn.flicker.service.RandomFileFinderService;

@RestController
public class RandomFileFinderController {
	
	@Autowired
	RandomFileFinderService fileFinder;
	
	@RequestMapping(value = "/random", method = RequestMethod.GET, produces = "image/jpg")
	public byte[] getRandomFile() throws IOException, EmptyDirectoryException {
		return fileFinder.fetchRandomFileData();
	}

}
