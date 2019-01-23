package test;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import WebElement.Button;
import WebElement.SeachBlock;


public class StartTest {
	
	public static String link;
	public static String fileName;
	
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() throws IOException {
		return new FileOperation().readFromXLSForDataProvider(fileName);
	}

	@Test(dataProvider = "data-provider")
	public void cianSeach(Object... data) {
		
		DriverManager.getDriver().get(link);
				
		/*Заполнение блока с параметрами для поиска, Нажимаем кнопку найти, проверяем что старница с результатами поиска загрузилась за 10 секунд P.S при дальнейшей реализации выделяется в отдельный слой*/
		new SeachBlock("//div[contains(@class,'c-filters-form')][1]").fill(data);
		new Button("//button[text()='Найти']").click();
		assertTrue(new Button().findElementAndVerifyVisibilityOf(10, "//button[text()='Сохранить в файл Excel']"), "Не дождались загрузки страницы с результатами поиска ");
		
	}
	
	
	@BeforeSuite
	@Parameters({ "link", "fileName" })
	public void setUpSuite(@Optional String link, @Optional String fileName) {
		this.link = link;
		this.fileName = fileName;

	}

	@AfterSuite

	public void tearDownSuite() {
		DriverManager.getDriver().close();

	}

	}			
		
		
		
				




