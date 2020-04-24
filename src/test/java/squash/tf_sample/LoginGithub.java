package squash.tf_sample;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginGithub {

    public static WebDriver driver;
    @Given("user is  on homepage")
    public void user_is_on_homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
    }
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.id("login_field")).click();
    }
    @And("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys("hafsa.13chafii@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("samantaguapita3");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    }
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        String exp_message = "Learn Git and GitHub without any code!";
        String actual = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/h2[1]")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();
    }
}
