package com.fapethedev.ogine.controller.menubar;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import com.fapethedev.ogine.model.database.manager.DBConnectionManager;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.utilities.Iconifier;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class MenuBarExitController
{
	public static void exit(JMenuBar mb)
	{
		int choice = JOptionPane.showConfirmDialog
					 (
						null,
						new Message(Message.EXIT_INFO_MSG),
						Message.EXIT_TITLE_MSG,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						Iconifier.warningIcon
					 );
		if(choice == JOptionPane.YES_OPTION)
		{
			DBConnectionManager.getSingleton().closeConnection();
			System.exit(0);
		}
	}
}
