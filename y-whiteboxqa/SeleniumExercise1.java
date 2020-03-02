package com.wbl.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumExercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "/Users/yamuna/Downloads/chromedriver");

		driver = new ChromeDriver();
        //Launch URL
		driver.get("http://automationpractice.com/index.php");

		driver.manage().window().maximize();
        
		//Login to account
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

		driver.findElement(By.name("email")).sendKeys("training.qaprep@gmail.com");

		driver.findElement(By.name("passwd")).sendKeys("Testing123");

		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        
		//Mouse hover and selecting T-shirts
		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).perform();

		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();

		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")))
				.perform();

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();
		
		//Selecting size, quantity and color
		driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]")).click();

		Select oSelect = new Select(driver.findElement(By.id("group_1")));

		oSelect.selectByVisibleText("L");

		driver.findElement(By.name("Orange")).click();
		
		//adding items to cart
		driver.findElement(By.name("Submit")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		//proceeding to checkout and completing buying process
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
		driver.findElement(By.id("cgv")).click();

		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        
		//Assert the text to confirm purchase
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Your order on My Store is complete."));

		driver.quit();
	}

}
