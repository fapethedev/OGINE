package com.fapethedev.ogine.view.component.listeners.adapter;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.button.SideNavButton;
import com.lowagie.text.Font;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SideNavButtonMouseAdapter extends MouseAdapter
{
	private final Colors colors = Colors.getInstance();
	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.UNDERLINE));
			button.setForeground(Color.BLACK);
			button.setBackground(colors.DARK_GRAY);
			button.setBorderColor(colors.DARK_GRAY);
		}
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		super.mouseReleased(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.BOLD));
			button.setForeground(Color.WHITE);
			button.setBackground(Color.BLACK);
			button.setBorderColor(Color.BLACK);
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) 
	{
		super.mouseEntered(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setBackground(colors.LIGHT_GRAY);
			button.setForeground(Color.BLACK);
			button.setBorderColor(colors.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		super.mouseExited(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setBackground(Color.BLACK);
			button.setForeground(Color.WHITE);
			button.setBorderColor(Color.BLACK);
		}
	}
}
