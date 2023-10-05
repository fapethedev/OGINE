package com.fapethedev.ogine.view.component.listeners.adapter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.lowagie.text.Font;

public class PaneMouseAdapter extends MouseAdapter 
{
	private Color bgColor;
	private java.awt.Font defaultFont;

	@Override
	public void mouseEntered(MouseEvent e)
	{	
		super.mouseEntered(e);
		if(e.getSource() instanceof JPanel panel)
		{
			this.bgColor = panel.getBackground();
			this.defaultFont = panel.getFont();
			panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.BLACK));
			panel.setBackground(bgColor.brighter());
			panel.setFont(panel.getFont().deriveFont(Font.UNDERLINE));
			panel.setFont(panel.getFont().deriveFont(20));
		}
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		super.mouseExited(e);
		if(e.getSource() instanceof JPanel panel)
		{
			panel.setBorder(BorderFactory.createEmptyBorder());
			panel.setBackground(bgColor);
			panel.setFont(defaultFont);
		}
	}
	
}
