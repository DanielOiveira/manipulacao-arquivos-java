package arquivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
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
		
		//Gera Arquivo .txt
		//File arquivo = new File("C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo.txt");
		
		//Gera Arquivo .csv
		File arquivo = new File("C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}

		FileWriter escreverArquivo = new FileWriter(arquivo);
		
		for(Pessoa p: pessoas) {
			escreverArquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escreverArquivo.flush();
		escreverArquivo.close();
	}

}
