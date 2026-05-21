package com.app.user.ui.steps;

import com.app.user.ui.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationSteps {
    private final RegistrationPage registrationPage;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserRegistrationSteps() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        this.registrationPage = new RegistrationPage(driver, wait);
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        driver.get("http://localhost:8080/register");
    }

    @When("I fill in the registration form with valid details")
    public void iFillInTheRegistrationFormWithValidDetails(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);
        registrationPage.fillRegistrationForm(data.get("firstName"), data.get("lastName"), data.get("email"), data.get("password"), data.get("phoneNumber"));
    }

    @When("I fill in the registration form with an existing email")
    public void iFillInTheRegistrationFormWithExistingEmail(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);
        registrationPage.fillRegistrationForm(data.get("firstName"), data.get("lastName"), data.get("email"), data.get("password"), data.get("phoneNumber"));
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        registrationPage.submitForm();
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        assertTrue(registrationPage.isSuccessMessageDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(registrationPage.isErrorMessageDisplayed());
    }
}