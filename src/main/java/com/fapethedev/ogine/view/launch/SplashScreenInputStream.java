package com.fapethedev.ogine.view.launch;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SplashScreenInputStream extends FilterInputStream 
{
	private SplashScreen screen;
    private int size = 0;
	
    public SplashScreenInputStream(Frame owner, InputStream in)
    {
	    super(in);
	    try
	    {
	        size = in.available();
	    }
	    catch(IOException ioe)
	    {
	    	size = 0;
	    }
	    screen = new SplashScreen(owner);
	    screen.begin();
	    screen.getProgress().setMaximum(size);
		screen.getTime().setDelay(size);
		screen.getTime().addActionListener(this::onInputRead);
		screen.getTime().start();
    }
    
    private void onInputRead(ActionEvent e)
    {
    	int x = screen.getProgress().getValue();
		if(x == 100)
		{
			screen.dispose();
			screen.getTime().stop();
			screen.getOwner().setVisible(true);
		}
		else
		{
			InputStreamReader isr = new InputStreamReader(this);
			BufferedReader br = new BufferedReader(isr);
			while(x < 100)
			{
				try
				{
					while(br.readLine() != null)
					{
						var note = br.readLine();
						screen.getProgress().setString(note);
						screen.getProgress().setValue(++x);	
					}
				}
				catch (IOException e1)
				{
					System.out.println(e1.getMessage());
				}
			}
		}
    }
}
