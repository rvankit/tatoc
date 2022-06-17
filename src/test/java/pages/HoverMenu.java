package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoverMenu {

    WebDriver driver;

    By menuTitle = By.className("menutitle");
    By goNext = By.xpath("//span[contains(@class,'menuitem') and contains(text(), 'Go Next')]");

    public HoverMenu(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnMenu2(){
        driver.findElement(menuTitle).click();
    }
   
    
    

    public void clickOnGoNext() {
        driver.findElement(goNext).click();
    }
}
