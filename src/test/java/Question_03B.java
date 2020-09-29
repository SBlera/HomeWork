import org.openqa.selenium.Alert;
import org.testng.Assert;

public class Question_03B {
    public static void main(String[] args) {
        Utils.InsertUrl("https://dgotlieb.github.io/Navigation/Navigation.html");
        Utils.FindByID("MyPrompt").click();
        Alert MyPrompt = Driver.getDriverInstance().switchTo().alert();
        MyPrompt.sendKeys("Lera");
        String MyUpdatedPrompt = MyPrompt.getText();
        Assert.assertEquals(MyUpdatedPrompt, "Lera");

    }
}

