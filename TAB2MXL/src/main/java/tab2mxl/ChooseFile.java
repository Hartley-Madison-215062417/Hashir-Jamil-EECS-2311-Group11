package tab2mxl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
 * Author: Madison
 * A lot of this code is based off code directly copied off of:
 * https://examples.javacodegeeks.com/desktop-java/swing/jfilechooser/create-file-chooser-dialog/
 * And so, needs to be rewritten.
 */

public class ChooseFile {

	private static final long serialVersionUID = 1L;
	
	private static void createAndShowGUI() {
		
		//Create and set up the window here
		final JFrame frame = new JFrame("Centered");
		
		//Next is displaying the window, with some specifics
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set flow layout for the frame
		frame.getContentPane().setLayout(new FlowLayout());
		
		JButton button = new JButton("Choose file: ");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createFileChooser(frame);
			}
			
		});
		
		frame.getContentPane().add(button);
		
		
	}
	
	private static void createFileChooser(final JFrame frame) {
		
		String fileName = File.separator+"tmp";
		JFileChooser fileChooser = new JFileChooser(new File(fileName));
		
		//pops up the "open file" file chooser dialog
		fileChooser.showSaveDialog(frame);
		
		System.out.println("Chosen File: " + fileChooser.getSelectedFile());
		
		
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
								
		});
		
		
		
	}//ends the main class
	
}//end of all
