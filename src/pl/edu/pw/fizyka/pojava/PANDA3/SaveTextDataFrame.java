package pl.edu.pw.fizyka.pojava.PANDA3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class SaveTextDataFrame extends JFrame {
	
	/**
	 * @author MJaszek
	 * @author APodwójci
	 */
	
	public String emptyFile;
	public String editedFile;
	
	public boolean ifWasSaved = false;
	public File savedFileName = null;

	public Color color;
	public String currentFont = "Arial";
	public int fontSize = 12;
	JTextArea notepadArea;
	DecimalFormat numberFormat;
	int i;
	double conutedLambda = 0;
	
	int languageSelected;
	Languages wordsSelected;
	
	
	
	SaveTextDataFrame(ArrayList <Double> eValues,
			ArrayList <Double> xValues, int stepNumber,
			int whichLanguage, Languages wordsStore) 
					throws HeadlessException {
		
		setSize(600, 600);
		setVisible(true);
		setTitle(wordsStore.words[whichLanguage][23]);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		addWindowListener(windowListener);
		
		languageSelected = whichLanguage;
		wordsSelected = wordsStore;
		
		//	Menu Section
				
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOptions = 
				new JMenu(wordsSelected.words[languageSelected][1]);
		JMenuItem menuItemSave = new JMenuItem("Zapisz");
		menuOptions.setMnemonic(KeyEvent.VK_M);
		
		menuItemSave.addActionListener(saveFileListener);
		
		menuOptions.add(menuItemSave);
		menuBar.add(menuOptions);
		setJMenuBar(menuBar);
				
		//	Panel section
		JPanel textAreaPanel = new JPanel();
		JPanel optionsBar = new JPanel();
		setLayout(new BorderLayout());

		optionsBar.setLayout(new GridLayout(1, 0));
		textAreaPanel.setLayout(new GridLayout(1, 1));
				
		add(textAreaPanel, BorderLayout.CENTER);
		add(optionsBar, BorderLayout.NORTH);
		
		notepadArea = new JTextArea();
		notepadArea.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(notepadArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		numberFormat = new DecimalFormat("0.0000");
		
		fillTextArea(eValues, xValues, stepNumber);
		
		//	textAreaPanel.add(notepadArea);
		this.add(scroll);
	};
	 
	public void fillTextArea (ArrayList <Double> eValues,
			ArrayList <Double> xValues, int stepNumber){
		notepadArea.setText(null);
		emptyFile = notepadArea.getText();
		notepadArea.append(wordsSelected.words[languageSelected][24]
				+ String.valueOf(numberFormat.
						format(FindLambdaLength(eValues, xValues)))
				+ " metres \n");
		notepadArea.append(" " 
				+ new String(new char[50]).replace("\0", "_") +"\n");
		notepadArea.append("| \t x[m] \t|\t  E   \t|\n");
		notepadArea.append(" " 
				+ new String(new char[70]).replace("\0", "*") +"\n");

		for (i = 0; i<stepNumber; i++){
				notepadArea.append("|\t" 
						+ String.valueOf(numberFormat.format(xValues.get(i))) 
						+ "\t| \t"
						+ numberFormat.format(eValues.get(i))  +"\t|\n");
			}
		editedFile = notepadArea.getText();
	};
	
	double FindLambdaLength (ArrayList <Double> eValues,
			ArrayList<Double> xValues) {
		
		int n=eValues.size();
		double calculatedLambda=0;
		ArrayList<Double> maxPositions = new ArrayList<Double>();
		
		//here the maximum value positions are found:
		for(int i=1; i<n-1; i++){
			if((eValues.get(i)>eValues.get(i-1)) && (eValues.get(i+1)<eValues.get(i))){
				maxPositions.add(xValues.get(i));
				}
			} 
		int maxPositionsSize = maxPositions.size();
		
		if (maxPositionsSize < 2){
			calculatedLambda=0;
		}
		
		else{
			double positionsDifference = 
					(maxPositions.get(maxPositionsSize-1)-maxPositions.get(0));
			calculatedLambda=2*positionsDifference/(maxPositionsSize-1);
		}

		return(calculatedLambda);
	}
	
	// Menu action listeners
	
	ActionListener saveFileListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (!ifWasSaved) {
				JFileChooser saveFileChooser = new JFileChooser();
				int chooserValue = saveFileChooser.showSaveDialog(notepadArea);
				if (chooserValue == JFileChooser.APPROVE_OPTION) {
					savedFileName = saveFileChooser.getSelectedFile();
					
					try {
						PrintWriter out = new PrintWriter(savedFileName + ".txt");
						Scanner scanner = new Scanner(notepadArea.getText());
						while(scanner.hasNext()){
							out.println(scanner.nextLine() + "\n");
							
						};
						out.close();
						scanner.close();
						
					} catch (IOException d) {
						
					}
				}
			} else {
				try {
					FileWriter out = new FileWriter(savedFileName + ".txt");
					out.write(notepadArea.getText());
					out.close();
					editedFile = notepadArea.getText();
				} catch (IOException d) {
					
				}
			}
		}
	};

	WindowListener windowListener = new WindowListener() {
		
		@Override
		public void windowClosing(WindowEvent arg0) {
			if (editedFile != emptyFile) {

				int i = JOptionPane.showConfirmDialog(
						SaveTextDataFrame.this,
						wordsSelected.words[languageSelected][27],
						wordsSelected.words[languageSelected][28],
						JOptionPane.YES_NO_CANCEL_OPTION);

				if (i == JOptionPane.OK_OPTION) {
					JFileChooser saveFileChooser = new JFileChooser();
					saveFileChooser.setDialogTitle(
							wordsSelected.words[languageSelected][29]);
					int wartosc = saveFileChooser
							.showSaveDialog(SaveTextDataFrame.this);
					if (wartosc == JFileChooser.APPROVE_OPTION) {
						File savedFileName = saveFileChooser.getSelectedFile();

						try {
							PrintWriter out = new PrintWriter(savedFileName + ".txt");
							Scanner scanner = new Scanner(notepadArea.getText());
							while(scanner.hasNext()){
								out.println(scanner.nextLine() + "\n");
								
							};
							out.close();
							scanner.close();
							
						} catch (IOException d) {
							JOptionPane.showMessageDialog(
									SaveTextDataFrame.this,
									wordsSelected.words[languageSelected][30],
									wordsSelected.words[languageSelected][31],
									JOptionPane.ERROR_MESSAGE);
						}
						
					}
					setVisible(false);
					dispose();
				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}

				if (i == JOptionPane.NO_OPTION) {
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		}
		
		
		
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
		}
	};
	
	
}