package Com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws Exception {
		String url="https://magento.com";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		FileInputStream fis = new FileInputStream("src\\Login\\LOG");
		Properties p = new Properties();
		p.load(fis);
		
		String myacc = p.getProperty("Myacc");
		System.out.println("The Myacc is: " + myacc);
		String email = p.getProperty("email");
		System.out.println(email);
		String pwd = p.getProperty("pwd");
		System.out.println(pwd);
		String login = p.getProperty("login");
		System.out.println(login);
		String logout = p.getProperty("logout");
		System.out.println(logout);
		
		driver.findElement(By.xpath(myacc)).click();
		driver.findElement(By.xpath(email)).sendKeys("subramanyaraj87@gmail.com");
		driver.findElement(By.xpath(pwd)).sendKeys("Welcome123");
		driver.findElement(By.xpath(login)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(logout)).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
