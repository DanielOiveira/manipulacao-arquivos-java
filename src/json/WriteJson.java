package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class WriteJson {
	public static void main(String[] args) throws IOException {
		
		// Escrevendo Arquivo JSON
		
		String CAMINHO = "C:\\Users\\DESKTOP\\eclipse-workspace\\manipulacao-arquivos-java\\src\\json\\usuarios.json";
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("38654365490");
		usuario1.setLogin("kiko");
		usuario1.setSenha("7890789");
		usuario1.setNome("Frederico Florindo");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("44567890834");
		usuario2.setLogin("chaves");
		usuario2.setSenha("7899012");
		usuario2.setNome("Chesperito Chavo");
		
		
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Organiza estrutura do Json
		
		String jsonUser = gson.toJson(usuarios); //Converte para Json
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = 
				new FileWriter(CAMINHO);
		
		fileWriter.write(jsonUser); // Escreve Json
		fileWriter.flush();
		fileWriter.close();
		
		
		// Lendo Arquivo JSON
		
		FileReader fileReader = new FileReader(CAMINHO);
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listaUsuarios = new ArrayList<>();
		
		for(JsonElement jsonElement: jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listaUsuarios.add(usuario);
		}
		
		System.out.println("Leitura do Arquivo JSON: " + listaUsuarios);
	}
}
