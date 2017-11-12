package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;
    private By menuInputAlert = By.xpath("//a[contains(text(), 'Input Alert')]");
    private By buttonRaiseAlert = By.xpath("//button");
    private By iframe = By.xpath("//iframe[@src='alert/input-alert.html']");
    private By textAfterAlert = By.id("demo");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void displayAlertBox() {
        driver.findElement(menuInputAlert).click();
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(buttonRaiseAlert).click();
    }

    public void acceptAlert(String msg) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(msg);
        alert.accept();
    }

    public String getTextAfterAlert() {
        return driver.findElement(textAfterAlert).getText();
    }
}
