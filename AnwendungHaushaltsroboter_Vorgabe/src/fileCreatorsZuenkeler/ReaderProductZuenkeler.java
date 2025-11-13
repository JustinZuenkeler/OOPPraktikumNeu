package fileCreatorsZuenkeler;

import java.io.*;

public abstract class ReaderProductZuenkeler {
	public abstract String[] leseAusDatei() throws IOException; 
	
	public abstract void schliesseDatei() throws IOException;
}
