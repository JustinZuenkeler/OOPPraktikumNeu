package business;

public class Haushaltsroboter {
	
    private String seriennummer;
    private float preis;
    private String modell;
    private String sensortyp;
    private String[] farben;
    
    public Haushaltsroboter(String seriennummer, float preis, String modell,
    	String sensortyp, String[] farben){
    	this.seriennummer = seriennummer;
      	this.preis = preis;
       	this.modell = modell;
       	this.sensortyp = sensortyp;
       	this.farben = farben;
    }

	public String getName() {
		return seriennummer;
	}

	public void setName(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getSensortyp() {
		return sensortyp;
	}

	public void setSensortyp(String sensortyp) {
		this.sensortyp = sensortyp;
	}

	public String[] getFarben() {
		return farben;
	}

	public void setFarben(String[] farben) {
		this.farben = farben;
	}
	
 	public String getFarbenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarben().length - 1; i++) {
			ergebnis = ergebnis + this.getFarben()[i] + trenner; 
		}
		return ergebnis	+ this.getFarben()[i];
	}
	
	public String gibHaushaltsroboterZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getPreis() + trenner
  			+ this.getModell() + trenner
  		    + this.getSensortyp() + trenner + "\n"
  		    + this.getFarbenAlsString(trenner) + "\n";
  	}
}

