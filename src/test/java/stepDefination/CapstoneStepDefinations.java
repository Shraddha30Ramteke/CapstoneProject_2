package stepDefination;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Test
public class CapstoneStepDefinations extends BaseClass{
	//ChromeDriver driver;
	String title;
	//public class CapstoneStepDefinitions {

	
		  public static WebDriver driver;
		    public String mainWindowHandle;
		    
		    //@BeforeClass
		    @Given("I launch the URL {string}")
		   
		    public void launchURL(String url) {
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("http://webdriveruniversity.com/index.html/");
		        mainWindowHandle = driver.getWindowHandle();
		        title = driver.getTitle();
				System.out.println(title);
				
				/*
				 * driver = new ChromeDriver();
				 * driver.get("http://the-internet.herokuapp.com/"); title = driver.getTitle();
				 * System.out.println(title);
				 */
		           
		        
		    }
		    
		     
		    @Test
		    @Then("the title of the page should be {string}")
		    public void verifyTitle(String expectedTitle) {
		        String actualTitle = driver.getTitle();
		        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match expected title");
		        System.out.println(title);
		        
		    }
  
		    @Test
		    @When("I click on the IFRAME link")
		    public void clickIFRAMELink() {
		        WebElement iframeLink = driver.findElement(By.xpath("//*[text()='IFRAME']"));
		        iframeLink.click();
		    }

		    @Then("a new tab should open and I switch to that tab")
		    public void switchToNewTab() {
		        Set<String> handles = driver.getWindowHandles();
		        for (String handle : handles) {
		            if (!handle.equals(mainWindowHandle)) {
		                driver.switchTo().window(handle);
		                break;
		            }
		        }
		    }

		    @Test
		    @And("I verify the presence of the Image")
		    public void verifyImagePresence() {
		        WebElement image = driver.findElement(By.xpath("//html//body//div[1]//div//div//div[1]//div//div//div//div[1]//img"));
		        Assert.assertTrue(image.isDisplayed(), "Image is not displayed");
		    }

		    @Test
		    @When("I click on the right arrow button")
		    public void clickRightArrowButton() {
		        WebElement rightArrowButton = driver.findElement(By.xpath("//html//body//div[1]//div//div//div[1]//div//div//a[2]//span"));
		        rightArrowButton.click();
		    }

		    @Test
		    @Then("the images should change accordingly")
		    public void verifyImagesChange() {
		        // Implement verification logic for image change
		    }

		    
		   
		   // @AfterClass
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();
		        }
		    }
	}

