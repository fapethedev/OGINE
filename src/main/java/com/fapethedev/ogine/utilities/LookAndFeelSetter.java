package com.fapethedev.ogine.utilities;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class LookAndFeelSetter 
{
	/**
	 * <p>
	 * Change the default look&feel by setting a new look&feel
	 * from the default look&feel library or an imported library
	 * <p>
	 * @param newLookAndFeel an object from LookAndFeel class
	 */
	public static void defineLAF(LookAndFeel newLookAndFeel)
	{
	   try 
	   {
		   UIManager.setLookAndFeel(newLookAndFeel);
	   }
	   catch(UnsupportedLookAndFeelException e)
	   {
		   System.out.println(e.getMessage());
	   }
	}
}
