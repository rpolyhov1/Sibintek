package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class FileOperation {

	String result;
	InputStream inputStream;
	HSSFWorkbook workBook;
	HashMap<Integer, ArrayList<String>> listfromFile = new HashMap<>();;
	static ArrayList<String> parameter;
	static ArrayList<String> valueParameter;

	// операция чтения файла в массив
	protected void readFromXLS(String fileName) throws IOException {

		try {
			inputStream = new FileInputStream(fileName);
			workBook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workBook.getSheetAt(0);//считываем первый лист из xls файла

		//Считываем массив данных с каждой строки листа
		for (Row row : sheet) {
			ArrayList<String> request = new ArrayList<>();
			for (int i = 0; i < row.getLastCellNum(); i++) {
				request.add(row.getCell(i) == null ? "" : getValue(row.getCell(i)));
			}
			listfromFile.put(row.getRowNum(), request);
		}

	}

// операция получения строки get запроса к cian.ru из одной строки в файле 
	protected String getLink(int position) {
		String str = Run.linkForPrint;
		parameter = listfromFile.get(0);
		valueParameter = listfromFile.get(position);
		int i = 0;
		for (String value : valueParameter) {
			if (!(value.equals(""))) {
				str += "&" + parameter.get(i) + "=" + value;
			}
			i++;
		}
		return str;

	}

	// сервисная операция получения номеров строк 
	protected Set<Integer> getSetId() {
		return listfromFile.keySet();
	}

	// сервисная операция форматирование  данных
	private String getValue(Cell cell) {
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return Integer.toString((int) cell.getNumericCellValue());
		case FORMULA:
		default:
			return Double.toString(cell.getNumericCellValue());
		}

	}

}
