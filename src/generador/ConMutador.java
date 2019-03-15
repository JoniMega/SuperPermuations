package generador;

import java.util.Vector;

import exceptions.UnexpectedValueException;

public class ConMutador {
	private Generador gen;
	private String solucio;
	
	public ConMutador(Generador gen) {
		this.gen=gen;
	}
	
	public void metode() {
		Vector<String> candidats = gen.getCandidats();
		this.solucio=candidats.elementAt(0);
		String aux=solucio.substring(2,this.solucio.length());
		candidats.removeElementAt(0);
		int index=0;
		for(int i=1; i<gen.getNumCandidats();i++) {
			//index=buscar la posicio del vector aquell qui encaixi
			this.solucio=this.solucio+candidats.get(index);
			candidats.removeElementAt(index);
		}
		System.out.println(solucio);
		
	}
	
	private int buscar(String num, Vector<String> candidats, int digits) {
		num=num.substring(0, (this.gen.getDigits()-digits)*2);
		for(int i=0; i<candidats.size();i++) {
			candidats.elementAt(0);
			if(candidats.elementAt(i).substring((this.gen.getDigits()-digits)*2, this.gen.getDigits()*2).equals(num)) {
				return i;
			}
		}
		if(digits>= this.gen.getDigits()) {
			return buscar(num, candidats,digits+1);
		}
		return 0;
	}
	
	public static void main (String [] args) throws UnexpectedValueException{
		Generador gen = new Generador(3);
		System.out.println(gen);
		ConMutador con = new ConMutador(gen);
		con.metode();
		System.out.println();
	}
	
}
 