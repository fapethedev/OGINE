package com.fapethedev.ogine.view.component.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class BoldListCellRenderer extends DefaultListCellRenderer
{
	private DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
	
	public BoldListCellRenderer()
	{
		super();
		setHorizontalAlignment(JLabel.LEADING);
	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus)
	{
		Component c = defaultListCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		c.setFont(getFont().deriveFont(Font.BOLD));
		c.setBackground(Color.WHITE);
		if(isSelected)
		{
            c.setBackground(new JTextField().getSelectionColor());
            c.setForeground(new JTextField().getSelectedTextColor());
        }
        else
        {
            c.setBackground(c.getBackground());
            c.setForeground(c.getForeground());
        }
		return c;
	}
	
	

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		int arc = 20;
		Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arc, arc);
		g2d.setClip(clip);
	}
}
