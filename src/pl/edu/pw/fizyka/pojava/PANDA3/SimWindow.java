package pl.edu.pw.fizyka.pojava.PANDA3;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimWindow extends JPanel {
	/**
	 * @author MJaszek
	 */
	
	private JSpinner xPositionSpinner;
	private JSpinner waveLengthSpinner;
	public JSlider waveLengthSlider;
	public JSlider xPositionSlider;
	public JSpinner stepNumber;
	
	int number;
	int i;	//	iterator 
	RunCalculations calculate;
	int languageSelected;
	Languages wordsSelected;
	boolean ifStarted = false;
	
	SimWindow (int whichLanguage, Languages wordsStore) throws HeadlessException, IOException{
		
		languageSelected = whichLanguage;
		wordsSelected = wordsStore;
		
		//	Right panel section	
		this.setLayout(new BorderLayout(25, 25));
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightCenter = new JPanel();
			right.add(rightCenter, BorderLayout.CENTER);
		this.add(right, BorderLayout.EAST);

		//	Left panel section	
		JPanel left = new JPanel(new BorderLayout(25, 25));
		JPanel leftTop = new JPanel(new BorderLayout(25, 25));
		JPanel leftTopCenter = new JPanel(new GridLayout(3, 1));
			JPanel leftTopCenterXPosition = 
					new JPanel(new BorderLayout(25, 25));
				leftTopCenterXPosition.setBorder(BorderFactory.
						createTitledBorder(wordsSelected.words[whichLanguage][6]));
			JPanel leftTopCenterWaveLength = 
					new JPanel(new BorderLayout(25,25));
				leftTopCenterWaveLength.setBorder(BorderFactory.
						createTitledBorder(wordsSelected.words[whichLanguage][7]));
			JPanel leftTopCenterSetSteps = 
					new JPanel(new BorderLayout(25, 25));
				leftTopCenterSetSteps.setBorder(BorderFactory.
						createTitledBorder(wordsSelected.words[whichLanguage][8]));
			JPanel leftBottom = 
					new JPanel(new BorderLayout(25,25));
			
		left.add(leftBottom, BorderLayout.SOUTH);
		left.add(leftTop, BorderLayout.NORTH);
		leftTop.add(leftTopCenter, BorderLayout.CENTER);
			leftTopCenter.add(leftTopCenterXPosition);
			leftTopCenter.add(leftTopCenterWaveLength);	
			leftTopCenter.add(leftTopCenterSetSteps);
		
		this.add(left, BorderLayout.WEST);
		
		//	Left Panel
		SpinnerNumberModel xPositionSpinnerModel = 
				new SpinnerNumberModel(0, 0, 700, 1);
		xPositionSpinner = new JSpinner(xPositionSpinnerModel);
		xPositionSpinner.addChangeListener(xValueSpinnerListener);

		xPositionSlider= new JSlider(0, 700, 0);
		xPositionSlider.setMajorTickSpacing(50); 
		xPositionSlider.setMinorTickSpacing(10);
		xPositionSlider.setPaintTicks(true);
		xPositionSlider.setPaintLabels(true);
		xPositionSlider.setPaintTrack(false);
		xPositionSlider.setPreferredSize(new Dimension(350, 50));
		xPositionSlider.addChangeListener(xValueSliderListener);
		
		//	Wavelength
		
		SpinnerNumberModel waveLengthSpinnerModel = 
				new SpinnerNumberModel(500, 0, 1000, 1);
		waveLengthSpinner = new JSpinner(waveLengthSpinnerModel);
		waveLengthSpinner.addChangeListener(waveLengthSpinnerListener);
		
		waveLengthSlider = new JSlider(0, 1000, 500);
		waveLengthSlider.setMajorTickSpacing(200);
		waveLengthSlider.setMinorTickSpacing(20);
		waveLengthSlider.setPaintTicks(true);
		waveLengthSlider.setPaintLabels(true);
		waveLengthSlider.setPaintTrack(false);
		waveLengthSlider.setPreferredSize(new Dimension(350, 50));
		waveLengthSlider.addChangeListener(waveLengthSliderListener);

		//	Number of steps
		SpinnerNumberModel stepNumberSpinnerModel = 
				new SpinnerNumberModel(500, 100, 1000, 1);
		stepNumber = new JSpinner(stepNumberSpinnerModel);
		stepNumber.addChangeListener(stepNumberChangeListener);
		stepNumber.setPreferredSize(new Dimension(80, 30));
		
		ImageIcon infoscheme = createImageIcon("img/infoscheme.jpg",
				wordsStore.words[whichLanguage][14], whichLanguage, wordsStore);
		JLabel schemeLabel = new JLabel();
		schemeLabel.setIcon(infoscheme);
		schemeLabel.setText(wordsStore.words[whichLanguage][14]);
		schemeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		schemeLabel.setVerticalTextPosition(JLabel.BOTTOM);
		schemeLabel.setHorizontalTextPosition(JLabel.CENTER);
		schemeLabel.setIconTextGap(15);
		
		JButton startMeasurement = new JButton(wordsStore.words[whichLanguage][13]);
		startMeasurement.setFont(new Font("Century Gothic", Font.ITALIC, 30));
		startMeasurement.setPreferredSize(new Dimension(300, 100));
		startMeasurement.addActionListener(startButton);
		
		//	Item adding section
		leftTopCenterXPosition.add(xPositionSlider, BorderLayout.CENTER);
		leftTopCenterXPosition.add(xPositionSpinner, BorderLayout.EAST);
		
		leftTopCenterWaveLength.add(waveLengthSlider, BorderLayout.WEST);
		leftTopCenterWaveLength.add(waveLengthSpinner, BorderLayout.EAST);
		
		leftTopCenterSetSteps.add(stepNumber, BorderLayout.NORTH);
		
		rightCenter.add(schemeLabel, BorderLayout.NORTH);

		leftBottom.add(startMeasurement);
	}
	
	
	ActionListener startButton = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(getXPositionValue() == 0.7){
				JOptionPane.showMessageDialog(SimWindow.this,
						wordsSelected.words[languageSelected][32],
						wordsSelected.words[languageSelected][33],
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					 calculate = new RunCalculations(getWaveLenghtValue(),
							 getXPositionValue(), (int)stepNumber.getValue(),
							 languageSelected, wordsSelected);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ifStarted = true;
			}
		}
	};
	
	ChangeListener xValueSliderListener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			xPositionSpinner.setValue((int) xPositionSlider.getValue());
			if(getXPositionValue() == 0.7){
				JOptionPane.showMessageDialog(SimWindow.this,
						wordsSelected.words[languageSelected][32],
						wordsSelected.words[languageSelected][33],
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(ifStarted){
					calculate.doThings(getWaveLenghtValue(),
							getXPositionValue(), getStepNumber());
				}
			}
		}
	};
	
	ChangeListener xValueSpinnerListener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			xPositionSlider.setValue((int) xPositionSpinner.getValue());
		}
	};
	
	ChangeListener waveLengthSliderListener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			waveLengthSpinner.setValue(waveLengthSlider.getValue());
			if(ifStarted){
				calculate.doThings(getWaveLenghtValue(),
						getXPositionValue(), getStepNumber());
			}
		}
			
	};
	
	ChangeListener waveLengthSpinnerListener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			waveLengthSlider.setValue((int) waveLengthSpinner.getValue());
		}
	};

	ChangeListener stepNumberChangeListener = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(ifStarted){
			waveLengthSpinner.setValue(waveLengthSlider.getValue());
			calculate.doThings(getWaveLenghtValue(),
					getXPositionValue(), getStepNumber());
			}
		}
	};

	public double getWaveLenghtValue (){
		double lambda = (double) waveLengthSlider.getValue()/1000.0;
		return lambda;
	};
	
	public double getXPositionValue (){
		double dX = (double) xPositionSlider.getValue()/1000.0;
		return dX;
	};
	
	public int getStepNumber(){
		int dS = (int) stepNumber.getValue();
		return dS;
	};
	public ImageIcon createImageIcon(String path, String description,
			int whichLanguage, Languages wordsStore) {
		
	 	java.net.URL imgURL = SimWindow.class.getResource(path);
	 	if (imgURL != null) {
	 			return new ImageIcon(imgURL, description);
	 	} 
	 	else {
	 			System.err.println(wordsStore.words[whichLanguage][34] + path);
	 		     return null;
	 			}
 	}
}
