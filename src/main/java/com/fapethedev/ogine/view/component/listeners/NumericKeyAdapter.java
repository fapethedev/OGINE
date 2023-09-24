package com.fapethedev.ogine.view.component.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class NumericKeyAdapter extends KeyAdapter
{

	@Override
	public void keyTyped(KeyEvent e) 
	{
		super.keyTyped(e);
		if(e.getSource() instanceof JTextField field)
		{
			var c = e.getKeyChar();
			if(!Character.isDigit(c))
			{
				e.consume();
			}
		}
	}
}
