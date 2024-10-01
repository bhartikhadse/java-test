package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import base.BaseObjects;

public class TC1 extends BaseObjects {
	@Test(dataProvider = "testdata")
	public static void login(String username, String password) {
		System.out.println("username: " + username + "password: " + password);
		driver.findElement(By.linkText(signIn_link_field)).click();
		driver.findElement(By.id(email_field)).sendKeys(username);
		driver.findElement(By.id(next_btn_field)).click();
		driver.findElement(By.id(password_field)).sendKeys(password);
		driver.findElement(By.id(login_next_field)).click();
		driver.findElement(By.xpath(skip_link_field)).click();

		System.out.println("User logged in");
	}

	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] { { "test1@gmail.com", "test123" }, { "test2@gmail.com", "test123" } };
	}
}
