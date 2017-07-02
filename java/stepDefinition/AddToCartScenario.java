package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddToCartScenario {
	
	public static WebDriverWait wait;
	public static WebDriver driver;
	String applicationURL="http://ebay.com";
	
    @Given("^launch to ebay application outline$")   
    public void launchBrowser() throws Throwable
    {
    	System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		 driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(applicationURL);
        wait = new WebDriverWait(driver, 100);
    }

    @When("^search products outline$")
    public void searchproducts() throws Throwable
    {
        driver.findElement(By.id("gh-ac")).sendKeys("Scenario Outline");
        driver.findElement(By.id("gh-btn")).click();
    }
    
    @Then("^successfully retrieve outline$")
    public void search_Successfully() throws Throwable
    {
        System.out.println("successfully retrived");
        Thread.sleep(10000);
    }
    
     
     @When("^select product from results outline$")
    public void clickonproducts() throws Throwable
    {
    	 
         WebElement imgProduct=driver.findElement(By.xpath("//ul[@id='ListViewInner']//h3//a[1]"));
          Actions actions = new Actions(driver);
  		actions.moveToElement(imgProduct);
  		Thread.sleep(2000);
  		actions.click().build().perform();	
  		
  		driver.findElement(By.id("isCartBtn_btn")).click();			
  	      System.out.println("Successfully select the product");
    }

    @Then("^add to cart outline$")
    public void addedtocart() throws Throwable
    {
        String Msg = driver.findElement( By.xpath("//span[contains(text(),'was just added to your cart')]")).getText();
               
        System.out.println("Selected product successfully added to cart  "+Msg);
            
           
        

    }

	
	
   
	

}
