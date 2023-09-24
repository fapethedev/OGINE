package com.fapethedev.ogine.view.component.background;

import java.awt.LayoutManager;

import javax.swing.ImageIcon;

public class MainMenuBackground extends Background 
{

	public MainMenuBackground() 
	{
		super();
		this.setLayout(null);
		image = new ImageIcon(getClass().getResource("/mainmenuwallpaper.jpg"));
	}

	public MainMenuBackground(LayoutManager lm)
	{
		super(lm);
		this.lm = lm;
		image = new ImageIcon(getClass().getResource("/mainmenuwallpaper.jpg"));
	}
}
