package com.fapethedev.ogine.controller.jasperreport;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.JRGenerator;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author FATIGBA Abiola Pierre-Edy
 */
public class JasperReportSchoolStudentController
{
    public synchronized static void printReport(MainMenu owner)
    {
        var pan = owner.getMainpane();
        int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CONFIRM_SCHOOL_STUDENT_REPORT_MSG),
					Message.CONFIRM_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
	
        if(choice == JOptionPane.YES_OPTION)
        {
        	try 
            {
                String rP = "./src/main/java/com/ogine/model/jasperreports/schoolStudentReport.jrxml";
                String rQ = """
                		SELECT R.matricule, R.year , S.profile_picture, S.last_name, S.first_name,
                			S.sex, I.institut_name, L.level_name, P.speciality_name 
                		FROM register R , students S,
                		    institut I,
		             		level L,
    		        		speciality P 
                		WHERE R.student_id = S.id 
                		AND R.institut_id = I.id
                		AND R.level_id = L.id 
                		AND R.speciality_id = P.id""";
                JRGenerator.createReport(rP, rQ);
            }
            catch (JRException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
