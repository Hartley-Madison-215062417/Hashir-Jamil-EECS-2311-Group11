package tab2mxl;


import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import guitar.Measure;
import guitar.Parser;
import guitar.Part;
import guitar.scorePartwise;

//import drums.Measure;
//import drums.Parser;
//import drums.Part;
//import drums.scorePartwise;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
import javafx.stage.Screen;
import javafx.scene.control.Label; 



public class Main extends Application{
	//comments
	
	Stage window;
	Scene scene1,scene2,scene3,scene4;
	Parser p;
	
	

	
	public static void main(String[] args) {
		
		launch(args);
						
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		 double height = primScreenBounds.getHeight();
		 double width =primScreenBounds.getWidth()/1.2;
		 primaryStage.setHeight(height);
		 primaryStage.setWidth(width);
		
		window = primaryStage;
		
		 Image background_image = new Image("file:soundwave.jpg");
	     ImageView mv = new ImageView(background_image);
	     mv.setFitHeight(width);
	     mv.setFitWidth(height);
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
	        layout1.setPrefSize(width,height);
	        layout1.getChildren().add(mv);
	        layout1.getChildren().add(textFlow);
	        layout1.getChildren().add(button);
	        layout1.getChildren().add(textFlow3);
	      
	        
	        Scene scene1 = new Scene(layout1, width, height, Color.BLACK);

	     
	     //2nd page
	        
	        Image background_image2 = new Image("file:soundwave.jpg");
		     ImageView mv2 = new ImageView(background_image2);
		     mv2.setFitHeight(height);
		     mv2.setFitWidth(width);
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
		        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text File", "*.txt"));
		        final Button openButton = new Button("Choose a Tablature File");
		   
		        openButton.setLayoutX(225);
		        openButton.setLayoutY(500);
		        openButton.setMinSize(150, 100);

		        final Button info_button = new Button();
		        info_button.setShape(new Circle(1));
		        info_button.setMaxSize(1,1);
		        
		        
		        final Button convert_button = new Button();
		        convert_button.setShape(new Circle(1));
		        convert_button.setMaxSize(1,1);
		        
		        ImageView convert = new ImageView("file:convert.png");
		        convert.setFitHeight(90);
		        convert.setFitWidth(90);
		        convert_button.setGraphic(convert);
		        

		        convert_button.setLayoutX(690);
		        convert_button.setLayoutY(300);
		        
		        
		        ImageView info = new ImageView("file:info.png");
		        info.setFitHeight(90);
		        info.setFitWidth(90);
		        info_button.setGraphic(info);
		        

		        info_button.setLayoutX(690);
		        info_button.setLayoutY(500);
		        //pop up page 
		        
		        info_button.setOnAction(e -> PopupGUI.display());
		        
		        TextFlow textinfo = new TextFlow();
		        Font info_font = new Font("Tahoma", 20);
		        Text infot = new Text("More Info");
		        infot.setFill(Color.WHITE);
		        infot.setFont(info_font);
		        textinfo.getChildren().add(infot);
		        textinfo.setLayoutX(700);
		        textinfo.setLayoutY(600);
		        
		        TextFlow textconvert = new TextFlow();
		        Font convert_font = new Font("Tahoma", 20);
		        Text convertt = new Text("Convert!");
		        convertt.setFill(Color.WHITE);
		        convertt.setFont(info_font);
		        textconvert.getChildren().add(convertt);
		        textconvert.setLayoutX(710);
		        textconvert.setLayoutY(400);
		        
		        //edit input page
		        Image background_image4 = new Image("file:soundwave.jpg");
			     ImageView mv4 = new ImageView(background_image4);
			     mv4.setFitHeight(height);
			     mv4.setFitWidth(width);
			     mv4.fitWidthProperty().bind(window.widthProperty());
			     mv4.fitHeightProperty().bind(window.heightProperty());
			     mv4.setOpacity(1);
			     
			     
			     
			     TextFlow textFlow_edit = new TextFlow();
				 Text title_edit = new Text("Zebra11 Converter \n");
				 title_edit.setFill(Color.WHITE);
				  title_edit.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
			        textFlow_edit.getChildren().add(title_edit);
			        textFlow_edit.setLayoutX(250);
			        textFlow_edit.setLayoutY(50);

			        TextFlow textFlow_edit2 = new TextFlow();
			        Font instructions_font6 = new Font("Tahoma", 20);
			        Text instuctions6 = new Text("Welcome to Zebra11 tablature to MusicXML converter! You can choose to convert a Tablature file in .txt \nformat or simply input the tabs in the text box below and click enter. Click more info for tablature \nformatting information.\n");
			        instuctions6.setFill(Color.WHITE);
			        instuctions6.setFont(instructions_font6);
			        textFlow_edit2.getChildren().add(instuctions6);
			        textFlow_edit2.setLayoutX(50);
			        textFlow_edit2.setLayoutY(150);
			    
			        final Button info_button2 = new Button();
			        info_button2.setShape(new Circle(1));
			        info_button2.setMaxSize(1,1);
			        
			        
			        final Button convert_button2 = new Button();
			        convert_button2.setShape(new Circle(1));
			        convert_button2.setMaxSize(1,1);
			        
			        ImageView convert2 = new ImageView("file:convert.png");
			        convert2.setFitHeight(90);
			        convert2.setFitWidth(90);
			        convert_button2.setGraphic(convert2);
			        

			        convert_button2.setLayoutX(690);
			        convert_button2.setLayoutY(300);
			        
			        
			        ImageView info2 = new ImageView("file:info.png");
			        info2.setFitHeight(90);
			        info2.setFitWidth(90);
			        info_button2.setGraphic(info2);
			        

			        info_button2.setLayoutX(690);
			        info_button2.setLayoutY(500);
			        //pop up page 
			        
			        info_button2.setOnAction(e -> PopupGUI.display());
			        
			        TextFlow textinfo2 = new TextFlow();
			        Font info_font2 = new Font("Tahoma", 20);
			        Text infot2 = new Text("More Info");
			        infot2.setFill(Color.WHITE);
			        infot2.setFont(info_font2);
			        textinfo2.getChildren().add(infot2);
			        textinfo2.setLayoutX(700);
			        textinfo2.setLayoutY(600);
			        
			        
			        TextFlow textconvert2 = new TextFlow();
			        Font convert_font2 = new Font("Tahoma", 20);
			        Text convertt2 = new Text("Convert!");
			        convertt2.setFill(Color.WHITE);
			        convertt2.setFont(info_font2);
			        textconvert2.getChildren().add(convertt2);
			        textconvert2.setLayoutX(710);
			        textconvert2.setLayoutY(400);
			        
 
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
				        textbox2.setLayoutX(540);//250,750
				        textbox2.setLayoutY(150);//100,150
				        textbox2.setMaxSize(350,800);
				        textbox2.setPrefHeight(500);
                		textbox2.appendText("Error: currently not supported");
                		
                		
                		TextArea inputbox = new TextArea(); 
				        inputbox.setLayoutX(170);
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
				        

				        edit_button.setLayoutX(950);
				        edit_button.setLayoutY(300);
				        
				        
				        
				        final Button edit_button2 = new Button();
				        edit_button2.setShape(new Circle(1));
				        edit_button2.setMaxSize(1,1);
				        
				        
				        
				        ImageView edit2 = new ImageView("file:edit.png");
				        edit2.setFitHeight(70);
				        edit2.setFitWidth(70);
				        edit_button2.setGraphic(edit2);
				        

				        edit_button2.setLayoutX(50);
				        edit_button2.setLayoutY(300);
				       
				        
                   	 TextArea textboxe = new TextArea(); 
     				
        		        textboxe.setLayoutX(50);
        		        textboxe.setLayoutY(250);
        		        textboxe.setMinSize(400, 400);
        		   //     textboxe.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 11));
     
        		       
        		        
						edit_button2.setOnAction(
				                new EventHandler<ActionEvent>() {
				                    @Override
				                    public void handle(final ActionEvent e) {
				                    	InputPopup.display();
				                    	if(InputPopup.measure_choice.equalsIgnoreCase("all")) {
				                    	inputbox.clear();
				                    	textbox2.clear();
				                    	p = null;
				                    	File output = new File("src//main//java//output//Output.xml");
				                    	output.delete();
				         		        
				         		      File input = new File("src//main//java//input//Input.txt");
				         		       Scanner s2;
									try {
										s2 = new Scanner(input);
										  while (s2.hasNext()) {
				                    	        
			                    	        	String line2 = s2.nextLine();
			                    	        textboxe.appendText(line2+'\n');
			                    	        
			                    	        }
										  input.delete();
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
	                    	        
		                    	      
				                   
				                    	Measure.measureNumber =1;
				                    	window.setScene(scene4);
				                    	}
				                    	
				                    	else {
				                    		int i = findMeasureIndex(inputbox.getText());
					                    	inputbox.clear();
					                    	textbox2.clear();
					                    	p = null;
					                    	File output = new File("src//main//java//output//Output.xml");
					                    	output.delete();
					         		        
					         		      File input = new File("src//main//java//input//Input.txt");
					         		       Scanner s2;
										try {
											s2 = new Scanner(input);
											textbox2.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick;");
				                    	    textbox2.setEditable(false);
											  while (s2.hasNext()) {
					                    	        
				                    	        	String line2 = s2.nextLine();
				                    	        textboxe.appendText(line2+'\n');
				                    	        
				                    	        }
											  
											  input.delete();
											  
											  textbox2.selectRange(i, i+112);
				                    	        textbox2.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
				                    	          @Override public void handle(MouseEvent t) { t.consume(); }});
				                    	        
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
		                    	        
			                    	      
					                   
					                    	Measure.measureNumber =1;
					                    	window.setScene(scene4);
				                    	
				                    		

				                    	      
				                    		
				                    		
				                    		
				                    	}
//				                    		inputbox.clear();
//					                    	textbox2.clear();
//					                    	p = null;
//					                    	File output = new File("src//main//java//output//Output.xml");
//					                    	output.delete();
//					                    	
//					                    	 File input = new File("src//main//java//input//Input.txt");
//					                    	Parser p = new Parser(input);
//			                                char[][] parsed = p.getTabCharMatrix();
//			                                
//			                                ArrayList<char[][]> testArrayList4 = p.measureSplitter(parsed);
//					         		        File newInput = chartoFile(testArrayList4);
//					         		        
//					         
//					         		       Scanner s2;
//										try {
//											s2 = new Scanner(newInput);
//											  while (s2.hasNext()) {
//					                    	        
//				                    	        	String line2 = s2.nextLine();
//				                    	        textboxe.appendText(line2+'\n');
//				                    	        
//				                    	        }
//											  input.delete();
//										} catch (FileNotFoundException e1) {
//											// TODO Auto-generated catch block
//											e1.printStackTrace();
//										}
//			                       
//				                    		int measure_num = Integer.valueOf(InputPopup.measure_choice);
//
//				                    		Measure.measureNumber =1;
//					                    	window.setScene(scene4);
//				                    	}
				        		
				                    }

									private int findMeasureIndex(String string) {
										System.out.print(string);
										return 1;
									}});
						
						convert_button2.setOnAction(
				                new EventHandler<ActionEvent>() {
				                	

							@Override
							  public void handle(final ActionEvent e) {
								// TODO Auto-generated method stub
							
									window.setScene(scene3);
			                		File input = new File("src//main//java//input//Input.txt");
			                		 FileWriter myWriter;
									try {
										myWriter = new FileWriter(input);
				                	      myWriter.write(textboxe.getText());
				                	      myWriter.close();
				                	      try {
				                	    	  
				                	    	  if (input.length() == 0 ) {
				                        			inputbox.clear();
				                        			inputbox.appendText("Error: No input was entered");
				                        			textbox2.clear();
				                        			textbox2.appendText("Error: No input was entered");
				                        			button2.setDisable(true);
				                        			edit_button.setDisable(true);
				                        			
				                        			
				                        		}
				                	    	  else {
				                	    		
					  
				                        		
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
				                            //    testArrayList4.add(parsed);
				                            //    testArrayList4.add(parsed);
				                                
				                                
				                           //     char[][] tmp = testArrayList4.get(0);
				                                
//				                                for (int i = 0; i < testArrayList3.size() ; i++) {
//				                                	System.out.print(testArrayList3.get(i));
//				                                }
				                                
//				                                char[][] tmp2 = testArrayList4.get(1);
//				                                for (int i = 0; i < tmp2.length ; i++) {
//				                                    System.out.println(p.getTabCharMatrix()[i]);
//				                                }
//				                                
//				                        	
				                     
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
				                        	        	String str = scan.nextLine();
				                        	        	inputbox.appendText(str + "\n");
				                        	        }
				                        	        boolean check = findErrors();
				                        	        if (check == true){
				                        	        	ErrorPopup.display();
				                        	        }
				                        
				                        	        
				                        	    } catch (FileNotFoundException ex) {
				                        	        System.err.println(ex);
				                        	    }
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
					                textboxe.clear();
						        			
							}

							private boolean findErrors() {
								
								String str = inputbox.getText();
								String[] a = str.split("\\r?\\n");
								for(int i = 0; i < a.length; i++) {
									if(a[i].isEmpty() == false) {
								if(a[i].charAt(0) !='|' && a[i].charAt(a[i].length()-1) !='|'  && a[i].isEmpty() == false) {
					
								return true;
								}
								}
								}
								return false;
							}
							
				        });
				        
				        //e -> EditPopup.display()
				        edit_button.setOnAction(
				        new EventHandler<ActionEvent>() {
		                	
		                    @Override
		                    public void handle(final ActionEvent e) {
		                    	
		                    	EditPopup.display();
		                    	File f = new File("src//main//java//output//Output.xml");
		                    	String choice = EditPopup.getChoice();
	
		                    	if(choice == "Time Signature") {
		                    	//File output = new File("src//main//java//output//Output.xml");
		                    	
		                    		try {
		     
										Scanner s = new Scanner(f);
										textbox2.clear();
	                    	        	textbox2.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick;");
			                    	    textbox2.setEditable(false);
										
		                    	        while (s.hasNext()) {
				                    	        
		                    	        	String line = s.nextLine();
		                    	        textbox2.appendText(line+"\n");
		                    	        
		                    	        }
		                    	        
		                    	        int i = findindex();
		           
		                    	      
		                    	        textbox2.selectRange(i, i+112);
		                    	        textbox2.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
		                    	          @Override public void handle(MouseEvent t) { t.consume(); }
		                    	        });
		                    	        

		                    	      
		                    	          
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
	                    	       
		                    		//f.delete();
		                    	}
		                    	
		                    	else if (choice == "Song Title") {
		                    		File output = new File("src//main//java//output//Output.xml");

		                    		try {
										Scanner s = new Scanner(output);
										textbox2.clear();
	                    	        	textbox2.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick;");
			                    	    textbox2.setEditable(false);
										
		                    	        while (s.hasNext()) {
				                    	        
				                    	        
		                    	        	String line = s.nextLine();
		                    	        textbox2.appendText(line+"\n");
		                    	        
		                    	        }
		                    	        
		                    	        int i = findindex2();
		                    	        System.out.print(i);
		                    	      
		                    	        textbox2.selectRange(i, i+55);
		                    	        textbox2.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
		                    	          @Override public void handle(MouseEvent t) { t.consume(); }
		                    	        });
		                    	        

		                    	      
		                    	          
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
	                    	       
		                    		//f.delete();
		                    		
		                    	}
		                    	//f.delete();
				        
		                    }

							private int findindex2() {
								String check = "<work>";
                    	        String h = textbox2.getText();
                    	        int j = 0;
                    	        for(int i =0;i<h.length()-6;i++) {
                    	        	String sub = h.substring(i, i+6);
                    	        	if(sub.equals(check)) {
                    	        		System.out.print(i);
                    	        		j =i;
                    	        		break;
                    	        	}
                    	        	}
                    	        return j;
                    	        }

							

							private int findindex() {
                    	        String check = "<time>";
                    	        String h = textbox2.getText();
                    	        int j = 0;
                    	        for(int i =0;i<h.length()-6;i++) {
                    	        	String sub = h.substring(i, i+6);
                    	        	if(sub.equals(check)) {
                    	        		System.out.print(i);
                    	        		j =i;
                    	        		break;
                    	        	}
                    	        	}
                    	        return j;
                    	        }

								
                    	        
							});
				        
				        
				        
