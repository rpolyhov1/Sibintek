package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

/** 
 * Программа для загрузки с cian.ru результатов поиска аренды квартиры
 * Исходный файл Data1.xls(файл расширяемый (в соответсвии с потребностями))
 * deal_type- тип сделки,offer_type- тип предложения,room1-room6: 1 комнатная -6 комнатная квартира, room7,room9 свободная планировка, студия. 
 * Результаты поиска выгружаются в каталог "Result" в xlsx файл, в формате сайта cian.ru Для каждого запроса отдельный файл.
 * @autor Полюхов Роман
 * @version 0.1
*/
public class Run {
	static WebDriver driver;
	static String fileName = "Data1.xls";// наименование файла с данными
	static String linkForPrint = "https://www.cian.ru/export/xls/offers/?currency=2&engine_version=2";// базовая строка get запроса печати в xls файл результатов поиска

	public static void main(String[] args) throws IOException {

		FileOperation fileOperation = new FileOperation();
		fileOperation.readFromXLS(fileName); //читаем файл

		//для каждой не пустой строки xls страницы 
		for (int position : fileOperation.getSetId()) {
			if (position != 0)
				DriverManager.getDriver().get(fileOperation.getLink(position));// выгружаем отчет по всем строкам раннее считанного файла (кроме строки с "шапкой")	
		}

	}

}
