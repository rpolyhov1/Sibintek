package WebElement;

import org.openqa.selenium.WebElement;

public class Button extends Element {
	String xpath;
	WebElement element;

	public Button(String xpath) {
		this.xpath = xpath;
		element = findElement(xpath);
	}
	public Button() {
		
	}

	public void click() {
		element.click();
	}
}
