package com.sdn.randomimageflicker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestRandomFileFinderService extends RandomImageFlickerApplicationTests {

	@When("^the client ask for a random file$")
	public void the_client_ask_for_a_file() {

	}

	@Given("^there is only one file and it is at the root of the default folder$")
	public void one_file_in_root_folder() {

	}

	@Given("^there is only one file and it is in a sub-folder of the default folder$")
	public void one_file_in_sub_folder() {

	}

	@Given("^the default folder is empty$")
	public void no_file() {

	}

	@Then("^the client receives the only one file from the default folder$")
	public void get_file_from_root_folder() {

	}

	@Then("the client receives the file in the sub-folder$")
	public void get_file_from_sub_folder() {

	}

	@Then("an exception is thrown$")
	public void get_exception() {

	}

}
