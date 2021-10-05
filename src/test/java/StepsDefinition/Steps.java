package StepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.AuthenticationPage;
import pages.HomePage;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    private final WebDriver driver = Hooks.driver;
    Response response;

    @Given("Create Account page is opened")
    public void openCreateAccount() {
        String email = RandomStringUtils.randomAlphanumeric(5) + "@mailsac.com";
        HomePage homepage = new HomePage(driver);
        homepage.signIn();
        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.enterEmail(email);
        authentication.clickCreateAccount();
    }


    @When("I submit form with {string} and {string}")
    public void submitFormFormWithName(String first_name, String last_name) {

        AuthenticationPage authentication = new AuthenticationPage(driver);
        authentication.enterPersonInfoFirstName(first_name);
        authentication.enterPersonInfoLastName(last_name);
        authentication.enterPersonInfoPassword("test_password");
        authentication.enterAddressFirstName("John");
        authentication.enterAddressLastName("Doe");
        authentication.enterAddressStreet("street");
        authentication.enterAddressCity("city");
        authentication.selectState("California");
        authentication.enterPostalCode("25115");
        authentication.enterMobilePhone("698756334");
        authentication.enterAlias("alias");
        authentication.clickSubmitAccount();
    }

    @Then("{string} account page is opened")
    public void accountPageIsOpened(String name) {
        AccountPage account = new AccountPage(driver);
        assertThat(account.verifySignOutButtonExists()).isTrue();
        assertThat(account.verifyUserInfoButtonExists(name)).isTrue();
    }

    @Given("I submit GET request to get pets with status: {string}")
    public void getPetsWithStatus(String status) {
        RequestSpecification request = RestAssured.given();
        response = request.get("/findByStatus?status=" + status);
    }

    @Given("I submit POST request to create pet with name: {string}")
    public void createPet(String name) {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        var id = Integer.valueOf(RandomStringUtils.randomNumeric(4));
        request.header("Content-Type", "application/json");
        requestParams.put("id", id);
        requestParams.put("name", name);
        request.body(requestParams.toJSONString());
        response = request.post();
    }


    @Given("I Set POST service api endpoint")
    public void setPostEndpoint() {
        RestAssured.baseURI = "https://petstore3.swagger.io/api/v3/pet";
    }

    @Then("Status code: {string} is displayed")
    public void statusCodeIsDisplayed(String code) {
        assertThat(response.getStatusCode()).isEqualTo(Integer.valueOf(code));
    }

    @And("Response contains node: {string} with value: {string}")
    public void responseContainsPetWithName(String node, String name) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        String name_ = jsonPathEvaluator.get(node);
        assertThat(name).isEqualTo(name_);
    }

    @And("I submit PUT request to update existing pet with status: {string}")
    public void updatePetWithName(String status) throws InterruptedException {
        RequestSpecification request = RestAssured.given();
        RequestSpecification request2 = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams2 = new JSONObject();
        var id = Integer.valueOf(RandomStringUtils.randomNumeric(4));
        request.header("Content-Type", "application/json");
        requestParams.put("id", id); // Cast
        requestParams.put("status", "available");
        request.body(requestParams.toJSONString());
        request.post();
        Thread.sleep(2000);
        requestParams2.put("id", id);
        requestParams2.put("status", status);
        request2.body(requestParams2.toJSONString());
        response = request2.put();
    }

    @And("I submit DELETE request to delete existing pet")
    public void deletePet() {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        var id = Integer.valueOf(RandomStringUtils.randomNumeric(4));
        request.header("Content-Type", "application/json");
        requestParams.put("id", id);
        requestParams.put("name", "name");
        request.body(requestParams.toJSONString());
        request.post();
        response = request.delete(String.valueOf(id));
    }

    @And("Response contains message {string}")
    public void responseContainsMessage(String message) {
        assertThat(response.body().asString()).contains(message);
    }

    @And("Response contains only nodes with status: {string}")
    public void responseContainsNodesWithStatus(String status) {
        ArrayList<String> list = response.jsonPath().get("status");
        for (String status_ : list) {
            assertThat(status_).isEqualTo(status);
        }
    }
}
