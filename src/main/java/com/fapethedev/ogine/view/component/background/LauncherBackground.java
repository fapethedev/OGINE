package com.fapethedev.ogine.view.component.background;

import javax.swing.ImageIcon;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class LauncherBackground extends Background
{	
	public LauncherBackground() 
	{
		super();
		this.setLayout(null);
		image = new ImageIcon(getClass().getResource("/images/startwallpaper.jpg"));
	}
}
