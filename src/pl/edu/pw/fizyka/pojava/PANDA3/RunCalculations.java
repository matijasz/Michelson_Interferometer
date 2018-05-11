package pl.edu.pw.fizyka.pojava.PANDA3;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author MJaszek
 */

public class RunCalculations {

	public static int i;
	ArrayList <Double> eValues = new ArrayList<Double>(); //a list of intensity values
	ArrayList <Double> xValues = new ArrayList<Double>(); //a list of positions in which intensity is measured
	ArrayList <Double> sinX1 = new ArrayList<Double>();
	ArrayList <Double> sinX2 = new ArrayList<Double>();
	ArrayList <Double> sinX12 = new ArrayList<Double>();
	Calculations calculate;
	SaveTextDataFrame saveFrame;
	RepresentWaves wavesFrame;
	IntensityChartWindow intensityChart;
	
	RunCalculations (double waveLength, double xPosition,
			int stepNumber, int whichLanguage, 
			Languages wordsStore)
					throws IOException{

		removeData();
		
		calculate = new Calculations();
		calculate.calculateThings(waveLength, xPosition,
				stepNumber, eValues, xValues);

		intensityChart = new IntensityChartWindow(eValues, 
				xValues, stepNumber, whichLanguage, wordsStore);
		saveFrame = new SaveTextDataFrame(eValues, xValues,
				stepNumber, whichLanguage, wordsStore);
		wavesFrame = new RepresentWaves(waveLength, xPosition,
				xValues, stepNumber, whichLanguage, wordsStore);
		doThings(waveLength, xPosition, stepNumber);
	};
	
	//	Method which does is running all calcuations for every
	// popup window with data 
	public void doThings (double waveLength, double xPosition,
			 final int stepNumber){
		removeData();

		calculate.calculateThings(waveLength, xPosition,
				stepNumber, eValues, xValues);
		wavesFrame.setDatasets(waveLength, xPosition,
				xValues, stepNumber);
		saveFrame.fillTextArea(eValues, xValues, stepNumber);	
		intensityChart.drawIntensityChart(eValues, xValues, stepNumber);
		
	};
	
	public void removeData(){
		eValues.clear();
		xValues.clear();
		sinX1.clear();
		sinX2.clear();
		sinX12.clear();
	} 

}
