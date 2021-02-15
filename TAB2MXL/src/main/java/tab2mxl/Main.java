package tab2mxl;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import java.util.Optional;


import java.io.File;
import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;
import javafx.geometry.VPos;
import javafx.scene.layout.StackPane; 
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.scene.control.TextInputDialog;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

	
	Group group = new Group();

	public void createText(){
		TextFlow textFlow = new TextFlow();
		 Text title = new Text("Zebra11 Converter \n");
		 title.setFill(Color.WHITE);
		  title.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
	        textFlow.getChildren().add(title);
	        textFlow.setLayoutX(250);
	        textFlow.setLayoutY(50);
	        
	        group.getChildren().add(textFlow);
	        
	        
	        TextFlow textFlow2 = new TextFlow();
	        Font instructions_font = new Font("Tahoma", 20);
	        Text instuctions = new Text("Welcome to Zebra11 tablature to MusicXML converter! You can choose to convert a Tablature file \n or simply input the tabs in the text box below and click enter.");
	        instuctions.setFill(Color.WHITE);
	        instuctions.setFont(instructions_font);
	        textFlow2.getChildren().add(instuctions);
	        textFlow2.setLayoutX(100);
	        textFlow2.setLayoutY(150);
	        
	        group.getChildren().add(textFlow2);

	}
	

     
     //create set on action for this button

	@Override
	public void start(Stage stage) throws Exception {
		
		
		
		createText();
	
		
        
        Image background_image = new Image("file:soundwave.jpg");
        ImageView mv = new ImageView(background_image);
        mv.setFitHeight(1000);
        mv.setFitWidth(1000);
        mv.setOpacity(0.4);
        
        group.getChildren().add(mv);
        
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        final Button openButton = new Button("Choose a Tablature File");
   
        openButton.setLayoutX(400);
        openButton.setLayoutY(500);
        openButton.setMinSize(200, 100);
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                       File file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                            System.out.print("file was chosen");
                        }
                    }
                });
        
      
        
        group.getChildren().add(openButton);
        
        TextField b = new TextField("input tab here"); 
        b.setLayoutX(150);
        b.setLayoutY(250);
        b.setMinSize(700, 200);
        
        
       // TilePane r = new TilePane(); 
        Label l = new Label("no text");
        
        
     // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                System.out.print(b.getText());   
                b.clear();
                
            } 
        }; 
  
        // when enter is pressed 
        b.setOnAction(event); 
  
        // add textfield 
        group.getChildren().add(b); 
        group.getChildren().add(l); 
  
      
        Scene scene = new Scene(group, 1000, 1000, Color.BLACK);
        stage.setTitle("Tablature to MusicXML Converter");
        stage.setScene(scene);

        stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
