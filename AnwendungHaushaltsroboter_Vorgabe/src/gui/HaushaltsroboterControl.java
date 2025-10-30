package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Haushaltsroboter;
import business.HaushaltsroboterModel;
import javafx.stage.Stage;

public class HaushaltsroboterControl {
	private HaushaltsroboterView hausView;
	private HaushaltsroboterModel hausModel;
	
	public HaushaltsroboterControl(Stage primaryStage){
		this.hausModel = new HaushaltsroboterModel();
		this.hausView = new HaushaltsroboterView(this, primaryStage,
		 hausModel);
	}
    public Haushaltsroboter haushaltsroboter;
    
    public void leseAusDatei(String typ){
    	try {
    		if("csv".equals(typ)){
	      		this.hausModel.leseAusDatei(typ);
	      		this.hausView.zeigeInformationsfensterAn(
	  	  	   			"Der Haushaltsroboter wurde gelesen!");
    		}
    		else {
    			this.hausView.zeigeInformationsfensterAn(
    	   				"Noch nicht implementiert!");
    		}
		}
		catch(IOException exc){
			this.hausView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			this.hausView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeHaushaltsroboterInCsvDatei() {
		try {
			this.hausModel.schreibeHaushaltsroboterInCsvDatei();
			this.hausView.zeigeInformationsfensterAn(
		   			"Die Haushaltsroboter wurden gespeichert!");
		}	
		catch(IOException exc){
			this.hausView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			this.hausView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	public void nehmeHaushaltsroboterAuf(){
    	try{ 
    		this.hausView.nehmeHaushaltsroboterAuf();
       	}
       	catch(Exception exc){
       		hausView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	

	
}
