package pl.edu.pw.fizyka.pojava.PANDA3;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Author APodwojci
 */

/*
 this class creates a window which enables user 
 to choose the language and opens the MainWindow
 */

public class ChoosingLanguage extends JFrame {

	boolean whichFrameToOpen=false;
	JFrame startFrame;
	JFrame afterChoiceFrame;
	int chosenLanguageNo=0;
	String[] language = { "Polski", "English", "Deutsch"};
	Languages wordsStore;
	JPanel labelPanel;
	JPanel languageMenuPanel;
	JLabel choiceLabel;
	JComboBox<String> comboBox;
	JButton choiceButton;
	
	public ChoosingLanguage() {

		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(25,25));
		setLocationRelativeTo(null);
		
		labelPanel = new JPanel();
		add(labelPanel, BorderLayout.NORTH);

		languageMenuPanel = new JPanel();
		add(languageMenuPanel, BorderLayout.CENTER);
		
		choiceLabel = new JLabel("PL / ENG / DE");
		labelPanel.add(choiceLabel);
		comboBox = new JComboBox<String>(language);
		languageMenuPanel.add(comboBox);
		choiceButton = new JButton("Wybierz/Choose/Wählen");
		languageMenuPanel.add(choiceButton);
		
		comboBox.addItemListener(chooseLanguageNumber);
		choiceButton.addActionListener(actionAfterChoice);
		
		wordsStore = new Languages();
	}
	
	
	//Action Listeners Section
	ItemListener chooseLanguageNumber = new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem()=="Polski"){
				chosenLanguageNo = 0;	
			}
			else if(e.getItem()=="English"){
				chosenLanguageNo = 1;
			}
			else{
				chosenLanguageNo = 2;
			}			
		}		
	};
	
	ActionListener actionAfterChoice = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				MainWindow mainWindow = 
						new MainWindow(chosenLanguageNo);
				mainWindow.setVisible(true);
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dispose();
		
		}
		
	};
	

	
}