package muzika;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prodavnica {
	private String ime;
	private String lokacija;
	private List<Artikal> inventar = new ArrayList<Artikal>();
	
	public Prodavnica(String ime, String lokacija) {
		this.ime = ime;
		this.lokacija = lokacija;
	}
	
	public void dodaj(Artikal artikal) {
		inventar.add(artikal);
	}
	
	public void kupi(int idArtikla) {
		for(Artikal a: inventar) {
			if(a.getId() == idArtikla) {
				a.kupi();
				return;
			}
		}
	}
	public List<Artikal> pretrazi(String tekst){
		List<Artikal> lista = new ArrayList<Artikal>();
		for(Artikal a: inventar) {
			if(a.ime().toLowerCase().contains(tekst.toLowerCase()))
				lista.add(a);
		}
		
		return lista;
	}
	public String toString() {
		String buffer = String.format("%s: %s [", ime, lokacija);
		for(Artikal a: inventar) {
			buffer += String.format("\n\t%s", a.toString());
		}
		buffer+="\n]";
		return buffer;
	}
}
