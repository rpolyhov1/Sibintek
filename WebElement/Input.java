package WebElement;

import org.openqa.selenium.WebElement;

public class Input extends Element {

	WebElement element;

	public Input(WebElement element) {
		this.element = element;
	}

	protected void fill(String value) {
		element.clear();
		element.sendKeys(value);
	}

}
