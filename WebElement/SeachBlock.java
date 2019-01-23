package WebElement;

import org.openqa.selenium.WebElement;

public class SeachBlock extends Element {
	String xpath;
	WebElement seachBlock;

	public SeachBlock(String xpath) {
		this.xpath = xpath;
		seachBlock = findElement(xpath);
	}

	public void fill(Object[] data) {
		new ComboBox(findSubElement(seachBlock, ".//div[1]")).fill(data[0].toString());// Заполнения типа сделки
		new ComboBox(findSubElement(seachBlock, ".//div[2]")).fill(data[1].toString());// Заполнение типаобъекта
		new ListBox(findSubElement(seachBlock, ".//div[3]")).fill(data);// заполнения кол-ва комнат
		new Input(findSubElement(seachBlock, ".//input[@placeholder='от']")).fill(data[10].toString());// заполнение минимальной цены
		new Input(findSubElement(seachBlock, ".//input[@placeholder='до']")).fill(data[11].toString());// заполнение максимальной цены
	}

}
