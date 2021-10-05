package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    final By btnSignOut = By.className("logout");

    public boolean verifySignOutButtonExists() {
        try {
            driver.findElement(btnSignOut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyUserInfoButtonExists(String name) {
        try {
            driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
