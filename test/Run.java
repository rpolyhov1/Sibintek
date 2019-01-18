package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class Run {
	static WebDriver driver;
	static String fileName = "Data1.xls";// ������������ ����� � �������
	static String linkForPrint = "https://www.cian.ru/export/xls/offers/?currency=2&engine_version=2";// ������� ������ get ������� ������ � xls ���� ����������� ������

	public static void main(String[] args) throws IOException {

		FileOperation fileOperation = new FileOperation();
		fileOperation.readFromXLS(fileName); //������ ����

		//��� ������ �� ������ ������ xls �������� 
		for (int position : fileOperation.getSetId()) {
			if (position != 0)
				DriverManager.getDriver().get(fileOperation.getLink(position));// ��������� ����� �� ���� ������� ������ ���������� ����� (����� ������ � "������")	
		}

	}

}
