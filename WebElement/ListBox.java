package WebElement;

import java.util.HashMap;
import org.openqa.selenium.WebElement;

public class ListBox extends Element {
	HashMap<Integer, String> mapCountRooms;

	public ListBox(WebElement element) {
		this.element = element;
		mapCountRooms = new HashMap<Integer, String>() {
			{
				put(1, "1-комнатная");
				put(2, "2-комнатная");
				put(3, "3-комнатная");
				put(4, "4-комнатная");
				put(5, "5-комнатная");
				put(6, "6-комнатная");
				put(7, "Студия");
				put(8, "Свободная");
			};
		};
	}

	protected void fill(Object[] data) {
		element.click();

		for (int i = 0; i < 8; i++) {
			if (!"".equals(data[i + 2])) {
				findSubElement(element, ".//*[contains(text(),'" + mapCountRooms.get(i + 1) + "')]").click();

			}

		}

	}
}
