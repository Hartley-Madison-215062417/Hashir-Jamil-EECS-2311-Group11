package tab2mxl;

import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class EditPopup {
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
	    
	    TextFlow textFlow3 = new TextFlow();
	    Text text = new Text("Change To: ");
	    text.setFill(Color.BLACK);
	    Font font3 = new Font("Tahoma", 15);
	    text.setFont(font3);
	    textFlow3.getChildren().add(text);
	    textFlow3.setLayoutX(20);
	    textFlow3.setLayoutY(160);
		
	    String[] options = {"Time Signature", "Song Title"};
	    ComboBox combo = new ComboBox(FXCollections.observableArrayList(options));
	    combo.setLayoutX(170);
	    combo.setLayoutY(100);
	    
	    final TextArea change = new TextArea("");
	    change.setLayoutX(170);
	    change.setLayoutY(150);
	    change.setMaxSize(200,50);
	    
	    change.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent keyEvent) {
				// TODO Auto-generated method stub
				if(keyEvent.getCode() == KeyCode.ENTER)
		        {
					
					String input_text = change.getText();
					char numerator = input_text.charAt(0);
					char denom = input_text.charAt(2);
					 
						try {
							File xml = new File("src//main//java//output//Output.xml");
						    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
						    DocumentBuilder dBuilder;
							dBuilder = dbFactory.newDocumentBuilder();

						    
						    Document doc = dBuilder.parse(xml);
						    doc.getDocumentElement().normalize();

						    System.out.println(doc.getDocumentElement().getNodeName());
						    NodeList nodes = doc.getElementsByTagName("time");

						    for (int i = 0; i < nodes.getLength(); i++) {
						      Node node = nodes.item(i);
						      if (node.getNodeType() == Node.ELEMENT_NODE) {
						        Element element = (Element) node;
					
						        setValue("beats",element,Integer.parseInt(String.valueOf(numerator)));
						        setValue("beat-type",element,Integer.parseInt(String.valueOf(denom)));
	
			
						      }
						    }
						} catch (ParserConfigurationException | SAXException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

					  }
		        }

			private void setValue(String tag, Element element,int value) {
				 NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
			        Node node = (Node) nodes.item(0);
			        node.setTextContent(String.valueOf(value));
			}

			private String getValue(String tag, Element element) {
				 NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
			        Node node = (Node) nodes.item(0);
			        return node.getNodeValue();
			
			}});
	    

	   Pane pane = new Pane();
		     
		      
		pane.getChildren().add(textFlow);
		pane.getChildren().add(combo);
		pane.getChildren().add(change);
		pane.getChildren().add(textFlow2);
		pane.getChildren().add(textFlow3);

		      
		Scene scene1= new Scene(pane, 500, 300,Color.RED);
		
		      
		popupwindow.setScene(scene1);
		popupwindow.showAndWait();

		       
	       
	}

}
