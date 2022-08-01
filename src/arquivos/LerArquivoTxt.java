package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws IOException {

		//Ler Arquivo .txt
		//FileInputStream entradaArquivo = new FileInputStream(new File(
		//		"C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo.txt"));
		
		//Ler Arquivo .csv
		  FileInputStream entradaArquivo = new FileInputStream(new File(
				"C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\arquivos\\arquivo.csv"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<>();

		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			
			//Remove Linhas em branco
			if(linha != null && !linha.isEmpty()){
				
				//Separa dados pelo demilitador
				String[] dados = linha.split("\\;");
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);
			}

			
		}
		
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}		

	}
}
