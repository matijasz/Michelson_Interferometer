package pl.edu.pw.fizyka.pojava.PANDA3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ForStudents extends JPanel {

	/**
	 * @author APodwojci
	 * this class provides information for students
	 */
	
	public ForStudents(int whichLanguage, Languages wordsStore) 
			throws HeadlessException, IOException {
		
		setLayout(new GridLayout(1,2));
		
		//setting panels
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JPanel p1 = new JPanel();
			p1.setBorder(BorderFactory.createLoweredBevelBorder());
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(1,1,30,30));
		p2.setLayout(new FlowLayout());
		this.add(p1);
		this.add(p2);
		
		//adding textarea with info
		
		
		String textInfo = wordsStore.words[whichLanguage][15];
		JTextArea textInfoArea = new JTextArea(textInfo);
//		textInfoArea.setLineWrap(true);
		textInfoArea.setWrapStyleWord(true);
		textInfoArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textInfoArea.setEditable(false);
		textInfoArea.setBackground(new Color(237,237,237));
		
		JScrollPane scroll = new JScrollPane(textInfoArea);
		scroll.setVerticalScrollBarPolicy
			(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy
			(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		p1.add(scroll);
		
		//adding image
		
		ImageIcon infoscheme = createImageIcon("img/infoscheme.jpg",
				wordsStore.words[whichLanguage][14],
				whichLanguage, wordsStore);
		JLabel schemeLabel = new JLabel();
		schemeLabel.setIcon(infoscheme);
		schemeLabel.setText(wordsStore.words[whichLanguage][14]);
		schemeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		schemeLabel.setVerticalTextPosition(JLabel.BOTTOM);
		schemeLabel.setHorizontalTextPosition(JLabel.CENTER);
		schemeLabel.setIconTextGap(15);
		p2.add(schemeLabel);
	}
	
	public ImageIcon createImageIcon(String path, String description, 
			int whichLanguage, Languages wordsStore) {
	 	java.net.URL imgURL = ForStudents.class.getResource(path);
	 	if (imgURL != null) {
	 			return new ImageIcon(imgURL, description);
	 	} 
	 	else {
	 			System.err.println(wordsStore.words[whichLanguage][34] + path);
	 		    return null;
	 			}
 	}
	
}