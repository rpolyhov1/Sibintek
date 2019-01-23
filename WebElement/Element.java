package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.DriverManager;

public class Element {
	WebElement element;
	WebDriver driver;

	public Element() {
		this.driver = DriverManager.getDriver();
	}

	// операция поиска  под элемента на странице с ожиданием доступности для операций
	public WebElement findElement(String xpath) {
		
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(element = driver.findElement(By.xpath(xpath))));
		return element;

	}

	// операция поиска элемента на странице с ожиданием доступности для операций
	public WebElement findSubElement(WebElement superElement, String xpath) {

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(element = superElement.findElement(By.xpath(xpath))));
		return element;

	}

	// операция проверки отображения элемеента на странице в течении заданного времени
	public Boolean findElementAndVerifyVisibilityOf(Integer time,String xpath) {

		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element = driver.findElement(By.xpath(xpath))));
			return true;
		} catch (Exception e) {
			return false;
		}

	}


}
