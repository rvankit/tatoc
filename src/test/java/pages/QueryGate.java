package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QueryGate {

    WebDriver driver;

    By symbol = By.id("symboldisplay");
    By name = By.id("name");
    By passKey = By.id("passkey");
    By submit = By.id("submit");

    public QueryGate(WebDriver driver){
        this.driver=driver;
    }

    public String symbol(){
        String textSymbol= driver.findElement(symbol).getText();
        System.out.println(textSymbol);
        return textSymbol;
    }

    public void loginToQueryGate(String u_name, String u_pass){
        driver.findElement(name).sendKeys(u_name);
        driver.findElement(passKey).sendKeys(u_pass);
    }

    public void clickProceed(){
        driver.findElement(submit).click();
    }
}
