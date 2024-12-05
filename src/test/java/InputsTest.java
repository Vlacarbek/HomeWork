import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void InputsTest() {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("123");
        softAssert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "123", "Поле должно содержать число 123");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("Всем привет и здасте");
        softAssert.assertNotEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "Всем привет и здасте", "Поле не должно содержать Всем привет и здасте ");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("10");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String TenAfterArrowUp = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(TenAfterArrowUp, "11", "После нажатия значение должно быть 11");
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("10");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String TenAfterArrowDown = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(TenAfterArrowDown, "9", "После нажатия значение должно быть 9");

    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}




