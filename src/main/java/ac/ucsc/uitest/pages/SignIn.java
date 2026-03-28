package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn extends BasePage{

   private static final By EMAIL_FIELD = By.xpath("//input[@id='email']");

   private static final By PASSWORD_FIELD = By.xpath("//input[@id='password']");

   private static final By SHOW_PASSWORD = By.xpath("(//button[normalize-space()='Show'])[1]");

    private static final By HIDE_PASSWORD = By.xpath("(//button[normalize-space()='Hide'])[1]");

   private static final By REMEMBER_MY_CREDENTIALS = By.xpath("(//input[@type='checkbox'])[1]");

   private static final By SIGN_IN = By.xpath("(//button[normalize-space()='Sign in'])[1]");

   private static final By CREATE_ACCOUNT = By.xpath("(//button[normalize-space()='Sign in'])[1]");

    public SignIn(WebDriver driver) {
        super(driver);
    }

   public void clickShowPassword() {
        click(SHOW_PASSWORD);
    }

    public void clickHidePassword() {
        click(HIDE_PASSWORD);
    }

    public void RememberMyCredentials() {
        click(REMEMBER_MY_CREDENTIALS);
    }

    public void clickSignIn() {
        click(SIGN_IN);
    }

    public void clickCreateAccount() {
        click(CREATE_ACCOUNT);
    }

    public void EmailField(String text) {type(EMAIL_FIELD, text);}

    public void PasswordField(String text) {type(PASSWORD_FIELD, text);}



}
