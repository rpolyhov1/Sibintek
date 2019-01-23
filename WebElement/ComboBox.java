package WebElement;

import org.openqa.selenium.WebElement;

public class ComboBox extends Element {
	WebElement element;

	public ComboBox(WebElement element) {
		this.element = element;
	}

	protected void fill(String value) {
		element.click();
		findSubElement(element, ".//*[contains(text(),'" + value + "')]").click();

	}

}
