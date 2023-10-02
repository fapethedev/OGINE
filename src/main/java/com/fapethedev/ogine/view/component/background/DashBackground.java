package com.fapethedev.ogine.view.component.background;

import java.awt.LayoutManager;

import javax.swing.ImageIcon;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class DashBackground extends Background 
{
	public DashBackground() 
	{
		super();
		this.setLayout(null);
		image = new ImageIcon(getClass().getResource("/images/dashwallpaper.jpg"));
	}
	
	public DashBackground(LayoutManager lm)
	{
		super(lm);
		this.lm = lm;
		image = new ImageIcon(getClass().getResource("/images/dashwallpaper.jpg"));
	}
}
