package muzika;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private List<Numera> lista = new ArrayList<Numera>();
	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
	}
	
	void dodaj(Numera num) {
		lista.add(num);
	}
	void dodaj(String name, String trajanje) {
		lista.add(new Numera(name,izvodjac,trajanje));
	}

	public String getNaziv() {
		return naziv;
	}
	
	public String getIzvodjac() {
		return izvodjac;
	}

	public Date getDatum() {
		return datum;
	}
	
	public String getTrajanje() {
		int trajanje = 0;
		for(int i=0;i<lista.size();i++) {
			String[] razbijeno = lista.get(i).getTrajanje().split(":");
			trajanje += Integer.parseInt(razbijeno[0])*60 + Integer.parseInt(razbijeno[1]);
		}
		return String.format("%d:%d", trajanje/60, trajanje%60);
	}
	
	public Numera getNumera(int index) {
		return lista.get(index);
	}
	public Numera getNumera(String ime) {
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNaizv().equals(ime))
				return lista.get(i); //cim ga pronadjemo vracamo
		}
		//ako smo dosli do ovde sigurno nije pronadjeno
		return null;
	}
	public String toString() {
		String buffer = String.format("%s - %s(%d):[", izvodjac,naziv,datum.getYear());
		for(int i=0;i<lista.size();i++) {
			buffer += String.format("\n\t%s", lista.get(i).toString());
		}
		buffer += String.format("\n]: %s\n",getTrajanje());
		
		return buffer;
	}
}
