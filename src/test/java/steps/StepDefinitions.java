package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.net.MalformedURLException;

public class StepDefinitions {

    public static String featureName;
    public WebDriver driver = new ChromeDriver();

    private LoginPage loginPage;


    @Before
    public void before(){
        loginPage = new LoginPage(driver);
    }

    @After
    public void after() {
        driver.close();
    }

    @Given("a customer launches browser and enters url {string}")
    public void a_customer_launches_browser_and_enters_url(String string) {
       loginPage.launchApplication(string);
    }

    @Given("a customer clicks the Sign-in Button")
    public void a_customer_clicks_the_sign_in_button() {
        loginPage.signIN();
    }

    @Given("a customer is on the Login Page")
    public void a_customer_is_on_the_login_page() {
        String pageTitle=loginPage.pageTitle();
        Assert.assertEquals("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool",pageTitle);
    }

    @Given("Enters valid {string} and {string}")
    public void enters_valid_username_and_password(String username,String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Customer clicks the Sign-in Button")
    public void customer_clicks_the_sign_in_button() {
       loginPage.submit();
    }

    @Then("Customer should login to the home page")
    public void customer_should_login_to_the_home_page() {
        String pageTitle=loginPage.pageTitle();
        Assert.assertEquals("Run Selenium Tests in 2000+ Desktop and Mobile Browsers",pageTitle);
    }


    @Given("Enter invalid {string} and {string}")
    public void enter_invalid_username_and_Password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("Customer should not login to the home page")
    public void customer_should_not_login_to_the_home_page() {
        String pageTitle=loginPage.pageTitle();
        Assert.assertNotEquals("Run Selenium Tests in 2000+ Desktop and Mobile Browsers",pageTitle);
    }

    @Then("Login page should display message {string}")
    public void login_page_should_display_message(String string) {

       String message=loginPage.getMessage();
       Assert.assertEquals(string,message);

    }

}