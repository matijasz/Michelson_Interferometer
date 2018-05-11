package pl.edu.pw.fizyka.pojava.PANDA3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class RepresentWaves extends JFrame   { 
	  
	/**
	 * @author MJaszek
	 * @author APodwojci
	 */
	//this class is supposed to give a chart 
	//presenting an overall interference of the waves in detector

	final XYSeries dataSet1;
    final XYSeries dataSet2;
    final XYSeries dataSet3; 	

    boolean if1 = true;
    boolean if2 = true;
    boolean if3 = true;
    
    double takenLambda;
	double k;
	double takenDeltaX;
	double takenStep;	
	double startPosition;
    double finishPosition;
    XYSeriesCollection xySeriesCollection;
    XYDataset xyDataset;
    
    RepresentWaves(double lambda, double deltaX, 
    		ArrayList<Double> xValues, double stepNumber,
    		int whichLanguage, Languages wordsStore){
    	
    	dataSet1= new XYSeries(wordsStore.words[whichLanguage][17]);
        dataSet2= new XYSeries(wordsStore.words[whichLanguage][18]);
        dataSet3 = new XYSeries(wordsStore.words[whichLanguage][19]);
	    
        setDatasets(lambda, deltaX, xValues, stepNumber);	

        xyDataset = xySeriesCollection;    
        
        JFreeChart lineGraph = ChartFactory.createXYLineChart 
        		(wordsStore.words[whichLanguage][20],  // Title 
                        wordsStore.words[whichLanguage][22], //X-Axis
                        wordsStore.words[whichLanguage][21], //Y-Axis
                        xyDataset        // Dataset 
                       ); 
        
        JFrame jframe = 
        		new JFrame(wordsStore.words[whichLanguage][16]);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        jframe.getContentPane().setLayout(new FlowLayout());
        jframe.setSize(700,520);
		jframe.setAlwaysOnTop(true);
		jframe.setLocationByPlatform(true);
		
		
        JCheckBox checkbox1 = 
        		new JCheckBox(wordsStore.words[whichLanguage][17], true);
		JCheckBox checkbox2 = 
				new JCheckBox(wordsStore.words[whichLanguage][18], true);     
		JCheckBox checkbox3 = 
				new JCheckBox(wordsStore.words[whichLanguage][19], true);
		jframe.add(checkbox1);
		jframe.add(checkbox2);
		jframe.add(checkbox3);
		
		checkbox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JCheckBox cb = (JCheckBox) e.getSource();
		        if (cb.isSelected()) {
		        	dataSet1.clear();
		        	for (double i=startPosition; i < finishPosition; i+=takenStep)
		        		dataSet1.add(i,2*Math.cos(-k*i));
		        	if1 = true;
		        } else {
		        dataSet1.clear();
	        	for (double i=startPosition; i < finishPosition; i+=takenStep)
	        		dataSet1.add(0,0);
	        	if1 = false;
		        }
			}
		});
		
		checkbox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JCheckBox cb = (JCheckBox) e.getSource();
		        if (cb.isSelected()) {
		        	dataSet2.clear();
		        	for (double i=startPosition; i< finishPosition; i+=takenStep)
		        		dataSet2.add(i,2*Math.cos(k*i-k*2*Math.PI*takenDeltaX/takenLambda));
		        	if2 = true;
		        } else {
		        	dataSet2.clear();
		        	for (double i=startPosition; i < finishPosition; i+=takenStep)
		        		dataSet2.add(0,0);
		        	if2 = false;
		        }

			}
		});
		
		checkbox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JCheckBox cb = (JCheckBox) e.getSource();
		        if (cb.isSelected()) {
		        	dataSet3.clear();
		        	for (double i=startPosition; i< finishPosition; i+=takenStep)
		        		dataSet3.add(i, 2*Math.cos(k*i-k*2*Math.PI*takenDeltaX/takenLambda)
		        				+2*Math.cos(-k*i));
		        	if3 = true;
		        } else {
		        	dataSet3.clear();
		        	for (double i=startPosition; i < finishPosition; i+=takenStep)
		        		dataSet3.add(0,0);
		        	if3 = false;
		        }

			}
		});

        ChartPanel chartPanel = 
        		new ChartPanel(lineGraph, true, true, true, true, true);
        jframe.getContentPane().add(chartPanel);
        jframe.getContentPane().add(
        		new JLabel(wordsStore.words[whichLanguage][26]));
        
        jframe.setVisible(true);
        
    }
	
    public void setDatasets (double lambda, double deltaX, 
    		ArrayList<Double> xValues, double stepNumber){
    	takenLambda=lambda;
    	k=2*Math.PI/takenLambda;
    	takenDeltaX = deltaX;
    	takenStep = (0.8 - 0.1 - deltaX)/stepNumber;
    	startPosition = xValues.get(0);
 	    finishPosition = xValues.get(xValues.size()-1);
    	
 	    dataSet1.clear();	
 		dataSet2.clear();
 		dataSet3.clear();
 	    
 		if (if1) 
 			for (double i=startPosition; i < finishPosition; i+=takenStep)
 				dataSet1.add(i,2*Math.cos(-k*i));
    	if (if2) 
    		for (double i=startPosition; i< finishPosition; i+=takenStep) 
    			dataSet2.add(i,2*Math.cos(k*i-k*2*Math.PI*takenDeltaX/takenLambda));
    	if (if3) 
    		for (double i=startPosition; i< finishPosition; i+=takenStep) 
    			dataSet3.add(
    					i,2*Math.cos(k*i-k*2*Math.PI*takenDeltaX/takenLambda)
    					+2*Math.cos(-k*i));
    	xySeriesCollection = new XYSeriesCollection(dataSet1); 
    	xySeriesCollection.addSeries(dataSet2);
    	xySeriesCollection.addSeries(dataSet3);
    	xyDataset = xySeriesCollection; 
    };
}
