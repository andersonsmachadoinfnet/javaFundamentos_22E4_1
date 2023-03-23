package br.anderson.infnet.appDr4TP3.API;

import java.io.BufferedReader;
import java.io.IOException;

public class util {
	public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }

}
