package com.fapethedev.ogine.utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.fapethedev.ogine.model.database.manager.SchoolRegister;
import com.fapethedev.ogine.model.database.manager.StudentManager;
import org.jfree.chart3d.Chart3D;
import org.jfree.chart3d.Chart3DFactory;
import org.jfree.chart3d.Chart3DPanel;
import org.jfree.chart3d.Colors;
import org.jfree.chart3d.Orientation;
import org.jfree.chart3d.data.StandardPieDataset3D;
import org.jfree.chart3d.graphics2d.Anchor2D;
import org.jfree.chart3d.label.StandardPieLabelGenerator;
import org.jfree.chart3d.legend.LegendAnchor;
import org.jfree.chart3d.plot.PiePlot3D;
import org.jfree.chart3d.style.ChartStyles;

/**
 * 
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class ChartGenerator 
{
	public static synchronized JPanel studentRegisterChart()
	{
		JPanel theChartPanel = new JPanel(new BorderLayout());
		int maxM = 0;
		int maxF = 0;
		try
		{
			maxM = StudentManager.getInstance().getMaxMale();
			maxF = StudentManager.getInstance().getMaxFemale();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		StandardPieDataset3D<String> dataset3d = new StandardPieDataset3D<>();
		dataset3d.add("Garçon", maxM);
		dataset3d.add("Fille", maxF);
		//
		Chart3D chart = Chart3DFactory.createPieChart("GRAPH DES ENREGISTREMENTS", "...........", dataset3d);
		chart.setAntiAlias(true);
		chart.setTitle("GRAPH DES ENREGISTREMENTS", new Font("Times new roman", Font.BOLD, 28), Color.LIGHT_GRAY);
		chart.setTitleAnchor(Anchor2D.TOP_LEFT);
		chart.setElementHinting(true);
		chart.setNotify(true);
		chart.setStyle(ChartStyles.createIceCubeStyle());
		chart.setLegendPosition(LegendAnchor.BOTTOM_RIGHT, Orientation.VERTICAL);
		chart.getViewPoint().panLeftRight(-Math.PI / 25);
		var plot3d = (PiePlot3D)chart.getPlot();
		plot3d.setToolTipGenerator(new StandardPieLabelGenerator(StandardPieLabelGenerator.PERCENT_TEMPLATE_2DP));
		plot3d.setSectionColors(Colors.createOchreSandColors()); 
		
		Chart3DPanel panel = new Chart3DPanel(chart);
		panel.zoomToFit(new Dimension(600, 600));
		theChartPanel.add(panel);
		theChartPanel.repaint();
		theChartPanel.revalidate();
		
		Timer time = new Timer(100, e ->{
		});
		
		time.start();
		return theChartPanel;
	}
	
	public static synchronized JPanel registerChart()
	{
		JPanel theChartPanel = new JPanel(new BorderLayout());
		int maxM = 0;
		int maxF = 0;
		try
		{
			maxM = SchoolRegister.getSingleton().getMaxMale();
			maxF = SchoolRegister.getSingleton().getMaxFemale();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		StandardPieDataset3D<String> dataset3d = new StandardPieDataset3D<>();
		dataset3d.add("Garçon", maxM);
		dataset3d.add("Fille", maxF);
		//
		Chart3D chart = Chart3DFactory.createPieChart("GRAPH DES INSCRIPTIONS", "...........", dataset3d);
		chart.setAntiAlias(true);
		chart.setTitle("GRAPH DES INSCRIPTIONS", new Font("Times new roman", Font.BOLD, 28), Color.LIGHT_GRAY);
		chart.setTitleAnchor(Anchor2D.TOP_LEFT);
		chart.setElementHinting(true);
		chart.setNotify(true);
		chart.setStyle(ChartStyles.createIceCubeStyle());
		chart.setLegendPosition(LegendAnchor.BOTTOM_RIGHT, Orientation.VERTICAL);
		chart.getViewPoint().panLeftRight(-Math.PI / 25);
		var plot3d = (PiePlot3D)chart.getPlot();
		plot3d.setToolTipGenerator(new StandardPieLabelGenerator(StandardPieLabelGenerator.VALUE_TEMPLATE_2DP));
		plot3d.setSectionColors(Colors.createRedRosesColors());
		//
		Chart3DPanel panel = new Chart3DPanel(chart);
		panel.zoomToFit(new Dimension(600, 600));
		theChartPanel.add(panel);
		theChartPanel.repaint();
		theChartPanel.revalidate();
		return theChartPanel;
	}
	
	/*public static synchronized boolean saveChart(String name, JFreeChart freeChart)
	{
		try 
		{
			switch(name.substring(name.lastIndexOf(".")))
			{
				case "PNG" : 
					ChartUtils.saveChartAsJPEG(new File(Path.chartPath.concat(name)), freeChart, 512, 512);
					return true;
				case "JPEG" :
					ChartUtils.writeChartAsPNG(new FileOutputStream(new File(Path.chartPath.concat(name))), freeChart, 512, 512);
					return true;
				default :
					throw new IllegalArgumentException("Le format " + name.substring(name.lastIndexOf(".")) +" n'est pas permit");
			}
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
	}*/
}
