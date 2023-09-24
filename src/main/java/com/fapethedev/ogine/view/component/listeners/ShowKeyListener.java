package com.fapethedev.ogine.view.component.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;

import com.fapethedev.ogine.view.launch.LauncherPage;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class ShowKeyListener implements KeyListener
{
	/**
	 * 
	 */
	public ShowKeyListener() 
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		JPasswordField text = (JPasswordField) e.getSource();
		if(!new String(text.getPassword()).isEmpty()
				&& !new String(text.getPassword()).equals(text.getToolTipText()))
			{
				LauncherPage.getShowButton().setVisible(true);
			}
			else
			{
				LauncherPage.getShowButton().setVisible(false);
			}	
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		JPasswordField text = (JPasswordField) e.getSource(); 
		if(!new String(text.getPassword()).isEmpty()
			&& !new String(text.getPassword()).equals(text.getToolTipText()))
		{
			LauncherPage.getShowButton().setVisible(true);
		}
		else
		{
			LauncherPage.getShowButton().setVisible(false);
		}
	}
}
