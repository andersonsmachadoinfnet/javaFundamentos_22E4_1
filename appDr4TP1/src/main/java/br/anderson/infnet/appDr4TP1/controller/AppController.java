package br.anderson.infnet.appDr4TP1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

@RestController
public class AppController {
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String helloWorld() {
		return "Olá estou ativo!";
	}
	
	@RequestMapping(value = "/personagem/{codigo}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String personagem(@PathVariable Integer codigo) {
		try {
			URL url = new URL("https://swapi.dev/api/people/"+codigo); 
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("Erro no servidor da Star Wars: " + responseCode);
			} else {
				StringBuilder sb = new  StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				sb.append("Consulta efetuada na api: https://swapi.dev");
				sb.append("Retorno (Sem alteração):");
				sb.append("----------------------------------------------");
				
				
				while (scanner.hasNext()) {
					sb.append(scanner.nextLine());
				}
				
				scanner.close();
				
				return sb.toString();		
			}	
		} catch(Exception e) {
			return e.toString();
		}
	}
}
