package tab2mxl;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputPopup {
	static String measure_choice;
	public static void display()
	{
Stage popupwindow=new Stage();
	    
		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Manual Edit");
		
		TextFlow textFlow6 = new TextFlow();
	    Text song_title = new Text("Edit Measures");
	    song_title.setFill(Color.BLACK);
	    Font font7 = new Font("Tahoma", 20);
	    song_title.setFont(font7);
	    textFlow6.getChildren().add(song_title);
	    textFlow6.setLayoutX(180);
	    textFlow6.setLayoutY(20);
	    
	    TextFlow textFlow3 = new TextFlow();
	    Text text = new Text("Measure Number: ");
	    text.setFill(Color.BLACK);
	    Font font3 = new Font("Tahoma", 15);
	    text.setFont(font3);
	    textFlow3.getChildren().add(text);
	    textFlow3.setLayoutX(20);
	    textFlow3.setLayoutY(100);

	    
	    Button b = new Button("Change");
	    b.setLayoutX(170);
	    b.setLayoutY(250);
	    b.setMaxSize(200,50);
		
	    final TextArea measure = new TextArea();
	    measure.setPromptText("Enter measure number or All to change all measures ");
	    measure.setLayoutX(170);
	    measure.setLayoutY(100);
	    measure.setMaxSize(200,50);
	    
	    b.setOnAction(
		        new EventHandler<ActionEvent>() {
                	
                    @Override
                    public void handle(final ActionEvent e) {
                    	measure_choice = measure.getText();
                    	popupwindow.close();
                    }});
    
	    
	    Pane pane = new Pane();
	    pane.getChildren().add(measure);
	    pane.getChildren().add(textFlow6);
		pane.getChildren().add(textFlow3);
		pane.getChildren().add(b);
		
		Scene scene1= new Scene(pane, 500, 300,Color.RED);
		
		
		popupwindow.setScene(scene1);
		popupwindow.showAndWait();
		
		
	

	}
	public String getMeasureChoice(){
		return measure_choice;
		
	}
}
