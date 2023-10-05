package com.fapethedev.ogine.view.component.button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.fapethedev.ogine.view.component.listeners.adapter.OButtonMouseAdapter;

import lombok.Getter;
import lombok.Setter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
@Getter @Setter
public class OButton extends JButton
{
	private Color background = Color.WHITE;
	private Color borderColor = Color.BLACK;
	private Color foreground = Color.BLACK;
	
	private String name;
	
	/**
	 * condtructor whithout args
	 */
	public OButton() 
	{
		super();
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBackground(background);
		this.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setContentAreaFilled(false);
		this.setFont(getFont().deriveFont(Font.BOLD));
		this.addMouseListener(new OButtonMouseAdapter());
		
	}

	/**
	 * @param text
	 */
	public OButton(String text) 
	{
		super(text);
		this.name = text;
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBackground(background);
		this.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setToolTipText(name);
		this.setFont(getFont().deriveFont(Font.BOLD));
		this.setContentAreaFilled(false);
		this.addMouseListener(new OButtonMouseAdapter());
	}

	
	@Override
	public void paintComponent(Graphics g)
	{
		int width = this.getWidth();
		int height = this.getHeight();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setColor(background);
		g2d.fillRoundRect(0, 0, width, height, height - 15, height - 15);
		g2d.setColor(borderColor);
		g2d.drawRoundRect(0, 0, width - 1, height - 1, height - 15, height - 15);
		g2d.setColor(foreground);
		
		if(this.name != null)
		{
			FontMetrics fm = g2d.getFontMetrics();
			int fmHeight = fm.getHeight();
			int fmWidth = fm.stringWidth(this.name);
			
			g2d.drawString
			(
				this.name,
				width / 2 - (fmWidth / 2),
				(height / 2) + (fmHeight / 4)
			);
		}
	}
	
	public void setBackground(Color background)
	{
		this.background = background;
		this.repaint();
		super.setBackground(background);
	}
	
	public void setForeground(Color foreground)
	{
		this.foreground = foreground;
		this.repaint();
		super.setForeground(foreground);
	}
	
	public void setText(String text)
	{
		this.name = text;
		this.setToolTipText(name);
		this.revalidate();
		this.repaint();
		super.setText(text);
	}
	
	public String getText()
	{
		return this.name;
	}
}
