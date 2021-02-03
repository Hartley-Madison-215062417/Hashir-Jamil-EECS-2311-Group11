package tab2mxl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
/*
 * @author Madison Hartley
 */
public class TestingGround {

	
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
	
	
	//@SuppressWarnings("resource")
	//@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Testing reading from a text and scanning text
			//	File tmpfile = new File("C:\\Users\\maddi\\Documents\\EECS2311\\creep.txt");
			//	Scanner scan = new Scanner(tmpfile);
				//System.out.println(tmpfile.length());
				
//				while(scan.hasNextLine()) {
//					System.out.println(scan.nextLine());
//				}
				//Concatonate to combine and rewrite a file, will probs need to do once converted
				//Test later
				
//				Scanner keys = new Scanner(System.in);
//				String fileName = keys.nextLine();
//				
//				File file = new File(fileName);
//				Scanner inputFile = new Scanner(file);
//				String tmp = inputFile.nextLine();
//				
//				while(inputFile.hasNextLine()) {
//					System.out.println(inputFile.nextLine());
//				}
				
		
		
		
		//Reads back the file if the path is directly written in the code. File name typed in when code is ran.
		
		
				Scanner user = new Scanner(System.in);
				String inputFileName, outputFileName;
				
				System.out.println("File Name: ");
				inputFileName = user.nextLine(); //.trim();
				System.out.println(inputFileName);
				
			
				File f = new File("C:\\users\\maddi\\Documents\\EECS2311");
				File[] matchingFiles = f.listFiles(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.startsWith(inputFileName); //&& name.endsWith("txt");
					}
					
				});
				
				for(int i = 0; i < matchingFiles.length; i++) {
					File tabFile = matchingFiles[i];
					Scanner tabInput = new Scanner(tabFile);
					//String tmp = tabInput.nextLine();
					while(tabInput.hasNextLine()) {
						System.out.println(tabInput.nextLine());
					}
						
					
				}
				

				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						createAndShowGUI();
					}
										
				});
				
				
				
//				String fileName = File.separator+"tmp";
//				JFileChooser fileChooser = new JFileChooser(new File(fileName));
//				File tempf = fileChooser.getSelectedFile();
//				
//				String path = tempf.getAbsolutePath();
//				
//				File tmpTab = new File(path);
//				Scanner scanTab = new Scanner(tmpTab);
//					
//				
//				System.out.println("fml");
//				
//				while(scanTab.hasNextLine()) {
//					System.out.println(scanTab.nextLine());
//				}
				
				
				
				
	}
	
	
	
	

}
