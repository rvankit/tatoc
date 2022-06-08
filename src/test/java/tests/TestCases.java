package tests;

import pages.ConnMysql;
import pages.HoverMenu;
import pages.QueryGate;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {

    WebDriver driver;

    @Before
    public void launchApplicaion(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankitsoni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc/advanced");
        driver.manage().window().maximize();
    }
    
     @Test
    public void clickOnMenuItem(){
        HoverMenu hm = new HoverMenu(driver);
        hm.clickOnMenu2();
    }

    @Test
    public void clickOnMenuItem(){
        HoverMenu hm = new HoverMenu(driver);
        hm.clickOnMenu2();
    }

    @Test
    public void inavlidLoginCredentials() {
        HoverMenu hm = new HoverMenu(driver);
        QueryGate qc = new QueryGate(driver);
        hm.clickOnMenu2();
        hm.clickOnGoNext();
        String symbol = qc.symbol();
        qc.loginToQueryGate("ankit", "test");
        qc.clickProceed();
        String errorMsg=driver.findElement(By.className("error")).getText();
        Assert.assertEquals("Error",errorMsg);
    }

    @Test
    public void validLoginCredentials() {
        HoverMenu hm = new HoverMenu(driver);
        QueryGate qc = new QueryGate(driver);
        hm.clickOnMenu2();
        hm.clickOnGoNext();
        String symbol = qc.symbol();
        ConnMysql connection = new ConnMysql();
        String id = connection.getId(symbol);
        String name = connection.getName();
        String passKey = connection.getPassKey();
        qc.loginToQueryGate(name, passKey);
        String heading= driver.findElement(By.cssSelector(".page h1")).getText();
        Assert.assertEquals("Query Gate",heading);
    }

    @After
    public void closeApplication(){
        driver.quit();
    }
}
