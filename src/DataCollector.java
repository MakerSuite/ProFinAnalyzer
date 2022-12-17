
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import weka.classifiers.misc.InputMappedClassifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

public class DataCollector {
	Map<String, String> map;
	InputMappedClassifier classifier = new InputMappedClassifier();

	public DataCollector() {
		map = new HashMap<String, String>();
		try{
		classifier.setModelPath("Models/RandomForestsTechAnalysis.model");
		classifier.setTrim(true);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public Map<String, String> getData(String ticker) {
		try {
			URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s="
					+ ticker + "&f=b4c1jj1j5k2r2yaba2enrsp6xkp5");
			Scanner s = new Scanner(url.openStream());

			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				map.put("BookValue", values[0]);