package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		//Gera Arquivo .xls (excel)
		File file = new File("C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo_excel.xls");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Michael Jackson");
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Elvys Presley");
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(38);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Marilyn Monroe");
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(30);
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //Escreve na planilha
		HSSFSheet linhasPessoas = hssfWorkbook.createSheet("Planilha de Pessoas"); // Cria a Planilha
		
		int numeroLinha = 0;
		
		for(Pessoa pessoa : pessoas ) {
			Row linha = linhasPessoas.createRow(numeroLinha++); //Cria Linha na Planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++); //Celula 1
			celNome.setCellValue(pessoa.getNome());
			
			Cell celEmail = linha.createCell(celula++); // Celula 2
			celNome.setCellValue(pessoa.getEmail());
			
			Cell celIdade = linha.createCell(celula++); // Celula 3
			celNome.setCellValue(pessoa.getIdade());
		}
		
		//Após montar a Planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		
		hssfWorkbook.write(saida); // Escreve dados na Planilha
		saida.flush();
		saida.close();
		
		System.out.println("Planilha criada  :)");
	}
}
