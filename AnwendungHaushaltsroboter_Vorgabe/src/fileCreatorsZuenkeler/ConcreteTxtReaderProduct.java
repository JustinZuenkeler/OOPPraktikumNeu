package fileCreatorsZuenkeler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProduct extends ReaderProductZuenkeler {
	BufferedReader ein;
	public ConcreteTxtReaderProduct() {
		try {
			ein = new BufferedReader(new FileReader("Haushaltsroboter.txt"));
		} catch (FileNotFoundException e) {
		}
	}
	@Override
	public String[] leseAusDatei() throws IOException {
			String[] ergebnisZeile = new String[5];
			int i = 0;
			while (i<ergebnisZeile.length) {
				String zeile = ein.readLine();
				ergebnisZeile[i] = zeile;
				i++;
			}
			return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
			ein.close();		
	}

}
