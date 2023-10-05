package com.fapethedev.ogine.view.component.listeners.adapter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.lowagie.text.Font;

public class AdminLabelMouseAdapter extends MouseAdapter 
{
	@Override
	public void mouseEntered(MouseEvent e) 
	{
		super.mouseEntered(e);
		if(e.getSource() instanceof JLabel label)
		{
			label.setFont(label.getFont().deriveFont(Font.UNDERLINE));
			label.setForeground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		super.mouseExited(e);
		if(e.getSource() instanceof JLabel label)
		{
			label.setFont(label.getFont().deriveFont(Font.BOLD));
			label.setForeground(Color.WHITE);
		}
	}
}
