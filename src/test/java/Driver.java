import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lera\\Desktop\\תלושים\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }
}