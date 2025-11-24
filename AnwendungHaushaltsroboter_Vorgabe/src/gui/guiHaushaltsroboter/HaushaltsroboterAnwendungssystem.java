package gui.guiHaushaltsroboter;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Haushaltsroboter;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class HaushaltsroboterAnwendungssystem {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblPreis   		 			= new Label("Preis:");
    private Label lblModell  	 			= new Label("Modell:");
    private Label lblSensortyp   			= new Label("Letzte Renovierung:");
    private Label lblFarben  				= new Label("Farben:");
    private TextField txtName 	 			= new TextField();
    private TextField txtPreis				= new TextField();
    private TextField txtModell				= new TextField();
    private TextField txtSensortyp			= new TextField();
    private TextField txtFarben	 			= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Haushaltsroboter
    private Haushaltsroboter haushaltsroboter;
    
    public HaushaltsroboterAnwendungssystem(Stage primaryStage){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Haushaltsrobotern");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblPreis.setLayoutX(20);
    	lblPreis.setLayoutY(130);
    	lblModell.setLayoutX(20);
    	lblModell.setLayoutY(170);
    	lblSensortyp.setLayoutX(20);
    	lblSensortyp.setLayoutY(210);
    	lblFarben.setLayoutX(20);
    	lblFarben.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblPreis, lblModell,
       		lblSensortyp, lblFarben);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtPreis.setLayoutX(170);
    	txtPreis.setLayoutY(130);
    	txtPreis.setPrefWidth(200);
    	txtModell.setLayoutX(170);
    	txtModell.setLayoutY(170);
    	txtModell.setPrefWidth(200);
      	txtSensortyp.setLayoutX(170);
    	txtSensortyp.setLayoutY(210);
    	txtSensortyp.setPrefWidth(200);
    	txtFarben.setLayoutX(170);
    	txtFarben.setLayoutY(250);
    	txtFarben.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtPreis, txtModell,
     		txtSensortyp, txtFarben);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeHaushaltsroboterAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeHaushaltsroboterAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeHaushaltsroboterInCsvDatei();
			}	
	    });
    }
    
    private void nehmeHaushaltsroboterAuf(){
    	try{ 
    		this.haushaltsroboter = new Haushaltsroboter(
    			txtName.getText(), 
    			Float.parseFloat(txtPreis.getText()),
   	            txtModell.getText(),
   	        	txtSensortyp.getText(),
    		    txtFarben.getText().split(";"));
    		zeigeInformationsfensterAn("Der Haushaltsroboter wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeHaushaltsroboterAn(){
    	if(this.haushaltsroboter != null){
    		txtAnzeige.setText(
    			this.haushaltsroboter.gibHaushaltsroboterZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Haushaltsroboter aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Haushaltsroboter.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.haushaltsroboter = new Haushaltsroboter(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				zeile[2], 
      				zeile[3], 
      				zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Der Haushaltsroboter wurde gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	private void schreibeHaushaltsroboterInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("HaushaltsroboterAusgabe.csv", true));
			aus.write(haushaltsroboter.gibHaushaltsroboterZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Haushaltsroboter wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
