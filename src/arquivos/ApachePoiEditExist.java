package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditExist {

	public static void main(String[] args) throws Exception {

		File file = new File("C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); //Entrada do arquivo xls
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Planilha
		
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) { //Enquanto houver linha
			Row linha = linhaIterator.next(); // Dados na Linha
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + " * Valor gravado em aula");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		
		saida.flush();
		saida.close();
		
		System.out.println("Planilha Atualizada ;)");
	}
}
