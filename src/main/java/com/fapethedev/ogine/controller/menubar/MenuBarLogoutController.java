package com.fapethedev.ogine.controller.menubar;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.launch.LauncherPage;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class MenuBarLogoutController
{
	public static void logout(JMenuBar mb)
	{
		int choice = JOptionPane.showConfirmDialog
				 (
					null,
					new Message(Message.LOGOUT_INFO_MSG),
					Message.LOGOUT_TITLE_MSG,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					Iconifier.warningIcon
				 );
		if(choice == JOptionPane.YES_NO_OPTION)
		{
			LauncherPage log = LauncherPage.getInstance(false);
			MainMenu.getInstance().dispose();
			log.setVisible(true);
		}
	}
}
