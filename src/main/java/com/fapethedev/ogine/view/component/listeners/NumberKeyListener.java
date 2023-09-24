package com.fapethedev.ogine.view.component.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class NumberKeyListener implements KeyListener 
{
	@Override
	public void keyTyped(KeyEvent e) 
	{
		if(e.getSource() instanceof JTextField field)
		{
			var c = e.getKeyChar();
			if(Character.isDigit(c) || c == '+')
			{
				if(field.getText().isEmpty())
				{
					if(c != '+')
					{
						e.consume();
					}
				}
				if(!field.getText().isEmpty())
				{
					if(c == '+')
					{
						e.consume();
					}
				}
			}
			else
			{
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

}
