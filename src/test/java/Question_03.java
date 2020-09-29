import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Objects;

public class Question_03 {

    @Test
    public void TestMyAlert() {
        Utils.InsertUrl("https://dgotlieb.github.io/Navigation/Navigation.html");
        Utils.FindByID("MyAlert").click();
        String TextOfMyAlert = Driver.getDriverInstance().switchTo().alert().getText();
        System.out.println("The text of my alert is:" + "" + TextOfMyAlert);
        Driver.getDriverInstance().close();
    }

        @Test
        public void TestMyPrompt () {
        Utils.InsertUrl("https://dgotlieb.github.io/Navigation/Navigation.html");
        Utils.FindByID("MyPrompt").click();
        Driver.getDriverInstance().switchTo().alert().sendKeys("Lera");


        }
    }

