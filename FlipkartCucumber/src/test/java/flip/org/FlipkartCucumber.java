package flip.org;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartCucumber {
	public static WebDriver driver;
	@Given("login to flipkart")
	public void login_to_flipkart() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https:\\www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("shameer");
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("0815151");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(4000);
	}

	@When("search for gadgets")
	public void search_for_gadgets() throws Exception {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("gadgets",Keys.ENTER);
		Thread.sleep(4000);
		WebElement filter=driver.findElement(By.xpath("//span[text()='Filters']"));
		filter.click();
		
	  
	}

	@When("click on gadgets")
	public void click_on_gadgets() {
		WebElement clk = driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[15]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(false)",clk);
	 driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[15]")).click();
		String parent=driver.getWindowHandle();
		Set<String>child=driver.getWindowHandles();
		for(String x:child) {
			if(!parent.equals(x)){
				driver.switchTo().window(x);
			}
		}
	}
	
	@When("click on buynow")
	public void click_on_buynow() throws Exception {
	   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();
	   Thread.sleep(4000);
	}

	@Then("payment page")
	public void payment_page() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _20xBvF _3AWRsL']")).click();
	}



}

