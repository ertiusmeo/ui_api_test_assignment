package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationPage extends BasePage {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    final By txtEmail = By.id("email_create");
    final By btnCreateAccount = By.id("SubmitCreate");
    final By txtPersonInfoFirstName = By.id("customer_firstname");
    final By txtPersonInfoLastName = By.id("customer_lastname");
    final By txtPersonInfoPassword = By.id("passwd");
    final By txtAddressFirstName = By.id("firstname");
    final By txtAddressLastName = By.id("lastname");
    final By txtAddressStreet = By.id("address1");
    final By txtAddressCity = By.id("city");
    final By txtAddressPostalCode = By.id("postcode");
    final By txtAddressMobilePhone = By.id("phone_mobile");
    final By txtAddressAlias = By.id("alias");
    final By btnSubmitAccount = By.id("submitAccount");
    final By ddlAddressState = By.id("id_state");

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail)).sendKeys(email);
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateAccount)).click();
    }

    public void enterPersonInfoFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPersonInfoFirstName)).sendKeys(firstname);
    }

    public void enterPersonInfoLastName(String lastname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPersonInfoLastName)).sendKeys(lastname);
    }

    public void enterPersonInfoPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPersonInfoPassword)).sendKeys(password);
    }

    public void enterAddressFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressFirstName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressFirstName)).sendKeys(firstname);
    }

    public void enterAddressLastName(String lastname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressLastName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressLastName)).sendKeys(lastname);
    }

    public void enterAddressStreet(String street) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressStreet)).sendKeys(street);
    }

    public void enterAddressCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressCity)).sendKeys(city);
    }

    public void enterPostalCode(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressPostalCode)).sendKeys(city);
    }

    public void enterMobilePhone(String mobile_phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressMobilePhone)).sendKeys(mobile_phone);
    }

    public void enterAlias(String alias) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressAlias)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddressAlias)).sendKeys(alias);
    }

    public void clickSubmitAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmitAccount)).click();
    }

    public void selectState(String state) {
        Select state_ = new Select(driver.findElement(ddlAddressState));
        state_.selectByVisibleText(state);
    }


}
