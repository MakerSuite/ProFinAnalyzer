
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
				map.put("PriceChangeRT",values[1]);
				map.put("52weekLow",values[2]); // 52 week low
				double val = 0;
				if(!values[3].equals("N/A")){
				String letter = values[3].substring(values[3].length()-1);
				String value = values[3].substring(0,values[3].length()-1);
				val = Float.parseFloat(value);
				if(letter.equals("B"))
				{
					val = val*1000;
				}
				}
				map.put("MarketCap",val+"");
				map.put("ChangeFromYearLow",values[4]);
				map.put("PriceChangePercent",values[5]);
				map.put("PERatioRT",values[6]);
				map.put("DividendYield",values[7]);
				map.put("Ask", values[8]);
				map.put("Bid",values[9]);
				map.put("AverageDayVolume",values[10]);
				map.put("EarningsPerShare" ,values[11]);
				map.put("Name",values[12]);
				map.put("PERatio2",values[13]);
				map.put("symbol",values[14]);
				map.put("priceBook",values[15]);
				map.put("StockExchange", values[16]);
				map.put("52weekhigh",values[17]); // 52 week high
				map.put("PriceSales",values[18]); // add this to database
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return map;
	}
	
	public String Classify(){
		
		String prediction = "";