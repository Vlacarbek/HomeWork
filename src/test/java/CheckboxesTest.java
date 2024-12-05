import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void CheckboxesTest() {
        SoftAssert softAssert = new SoftAssert();
        WebElement[] checkboxes = driver.findElements(By.cssSelector("[type=checkbox]")).toArray(new WebElement[0]);
        WebElement OneCheckbox = checkboxes[0];
        softAssert.assertFalse(OneCheckbox.isSelected(), "Первый чекбокс должен быть unchecked");
        OneCheckbox.click();
        softAssert.assertTrue(OneCheckbox.isSelected(), "Первый чекбокс должен быть checked");
        WebElement TwoCheckbox = checkboxes[1];
        softAssert.assertTrue(TwoCheckbox.isSelected(), "Второй чекбокс должен быть checked");
        TwoCheckbox.click();
        softAssert.assertFalse(TwoCheckbox.isSelected(), "Второй чекбокс должен быть unchecked");

    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}

