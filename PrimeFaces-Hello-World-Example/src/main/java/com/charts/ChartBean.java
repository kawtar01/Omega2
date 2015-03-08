package com.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.parse.ReadCVS;

@ManagedBean
@RequestScoped
public class ChartBean implements Serializable {

   /**
    *
    */
   private static final long serialVersionUID = 1L;
   private CartesianChartModel categoryModel;

   public ChartBean() {
   }

   public CartesianChartModel getCategoryModel() {
      return categoryModel;
   }

   @PostConstruct
   public void init()
   {
	   createZoomModel();
   }
   public void createZoomModel()
   {
	   categoryModel = initLinearModel();  
	   
   }
   public CartesianChartModel initLinearModel() {
	  ReadCVS obj = new ReadCVS();
	  List<String> res=new ArrayList<String>();
	  res=obj.run();
	  categoryModel = new CartesianChartModel();
	  ChartSeries s=new ChartSeries();
	  ChartSeries s1=new ChartSeries();
	  List<ChartSeries>list=new ArrayList<ChartSeries>();
	  for(int i=0;i<res.size();i++)
	  {
			
			String line=res.get(i);
			System.out.println(line);
			String[] values=line.trim().split(",");
			String label=values[0];
			System.out.println(label);
			s.setLabel("Unit 0");
			s.set(label,Integer.parseInt(values[1]));
			s1.setLabel("Unit 1");
			s1.set(label,Integer.parseInt(values[2]));
			
			System.out.println("next");			
	  }
	  categoryModel.addSeries(s);
	  categoryModel.addSeries(s1);

	  //boys.set("2004", 120);
      //boys.set("2005", 100);
      //boys.set("2006", 44);
      //boys.set("2007", 150);
      //boys.set("2008", 25);

     /* ChartSeries girls = new ChartSeries();
      girls.setLabel("Girls");

      girls.set("2004", 52);
      girls.set("2005", 60);
      girls.set("2006", 110);
      girls.set("2007", 135);
      girls.set("2008", 120);

      
      categoryModel.addSeries(girls);*/
      return categoryModel;
   }

}