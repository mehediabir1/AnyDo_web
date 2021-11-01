import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AnyDo {
    WebDriver driver;

    //Setting Up Browser and Account
    @BeforeClass
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://desktop.any.do");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div[3]/div/div/div/div[1]/div/div/div/div[1]/button[3]")).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div[3]/div/div/div/div[2]/div/div[2]/form/div/input"))).click();
        WebElement EmailInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div[3]/div/div/div/div[2]/div/div[2]/form/div/input"));
        EmailInput.sendKeys("mymail@mail.com");
        EmailInput.sendKeys(Keys.ENTER);

        new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div[3]/div/div/div/div[2]/div/div[2]/form[2]/div/input"))).click();
        WebElement PassInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div[3]/div/div/div/div[2]/div/div[2]/form[2]/div/input"));
        PassInput.sendKeys("password");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/section/div/div[3]/div/div/div/div[2]/div/div[2]/form[2]/button[2]")).click();
    }

    //Test Cases

    @Test
    public void TC00_1(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.className("AppHeaderNewTaskButton__button__text")).click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement TaskName= driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/section/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div/div"));
        TaskName.click();
        TaskName.sendKeys("MyTask for QUPS");
        TaskName.sendKeys(Keys.ENTER);
//        driver.findElement(By.className("ButtonsBar__button")).click();
    }
    @Test
    public void TC00_2(){

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("AppHeaderNewTaskButton__button__text")).click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement TaskName= driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/section/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div/div"));
        TaskName.click();
        TaskName.sendKeys("My Friday Task");

        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/form/section/div/div/div/div[1]/div[1]/div[2]/div[2]/div/button")).click();

        WebElement NotesText = driver.findElement(By.className("DynamicTextArea__visibleTextArea"));
        NotesText.click();
        NotesText.sendKeys("Hangout with friends");
//        TaskName.sendKeys(Keys.ENTER);
//        driver.findElement(By.className("ButtonsBar__button")).click();
    }
}
