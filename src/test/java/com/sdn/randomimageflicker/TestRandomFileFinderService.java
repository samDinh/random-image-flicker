package com.sdn.randomimageflicker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sdn.flicker.error.EmptyDirectoryException;
import sdn.flicker.service.RandomFileFinderService;

public class TestRandomFileFinderService extends RandomImageFlickerApplicationTests {

	@Autowired
	private RandomFileFinderService finder;
	
	String result;

	@When("^the client ask for a random file$")
	public void the_client_ask_for_a_file() throws IOException, EmptyDirectoryException {
		result = finder.fetchRandomFilePath();
	}

	@Given("^there is only one file and it is at the root of the default folder$")
	public void one_file_in_root_folder() {
		finder.setRoot_directory(".\\src\\test\\resources\\testFolder");

	}

	@Given("^there is only one file and it is in a sub-folder of the default folder$")
	public void one_file_in_sub_folder() {
		finder.setRoot_directory(".\\src\\test\\resources\\testFolder2");
	}

	@Then("^the client receives the only one file from the default folder$")
	public void get_file_from_root_folder() {
		assertThat(result).isEqualTo(".\\src\\test\\resources\\testFolder\\testFile.jpg");
	}

	@Then("the client receives the file in the sub-folder$")
	public void get_file_from_sub_folder() {
		assertThat(result).isEqualTo(".\\src\\test\\resources\\testFolder2\\testSubFolder\\testFile2.jpg");
	}

	@Test
	public void testFetchRandomFilePath_empty_directory_case() {
		finder.setRoot_directory(".\\src\\test\\resources\\testFolder3");
		try {
			result = finder.fetchRandomFilePath();
			fail("should have thrown EmptyDirectoryException");
		} catch (IOException e) {
			fail("should have thrown EmptyDirectoryException");
		} catch (EmptyDirectoryException e) {
		}
	}

}
