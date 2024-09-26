package logica;

import java.io.IOException;

import datos.ManejadorArchivo;

public class LogicaCifrador {
	
	private ManejadorArchivo miManejadorArchivo;
	
	public LogicaCifrador() {
		miManejadorArchivo = new ManejadorArchivo("archivo_cifrado.tdp");
	}
	
	public String cifrar(String texto) {
		texto = texto.replace('a', '1');
		texto = texto.replace('e', '2');
		texto = texto.replace('i', '3');
		texto = texto.replace('o', '4');
		texto = texto.replace('u', '5');
		texto = texto.replace('A', '6');
		texto = texto.replace('E', '7');
		texto = texto.replace('I', '8');
		texto = texto.replace('O', '9');
		texto =  texto.replace('U', '0');
		return texto;
	}
	
	public void guardarTexto(String texto) throws IOException {
		miManejadorArchivo.escribirEnArchivo(texto);
	}
	
	public String leerTexto() throws IOException {
		return miManejadorArchivo.leerDeArchivo();
	}
	
}
