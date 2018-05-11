package pl.edu.pw.fizyka.pojava.PANDA3;

//	a dictionary for 3 languages versions
/**
 * @Author APodwojci
 */

public class Languages {

	int numberOfLanguages = 3;
	int numberOfTextItems = 35;
	String [][] words = 
			new String [numberOfLanguages][numberOfTextItems];

	public Languages(){
		
		for(int language=0; language<3; language++){
			for(int textItem=0; textItem<numberOfTextItems; textItem++){
				words[language][textItem]= new String();
			}
		}
		
		//POLSKI
		words [0][0] = "Doświadczenie Michelsona";
		words [0][1] = "Menu";
		words [0][2] = "Nowa Sesja";
		words [0][3] = "Wyjście";
		words [0][4] = "Symulacja";
		words [0][5] = "Dla ucznia";
		words [0][6] = "Wybierz przesunięcie zwierciadła [mm]";
		words [0][7] = "Wybierz długość fali [mm]";
		words [0][8] = "Wybierz liczbę kroków w pomiarze";
		words [0][9] = "przesunięcie zwierciadła [m]";
		words [0][10] = "natężenie fali wypadkowej";
		words [0][11] = "seria pomiarowa";
		words [0][12] = "Natężenie fali wypadkowej (stojącej) w"
				+ " zależności od przesunięcia zwierciadła";
		words [0][13] = "Start pomiaru";
		words [0][14] = "Schemat układu pomiarowego w "
				+ "doświadczeniu Michelsona";
		words [0][15] = "\nCelem ćwiczenia jest zbadanie zjawiska"
				+ " interferencji fal i \nwyznaczenie długości "
				+"fali promieniowania mikrofalowego \nza pomocą"
				+ " interferometru Michelsona."
				+"\nMikrofale to fale o długościach rzędu"
				+ " centymetrów.\nFala elektromagnetyczna ze"
				+ " źródła pada na półprzepuszczalną \npłytkę P, "
				+"która przepuszcza połowę natężenia fali,"
				+ " a połowę odbija. \nFala odbita "
				+"kierowana jest na zwierciadło Z2, a po"
				+ " odbiciu,\nprzechodzi przez płytkę P i trafia"
				+ " do detektora fal \nelektromagnetycznych D."
				+ " Fala, która przeszła przez płytkę P,"
				+ "\nodbija się od zwierciadła Z1, ulega odbiciu "
				+"od płytki P i trafia do \ndetektora D. "
				+ "Zwierciadło Z1 można przesuwać, "
				+"zmieniając w ten \nsposób różnicę dróg "
				+ "optycznych fal odbitych od obu zwierciadeł."
				+"\n\n Δ - różnica dróg optycznych, λ - długość"
				+ " fali, n - wielokrotność"
				+"\n\n Jeśli Δ =nλ, to mamy wzmocnienie"
				+ " fali interferowanej\n\n Jeśli Δ =(2n+1)λ/2,"
				+ " to mamy wygaszenie fali interferowanej"
				+"\n\n Jeśli x to przesunięcie zwierciadła,"
				+ " a n - liczba max wzmocnień,"
				+"\n\n to długość poszukiwanej fali: "
				+ "\n\n\t\t    λ=2x/n"
				+"\n\nOdczytując na wykresie liczbę wzmocnien n, otrzymamy \ndługość fali.";
		words [0][16] = "Wykresy funkcji składowych i wypadkowej";
		words [0][17] = "Składowa 1";
		words [0][18] = "Składowa 2";
		words [0][19] = "Wypadkowa";
		words [0][20] = "Różnica faz fal składowych i ich "
				+ "interferencja w detektorze";
		words [0][21] = "Cosinus()";
		words [0][22] = "Położenie (przesunięcie zwierciadła"
				+ " ruchomego) [m]";
		words [0][23] = "Zapisz tekstowe wyniki pomiarów";
		words [0][24] = "Wyznaczona w doświadczeniu długość"
				+ " fali:";
		words [0][25] = "Zapisz";
		words [0][26] = "---> kliknij prawy przycisk myszy "
				+ "na wykresie by zapisać";
		words [0][27] = "Czy chcesz zapisać plik w aktualnym stanie?";
		words [0][28] = "Plik nie został zapisany!";
		words [0][29] = "Podaj nazwę";
		words [0][30] = "Błąd podczas zapisywania pliku";
		words [0][31] = "BŁĄD";
		words [0][32] = "Nie można przesunąć zwierciadła dalej"
				+ "\nwybierz przesunięcie mniejsze niż 700 mm";
		words [0][33] = "** UWAGA! **";
		words [0][34] = "Nie udało się znaleźć pliku.";
		
		//	ENGLISH
		words [1][0] = "Michelson Interferometer Experiment";
		words [1][1] = "Menu";
		words [1][2] = "New Session";
		words [1][3] = "Exit";
		words [1][4] = "Simulation";
		words [1][5] = "For students";
		words [1][6] = "Change the mirror's position [mm]";
		words [1][7] = "Choose the source wavelength [mm]";
		words [1][8] = "Choose the number of recors in the"
					 + " experiment (>=500)";
		words [1][9] = "the change of the mirror's position [m]";
		words [1][10] = "the wave's intensity";
		words [1][11] = "experiments series";
		words [1][12] = "The intensity of combined wave";
		words [1][13] = "START";
		words [1][14] = "Michelson Interferometer - Scheme";
		words [1][15] = "\nThe aim of the experiment is to "
				+ "observe the interference \nof waves and "
				+"finding the source microwave's length,"
				+ "\nusing the Michelson Interferometer."
				+"\nEM wave is emitted from the light source."
				+"\nThe falf-silvered mirror P passes half to "
				+ "the movable mirror.\nFrom the movable mirror "
				+ "the light is reflected back,"
				+"\ngoes through the P mirror and further "
				+ "straight to the detector.\n"
				+"The other half goes through the half-silvered "
				+ "mirror and after it reaches\nthe fixed mirror,"
				+ " it goes back to the P mirror, which reflects"
				+ " it straight \nto the detector.\n\nBy moving"
				+ " the mirror and finding positions in which "
				+ "\nthe intensity in detector is maximum, you"
				+ " can approximate\nthe source wavelength."
				+"\n\n Δ - mirrors positions difference, "
				+ "λ - wavelength, n - natural number"
				+"\n\n If Δ =nλ, we observe the maximum intensity"
				+"\n\n When Δ =(2n+1)λ/2, the instensity is 0"
				+"\n\n If x is the mirror's position difference, "
				+ "n - the number of maximum \n intensity,"
				+"\n\n points observed, then:"
				+"\n\n the approximate wavelength is: "
				+ "\n\n\t\t    λ=2x/n"
				+"\n\nIn short: count the number of maximum values"
				+ "\non the intensity chart,"
				+"\ncheck the position difference and find the λ";
		words [1][16] = "Two reflected waves and the interferred "
				+ "wave";
		words [1][17] = "Wave 1";
		words [1][18] = "Wave 2";
		words [1][19] = "Interferred";
		words [1][20] = "The waves' phase difference and their "
				+ "interference";
		words [1][21] = "Cosinus()";
		words [1][22] = "The changing position of the movable "
				+ "mirror [m]";
		words [1][23] = "Save the records as .txt file";
		words [1][24] = "Wavelength found in the experiment:";
		words [1][25] = "Save";
		words [1][26] = "---> right click on the chart to save";
		words [1][27] = " Do you want to save file in it's current "
				+ "state? ";
		words [1][28] = " File not saved! ";
		words [1][29] = "Give the name";
		words [1][30] = "Error while saving file!";
		words [1][31] = "ERROR";
		words [1][32] = "You shall not pass 700 mm limit! \nchoose "
				+ "the position smaller than 700 mm";
		words [1][33] = "** WARNING! **";
		words [1][34] = "Couldn' t find file: ";
		
		//DEUTSCH
		words [2][0] = "Michelson-Interferometer Experiment";
		words [2][1] = "Menu";
		words [2][2] = "Neues Experiment";
		words [2][3] = "Exit";
		words [2][4] = "Simulation";
		words [2][5] = "Für Studenten";
		words [2][6] = "Wählen Sie die Lage von dem Spiegel [mm]";
		words [2][7] = "Wählen Sie die Wellelänge [mm]";
		words [2][8] = "Wählen Sie den Schritt";
		words [2][9] = "die Lage des Spiegels";
		words [2][10] = "Wellestärke";
		words [2][11] = "Messungen";
		words [2][12] = "Resultierende Wellestärke";
		words [2][13] = "START";
		words [2][14] = "Aufbau des Michelson-Interferometers";
		words [2][15] = "\nDie generelle Funktionsweise eines "
				+ "Interferometers besteht darin,"
				+ "\ndass eine Lichtwelle in zwei Teile aufgeteilt"
				+ " wird. Diese zwei Wellen\ndurchlaufen dann "
				+ "unterschiedlich lange Strecken oder Medien, in"
				+ " denen\ndie Laufzeit verschieden ist. Dadurch"
				+ " ergibt sich eine Phasenverschiebung"
				+ "\nzwischen den zwei Wellen. Werden diese dann "
				+ "wieder zusammengeführt,\nkommt es zur Interferenz."
				+ "\nDie beiden Strahlbündel sind dabei noch immer "
				+ "kohärent, wenn ihr \noptischer Wegunterschied"
				+ " kleiner als die Kohärenzlänge der Lichtquelle"
				+ " ist. \nSind die Abstände zwischen der "
				+ "semipermeablen Platte\nund den Spiegeln jeweils "
				+ "gleich, haben die am Detektor eintreffenden "
				+ "\nStrahlen\neinen Phasenunterschied von 0."
				+ " Verschiebt man nun einen der beiden \nSpiegel"
				+ "\num den Abstand 'd', so entsteht zwischen den"
				+ " beiden Strahlenbündeln\nein Wegunterschied Δw=2d,"
				+ " und die Lichtstärke ändert sich.Stellt man \nnun die"
				+ "\nAnzahl 'z' der Interferenzmaxima bei einer"
				+ " Verschiebestrecke Δw fest,\nso lässt"
				+ " sich die Wellenlänge λ  leicht berechnen,"
				+ " da stets gilt:"
				+ "\n\n\t\tΔd=zλ/2"
				+ "\n\n\n(de.wikipedia.org)";
		words [2][16] = "Zwei Wellen und resultierende Welle";
		words [2][17] = "Welle 1";
		words [2][18] = "Welle 2";
		words [2][19] = "resultierende Welle";
		words [2][20] = "Zwei Wellen und Welleinterferenz";
		words [2][21] = "Cosinus()";
		words [2][22] = "Lage des Spiegels [m]";
		words [2][23] = "Messungen Speichern";
		words [2][24] = "Wellenlänge in dieses Experiment:";
		words [2][25] = "Speichern";
		words [2][26] = "---> Für Speichern die rechte"
				+ " Maustaste drücken";
		words [2][27] = "Möchten Sie speichern?";
		words [2][28] = "Nichte gespeicherte Datei!";
		words [2][29] = "Geben Sie die Name";
		words [2][30] = "Fehler mit Speichern";
		words [2][31] = "Fehler!";
		words [2][32] = "Sie können den Spiegel nicht weiter "
				+ "versetzen! Wählen Sie die Lage von dem Spiegel"
				+ " kleiner als 700 mm!";
		words [2][33] = "** WARNUNG! **";
		words [2][34] = "Nicht versucht";
					
	}
}