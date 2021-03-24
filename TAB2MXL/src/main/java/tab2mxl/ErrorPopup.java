package tab2mxl;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorPopup {
	public static void display()
	{
	Stage popupwindow=new Stage();
	      
	popupwindow.initModality(Modality.APPLICATION_MODAL);
	popupwindow.setTitle("Minor Errors");
	      
	      
	Label label1= new Label("You have symbols/text above and below the \n measure lines. This information will not be parsed.\n Click the more info button for formatting rules. ");
	label1.setLayoutX(100);
    label1.setLayoutY(250);
//    
//	ImageView format = new ImageView("file:format.png");
//    format.setFitHeight(200);
//    format.setFitWidth(200);      
//	     

	VBox layout= new VBox(10);
	     
	      
	layout.getChildren().addAll(label1);
	//layout.getChildren().addAll(format);
	

	      
	Scene scene1= new Scene(layout, 300, 100);
	      
	popupwindow.setScene(scene1);
	popupwindow.showAndWait();

	       
	}

}
