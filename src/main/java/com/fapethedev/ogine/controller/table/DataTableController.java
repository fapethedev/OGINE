package com.fapethedev.ogine.controller.table;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.fapethedev.ogine.model.database.entities.SchoolStudent;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.manager.SchoolStudentManager;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class DataTableController
{
	public synchronized static void populateTable(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		var table = owner.getDataTable();
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        JTableHeader th = table.getTableHeader();
		
		try
		{
			schoolStudentList = SchoolStudentManager.getSingleton().getSchoolStudent();
			tableModel.setRowCount(0);
			for(SchoolStudent stu : schoolStudentList)
			{
				Object[] rows = {stu.year(), stu.matricule(), stu.lastName(), 
						stu.firstName(), stu.sex(), stu.institut(), stu.level(), stu.speciality()};
				tableModel.addRow(rows);
			}
		}
		catch (Exception e)
		{
			var errMsg = e.getMessage();
			JOptionPane.showMessageDialog
			(
				pan,
				new Message(errMsg),
				Message.ERROR_TITLE_MSG,
				JOptionPane.ERROR_MESSAGE,
				Iconifier.errorIcon
			);
		}
        table.setTableHeader(th);
        //JTableAutoReziser.fitToData(table);
	}
	
	public synchronized static void populateFromSearch(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		var table = owner.getDataTable();
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
		String title [] = {"Année".toUpperCase(), "Matricule".toUpperCase(), "Nom".toUpperCase(), "Prénoms".toUpperCase(),
                "Sexe".toUpperCase(), "Institut".toUpperCase(), "Niveau".toUpperCase(), "Spécialité".toUpperCase()};
		int row = 0;
		DefaultTableModel tableModel = new DefaultTableModel(title, row);
		try
		{
			schoolStudentList = SchoolStudentManager.getSingleton().searchSchoolStudent(owner.getSearchField().getText());
			for(SchoolStudent stu : schoolStudentList)
			{
				Object[] rows = {stu.year(), stu.matricule(), stu.lastName(), 
						stu.firstName(), stu.sex(), stu.institut(), stu.level(), stu.speciality()};
				tableModel.addRow(rows);
			}
                table.setModel(tableModel);
		}
		catch (Exception e)
		{
			var errMsg = e.getMessage();
			JOptionPane.showMessageDialog
			(
				pan,
				new Message(errMsg),
				Message.ERROR_TITLE_MSG,
				JOptionPane.ERROR_MESSAGE,
				Iconifier.errorIcon
			);
		}
//		JTableAutoReziser.fitToData(table);
	}
}
