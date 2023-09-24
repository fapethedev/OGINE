package com.fapethedev.ogine.view.component.button;

import java.awt.Color;
import java.awt.Graphics;

import com.fapethedev.ogine.utilities.OgineColor;
import com.fapethedev.ogine.view.component.listeners.DashOBMouseAdapter;

public class DashOButton extends OButton
{

	public DashOButton(String text)
	{
		super(text);
		this.setBackground(Color.BLACK);
		this.setBorderColor(Color.WHITE);
		this.setForeground(Color.WHITE);
		this.setFocusPainted(true);
		this.addMouseListener(new DashOBMouseAdapter());
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		if(this.isFocusOwner())
		{
			this.setForeground(OgineColor.BELGE);
			this.setBorderColor(OgineColor.BELGE);
			this.revalidate();
            this.repaint();
		}
		if(!this.isFocusOwner())
		{
			this.setBorderColor(Color.WHITE);
			this.setForeground(Color.WHITE);
			this.revalidate();
            this.repaint();
		}
		
		this.repaint();
	}
	
	
}
