package pl.edu.pw.fizyka.pojava.PANDA3;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainWindow extends JFrame {
	
	/**
	 * @Author APodwojci
	 * @author MJaszek
	 */
	
	private static final long serialVersionUID = 1L;
	
	int chosenLanguageNo;
	String[] language = { "Polski", "English", "Deutsch"};
	Languages wordsStore = new Languages();	
	ChoosingLanguage startFrame;
	
	MainWindow(int whichLanguage) throws HeadlessException, 
	IOException {
		setTitle(wordsStore.words[whichLanguage][0]);
		setSize(1100, 600);
		setMaximumSize(new Dimension(1920, 1080));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//	Look and feel section
		try{
			for(LookAndFeelInfo LaF : 
				UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(LaF.getName())){ 
					UIManager.setLookAndFeel(LaF.getClassName());
					break;
				}
			}
		}catch (Exception e1){
			e1.printStackTrace();
			JOptionPane.showMessageDialog(MainWindow.this, 
					"Nimbus niedostepny");
		} 
		
		//	Menu section
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu1 = 
				new JMenu(wordsStore.words[whichLanguage][1]);
		menuBar.add(menu1);
		JMenuItem newFrame = 
				new JMenuItem(wordsStore.words[whichLanguage][2]);
		JMenuItem exit = 
				new JMenuItem(wordsStore.words[whichLanguage][3]);
		newFrame.addActionListener(newSession);
		exit.addActionListener(closeListener);
		
		menu1.add(newFrame);
		menu1.add(exit);
		//	Pane section
		JTabbedPane tPane = new JTabbedPane();
		tPane.addTab(wordsStore.words[whichLanguage][4],
				new SimWindow(whichLanguage, wordsStore));
		tPane.addTab(wordsStore.words[whichLanguage][5], 
				new ForStudents(whichLanguage, wordsStore));
        this.add(tPane);
	}

	
		//	ActionListeners
	
	ActionListener closeListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	ActionListener newSession = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				MainWindow.main(new String[0]);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dispose();
		}
	};

	//	Main
	public static void main(String[] args) throws HeadlessException, 
	IOException {
		ChoosingLanguage startFrame = new ChoosingLanguage();
		startFrame.setVisible(true);
	}
}


