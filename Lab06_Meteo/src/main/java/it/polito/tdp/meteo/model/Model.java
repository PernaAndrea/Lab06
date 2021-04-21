package it.polito.tdp.meteo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.meteo.DAO.MeteoDAO;

public class Model {
	
	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;

	private MeteoDAO dao;
	
	public Model() {

		dao = new MeteoDAO();
	}

	// of course you can change the String output with what you think works best
	public String getUmiditaMedia(int mese) {
		
		Map<String,Float> CittaUmiditaMedia = new HashMap<String,Float>();
		List<Rilevamento> GenovaRilevamenti = new ArrayList<Rilevamento>(dao.getAllRilevamentiLocalitaMese(mese,"Genova"));
		List<Rilevamento> MilanoRilevamenti = new ArrayList<Rilevamento>(dao.getAllRilevamentiLocalitaMese(mese,"Milano"));
		List<Rilevamento> TorinoRilevamenti = new ArrayList<Rilevamento>(dao.getAllRilevamentiLocalitaMese(mese,"Torino"));
		
		//Citta Genova = new Citta("Genova",dao.getAllRilevamenti("Genova"));
		//Citta Milano = new Citta("Milano",dao.getAllRilevamenti("Milano"));
		//Citta Torino = new Citta("Torino",dao.getAllRilevamenti("Torino"));
		
		float mediaUmiditaMilano = 0;
		float mediaUmiditaGenova = 0;
		float mediaUmiditaTorino = 0;
		
		String tot = "";
		
		for(Rilevamento r : GenovaRilevamenti) {
			mediaUmiditaGenova += r.getUmidita();
		}
		mediaUmiditaGenova = mediaUmiditaGenova/GenovaRilevamenti.size();
		CittaUmiditaMedia.put("Genova", mediaUmiditaGenova);
		tot += "Città Genova: umidità "+mediaUmiditaGenova +"\n";
		
		for(Rilevamento r : MilanoRilevamenti) {
			mediaUmiditaMilano += r.getUmidita();
		}
		mediaUmiditaMilano = mediaUmiditaMilano/MilanoRilevamenti.size();
		CittaUmiditaMedia.put("Milano", mediaUmiditaMilano);
		tot += "Città Milano: umidità "+mediaUmiditaMilano +"\n";
		
		for(Rilevamento r : TorinoRilevamenti) {
			mediaUmiditaTorino += r.getUmidita();
		}
		mediaUmiditaTorino = mediaUmiditaTorino/TorinoRilevamenti.size();
		CittaUmiditaMedia.put("Torino", mediaUmiditaTorino);
		tot += "Città Torino: umidità "+mediaUmiditaTorino ;
		
		return tot;
	}
	
	// of course you can change the String output with what you think works best
	public String trovaSequenza(int mese) {
		return "TODO!";
	}
	

}
