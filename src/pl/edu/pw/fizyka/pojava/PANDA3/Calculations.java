package pl.edu.pw.fizyka.pojava.PANDA3;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Calculations extends JFrame{
	/**
	 * //this class is supposed to provide
	 *  wave E for exact Z2 position
	 * @author APodwojci
	 */
	
	double foundLambdaLength;
	double r = 0.1;
	double E0 = 2.0;
	double rMax = 0.8;
	double step;
	double k;
	
	Calculations () throws IOException{
		
        
	}
	
	public void calculateThings(double givenLambda,
			double givenDeltaX, int stepNumber,
			ArrayList <Double> eValues,ArrayList <Double> xValues){
		//length to deltaX for following positions
		step = (rMax - r - givenDeltaX)/stepNumber;
		k=2*Math.PI/givenLambda;
		
			for (int i=0; i<=stepNumber; i++){
				double zCurrentPosition=i*step;
				xValues.add(zCurrentPosition);
				
				double countedE = 4*E0*E0
						*Math.cos(2*Math.PI*(givenDeltaX+i*step)/givenLambda)
						*Math.cos(2*Math.PI*(givenDeltaX+i*step)/givenLambda);
				eValues.add(countedE);
		};
	}
}

