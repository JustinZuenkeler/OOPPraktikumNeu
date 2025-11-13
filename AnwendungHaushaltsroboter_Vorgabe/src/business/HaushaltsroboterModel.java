package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import fileCreatorsZuenkeler.*;

public class HaushaltsroboterModel {
	
    public Haushaltsroboter haushaltsroboter;
    
    public Haushaltsroboter getHaushaltsroboter() {
    	return haushaltsroboter;
    }

	/*public void leseAusDatei(String typ) throws IOException{
      			BufferedReader ein = new BufferedReader(new FileReader("Haushaltsroboter.csv"));
      			String[] zeile = ein.readLine().split(";");
      			haushaltsroboter = new Haushaltsroboter(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				zeile[2], 
      				zeile[3], 
      				zeile[4].split("_"));
      				ein.close();
	}*/
    
    public void leseAusDatei(String typ) throws IOException{
    	ReaderCreatorZuenkeler readerCreator = new ConcreteCreator();
		ReaderProductZuenkeler reader = readerCreator.factoryMethod(typ);
		String[] zeile = reader.leseAusDatei();
		this.haushaltsroboter = new Haushaltsroboter(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				zeile[2], 
      				zeile[3], 
      				zeile[4].split("_"));
		reader.schliesseDatei();
    }
//    
//    public void leseAusDateiCsv(String typ) throws IOException{
//    	ReaderCreatorZuenkeler readerCreator = new ConcreteCreator();
//		ReaderProductZuenkeler reader = readerCreator.factoryMethod(typ);
//		String[] zeile = reader.leseAusDatei();
//		this.haushaltsroboter = new Haushaltsroboter(zeile[0], 
//      				Float.parseFloat(zeile[1]), 
//      				zeile[2], 
//      				zeile[3], 
//      				zeile[4].split("_"));
//		reader.schliesseDatei();
//    }
//    
//    public void leseAusDateiTxt(String typ) throws IOException{
//    	ReaderCreatorZuenkeler readerCreator = new ConcreteCreator();
//		ReaderProductZuenkeler reader = readerCreator.factoryMethod(typ);
//		String[] zeile = reader.leseAusDatei();
//		this.haushaltsroboter = new Haushaltsroboter(zeile[0], 
//      				Float.parseFloat(zeile[1]), 
//      				zeile[2], 
//      				zeile[3], 
//      				zeile[4].split("_"));
//		reader.schliesseDatei();
//    }
    
		
	public void schreibeHaushaltsroboterInCsvDatei() throws IOException {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("HaushaltsroboterAusgabe.csv", true));
			aus.write(haushaltsroboter.gibHaushaltsroboterZurueck(';'));
			aus.close();

	}
	
	

}
