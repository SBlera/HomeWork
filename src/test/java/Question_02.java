import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class Question_02 {

    @BeforeClass
    public static void runOnceBeforeClass() {
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) Driver.getDriverInstance());
        ngWebDriver.waitForAngularRequestsToFinish();
        Driver.getDriverInstance().get(" https://dgotlieb.github.io/AngularJS/main.html");
    }

    @Test
    public void test01_ClearSendAndAssertName() {
        WebElement SentName = Driver.getDriverInstance().findElement(ByAngular.model("firstName"));
        SentName.clear();
        SentName.sendKeys("Lera");
        assertEquals(SentName.getAttribute("value"),"Lera");

    }

    @AfterClass
    public static void tearDown() {
        Driver.getDriverInstance().quit();
    }
}
