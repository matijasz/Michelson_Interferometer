package pl.edu.pw.fizyka.pojava.PANDA3;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class IntensityChartWindow extends JFrame   { 
	  
	/**
	 * @author MJaszek
	 * @author APodwojci
	 */
	//this class is supposed to give a chart presenting
	//an overall interference of the waves in detector

	double takenLambda;
	double l;
	double takenDeltaX;
	double takenStep;	
	double startPosition;
    double finishPosition;
    XYSeriesCollection collection1;
    XYDataset xyDataset;
    final XYSeries series1;
	
    
    IntensityChartWindow(ArrayList <Double> eValues,
    		ArrayList <Double> xValues, int stepNumber,
    		int whichLanguage, Languages wordsStore)
    { 
    	series1 = new XYSeries(wordsStore.words[whichLanguage][11]);
    	collection1 = new XYSeriesCollection();
    	
    	JFrame chartFrame = 
    			new JFrame(wordsStore.words[whichLanguage][16]);
		chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		chartFrame.getContentPane().setLayout(new FlowLayout());
		chartFrame.setSize(700,520);
		chartFrame.setAlwaysOnTop(true);
		chartFrame.setLocationByPlatform(true);

		
		drawIntensityChart(eValues, xValues, stepNumber);
		
		JFreeChart lineGraph = ChartFactory.createXYLineChart 
                (wordsStore.words[whichLanguage][20], //Title 
                 wordsStore.words[whichLanguage][22], //X-Axis label 
                 wordsStore.words[whichLanguage][21], //Y-Axis label 
                  xyDataset       					  // Dataset 
                 ); 
		
		ChartPanel chartPanel = new ChartPanel(lineGraph,
				true, true, true, true, true);
        chartFrame.getContentPane().add(chartPanel);
        chartFrame.getContentPane().add(
        		new JLabel(wordsStore.words[whichLanguage][26]));
        		
		chartFrame.setVisible(true);       
    }

    public void drawIntensityChart(ArrayList <Double> eValues,
    		ArrayList <Double> xValues, int stepNumber){
    	
    	series1.clear();
    	collection1.removeAllSeries();
    	
    	for (int i = 0; i<stepNumber; i++){
			series1.add(xValues.get(i), eValues.get(i));
		}
    	collection1.addSeries(series1);
		xyDataset = collection1;
    };    
    
}
