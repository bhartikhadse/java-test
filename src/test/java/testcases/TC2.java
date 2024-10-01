package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import base.BaseObjects;
import utilities.ReadExcelDataFW;

public class TC2 extends BaseObjects {
	@Test(dataProviderClass = ReadExcelDataFW.class, dataProvider = "bvtDataFW")
	public static void LoginTest(String username, String password) {
		System.out.println("username: " + username + "password: " + password);
		driver.findElement(By.linkText(signIn_link_field)).click();
		driver.findElement(By.id(email_field)).sendKeys(username);
		driver.findElement(By.id(next_btn_field)).click();
		driver.findElement(By.id(password_field)).sendKeys(password);
		driver.findElement(By.id(login_next_field)).click();
		driver.findElement(By.xpath(skip_link_field)).click();
		System.out.println("User logged in");
	}

}
