package com.fapethedev.ogine.controller.launcher;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.launch.LauncherPage;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class LauncherShowController 
{
	/**
	 * <p>Show the LauncherPage passwordfield content on the first usage
	 * and change the icon of the button to showIcon from maskIcon<p>
	 * 
	 * <p>Mask the LauncherPage passworfield content on the second usage
	 * and set the default icon of the show button<p>
	 *  
	 * @param owner The LauncherPage which owns the passwordfield
	 */
	public static void show(LauncherPage owner)
	{
		var passF = owner.getUserPasswordField();
		var showB = LauncherPage.getShowButton();
		
		if(new String(passF.getPassword()).compareTo(new String(passF.getToolTipText())) == 0 
				|| new String(passF.getPassword()).isEmpty()){}
		else
		{
			if(showB.getIcon() == Iconifier.showIcon)
			{
				passF.setFocusable(true);
				showB.setIcon(Iconifier.maskIcon);
				showB.setToolTipText("Masquer le mot de passe");
				passF.setEchoChar((char) 0);
			}
			else
			{
				passF.setFocusable(true);
				showB.setIcon(Iconifier.showIcon);
				showB.setToolTipText("Masquer le mot de passe");
				passF.setEchoChar('¤');	
			}
		}
	}
}
