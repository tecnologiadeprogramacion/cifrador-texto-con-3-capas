package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivo {
	
	private String nombreArchivo;
	
	public ManejadorArchivo(String nombre) {
		nombreArchivo = nombre;
	}
	
	public void escribirEnArchivo(String texto) throws IOException {
		BufferedWriter archivo;
		archivo = new BufferedWriter(new FileWriter(nombreArchivo));
		archivo.write(texto);
		archivo.close();
	}
	
	public String leerDeArchivo() throws IOException {
		String lineaLeida;
		String textoLeido = "";
		BufferedReader archivo;
		
		archivo = new BufferedReader(new FileReader(nombreArchivo));
		while((lineaLeida = archivo.readLine()) != null) {
			textoLeido += lineaLeida;
		}
		archivo.close();
		return textoLeido;
	}	
	
}
