package tab2mxl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import guitar.Parser;
import guitar.Part;
import guitar.scorePartwise;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.scene.control.Label; 



public class Main extends Application{
	//comments
	
	Stage window;
	Scene scene1,scene2,scene3;
	Parser p;

	
	public static void main(String[] args) {
		
		launch(args);
						
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		window = primaryStage;
		
		 Image background_image = new Image("file:soundwave.jpg");
	     ImageView mv = new ImageView(background_image);
	     mv.setFitHeight(1000);
	     mv.setFitWidth(1000);
	     mv.fitWidthProperty().bind(window.widthProperty());
	     mv.fitHeightProperty().bind(window.heightProperty());
	     mv.setOpacity(1);
	     
	     TextFlow textFlow = new TextFlow();
		 Text title = new Text("Zebra11 Converter \n");
		 title.setFill(Color.WHITE);
		  title.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
	        textFlow.getChildren().add(title);
	        textFlow.setLayoutX(250);
	        textFlow.setLayoutY(50);
	        
	        TextFlow textFlow3 = new TextFlow();
	        Font start_font = new Font("Tahoma", 30);
	        Text start = new Text("Start!");
	        start.setFill(Color.WHITE);
	        start.setFont(start_font);
	        textFlow3.getChildren().add(start);
	        textFlow3.setLayoutX(470);
	        textFlow3.setLayoutY(570);

	        final Button button = new Button();
	        button.setShape(new Circle(1));
	        button.setMaxSize(3,3);

	        ImageView icon = new ImageView("file:icon1.png");
	        icon.setFitHeight(150);
	        icon.setFitWidth(150);
	        button.setGraphic(icon);
	        

	        button.setLayoutX(420);
	        button.setLayoutY(400);
	        button.setOnAction(e -> window.setScene(scene2));
	
	        
	        Pane layout1 = new Pane();
	        layout1.setPrefSize(1000,1000);
	        layout1.getChildren().add(mv);
	        layout1.getChildren().add(textFlow);
	        layout1.getChildren().add(button);
	        layout1.getChildren().add(textFlow3);
	      
	        
	        Scene scene1 = new Scene(layout1, 1000, 1000, Color.BLACK);

	     
	     //2nd page
	        
	        Image background_image2 = new Image("file:soundwave.jpg");
		     ImageView mv2 = new ImageView(background_image2);
		     mv2.setFitHeight(1000);
		     mv2.setFitWidth(1000);
		     mv2.fitWidthProperty().bind(window.widthProperty());
		     mv2.fitHeightProperty().bind(window.heightProperty());
		     mv2.setOpacity(1);
		     
		     
		     
		     TextFlow textFlow2 = new TextFlow();
			 Text title2 = new Text("Zebra11 Converter \n");
			 title2.setFill(Color.WHITE);
			  title2.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		        textFlow2.getChildren().add(title2);
		        textFlow2.setLayoutX(250);
		        textFlow2.setLayoutY(50);

		        TextFlow textFlow4 = new TextFlow();
		        Font instructions_font = new Font("Tahoma", 20);
		        Text instuctions = new Text("Welcome to Zebra11 tablature to MusicXML converter! You can choose to convert a Tablature file in .txt \nformat or simply input the tabs in the text box below and click enter. Click more info for tablature \nformatting information.\n");
		        instuctions.setFill(Color.WHITE);
		        instuctions.setFont(instructions_font);
		        textFlow4.getChildren().add(instuctions);
		        textFlow4.setLayoutX(50);
		        textFlow4.setLayoutY(150);
		        
		        
		        FileChooser fileChooser = new FileChooser();
		        fileChooser.setTitle("Open Resource File");
		        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		        final Button openButton = new Button("Choose a Tablature File");
		   
		        openButton.setLayoutX(225);
		        openButton.setLayoutY(500);
		        openButton.setMinSize(150, 100);

		        final Button info_button = new Button();
		        info_button.setShape(new Circle(1));
		        info_button.setMaxSize(1,1);
		        
		        
		        ImageView info = new ImageView("file:info.png");
		        info.setFitHeight(90);
		        info.setFitWidth(90);
		        info_button.setGraphic(info);
		        

		        info_button.setLayoutX(690);
		        info_button.setLayoutY(300);
		        //pop up page 
		        
		        info_button.setOnAction(e -> PopupGUI.display());
		        
		        TextFlow textinfo = new TextFlow();
		        Font info_font = new Font("Tahoma", 20);
		        Text infot = new Text("More Info");
		        infot.setFill(Color.WHITE);
		        infot.setFont(info_font);
		        textinfo.getChildren().add(infot);
		        textinfo.setLayoutX(700);
		        textinfo.setLayoutY(400);
		        
 
		        //3rd page 
		        Image background_image3 = new Image("file:soundwave.jpg");
			     ImageView mv3 = new ImageView(background_image);
			     mv3.fitWidthProperty().bind(window.widthProperty());
			     mv3.fitHeightProperty().bind(window.heightProperty());
			     mv3.setOpacity(1);
			     

					TextFlow textFlow5 = new TextFlow();
					 Text title5 = new Text("Zebra11 Converter \n");
					 title5.setFill(Color.WHITE);
					  title5.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
				        textFlow5.getChildren().add(title5);
				        textFlow5.setLayoutX(250);
				        textFlow5.setLayoutY(50);
				        
				        TextArea textbox2 = new TextArea(); 
				        textbox2.setLayoutX(440);//250,750
				        textbox2.setLayoutY(150);//100,150
				        textbox2.setMaxSize(350,800);
				        textbox2.setPrefHeight(500);
                		textbox2.appendText("Error: currently not supported");
                		
                		TextArea inputbox = new TextArea(); 
				        inputbox.setLayoutX(70);
				        inputbox.setLayoutY(150);
				        inputbox.setMaxSize(350,700);
				        inputbox.setPrefHeight(500);
                		inputbox.appendText("Error: currently not supported");
				        
				        
				        final Button button2 = new Button();
				        button2.setShape(new Circle(1));
				        button2.setMaxSize(1,1);

				        ImageView dicon = new ImageView("file:download_icon.png");
				        dicon.setFitHeight(70);
				        dicon.setFitWidth(70);
				        button2.setGraphic(dicon);
				        button2.setLayoutX(850);
				        button2.setLayoutY(30);
				        
				        
				        final Button button3 = new Button();
				        button3.setShape(new Circle(1));
				        button3.setMaxSize(1,1);

				        ImageView ricon = new ImageView("file:restart.png");
				        ricon.setFitHeight(70);
				        ricon.setFitWidth(70);
				        button3.setGraphic(ricon);
				        button3.setLayoutX(70);
				        button3.setLayoutY(30);
				        
				        TextFlow textFlow7 = new TextFlow();
				        Font restart_font = new Font("Tahoma", 20);
				        Text restart = new Text("Restart");
				        restart.setFill(Color.WHITE);
				        restart.setFont(restart_font);
				        textFlow7.getChildren().add(restart);
				        textFlow7.setLayoutX(85);
				        textFlow7.setLayoutY(110);
				        
				       
				        TextFlow textFlow6 = new TextFlow();
				        Font download_font = new Font("Tahoma", 20);
				        Text download = new Text("Download");
				        download.setFill(Color.WHITE);
				        download.setFont(download_font);
				        textFlow6.getChildren().add(download);
				        textFlow6.setLayoutX(850);
				        textFlow6.setLayoutY(110);
				        
				        final Button edit_button = new Button();
				        edit_button.setShape(new Circle(1));
				        edit_button.setMaxSize(1,1);
				        
				        
				        ImageView edit = new ImageView("file:edit.png");
				        edit.setFitHeight(70);
				        edit.setFitWidth(70);
				        edit_button.setGraphic(edit);
				        

				        edit_button.setLayoutX(850);
				        edit_button.setLayoutY(300);
				        
				      //  edit_button.setOnAction(e -> EditPopup.display());
				        
				        TextFlow edit_text = new TextFlow();
				        Font edit_font = new Font("Tahoma", 20);
				        Text edittext = new Text("Edit");
				        edittext.setFill(Color.WHITE);
				        edittext.setFont(edit_font);
				        edit_text.getChildren().add(edittext);
				        edit_text.setLayoutX(875);
				        edit_text.setLayoutY(390);
		        
		        
		       // openButton.setOnAction(e -> window.setScene(scene3));

		        openButton.setOnAction(
		                new EventHandler<ActionEvent>() {
		                	
		                    @Override
		                    public void handle(final ActionEvent e) {

		                       File file = fileChooser.showOpenDialog(primaryStage);
		                        if (file != null) {
		                        	window.setScene(scene3);
	
		                        	try {
		                        		
		                        		Parser p = new Parser(file);
		                        		//change??
		                                char[][] parsed = p.getTabCharMatrix();
		                                ArrayList<char[][]> testArrayList3 = p.measureSplitter(parsed);
		                                /*
		                                 * Here, we need to add a call to a parser method.
		                                 * It will separate the measures into individual char arrays,
		                                 * then, it will put them into an ArrayList in order.
		                                 * Change the .add below. (remove them)
		                                 * The return will be the ArrayList.
		                                 */
		                                testArrayList3.add(parsed);
		                                testArrayList3.add(parsed);
		                                char[][] tmp = testArrayList3.get(0);
		                                
		                                for (int i = 0; i < tmp.length ; i++) {
		                                    //System.out.println(p.getTabCharMatrix()[i]);
		                                }
		                                
		                                char[][] tmp2 = testArrayList3.get(1);
		                                for (int i = 0; i < tmp2.length ; i++) {
		                                    //System.out.println(p.getTabCharMatrix()[i]);
		                                }



		                        		Part part = p.createMusicalPart(testArrayList3);
		                        		scorePartwise sp = new scorePartwise();
		                        		sp.getParts().add(part);
		                        		
		                        		JAXBContext jc = JAXBContext.newInstance(scorePartwise.class);
		                        		Marshaller ms = jc.createMarshaller();
		                        		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		                        		ms.marshal(sp,new File("src//main//java//output//Output.xml"));
		      

		                        		File output = new File("src//main//java//output//Output.xml");
		                        		ms.marshal(sp,output);
		  
		             
		  
		                        		try {
		                        	        Scanner s = new Scanner(output); //what's this doing?
		                        	        textbox2.clear();
		                        	        while (s.hasNext()) {
		                        	          textbox2.appendText(s.nextLine()+"\n");
		                        	          
		                        	        }
		                        	        
		                        	        Scanner scan = new Scanner(file);
		                        	        inputbox.clear();
		                        	        while(scan.hasNext()) {
		                        	        	inputbox.appendText(scan.nextLine() + "\n");
		                        	        }
		                        	        
		                        	        
		                        	    } catch (FileNotFoundException ex) {
		                        	        System.err.println(ex);
		                        	    }
		                        	
		                        	
		                        	}catch (JAXBException ex) {
		                        		// TODO Auto-generated catch block
		                        		System.out.println(""+ex.getMessage());
		                        	}
		                        	}

		                        }
		                    
		                });
		        
		        TextArea textbox = new TextArea("input tab here"); 
		        textbox.setLayoutX(50);
		        textbox.setLayoutY(250);
		        textbox.setMinSize(400, 200);
		        
		        textbox.setOnKeyPressed(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent keyEvent) {
						// TODO Auto-generated method stub
						if(keyEvent.getCode() == KeyCode.ENTER)
				        {
							window.setScene(scene3);
	                		File input = new File("src//main//java//input//Input.txt");
	                		 FileWriter myWriter;
							try {
								myWriter = new FileWriter(input);
		                	      myWriter.write(textbox.getText());
		                	      myWriter.close();
		                	      try {
		                        		
		                        		Parser p = new Parser(input);
		                        		//change??
		                                char[][] parsed = p.getTabCharMatrix();
		                                
		                                ArrayList<char[][]> testArrayList4 = p.measureSplitter(parsed);
		                            
		                                /*
		                                 * Here, we need to add a call to a parser method.
		                                 * It will separate the measures into individual char arrays,
		                                 * then, it will put them into an ArrayList in order.
		                                 * Change the .add below. (remove them)
		                                 * The return will be the ArrayList.
		                                 */
		                                testArrayList4.add(parsed);
		                                testArrayList4.add(parsed);
		                                
		                                
		                                char[][] tmp = testArrayList4.get(0);
		                                
//		                                for (int i = 0; i < testArrayList3.size() ; i++) {
//		                                	System.out.print(testArrayList3.get(i));
//		                                }
		                                
		                                char[][] tmp2 = testArrayList4.get(1);
		                                for (int i = 0; i < tmp2.length ; i++) {
		                                    System.out.println(p.getTabCharMatrix()[i]);
		                                }
		                        	
		                     
		                        		Part part = p.createMusicalPart(testArrayList4);
		                        		scorePartwise sp = new scorePartwise();
		                        		sp.getParts().add(part);
		                        		
		                        		JAXBContext jc = JAXBContext.newInstance(scorePartwise.class);
		                        		Marshaller ms = jc.createMarshaller();
		                        		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		                        		ms.marshal(sp,new File("src//main//java//output//Output.xml"));
		      

		                        		File output = new File("src//main//java//output//Output.xml");
		                        		ms.marshal(sp,output);
		  

		                        		try {
		                        	        Scanner s = new Scanner(output);
		                        	        textbox2.clear();
		                        	        while (s.hasNext()) {
		                        	          textbox2.appendText(s.nextLine()+"\n");
		                        	        }
		                        	        
		                        	        Scanner scan = new Scanner(input);
		                        	        inputbox.clear();
		                        	        while(scan.hasNext()) {
		                        	        	inputbox.appendText(scan.nextLine() + "\n");
		                        	        }
		                        	        
		                        	     
		                        	        
		                        	    } catch (FileNotFoundException ex) {
		                        	        System.err.println(ex);
		                        	    }
		                        	
		                        	
		                        	}catch (JAXBException ex) {
		                        		// TODO Auto-generated catch block
		                        		System.out.println(""+ex.getMessage());
		                        	}
		                        	}
		                	      
							 catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			                textbox.clear();
				        }
						
					}});
		        
		        button2.setOnAction(
		                new EventHandler<ActionEvent>() {
		                    @Override
		                    public void handle(final ActionEvent e) {
		                    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Xml", "*.xml"));

		                    File dest = fileChooser.showSaveDialog(window);
		              
		                    if (dest != null) {
		                    	try {
	                        		File output = new File("src//main//java//output//Output.xml");
		                    		Files.copy(output.toPath(), dest.toPath());
		                    	} catch (IOException ex) {
		                    		 System.err.println(ex);
		                    	}
            	        // handle exception...
		                    		
		                    	}
		                    }});
		        
		        button3.setOnAction(e -> window.setScene(scene2));
		  
		        Pane layout2 = new Pane();
		        layout2.setPrefSize(1000,1000);
		        layout2.getChildren().add(mv2);
		        layout2.getChildren().add(textFlow2);
		        layout2.getChildren().add(textFlow4);
		        layout2.getChildren().add(openButton);
		        layout2.getChildren().add(textbox);
		        layout2.getChildren().add(info);
		        layout2.getChildren().add(info_button);
		        layout2.getChildren().add(textinfo);

		        
		        
		        Pane layout3 = new Pane();
		        layout3.setPrefSize(1000,1000);
		        layout3.getChildren().add(mv3);
		        layout3.getChildren().add(textFlow5);
		        layout3.getChildren().add(textbox2);
		        layout3.getChildren().add(inputbox);
		        layout3.getChildren().add(button2);
		        layout3.getChildren().add(dicon);
		        layout3.getChildren().add(textFlow6);
		        layout3.getChildren().add(ricon);
		        layout3.getChildren().add(button3);
		        layout3.getChildren().add(textFlow7);
		        layout3.getChildren().add(edit);
		        layout3.getChildren().add(edit_button);
		        layout3.getChildren().add(edit_text);
		        

		        
	
		     
		scene2 = new Scene(layout2, 1000, 1000,Color.BLACK);
		scene3 = new Scene(layout3, 1000,1000,Color.BLACK);
		
		window.setScene(scene1);
		window.setTitle("Tablature to MusicXML Converter");
		window.show();
		
		PrintWriter writer = new PrintWriter("src//main//java//output//Output.xml");
		writer.print("");
		// other operations
		writer.close();
		
		PrintWriter writer2 = new PrintWriter("src//main//java//input//Input.xml");
		writer2.print("");
		// other operations
		writer2.close();
		
		
	}

}
