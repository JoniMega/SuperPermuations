package generador;

import java.util.Vector;

import exceptions.UnexpectedValueException;

public class Generador {
	private int digits;
	private int easyNumCandidats;
	private int percent;
	private boolean modeEficient;
	
	private Vector<String> candidats = new Vector<String>();
	
	public Generador(int digits) throws UnexpectedValueException {
		this.digits=digits;
		this.easyNumCandidats=0;
		this.percent=10;
		this.modeEficient=false;
		System.out.println("EXECUCIÓ INICIADA");
		this.generarCandidats("", 1);
		if(comprovador()) System.out.println("COMPLETAT CORRECTAMENT");
	}
	public Generador(int digits, boolean eficient) throws UnexpectedValueException {
		this.digits=digits;
		this.easyNumCandidats=0;
		this.percent=10;
		this.modeEficient=eficient;
		System.out.println("EXECUCIÓ INICIADA");
		this.generarCandidats("", 1);
		if(comprovador()) System.out.println("COMPLETAT CORRECTAMENT");
	}
	
	public int getDigits() {
		return this.digits;
	}
	
	public int getNumCandidats(){
		return this.candidats.size();
	}
	
	private int expectedNumCandidats() {
		int aux=1;
		for(int i=1; i<=this.digits;i++) {
			aux=aux*i;
		}
		return aux;
	}
	
	private boolean comprovador() throws UnexpectedValueException {
		int aux=expectedNumCandidats();
		if(aux!=this.candidats.size()) throw new UnexpectedValueException(this.candidats.size(),aux);
		return true;
	}
	
	public Vector<String> getCandidats(){
		return this.candidats;
	}
	
	private void generarCandidats(String num, int aux) {
		if(aux>this.digits)return;
		for(int i=1;i<=digits;i++) {
			if(valid(num+"-"+i))
			if(aux>=this.digits) {
				candidats.addElement(num+"-"+i);
				if(!this.modeEficient)proces();
			}else {
				generarCandidats(num+"-"+i,aux+1);
			}
		}
	}
	
	//TODO Fer un Thread que vagi paral·lament imprimint el %
	private void proces() {
		this.easyNumCandidats++;
		double percent=(double)(this.easyNumCandidats)/(double)(expectedNumCandidats())*100;
		if(percent>=this.percent) {
			System.out.println(" "+this.percent+"%");
			this.percent=this.percent+10;
		}
	}
	
	private boolean valid(String num) {
		String aux[]=num.split("-");
		Vector<String> numeros = new Vector<String>();
		for (String i:aux) {	    
		    if(numeros.contains(i)) return false;
		    numeros.add(i);
		}
		return true;
	}
	
	//TODO fer una interficie SWING 
	public String toString() {
		String aux=
				"Num de digits per opcio: "+this.digits+"\n"+
				"Num opcions: "+
				this.getNumCandidats()+"\n";
		if(this.digits<=4)
		aux=aux+"Resultat: "+this.candidats+"\n";
		return aux;
	}
	
	public static void main (String [] args) throws UnexpectedValueException{
		Generador gen = new Generador(3);
		System.out.println(gen);
		//System.out.println(gen.getCandidats());
	}
}
