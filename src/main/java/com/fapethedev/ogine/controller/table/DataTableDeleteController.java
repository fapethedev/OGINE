package com.fapethedev.ogine.controller.table;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class DataTableDeleteController
{
	public synchronized static void erase(MainMenu owner)
	{
        var pan = owner.getCenterpane();
        var table = owner.getDataTable();
        int i = table.getSelectedRow();
        if(i < 0)
        {
            JOptionPane.showMessageDialog
            (		
                pan,
                new Message("VEUILLEZ SELECTIONNER UN ETUDIANT !"),
                Message.DEFAULT_TITLE_MSG,
                JOptionPane.WARNING_MESSAGE,
                Iconifier.warningIcon
            );
        }
        else
        {
        	int choice = JOptionPane.showConfirmDialog
                    (
                        pan,
                        new Message(Message.CONFIRM_DELETE_INFO_MSG),
                        Message.DEFAULT_TITLE_MSG,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        Iconifier.questionIcon
                    );
		    if(choice == JOptionPane.YES_OPTION)
		    {	
		        
		        var matri = table.getModel().getValueAt(i, 1).toString();
		        var lN = table.getModel().getValueAt(i, 2).toString();
		        var fN = table.getModel().getValueAt(i, 3).toString();
		        int stu_id;
//		        Student stu  = new Student(null, lN, fN, null, null, null, null, null, null, null ,null,
//		                null, null, null, null, null, null, null, null);
//		        try
//		        {
//		            stu_id = StudentManager.getInstance().getId(stu);
//		            SchoolRegister.getSingleton().deleteRegistredStudent(new Register(matri, 0, stu_id, 0, 0, 0));
//		            StudentManager.getInstance().deleteStudentByName(stu);
//		            DataTableController.populateTable(owner);
//		            RegisterInfoController.inform(owner);
//
//		            JOptionPane.showMessageDialog
//                    (
//                        pan,
//                        new Message(Message.DELETE_SUCCES_MSG),
//                        Message.DEFAULT_TITLE_MSG,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        Iconifier.confirmIcon
//                    );
//		        }
//		        catch(Exception exception)
//		        {
//		            String errMsg = exception.getMessage();
//		            JOptionPane.showMessageDialog
//		            (
//		                pan,
//		                new Message(errMsg),
//		                Message.ERROR_TITLE_MSG,
//		                JOptionPane.ERROR_MESSAGE,
//		                Iconifier.errorIcon
//		            );
//		        }
            }
        }
	}
}
