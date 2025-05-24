package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class LoginSteps {
    
    private WebDriver driver;
    
    public LoginSteps() {
        this.driver = WebDriverManager.getDriver();
    }
    
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }
    
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    
    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
    
    @Then("I should see the title {string}")
    public void i_should_see_the_title(String title) throws InterruptedException {
        WebElement pageTitle = driver.findElement(By.cssSelector(".title"));
        Assert.assertEquals(title, pageTitle.getText());
        Thread.sleep(10000);
        driver.quit();
    }
    
    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) throws InterruptedException {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertEquals(errorMessage, errorElement.getText());
        Thread.sleep(10000);
    }
}