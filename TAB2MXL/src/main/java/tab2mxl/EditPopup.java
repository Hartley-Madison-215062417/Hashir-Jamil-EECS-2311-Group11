package tab2mxl;

import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EditPopup{
	static String choice="";
	static Scene scene2;
	static int number = 0;
	static int beats = 4;
	static int beatType = 4;
	
	public static void display()
	{
		Stage popupwindow=new Stage();
	    
		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Manual Edit");
		
		      

	    TextFlow textFlow = new TextFlow();
	    Font font = new Font("Tahoma", 20);
	    Text choose = new Text("What would you like to edit?");
	    choose.setFill(Color.BLACK);
	    choose.setFont(font);
	    textFlow.getChildren().add(choose);
	    textFlow.setLayoutX(125);
	    textFlow.setLayoutY(20);
	    
	    TextFlow textFlow2 = new TextFlow();
	    Font font2 = new Font("Tahoma", 15);
	    Text change_text = new Text("Edit: ");
	    change_text.setFill(Color.BLACK);
	    change_text.setFont(font2);
	    textFlow2.getChildren().add(change_text);
	    textFlow2.setLayoutX(20);
	    textFlow2.setLayoutY(105);
	    
	    TextFlow textFlow4 = new TextFlow();
	    Font font4 = new Font("Tahoma", 15);
	    Text measure_text = new Text("Measure Number: ");
	    measure_text.setFill(Color.BLACK);
	    measure_text.setFont(font4);
	    textFlow4.getChildren().add(measure_text);
	    textFlow4.setLayoutX(20);
	    textFlow4.setLayoutY(180);
	    
	    final TextArea measure = new TextArea("");
	    measure.setPromptText("Enter measure number or All to change all measures ");
	 
	  
	    measure.setLayoutX(170);
	    measure.setLayoutY(180);
	    measure.setMaxSize(200,50);
	    
	    TextFlow textFlow3 = new TextFlow();
	    Text text = new Text("Change To: ");
	    text.setFill(Color.BLACK);
	    Font font3 = new Font("Tahoma", 15);
	    text.setFont(font3);
	    textFlow3.getChildren().add(text);
	    textFlow3.setLayoutX(20);
	    textFlow3.setLayoutY(100);
	    
	    
	    TextFlow textFlow5 = new TextFlow();
	    Text title = new Text("Edit Time Signature ");
	    title.setFill(Color.BLACK);
	    Font font6 = new Font("Tahoma", 20);
	    title.setFont(font6);
	    textFlow5.getChildren().add(title);
	    textFlow5.setLayoutX(180);
	    textFlow5.setLayoutY(20);
	    
	    TextFlow textFlow6 = new TextFlow();
	    Text song_title = new Text("Edit Song Title");
	    song_title.setFill(Color.BLACK);
	    Font font7 = new Font("Tahoma", 20);
	    song_title.setFont(font7);
	    textFlow6.getChildren().add(song_title);
	    textFlow6.setLayoutX(180);
	    textFlow6.setLayoutY(20);
		
		
	    String[] options = {"Time Signature", "Song Title"};
	    ChoiceBox<String> combo = new ChoiceBox<>();
	    combo.getItems().addAll("Time Signature","Song Title");
	    combo.setLayoutX(170);
	    combo.setLayoutY(100);
	    
	    
	    Button b = new Button("Change");
	    b.setLayoutX(350);
	    b.setLayoutY(100);
	    b.setMaxSize(200,50);
	    
	    Button b2 = new Button("Change");
	    b2.setLayoutX(170);
	    b2.setLayoutY(250);
	    b2.setMaxSize(200,50);
	    
	    Button b3 = new Button("Change");
	    b3.setLayoutX(170);
	    b3.setLayoutY(250);
	    b3.setMaxSize(200,50);
	    
	    final TextArea change = new TextArea("");
	    change.setPromptText("beat/beat type");
	 
	  
	    change.setLayoutX(170);
	    change.setLayoutY(100);
	    change.setMaxSize(200,50);
	    
	    b.setOnAction(
		        new EventHandler<ActionEvent>() {
                	
                    @Override
                    public void handle(final ActionEvent e) {
                    	if(combo.getValue() == "Time Signature") {
                    	Pane tpane = new Pane();
                		tpane.getChildren().add(change);
                		tpane.getChildren().add(textFlow5);
                		tpane.getChildren().add(textFlow3);
                		tpane.getChildren().add(textFlow4);
                		tpane.getChildren().add(measure);
                		tpane.getChildren().add(b2);
                		      
                    	Scene scene2= new Scene(tpane, 500, 300,Color.RED);
						popupwindow.setScene(scene2);
						
						 b2.setOnAction(
							        new EventHandler<ActionEvent>() {
					                	
					                    @Override
					                    public void handle(final ActionEvent e) {
											choice = "Time Signature";
											String input_text = change.getText();
											if(input_text.length()!=3) {
												change.clear();
												change.appendText("Invalid input. Please make sure to enter beats/beat type without any additional text/spaces");
											}
											else {
											char numerator = input_text.charAt(0);
											char denom = input_text.charAt(2);
											beats = numerator;
											beatType = denom;
											
											String measure_choice = measure.getText();
									
											File xml = new File("src//main//java//output//Output.xml");
												
											DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
									        DocumentBuilder dBuilder;
									        
									        if(measure_choice.equalsIgnoreCase("all")) {
									        
									        try {
									            dBuilder = dbFactory.newDocumentBuilder();
									            Document doc = dBuilder.parse(xml);
									            doc.getDocumentElement().normalize();
									            
									            number =1;

										        NodeList nodes = doc.getElementsByTagName("time");
										        for(int i=0;i<nodes.getLength();i++) {
										       
										        Node node = nodes.item(i);
										        if (node.getNodeType() == Node.ELEMENT_NODE) {
											        Element element = (Element) node;
											        Node beat = element.getElementsByTagName("beats").item(0).getFirstChild();
											        beat.setNodeValue(String.valueOf(numerator));
											        
											       Node type = element.getElementsByTagName("beat-type").item(0).getFirstChild();
											        type.setNodeValue(String.valueOf(denom));
											        
											        
										        }
										        }
										        
									            doc.getDocumentElement().normalize();
									            TransformerFactory transformerFactory = TransformerFactory.newInstance();
									            Transformer trans = transformerFactory.newTransformer();
									            DOMSource dom = new DOMSource(doc);
									            xml.delete();
 				    				            StreamResult newfile = new StreamResult(new File("src//main//java//output//Output.xml"));
									          //  StreamResult newfile = new StreamResult(new File("updated.xml"));
									           // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
									            trans.transform(dom, newfile);
									            
									            popupwindow.close();
									            
									            
									        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
									            e1.printStackTrace();
									        }
									        }
									        else if(isNumeric(measure_choice)) {
									        	int num = Integer.parseInt(measure_choice);
									        	number = num;
									  
									        	
										        try {
										            dBuilder = dbFactory.newDocumentBuilder();
										            Document doc = dBuilder.parse(xml);
										            doc.getDocumentElement().normalize();
										            
										            

											        NodeList nodes = doc.getElementsByTagName("time");
											       
											        Node node = nodes.item(num-1);
											        if (node.getNodeType() == Node.ELEMENT_NODE) {
												        Element element = (Element) node;
												        Node beat = element.getElementsByTagName("beats").item(0).getFirstChild();
												        beat.setNodeValue(String.valueOf(numerator));
												        
												       Node type = element.getElementsByTagName("beat-type").item(0).getFirstChild();
												        type.setNodeValue(String.valueOf(denom));
												        
												        
											        }
											        
										            doc.getDocumentElement().normalize();
										            TransformerFactory transformerFactory = TransformerFactory.newInstance();
										            Transformer trans = transformerFactory.newTransformer();
										            DOMSource dom = new DOMSource(doc);
										            xml.delete();
	 				    				            StreamResult newfile = new StreamResult(new File("src//main//java//output//Output.xml"));
										          //  StreamResult newfile = new StreamResult(new File("updated.xml"));
										           // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
										            trans.transform(dom, newfile);
										            
										            popupwindow.close();
										            
										            
										        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
										            e1.printStackTrace();
										        }
									        }
									     
									        
									        else{
									        	measure.clear();
									        	measure.appendText("Invalid input");
									        }
									        
									        
											}  }});
						
                    	}
                    	
                    	else if(combo.getValue() == "Song Title"){
                    		
                    		Pane tpane = new Pane();
                    		tpane.getChildren().add(change);
                    		tpane.getChildren().add(textFlow6);
                    		tpane.getChildren().add(textFlow3);  
                    		tpane.getChildren().add(b3); 
                    		
                        	Scene scene2= new Scene(tpane, 500, 300,Color.RED);
    						popupwindow.setScene(scene2);
    						
    						 b3.setOnAction(
 							        new EventHandler<ActionEvent>() {
 					                	
 					                    @Override
 					                    public void handle(final ActionEvent e) {
 					                    	
 					                    	choice = "Song Title";
 				    						String input_text = change.getText();
 				    						File xml = new File("src//main//java//output//Output.xml");
 				    							
 				    						DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 				    				        DocumentBuilder dBuilder;
 				    				        try {
 				    				            dBuilder = dbFactory.newDocumentBuilder();
 				    				            Document doc = dBuilder.parse(xml);
 				    				            doc.getDocumentElement().normalize();


 				    					        NodeList nodes = doc.getElementsByTagName("work");
 				    					     
 				    					        Node node = nodes.item(0);
 				    					        if (node.getNodeType() == Node.ELEMENT_NODE) {
 				    						        Element element = (Element) node;
 				    						        Node beat = element.getElementsByTagName("work-title").item(0).getFirstChild();
 				    						        beat.setNodeValue(String.valueOf(input_text));
 				    						   
 				    					        }
 				    					        
 				    				            doc.getDocumentElement().normalize();
 				    				            TransformerFactory transformerFactory = TransformerFactory.newInstance();
 				    				            Transformer trans = transformerFactory.newTransformer();
 				    				            DOMSource dom = new DOMSource(doc);
 				    				            xml.delete();
 				    				            StreamResult newfile = new StreamResult(new File("src//main//java//output//Output.xml"));
 				    				           // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
 				    				            trans.transform(dom, newfile);
 				    				            
 				    				            popupwindow.close();
 				    				            
 				    				            
 				    				        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
 				    				            e1.printStackTrace();
 				    				        }
 				                    		
 				                    	}
 					                    });
    						
    						
                    	}
                    	
                    	
                    	
                    }});
	    

	   Pane pane = new Pane();
		     
		      
		pane.getChildren().add(textFlow);
		pane.getChildren().add(textFlow2);
		pane.getChildren().add(combo);
		pane.getChildren().add(b);

		
		Scene scene1= new Scene(pane, 500, 200,Color.RED);
		
		
		      
		popupwindow.setScene(scene1);
		popupwindow.showAndWait();

		       
	       
	}
	public static boolean isNumeric(String s) {
		try {
	        int i = Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
		
	}
	
	private static void getValue(ComboBox combo) {
		
	}

	public static String getChoice() {
		return choice;
	}




}