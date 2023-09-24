package com.fapethedev.ogine.controller.launcher;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.model.database.manager.DBConnectionManager;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.launch.LauncherPage;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class LauncherQuitController 
{
	/**
	 * CLose the connection and dispose the frame
	 * 
	 * @param owner The LauncherPage to quit
	 */
	public static void quit(LauncherPage owner)
	{
		int action = JOptionPane.showConfirmDialog
		 (
			owner, 
			new Message(Message.EXIT_INFO_MSG),
			Message.EXIT_TITLE_MSG,
			JOptionPane.YES_NO_OPTION,
			JOptionPane.WARNING_MESSAGE,
			Iconifier.warningIcon
		  );
		
		if(action == JOptionPane.YES_OPTION)
		{
			DBConnectionManager.getSingleton().closeConnection();
			System.exit(0);
		}
	}
}
