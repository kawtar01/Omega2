package com.parse;

	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
	 
	public class ReadCVS {
	 
	  public static void main(String[] args) {
	 
		ReadCVS obj = new ReadCVS();
		obj.run();
	 
	  }
	 
	  public List<String> run() {
	 
		String csvFile = "D:\\PrimeFaces-Hello-World-Example\\src\\main\\resources\\GeoIPCountryWhois.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<String>resul=new ArrayList<String>();
		//int i=0;
		
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String tp="";
			        // use comma as separator
				String[] country = line.split(cvsSplitBy);
				
				for(int j=0;j<country.length-1;j++)
				{
					String bid=country[j]+",";
					tp=tp+bid;	
				}
				String tmp=tp+country[country.length-1];
				//System.out.println(tmp);
				//tmp="Country [1= " + country[i] + " , 2=" + country[i+1] +  " , 3=" + country[i+2] + " ,4=" + country[i+3] + " , 5=" + country[i+4] + " , 6=" + country[i+5] +"]";
				//result=result+tmp;
				resul.add(tmp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//result="merde";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
		return resul;
	  }
	 
	}