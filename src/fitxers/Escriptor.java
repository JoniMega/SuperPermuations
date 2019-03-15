package fitxers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class Escriptor {
	private PrintWriter escriptor;
	private String filename;
	
	public Escriptor(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		this.escriptor = new PrintWriter(filename, "UTF-8");
		this.filename=filename;
	}
	
	public void add(String num) {
		this.escriptor.print(num);
	}
	
	public void add(Vector<String> candidats) {
		
	}
	
	public void finiquitao() {
		this.escriptor.close();
	}
}