				        TextFlow edit_text = new TextFlow();
				        Font edit_font = new Font("Tahoma", 20);
				        Text edittext = new Text("Edit Output");
				        edittext.setFill(Color.WHITE);
				        edittext.setFont(edit_font);
				        edit_text.getChildren().add(edittext);
				        edit_text.setLayoutX(945);
				        edit_text.setLayoutY(390);
				        
				        TextFlow edit_text2 = new TextFlow();
				        Font edit_font2 = new Font("Tahoma", 20);
				        Text edittext2 = new Text("Edit Input");
				        edittext2.setFill(Color.WHITE);
				        edittext2.setFont(edit_font);
				        edit_text2.getChildren().add(edittext2);
				        edit_text2.setLayoutX(50);
				        edit_text2.setLayoutY(390);
		        
		        
		        
		       // openButton.setOnAction(e -> window.setScene(scene3));

		        openButton.setOnAction(
		                new EventHandler<ActionEvent>() {
		                	
		                    @Override
		                    public void handle(final ActionEvent e) {
		                    	
		                    	

		                       File file = fileChooser.showOpenDialog(primaryStage);
		                        if (file != null) {
		                        
		                        	window.setScene(scene3);
		                        	
	
		                        	try {
		                        		
		                        		if (file.length() == 0) {
		                        			inputbox.clear();
		                        			inputbox.appendText("Error: No input was entered");
		                        			textbox2.clear();
		                        			textbox2.appendText("Error: No input was entered");
		                        			button2.setDisable(true);
		                        			edit_button.setDisable(true);
		                        			edit_button2.setDisable(true);
		                        		}
		                        		else {
		                        			
		                        			 byte[] array = new byte[(int) file.length()];
		                        			FileOutputStream destFile = new FileOutputStream("src//main//java//input//Input.txt");
		                        		      FileInputStream sourceFile = new FileInputStream(file);

		                        		      // reads all data from input.txt
		                        		      sourceFile.read(array);

		                        		      // writes all data to newFile
		                        		      destFile.write(array);
	
		                        	        
		                        		Parser p = new Parser(file);
		                                char[][] parsed = p.getTabCharMatrix();       
		                                ArrayList<char[][]> testArrayList3 = p.measureSplitter(parsed);
		                                
		                                
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
		                        	        Scanner s = new Scanner(output);
		                        	        textbox2.clear();
		                        	        while (s.hasNext()) {
		                        	          textbox2.appendText(s.nextLine()+"\n");
		                        	        }
		                        	        
		                        	        Scanner scan = new Scanner(file);
		                        	        inputbox.clear();
		                        	       
		                        	        while(scan.hasNext()) {
		                        	        	String str = scan.nextLine();
		                        	        	inputbox.appendText(str + "\n");
		                        	        }
		                        	        boolean check = findErrors();
		                        	        if (check == true){
		                        	        	ErrorPopup.display();
		                        	        }
		                        
		                        	        
		                        	    } catch (FileNotFoundException ex) {
		                        	        System.err.println(ex);
		                        	    }}
		                        	}catch (JAXBException | IOException ex) {
		                        		// TODO Auto-generated catch block
		                        		System.out.println(""+ex.getMessage());
		                        	}
		                        	}

		                        }

							private boolean findErrors() {
						
									
									String str = inputbox.getText();
									String[] a = str.split("\\r?\\n");
									for(int i = 0; i < a.length; i++) {
										if(a[i].isEmpty() == false) {
									if(a[i].charAt(0) !='|' && a[i].charAt(a[i].length()-1) !='|'  && a[i].isEmpty() == false) {
						
									return true;
									}
									}
									}
									return false;
								}
							}
		                    
		                );
		        
		        TextArea textbox = new TextArea(); 
		     
		        textbox.setPromptText("Enter tablature here");
		        textbox.setLayoutX(50);
		        textbox.setLayoutY(250);
		        textbox.setMinSize(400, 200);
        	        
				
		      
				
		        convert_button.setOnAction(
		                new EventHandler<ActionEvent>() {
		                	

					@Override
					  public void handle(final ActionEvent e) {
						// TODO Auto-generated method stub
					
							window.setScene(scene3);
	                		File input = new File("src//main//java//input//Input.txt");
	                		 FileWriter myWriter;
							try {
								myWriter = new FileWriter(input);
		                	      myWriter.write(textbox.getText());
		                	      myWriter.close();
		                	      try {
		                	    	  
		                	    	  if (input.length() == 0) {
		                        			inputbox.clear();
		                        			inputbox.appendText("Error: No input was entered");
		                        			textbox2.clear();
		                        			textbox2.appendText("Error: No input was entered");
		                        			button2.setDisable(true);
		                        			edit_button.setDisable(true);
		                        			edit_button2.setDisable(true);
		                        			
		                        			
		                        		}
		                	    	  else {
		                	    		
			  
		                        		
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
		                            //    testArrayList4.add(parsed);
		                            //    testArrayList4.add(parsed);
		                                
		                                
		                           //     char[][] tmp = testArrayList4.get(0);
		                                
//		                                for (int i = 0; i < testArrayList3.size() ; i++) {
//		                                	System.out.print(testArrayList3.get(i));
//		                                }
		                                
//		                                char[][] tmp2 = testArrayList4.get(1);
//		                                for (int i = 0; i < tmp2.length ; i++) {
//		                                    System.out.println(p.getTabCharMatrix()[i]);
//		                                }
//		                                
//		                        	
		                     
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
		                        	        	String str = scan.nextLine();
		                        	        	inputbox.appendText(str + "\n");
		                        	        }
		                        	        boolean check = findErrors();
		                        	        if (check == true){
		                        	        	ErrorPopup.display();
		                        	        }
		                        
		                        	        
		                        	    } catch (FileNotFoundException ex) {
		                        	        System.err.println(ex);
		                        	    }
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

					private boolean findErrors() {
						
						String str = inputbox.getText();
						String[] a = str.split("\\r?\\n");
						for(int i = 0; i < a.length; i++) {
							if(a[i].isEmpty() == false) {
						if(a[i].charAt(0) !='|' && a[i].charAt(a[i].length()-1) !='|'  && a[i].isEmpty() == false) {
			
						return true;
						}
						}
						}
						return false;
					}
					
		        });
		        
		        button2.setOnAction(
		                new EventHandler<ActionEvent>() {
		                    @Override
		                    public void handle(final ActionEvent e) {
		                    	fileChooser.getExtensionFilters().clear();
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
		        
		        button3.setOnAction(
		                new EventHandler<ActionEvent>() {
		                    @Override
		                    public void handle(final ActionEvent e) {
		                    	inputbox.clear();
		                    	textbox2.clear();
		                    	p = null;
		                    	File input = new File("src//main//java//input//Input.xml");
		                    	input.delete();
		                    	File output = new File("src//main//java//output//Output.xml");
		                    	output.delete();
		                    	
		                   
		                    	Measure.measureNumber =1;
		                    	window.setScene(scene2);
		                    	
		                    	
		        		
		                    }});
		        		
		  
		        Pane layout2 = new Pane();
		        layout2.setPrefSize(width,height);
		        layout2.getChildren().add(mv2);
		        layout2.getChildren().add(textFlow2);
		        layout2.getChildren().add(textFlow4);
		        layout2.getChildren().add(openButton);
		        layout2.getChildren().add(textbox);
		        layout2.getChildren().add(info);
		        layout2.getChildren().add(info_button);
		        layout2.getChildren().add(textinfo);
		        layout2.getChildren().add(convert);
		        layout2.getChildren().add(convert_button);
		        layout2.getChildren().add(textconvert);

		        
		        
		        Pane layout3 = new Pane();
		        layout3.setPrefSize(width,height);
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
		        layout3.getChildren().add(edit2);
		        layout3.getChildren().add(edit_button2);
		        layout3.getChildren().add(edit_text2);
		        
		        Pane layout4 = new Pane();
		        layout4.setPrefSize(width,height);
		        layout4.getChildren().add(mv4);
		        layout4.getChildren().add(textFlow_edit);
		        layout4.getChildren().add(textFlow_edit2);
		        layout4.getChildren().add(textboxe);
		        layout4.getChildren().add(info2);
		        layout4.getChildren().add(info_button2);
		        layout4.getChildren().add(textinfo2);
		        layout4.getChildren().add(convert2);
		        layout4.getChildren().add(convert_button2);
		        layout4.getChildren().add(textconvert2);
		      
		        
	
		     
		scene2 = new Scene(layout2, width, height,Color.BLACK);
		scene3 = new Scene(layout3, width,height,Color.BLACK);
		
		scene4 = new Scene(layout4, width,height,Color.BLACK);
		
		window.setScene(scene1);
		window.setTitle("Tablature to MusicXML Converter");
		window.show();
		
		File input = new File("src//main//java//input//Input.txt");
    	input.delete();
    	File output = new File("src//main//java//output//Output.xml");
    	output.delete();
    	
		
		
	}
	
	public File chartoFile(ArrayList<char[][]> tmpArray1){
		
		File edit = new File("src//main//java//input//EditInput.txt");
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(edit);
			for(int i = 0; i < tmpArray1.size(); i++) {
				
				char[][] tmpPrint2 = tmpArray1.get(i);
				for(int j = 0; j < tmpPrint2.length; j++) {
					myWriter.write('|');
					for(int k = 0; k < tmpPrint2[0].length; k++) {
						myWriter.write(tmpPrint2[j][k]);
					}
					myWriter.write('|');
					myWriter.write('\n');
				}
				myWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return edit;
	}

}
