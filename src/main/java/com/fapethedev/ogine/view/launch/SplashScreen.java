package com.fapethedev.ogine.view.launch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

import com.fapethedev.ogine.utilities.Iconifier;

import lombok.Getter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
@Getter
public final class SplashScreen extends JWindow 
{
	private Timer time;
	private JProgressBar progress;
	private final int WIDTH = 684;
	private final int HEIGTH = 390;

	public SplashScreen(Frame owner) 
	{
		super(owner);
	}

	public SplashScreen(Window owner) 
	{
		super(owner);
	}
	
	public void begin()
	{
		JPanel panel = new JPanel();
		JLabel splashLabel = new JLabel(Iconifier.splashImage);
		progress = new JProgressBar(0, 100);
		
		this.setSize(WIDTH, HEIGTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(panel);
		this.add(splashLabel, BorderLayout.PAGE_START);
		this.add(progress, BorderLayout.PAGE_END);
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(Color.WHITE);
								
		progress.setBackground(Color.DARK_GRAY);
		progress.setForeground(Color.WHITE);
		
		this.revalidate();
		
		time = new Timer(100, this::onTimeUpdate);
		time.start();
	}
	
	private void onTimeUpdate(ActionEvent e)
	{
		
		int x = progress.getValue();
		if(x == 100)
		{
			this.dispose();
			time.stop();
			getOwner().setVisible(true);
		}
		else
		{
			progress.setValue(x + 10);
		}	
	}
}
