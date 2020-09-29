import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Question_01{

    public static void main(String[] args) throws InterruptedException {

        //question 1
        Utils.InsertUrl("https://dgotlieb.github.io/Selenium/synchronization.html");
        Utils.Q1ClickRemoveCheckBoxAndWait();
        Utils.Q1ClickShowHiddenAndWait();
        Utils.Q1ClickRenderAndWait();

    }

}
