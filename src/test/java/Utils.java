import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void Q1ClickRemoveCheckBoxAndWait(){
        Driver.getDriverInstance().findElement(By.xpath("//*[@id=\"btn\"]")).click();
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public static void Q1ClickShowHiddenAndWait() throws InterruptedException {
        Driver.getDriverInstance().findElement(By.xpath("//*[@id=\"hidden\"]")).click();
        Thread.sleep(5000);
    }

    public static void Q1ClickRenderAndWait() {
        Driver.getDriverInstance().findElement(By.xpath("//*[@id=\"rendered\"]")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriverInstance(), 20);

    }

    public static void InsertUrl(String url){
        Driver.getDriverInstance().get(url);
        Driver.getDriverInstance().manage().window().maximize();
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public static WebElement FindByID(String ID){
        WebElement FoundById = Driver.getDriverInstance().findElement(By.id(ID));
        return FoundById;
    }
}

