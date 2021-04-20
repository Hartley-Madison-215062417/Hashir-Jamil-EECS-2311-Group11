package tab2mxl;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.*;

public class PopupGUI {
	
	public static void display()
	{
	Stage popupwindow=new Stage();
	      
	popupwindow.initModality(Modality.APPLICATION_MODAL);
	popupwindow.setTitle("Information");
	      
	      
	Label label1= new Label("Tablature must be formatted in the following way inside the measure. \n Symbols on top or below measures will not be parsed.");
	label1.setLayoutX(100);
    label1.setLayoutY(250);
    
	ImageView format = new ImageView("file:format.png");
    format.setFitHeight(400);
    format.setFitWidth(400);      
	     

	VBox layout= new VBox(10);
	     
	      
	layout.getChildren().addAll(label1);
	layout.getChildren().addAll(format);
	
	
	layout.setAlignment(Pos.CENTER);
	      
	Scene scene1= new Scene(layout, 700, 500);
	      
	popupwindow.setScene(scene1);
	popupwindow.showAndWait();

	       
	}

}
