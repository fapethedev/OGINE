package com.fapethedev.ogine.controller.chart;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.fapethedev.ogine.view.component.SaveChooser;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.menu.MainMenu;

public class StudentRegisterChart 
{
	public synchronized static void save(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		
		int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.SAVE_INFO_MSG),
					Message.SAVE_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
		if(choice == JOptionPane.YES_OPTION)
		{	
			SaveChooser save = new SaveChooser();
			int action = save.showSaveDialog(pan);
			if(action == JFileChooser.APPROVE_OPTION)
			{
				var name = save.getName(save.getSelectedFile());
				//ChartGenerator.saveChart(name, ChartGenerator.studentRegisterChart());
			}
		}
	}
}
