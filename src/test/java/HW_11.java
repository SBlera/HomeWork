import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class HW_11 {


    private static WebDriver driver;
    private static NgWebDriver ngWebDriver;

    @BeforeClass
    public static void RunBeforClass() {
        driver = Driver.getDriverInstance();
        ngWebDriver = new NgWebDriver((JavascriptExecutor)driver);
        Utils.InsertUrl("https://dgotlieb.github.io/Selenium/synchronization.html");
    }

    //Q1
    @Test
    public void Test01_TestImplicitWait() {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Utils.FindByID("checkbox").isDisplayed();
        Utils.FindByID("btn").click();
        Utils.FindByID("message").isDisplayed();
    }

    @Test
    public void Test02_TestSleep() throws InterruptedException {
        Utils.FindByID("hidden").click();
        Thread.sleep(5000);
        Utils.FindByID("finish1").isDisplayed();
    }

    @Test
    public void Test03_TestExplicitWait() {
        Utils.FindByID("rendered").click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        String NewElementText = driver.findElement(By.id("finish2")).getText();
        assertEquals(NewElementText, "This is a new element");
    }

    //2
    @Test
    public void Test04_angularAssertTest() {
        driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
        ngWebDriver.waitForAngularRequestsToFinish();
        WebElement firstname = driver.findElement(ByAngular.model("firstName"));
        firstname.clear();
        firstname.sendKeys("Daniel");
        assertEquals(driver.findElement(By.xpath("//input")).getAttribute("value"), "Daniel");
    }

    //3
    @Test
    public void Test05_TestGetAlertText() {
        Utils.InsertUrl("https://dgotlieb.github.io/Navigation/Navigation.html");
        Utils.FindByID("MyAlert").click();
        Alert TextOfMyAlert = driver.switchTo().alert();
        System.out.println("The text of my alert is:" + "" +TextOfMyAlert.getText());
        TextOfMyAlert.accept();
    }

    @Test
    public void Test06_TestPromptAlert() {
        Utils.InsertUrl("https://dgotlieb.github.io/Navigation/Navigation.html");
        Utils.FindByID("MyPrompt").click();
        Alert PromptAlert = driver.switchTo().alert();
        PromptAlert.sendKeys("Lera");
        PromptAlert.accept();
        String Input = "Lera";
        assertEquals(Input, driver.findElement(By.id("output")).getText());

    }

    @Test
    public void Test07_TestConfirmBox() {
        Utils.FindByID("MyConfirm").click();
        Alert ConfirmBox = driver.switchTo().alert();
        ConfirmBox.accept();
        String OutPut = "Confirmed";
        assertEquals(OutPut, Utils.FindByID("output").getText());
    }


    @Test
    public void Test08_TestHandlingTabs() {
        String OriginalTab = driver.getWindowHandle();
        Utils.FindByID("openNewTab").click();
        ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
        NewTab.remove(OriginalTab);
        driver.switchTo().window(NewTab.get(0));
        System.out.println("Tab text is: " + Utils.FindByID("new_tab_container").getText());
        String output = "This is a new Tab";
        assertEquals(output, Utils.FindByID("new_tab_container").getText());
        driver.close();
        driver.switchTo().window(OriginalTab);
        assertEquals("Navigation", Utils.FindByID("title").getText());
    }

    @Test
    public void Test09_TestWindows() {
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a[href='newWindow.html']")).click();
        for (String winHandle : driver.getWindowHandles()) { //Switch to new window opened
            driver.switchTo().window(winHandle);
        }
        System.out.println("Tab text is: " + driver.findElement(By.id("new_window_container")).getText());
        String output = "This is a new Window";
        assertEquals(output, driver.findElement(By.id("new_window_container")).getText());
        driver.close();
        driver.switchTo().window(winHandleBefore);
        assertEquals("Navigation", driver.findElement(By.id("title")).getText());
    }

    //4
    // the pageLoadTimeout limits the time that the script allots for a web page to be displayed

    //5 + 6
//    @Test
//    public void Test11_use_utils() {
//        System.out.println(Utils.getCurrentDate());
//        System.out.println(Utils.getOS());
//    }
//
//    //7
//    @Test
//    public void Test12_POM() throws InterruptedException {
//        driver.get("https://dgotlieb.github.io/WebCalculator");
//        System.out.println(driver.findElement(By.id(Constants.SEVEN)).getSize());
//        System.out.println(driver.findElement(By.id("six")).isDisplayed());
//        WebCalculatorPage.pressFive();
//        WebCalculatorPage.pressPlus();
//        WebCalculatorPage.pressFive();
//        WebCalculatorPage.pressEquals();
//        Thread.sleep(1000);
//        String expectedResult = "10";
//        assertEquals(expectedResult, WebCalculatorPage.getResult());
//    }

//    @AfterClass
//    public void afterAll() {
//        driver.quit();
//    }
}