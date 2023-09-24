package com.fapethedev.ogine.utilities;

import com.fapethedev.ogine.model.database.manager.DBConnectionManager;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class JRGenerator
{
	/**
	 * 
	 * @param reportPath its the absolute path oft the jrxml file used to design the report
	 * @param reportQuery the sql query use in the report data source
	 * 					  Need to be the same as the one in the jrxml source
	 * @throws JRException
	 */
	public static void createReport(String reportPath, String reportQuery) throws JRException
	{
		JasperDesign jdesign = JRXmlLoader.load(reportPath);
        String query = reportQuery;
        
        JRDesignQuery updateQuery = new JRDesignQuery();
        updateQuery.setText(query);
        
        jdesign.setQuery(updateQuery);
        
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, null, DBConnectionManager.getSingleton().getConnection());
        
        JasperViewer.viewReport(jprint, false);
	}
}
