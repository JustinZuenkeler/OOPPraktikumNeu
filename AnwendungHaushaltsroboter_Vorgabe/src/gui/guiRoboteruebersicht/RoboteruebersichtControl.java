package gui.guiRoboteruebersicht;
import business.HaushaltsroboterModel;
import javafx.stage.Stage;
public class RoboteruebersichtControl {	
	private RoboteruebersichtView
 		roboteruebersichtView;
	private HaushaltsroboterModel haushaltsroboterModel;
	public RoboteruebersichtControl(Stage primaryStage){
 		//this.haushaltsroboterModel = new HaushaltsroboterModel();
 		this.haushaltsroboterModel = this.haushaltsroboterModel.getInstance();
		this.roboteruebersichtView 
		 	= new RoboteruebersichtView(this, primaryStage,
			haushaltsroboterModel);
	}
}
	