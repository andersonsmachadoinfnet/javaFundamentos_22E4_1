package br.anderson.infnet.appDr4TP3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
public class AppController {
	@GetMapping(value = "/")
	public String telaIndex() {
		return "index";
	}
	
/*	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
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
	*/
}
