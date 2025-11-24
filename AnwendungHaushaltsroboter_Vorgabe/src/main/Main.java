package main;

import gui.guiHaushaltsroboter.HaushaltsroboterAnwendungssystem;
import gui.guiHaushaltsroboter.HaushaltsroboterControl;
import gui.guiHaushaltsroboter.HaushaltsroboterView;
import gui.guiRoboteruebersicht.RoboteruebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new HaushaltsroboterControl(primaryStage);
		
		Stage fensterRoboteruebersicht = new Stage();
		new RoboteruebersichtControl(fensterRoboteruebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
