package com.fapethedev.ogine.view.component.listeners.adapter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lowagie.text.Font;
import com.fapethedev.ogine.view.component.button.DashOButton;

public class DashOBMouseAdapter extends MouseAdapter 
{
	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		if(e.getSource() instanceof DashOButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.UNDERLINE));
			button.setForeground(Color.LIGHT_GRAY);
			button.setBackground(Color.DARK_GRAY);
		}
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		super.mouseReleased(e);
		if(e.getSource() instanceof DashOButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.BOLD));
			button.setForeground(Color.WHITE);
			button.setBackground(Color.BLACK);
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) 
	{
		super.mouseEntered(e);
		if(e.getSource() instanceof DashOButton button)
		{
			button.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		super.mouseExited(e);
		if(e.getSource() instanceof DashOButton button)
		{
			button.setBackground(Color.BLACK);
		}
	}
}
