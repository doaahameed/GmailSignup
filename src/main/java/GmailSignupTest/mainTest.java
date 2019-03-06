package GmailSignupTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.dataReader;

public class mainTest {
		
	public WebDriver driver;
	dataReader datareaderobj;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");

		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void signUp() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		datareaderobj = new dataReader();
		datareaderobj.readData();

		driver.findElement(By.xpath("//div[@class = 'gb_xc']/a[@target='_top']")).click();
		System.out.println(datareaderobj.useremail);
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(datareaderobj.useremail);

		driver.findElement(By.xpath("//div[@role='button'and@id='identifierNext']")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement password = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		password.sendKeys(datareaderobj.password);

		driver.findElement(By.id("passwordNext")).click();

		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement Gmail = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Gmail')]")));
		Gmail.click();

		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(datareaderobj.receipentMail);

		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(datareaderobj.mailTitle);
		driver.findElement(By.xpath("//div[@role='button' and text()='Send']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sent']")).click();	

		driver.findElement(By.xpath("//*[normalize-space(text())and normalize-space(.)='Conversations'][1]/following::tr[1]/td[6]")).click();
		Thread.sleep(5000);
		String title = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
		System.out.println(title);

		Assert.assertEquals(title, datareaderobj.mailTitle);
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}

