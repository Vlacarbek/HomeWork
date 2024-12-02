import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

public class HomeWork_b {

        WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/checkboxes");
        }

        @Test
        public void Quest_b() {

            WebElement [] checkboxes = driver.findElements(By.cssSelector("[type=checkbox]")).toArray(new WebElement[0]);

            WebElement OneCheckbox = checkboxes[0];
            Assert.assertFalse(OneCheckbox.isSelected(), "Первый чекбокс должен быть unchecked");
            OneCheckbox.click();
            Assert.assertTrue(OneCheckbox.isSelected(), "Первый чекбокс должен быть checked");

            WebElement TwoCheckbox = checkboxes[1];
            Assert.assertTrue(TwoCheckbox.isSelected(), "Второй чекбокс должен быть checked");
            TwoCheckbox.click();
            Assert.assertFalse(TwoCheckbox.isSelected(), "Второй чекбокс должен быть unchecked");

        }
        @AfterMethod(alwaysRun = true)
        public void quit() {
            driver.quit();
        }
    }

