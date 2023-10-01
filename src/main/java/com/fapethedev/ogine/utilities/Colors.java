package com.fapethedev.ogine.utilities;

import java.awt.Color;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class Colors
{
	private static volatile Colors instance;

	private Colors() {
	}

	/**
	 * Returns a singleton of {@code Colors}
	 * @return a singleton of {@code Colors}
	 */
	public static Colors getInstance()
	{
		if (instance == null) {
			synchronized (Colors.class)
			{
				if (instance == null)
				{
					instance = new Colors();
				}
			}
		}
		return instance;
	}

	public  final Color BLUE = new Color(0, 140, 195);
	public  final Color DARK_BLUE = new Color(0, 73, 97);
	public  final Color LIGHT_BLUE = new Color(2, 52, 71);
	public  final Color RED = new Color(100, 6, 6);
	public  final Color LIGHT_RED = new Color(120, 6, 6);
	public  final Color DARK_RED = new Color(80, 6, 6);
	public  final Color GRAY = new Color(212, 212, 212);
	public  final Color LIGHT_GRAY = new Color(245, 245, 245);
	public  final Color DARK_GRAY = new Color(175, 175, 175);
	public  final Color BELGE = new Color(255, 248, 189);
	public  final Color DARK_GREEN = new Color(2, 94, 29);
	public  final Color GREEN = new Color(46, 124, 29);
	public  final Color DARK_YELLOW = new Color(162, 114, 52);
	public  final Color YELLOW = new Color(233, 201, 116);
	public  final Color ORANGE = new Color(255, 113, 0);
}
