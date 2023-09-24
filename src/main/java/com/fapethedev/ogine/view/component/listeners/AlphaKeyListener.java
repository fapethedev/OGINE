package com.fapethedev.ogine.view.component.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class AlphaKeyListener implements KeyListener 
{
	/**
	 * 
	 */
	public AlphaKeyListener()
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		var c = e.getKeyChar();
		
		if(Character.isDigit(c))
		{
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {};

	@Override
	public void keyReleased(KeyEvent e) {};

}
