package com.fapethedev.ogine.view.component.listeners.adapter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lowagie.text.Font;
import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.button.OButton;

public class OButtonMouseAdapter extends MouseAdapter 
{
	private final Colors colors = Colors.getInstance();
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		if(e.getSource() instanceof OButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.UNDERLINE));
			button.setForeground(colors.BELGE);
			button.setBackground(colors.LIGHT_BLUE);
			button.setBorderColor(colors.LIGHT_BLUE);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		super.mouseReleased(e);
		if(e.getSource() instanceof OButton button)
		{
			button.setFont(button.getFont().deriveFont(Font.BOLD));
			button.setForeground(Color.BLACK);
			button.setBorderColor(Color.BLACK);
			button.setBackground(Color.WHITE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		super.mouseEntered(e);
		if(e.getSource() instanceof OButton button)
		{
			button.setForeground(Color.BLACK);
			button.setBackground(new Color(240, 240, 240));
			button.setBorderColor(new Color(240, 240, 240));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		super.mouseExited(e);
		if(e.getSource() instanceof OButton button)
		{
			button.setForeground(Color.BLACK);
			button.setBorderColor(Color.BLACK);
			button.setBackground(Color.WHITE);
		}
	}
}
