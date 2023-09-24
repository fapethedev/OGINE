package com.fapethedev.ogine.view.component.button;

import static com.formdev.flatlaf.util.UIScale.scale;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;

import com.formdev.flatlaf.ui.FlatUIUtils;

/**
 * Button that draws a scaled arrow in one direction.
 *
 * @author FATIGBA Abiola Pierre-Edy
 */
public class ArrowButton extends BasicArrowButton implements UIResource
{
	public static final int DEFAULT_ARROW_WIDTH = 9;

	protected boolean chevron;
	protected Color foreground;
	protected Color disabledForeground;
	protected Color hoverForeground;
	protected Color hoverBackground;
	protected Color pressedForeground;
	protected Color pressedBackground;

	private int arrowWidth = DEFAULT_ARROW_WIDTH;
	private float xOffset = 0;
	private float yOffset = 0;

	private boolean hover;
	private boolean pressed;

	public ArrowButton( int direction, String type, Color foreground, Color disabledForeground,
		Color hoverForeground, Color hoverBackground, Color pressedForeground, Color pressedBackground)
	{
		super(direction, null, null, null, null);
		updateStyle(type, foreground, disabledForeground, hoverForeground, hoverBackground, pressedForeground, pressedBackground);

		setOpaque(false);
		setBorder(null);

		if(hoverForeground != null || hoverBackground != null ||
			pressedForeground != null || pressedBackground != null)
		{
			addMouseListener( new MouseAdapter() 
			{
				@Override
				public void mouseEntered(MouseEvent e)
				{
					hover = true;
					repaint();
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					hover = false;
					repaint();
				}

				@Override
				public void mousePressed(MouseEvent e)
				{
					if(SwingUtilities.isLeftMouseButton(e))
					{
						pressed = true;
						repaint();
					}
				}

				@Override
				public void mouseReleased(MouseEvent e)
				{
					if(SwingUtilities.isLeftMouseButton(e))
					{
						pressed = false;
						repaint();
					}
				}
			});
		}
	}

	public void updateStyle(String type, Color foreground, Color disabledForeground,
		Color hoverForeground, Color hoverBackground, Color pressedForeground, Color pressedBackground)
	{
		this.chevron = FlatUIUtils.isChevron(type);
		this.foreground = foreground;
		this.disabledForeground = disabledForeground;
		this.hoverForeground = hoverForeground;
		this.hoverBackground = hoverBackground;
		this.pressedForeground = pressedForeground;
		this.pressedBackground = pressedBackground;
	}



	public int getArrowWidth()
	{
		return arrowWidth;
	}

	public void setArrowWidth(int arrowWidth)
	{
		this.arrowWidth = arrowWidth;
	}

	protected boolean isHover()
	{
		return hover;
	}

	protected boolean isPressed()
	{
		return pressed;
	}

	public float getXOffset()
	{
		return xOffset;
	}

	public void setXOffset(float xOffset)
	{
		this.xOffset = xOffset;
	}

	public float getYOffset()
	{
		return yOffset;
	}

	public void setYOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}

	protected Color deriveBackground(Color background) 
	{
		return background;
	}

	protected Color deriveForeground(Color foreground) 
	{
		return FlatUIUtils.deriveColor(foreground, this.foreground);
	}

	/**
	 * Returns the color used to paint the arrow.
	 *
	 * @since 1.2
	 */
	protected Color getArrowColor() 
	{
		return isEnabled()
			? (pressedForeground != null && isPressed()
				? pressedForeground
				: (hoverForeground != null && isHover()
					? hoverForeground
					: foreground))
			: disabledForeground;
	}

	@Override
	public Dimension getPreferredSize() 
	{
		return scale(super.getPreferredSize());
	}

	@Override
	public Dimension getMinimumSize() 
	{
		return scale(super.getMinimumSize());
	}

	@Override
	public void paint( Graphics g )
	{
		super.paint(g);
		Object[] oldRenderingHints = FlatUIUtils.setRenderingHints(g);

		// paint hover or pressed background
		if(isEnabled())
		{
			Color background = (pressedBackground != null && isPressed())
				? pressedBackground
				: (hoverBackground != null && isHover()
					? hoverBackground
					: null);

			if(background != null)
			{
				g.setColor( deriveBackground(background));
				paintBackground((Graphics2D)g);
			}
		}

		// paint arrow
		g.setColor(deriveForeground(getArrowColor()));
		paintArrow((Graphics2D)g);

		FlatUIUtils.resetRenderingHints(g, oldRenderingHints);
	}

	protected void paintBackground(Graphics2D g)
	{
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	protected void paintArrow(Graphics2D g)
	{
		boolean vert = (direction == NORTH || direction == SOUTH);
		int x = 0;

		// move arrow for round borders
		Container parent = getParent();
		if(vert && parent instanceof JComponent && FlatUIUtils.hasRoundBorder((JComponent)parent))
			x -= scale(parent.getComponentOrientation().isLeftToRight() ? 1 : -1);

		FlatUIUtils.paintArrow(g, x, 0, getWidth(), getHeight(), getDirection(), chevron, getArrowWidth(), getXOffset(), getYOffset());
	}
}
