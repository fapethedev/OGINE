package com.fapethedev.ogine.view.component.listeners.adapter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lowagie.text.Font;
import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.button.SideNavButton;

public class SideNavLogoutMouseAdapter extends MouseAdapter
{
	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.UNDERLINE));
			button.setForeground(Color.LIGHT_GRAY);
			button.setBackground(Colors.getInstance().DARK_RED);
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
			button.setBackground(Colors.getInstance().RED);
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) 
	{
		super.mouseEntered(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setBackground(Colors.getInstance().LIGHT_RED);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		super.mouseExited(e);
		if(e.getSource() instanceof SideNavButton button)
		{
			button.setBackground(Colors.getInstance().RED);
		}
	}
}
