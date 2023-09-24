package com.fapethedev.ogine.controller.launcher;

import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.view.launch.LauncherPage;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class LauncherResetController extends LauncherController
{
	/**
	 * Reset the LauncherPage fields's
	 * 
	 * @param owner The LauncherPage which owns the fields
	 */
	public static void reset(LauncherPage owner)
	{
		var userF = owner.getUserIDField();
		var passF = owner.getUserPasswordField();
		var showB = LauncherPage.getShowButton();
		
		if((userF.getText().compareTo(userF.getToolTipText()) == 0 || userF.getText().isEmpty())
				&& new String(passF.getPassword()).compareTo(new String(passF.getToolTipText())) == 0 
				|| new String(passF.getPassword()).isEmpty()){}
		else if((userF.getText().compareTo(userF.getToolTipText()) == 0 || userF.getText().isEmpty()))
		{
			passF.setText(null);
			
			if(new String(passF.getPassword()).isEmpty())
			{
				passF.setText(passF.getToolTipText());
				passF.setEchoChar((char) 0);
				Placeholder.addPlaceholderStyle(passF);
				Placeholder.passFGetPlaceholder(passF);
				showB.setVisible(false);
			}
		}
		else if(new String(passF.getPassword()).compareTo(new String(passF.getToolTipText())) == 0 
				|| new String(passF.getPassword()).isEmpty())
		{
			userF.setText(null);
			
			if(userF.getText().isEmpty())
			{
				userF.setText(userF.getToolTipText());
				Placeholder.addPlaceholderStyle(userF);
				Placeholder.userFGetPlaceholder(userF);
			}
		}
		else
		{
			userF.setText(null);
			passF.setText(null);
			
			if(userF.getText().isEmpty() && new String(passF.getPassword()).isEmpty())
			{
				Placeholder.addPlaceholderStyle(userF);
				Placeholder.userFGetPlaceholder(userF);
				passF.setText(passF.getToolTipText());
				passF.setEchoChar((char) 0);
				Placeholder.addPlaceholderStyle(passF);
				Placeholder.passFGetPlaceholder(passF);
				showB.setVisible(false);
			}
		}
	}
}
