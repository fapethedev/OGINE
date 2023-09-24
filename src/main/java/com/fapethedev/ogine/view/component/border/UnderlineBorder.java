package com.fapethedev.ogine.view.component.border;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public abstract class UnderlineBorder implements Border
{
	private static Color defaultC = Color.BLACK;
	private static int thickness = 1;
	
	public static Border createUnderlineBorder()
	{
		return BorderFactory.createMatteBorder(0, 0, thickness, 0, defaultC);
	}
	
	public static Border createUnderlineBorder(int thickness)
	{
		return BorderFactory.createMatteBorder(0, 0, thickness, 0, defaultC);
	}
	
	public static Border createUnderlineBorder(Color c)
	{
		return BorderFactory.createMatteBorder(0, 0, thickness, 0, c);
	}

	public static Border createUnderlineBorder(Color c, int thickness) 
	{
		return BorderFactory.createMatteBorder(0, 0, thickness, 0, c);
	}
}
