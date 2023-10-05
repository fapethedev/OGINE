package com.fapethedev.ogine.view.component.listeners.adapter;

import com.fapethedev.ogine.utilities.Colors;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ExitButtonMouseAdapter extends MouseAdapter 
{
	@Override
	public void mouseEntered(MouseEvent e)
	{
		super.mouseEntered(e);
		if(e.getSource() instanceof JButton button)
		{
			button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		}
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		super.mouseExited(e);
		if(e.getSource() instanceof JButton button)
		{
			button.setBorder(BorderFactory.createEmptyBorder());
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		if(e.getSource() instanceof JButton button)
		{
			button.setBorder(BorderFactory.createLineBorder(Colors.getInstance().LIGHT_BLUE, 2));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(e.getSource() instanceof JButton button)
		{
			button.setBorder(BorderFactory.createEmptyBorder());
		}
	}
}
