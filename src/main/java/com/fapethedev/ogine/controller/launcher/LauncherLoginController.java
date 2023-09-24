package com.fapethedev.ogine.controller.launcher;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import com.fapethedev.ogine.model.database.manager.UserManager;
import com.fapethedev.ogine.model.database.entities.User;
import com.fapethedev.ogine.security.SecurityManager;
import com.fapethedev.ogine.utilities.Admin;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.launch.LauncherPage;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class LauncherLoginController extends LauncherController
{
	/**
	 * The login action controller 
	 *  
	 * @param owner The LauncherPage which from the main menu have to be
	 * displayed after the click on the login button
	 */
	public static void login(LauncherPage owner)
	{
		var userF = owner.getUserIDField();
		var passF = owner.getUserPasswordField();
		
		if((userF.getText().compareTo(userF.getToolTipText()) == 0 || userF.getText().isEmpty())
				&& new String(passF.getPassword()).compareTo(new String(passF.getToolTipText())) == 0 
				|| new String(passF.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog
			(
				owner,
				new Message(Message.ALL_FIELD_MISSING_MSG),
				Message.DEFAULT_TITLE_MSG,
				JOptionPane.WARNING_MESSAGE,
				Iconifier.warningIcon
			);
		}
		else if(userF.getText().compareTo(userF.getToolTipText()) == 0 || userF.getText().isEmpty())
		{
			JOptionPane.showMessageDialog
			(
				owner,
				new Message(Message.USERNAME_MISSING_MSG),
				Message.DEFAULT_TITLE_MSG,
				JOptionPane.WARNING_MESSAGE,
				Iconifier.warningIcon
			);
		}
		else if(new String(passF.getPassword()).compareTo(new String(passF.getToolTipText())) == 0 
				|| new String(passF.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog
			(
				owner,
				new Message(Message.PASSWORD_MISSING_MSG),
				Message.DEFAULT_TITLE_MSG,
				JOptionPane.WARNING_MESSAGE,
				Iconifier.warningIcon
			);
		}
		else
		{
			String name = userF.getText();
			String pass = SecurityManager.toHash(new String(passF.getPassword()));
			User inUser = new User(name, pass, null);
			try
			{
				inUser = UserManager.getSingleton().login(inUser);
				Admin.using(inUser);
				userF.setBorder(BorderFactory.createLineBorder(Color.GREEN));
				passF.setBorder(BorderFactory.createLineBorder(Color.GREEN));
				JOptionPane.showMessageDialog
				(
					owner,
					new Message(Message.AUTENTIFICATION_SUCCESS_MSG),
					Message.DEFAULT_TITLE_MSG,
					JOptionPane.INFORMATION_MESSAGE,
					Iconifier.confirmIcon
				);
                                
				owner.dispose();
				userF.setText(Message.USERNAME_TAG);
				passF.setText(Message.PASSWORD_TAG);
				passF.setEchoChar((char) 0);
				Placeholder.addPlaceholderStyle(userF);
				Placeholder.addPlaceholderStyle(passF);
				Placeholder.userFGetPlaceholder(userF);
				Placeholder.passFGetPlaceholder(passF);
				userF.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.white, Color.BLACK));
                passF.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.white, Color.BLACK));
				MainMenu.getInstance().setVisible(true);
			}
			catch(Exception exception)
			{
				String errMsg = exception.getMessage();
				JOptionPane.showMessageDialog
				(
					owner,
					new Message(errMsg),
					Message.ERROR_TITLE_MSG,
					JOptionPane.ERROR_MESSAGE, 
					Iconifier.errorIcon
				);
				
				if(errMsg.equals(Message.USERNAME_ERROR_MSG))
				{
					Placeholder.redPlaceholderStyle(userF);
					passF.setText(null);
				}
				else if(errMsg.equals(Message.PASSWORD_ERROR_MSG))
				{
					Placeholder.redPlaceholderStyle(passF);
				}
			}
		}
	}

	public static void loginAsGuest(LauncherPage owner) 
	{
		int choice = JOptionPane.showConfirmDialog(
				owner, 
				new Message(Message.DO_You_WANT_TO_LOG_AS_GUEST),
				Message.DEFAULT_TITLE_MSG,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				Iconifier.questionIcon
				);
		
		if(choice == JOptionPane.YES_OPTION)
		{
			User guestUser = new User("invité", SecurityManager.toHash("inspecteur"), null);
			try
			{
				guestUser = UserManager.getSingleton().login(guestUser);
				Admin.using(guestUser);
				JOptionPane.showMessageDialog
				(
					owner,
					new Message(Message.WELCOME_GUEST_MSG),
					Message.DEFAULT_TITLE_MSG,
					JOptionPane.INFORMATION_MESSAGE,
					Iconifier.confirmIcon
				);
	                            
				owner.dispose();
				MainMenu.getInstance().setVisible(true);
			}
			catch(Exception exception)
			{
				String errMsg = exception.getMessage();
				JOptionPane.showMessageDialog
				(
					owner,
					new Message(errMsg),
					Message.ERROR_TITLE_MSG,
					JOptionPane.ERROR_MESSAGE, 
					Iconifier.errorIcon
				);
			}
		}
		
	}
}
