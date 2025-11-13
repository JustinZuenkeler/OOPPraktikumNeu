package fileCreatorsZuenkeler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProduct extends ReaderProductZuenkeler {
	BufferedReader ein;
	public ConcreteCsvReaderProduct() {
		try {
			ein = new BufferedReader(new FileReader("Haushaltsroboter.csv"));
		} catch (FileNotFoundException e) {
		}
	}
	@Override
	public String[] leseAusDatei() throws IOException {
			String[] zeile = ein.readLine().split(";");
			return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
			ein.close();		
	}


}
