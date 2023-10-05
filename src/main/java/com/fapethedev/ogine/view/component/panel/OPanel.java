package com.fapethedev.ogine.view.component.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class OPanel extends JPanel
{
	private Color background = Color.WHITE;
	private Color borderColor = Color.WHITE;
	private int radius;

	/**
	 * @param radius, witch will determinate the panel top corner rounds
	 */
	public OPanel(int radius)
	{
		super();
		this.radius = radius;
		this.setBackground(new Color(255, 255, 255, 0));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}

	/**
	 */
	public OPanel(int radius, LayoutManager layout)
	{
		super(layout);
		this.radius = radius;
		this.setBackground(new Color(255, 255, 255, 0));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		int width = this.getWidth();
		int height = this.getHeight();
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setColor(background);
		g2d.fillRoundRect(0, 0, width, height, radius, radius);
		g2d.setColor(borderColor);
		g2d.drawRoundRect(0, 0, width - 1, height - 1, radius, radius);
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	
	public void setBackground(Color background)
	{
		this.background = background;
		super.setBackground(background);
	}
	
	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}
}
