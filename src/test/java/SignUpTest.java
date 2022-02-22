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
    public void zipCode(){
        /*
        1.Открыть браузер
        2. Перейти по ссылке https://www.sharelane.com/cgi-bin/register.py
        3. Вводим 5 цифр, например 12345
        4.Нажать Continue
        5.Проверить, что кнопка Register видна
        6.Вводим поле First name, например Illia
        7.Вводим поле Last name, например Abramovich
        8.Вводим поле Email, например i.a6ram@gmail.com
        9.Вводим поле Password, например pipika
        10. Вводим поле Confirm password, например pipika
        11. Закрыть браузер
         */

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDispLayed =driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDispLayed);

            driver.findElement(By.name("first_name")).sendKeys("Illia");
            driver.findElement(By.name("last_name")).sendKeys("Abramovich");
            driver.findElement(By.name("email")).sendKeys("i.a6ram@gmail.com");
            driver.findElement(By.name("password1")).sendKeys("pipika");
            driver.findElement(By.name("password2")).sendKeys("pipika");
            driver.findElement(By.cssSelector("[value=Register")).click();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDoun(){
        driver.quit();
    }
}
