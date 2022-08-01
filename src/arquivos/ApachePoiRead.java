package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiRead {

	public static void main(String[] args) throws Exception {

		FileInputStream entrada = new FileInputStream(new File(
				"C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo_excel.xls"));

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);// Prepara a entrada do arquivo para leitura
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);// Pega a primeira planilha do arquivo

		Iterator<Row> linhaIterator = planilha.iterator();

		List<Pessoa> pessoas = new ArrayList<>();

		while (linhaIterator.hasNext()) { // Enquanto houver linha no arquivo
			Row linha = linhaIterator.next(); // Dados da pessoa na linha

			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();

			while (celulas.hasNext()) { // Percorrer as células
				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}
			}

			pessoas.add(pessoa);
		}

		entrada.close(); // Fim da Leitura do Arquivo

		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}
