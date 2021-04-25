package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void launchApplication(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @FindBy(linkText="Sign in")
    private WebElement mainPage_sign_in_btn;

    @FindBy(id="user_email_login")
    private WebElement userName;

    @FindBy(id="user_password")
    private WebElement password;

    @FindBy(name="commit")
    private WebElement submitBTN;

    @FindBy(xpath="//*[@id=\"signin_signup_form\"]/div[2]/div/div[1]/div[5]/div/div/div/span")
    private WebElement errorMessage;

    public void signIN(){
        mainPage_sign_in_btn.click();
    }

    public String pageTitle(){

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }

       return driver.getTitle();
    }


    public void enterUsername(String userName)
    {
        this.userName.clear();
        this.userName.sendKeys(userName);
    }

    public void enterPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void submit()
    {
        //To scroll down to view the submit button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBTN);
        submitBTN.click();
    }

    public String getMessage()
    {
        return errorMessage.getText();
    }
}
