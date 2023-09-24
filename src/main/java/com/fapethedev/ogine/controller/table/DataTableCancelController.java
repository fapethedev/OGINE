package com.fapethedev.ogine.controller.table;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 *
 * @author hp
 */
public class DataTableCancelController
{
    public synchronized static void cancel(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		
		int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CANCEL_INFO_MSG),
					Message.DEFAULT_TITLE_MSG,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
		if(choice == JOptionPane.YES_OPTION)
                {
			owner.getCard().show(pan, owner.getList(0));
		}
	}
}
