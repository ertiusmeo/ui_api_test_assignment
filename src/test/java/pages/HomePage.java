package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    final By btnSignIn = By.xpath(" //a[contains(text(),'Sign in')]");


    public void signIn() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSignIn)).click();

    }

}
