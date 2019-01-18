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

	// �������� ������ ����� � ������
	protected void readFromXLS(String fileName) throws IOException {

		try {
			inputStream = new FileInputStream(fileName);
			workBook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workBook.getSheetAt(0);//��������� ������ ���� �� xls �����

		//��������� ������ ������ � ������ ������ �����
		for (Row row : sheet) {
			ArrayList<String> request = new ArrayList<>();
			for (int i = 0; i < row.getLastCellNum(); i++) {
				request.add(row.getCell(i) == null ? "" : getValue(row.getCell(i)));
			}
			listfromFile.put(row.getRowNum(), request);
		}

	}

	// �������� ��������� ������ get ������� � cian.ru �� ����� ������ � ����� 
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

	// ��������� �������� ��������� ������� ����� 
	protected Set<Integer> getSetId() {
		return listfromFile.keySet();
	}

	// ��������� �������� ��������������  ������
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
