package br.com.proj.util;

import java.io.IOException;

public class ManipulaService {
	public static void shut_server() 
	{ 
		//Localiza��o do Servidor de aplica��o
		String lien = "D:\\Sistemas-Distribuidos\\apache-tomcat-8.0.43\\bin";
	      try {
	        Runtime.getRuntime().exec(lien+"\\shutdown.bat");
	        System.out.println("Servi�o desligado!");
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	        System.out.println("Erro ao parar servidor! ");
	    }
	}
}
