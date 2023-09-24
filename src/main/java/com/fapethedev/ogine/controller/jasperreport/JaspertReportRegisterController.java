package com.fapethedev.ogine.controller.jasperreport;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 *
 * @author hp
 */
public class JaspertReportRegisterController
{
    public synchronized static void printReport(MainMenu owner)
    {
        var pan = owner.getMainpane();
        int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CONFIRM_REGISTER_REPORT_MSG),
					Message.CONFIRM_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
	
        if(choice == JOptionPane.YES_OPTION)
        {

        }
    }
}
