package com.fapethedev.ogine.controller.jasperreport;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.JRGenerator;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author hp
 */
public class JaspertReportStudentController
{
    public synchronized static void printReport(MainMenu owner)
    {
        var pan = owner.getMainpane();
        int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CONFIRM_STUDENT_REPORT_MSG),
					Message.CONFIRM_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
	
		if(choice == JOptionPane.YES_OPTION)
		{
            try 
            {
                String rP = "./src/main/java/com/ogine/model/jasperreports/studentReport.jrxml";
                String rQ = "SELECT * FROM students ORDER BY id ASC";
                JRGenerator.createReport(rP, rQ);
            }
            catch (JRException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
                
    }
}
