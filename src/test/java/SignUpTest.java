import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void zipCode() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDispLayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDispLayed);

    }
    @Test
    public void zipCodePozitive(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Illia");
        driver.findElement(By.name("last_name")).sendKeys("Abramovich");
        driver.findElement(By.name("email")).sendKeys("i.a6ram@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("pipika");
        driver.findElement(By.name("password2")).sendKeys("pipika");
        driver.findElement(By.cssSelector("[value=Register")).click();
        boolean isDisplayed= driver.findElement(By.className("confirmation_message")).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @Test
    public void zipCodeNegative1() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDispLayed = driver.findElement(By.className("error_message")).isDisplayed();
        Assert.assertTrue(isDispLayed);
    }
    @Test
    public void zipCodeNegative2(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDispLayed = driver.findElement(By.className("error_message")).isDisplayed();
        Assert.assertTrue(isDispLayed);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDoun(){
        driver.quit();
    }
}
