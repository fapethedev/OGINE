package com.fapethedev.ogine.view.component.field;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;

import javax.annotation.Nonnull;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import com.fapethedev.ogine.utilities.Iconifier;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class OSearchField extends JTextField
{
	private Color animationColor = new Color(3, 175, 255);
	private Color background = Color.WHITE;
	private Color borderColor = Color.BLACK;
    private Color placeholderColor = Color.GRAY;
    private Color focusColor = new Color(80, 199, 255);
    private String placeholder;
	private Image image;
	int maxLength = 35;
	/**
	 * 
	 */
	public OSearchField() 
	{
		super();
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 25));
		this.setFont(new Font("Arial", Font.BOLD, 18));
		this.setSelectionColor(new Color(80, 199, 255));
		this.setPlaceholder("Rechercher selon ... ");
        this.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				
				if(getLength() + str.length() > maxLength)
				{
					str = str.substring(0, maxLength - getLength());
				}
				super.insertString(offs, str, a);
			}
        });
        
        this.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent me)
			{
				if(image != Iconifier.searchIcon.getImage())
				{
					if(checkMouseOver(me.getPoint()))
					{
						setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					else
					{
						setCursor(new Cursor(Cursor.TEXT_CURSOR));
					}
				}
				else
				{
					setCursor(new Cursor(Cursor.TEXT_CURSOR));
				}
			}
		});
		
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent me)
			{
				if(image != Iconifier.searchIcon.getImage())
				{
					if(SwingUtilities.isLeftMouseButton(me) && checkMouseOver(me.getPoint()))
					{
						if(me.getSource() instanceof JTextField field)
						{
							if(!field.getText().isEmpty() || field.getCaretPosition() > 0 && (getText() != getPlaceholder()))
							{
								field.setText("");
							}
						}
					}
				}
			}
		});
    }
	
	public OSearchField(String text, int columns) 
	{
		maxLength = columns;
		this.setPlaceholder(text);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 25));
		this.setFont(new Font("Arial", Font.BOLD, 18));
		this.setSelectionColor(new Color(80, 199, 255));
        this.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				
				if(getLength() + str.length() > maxLength)
				{
					str = str.substring(0, maxLength - getLength());
				}
				super.insertString(offs, str, a);
			}
        });
        
        this.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent me)
			{
				if(image != Iconifier.searchIcon.getImage())
				{
					if(checkMouseOver(me.getPoint()))
					{
						setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					else
					{
						setCursor(new Cursor(Cursor.TEXT_CURSOR));
					}
				}
				else
				{
					setCursor(new Cursor(Cursor.TEXT_CURSOR));
				}
			}
		});
		
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent me)
			{
				if(image != Iconifier.searchIcon.getImage())
				{
					if(SwingUtilities.isLeftMouseButton(me) && checkMouseOver(me.getPoint()))
					{
						if(me.getSource() instanceof JTextField field)
						{
							if(!field.getText().isEmpty() || field.getCaretPosition() > 0 && (getText() != getPlaceholder()))
							{
								field.setText("");
							}
						}
					}
				}
			}
		});
	}
 
	public boolean checkMouseOver(Point mouse)
	{
		int width = this.getWidth();
		int height = this.getHeight();
		int butMargin = 5;
		int butSize = height - butMargin * 2;
		Point p = new Point(width - height + 3, butMargin);
		Ellipse2D.Double cercle = new Ellipse2D.Double(p.x, p.y, butSize, butSize);
		
		return cercle.contains(mouse);
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
        g2d.fillRoundRect(0, 0, width, height, height, height);
        g2d.setColor(borderColor);
        g2d.drawRoundRect(0, 0, width - 1, height - 1, height, height);
        super.paintComponent(g);
        
        int butMargin = 5;
		int butSize = height - butMargin * 2;
		GradientPaint gp = new GradientPaint(0, 0, Color.WHITE, width, 0, Color.WHITE);
		g2d.setPaint(gp);
		g2d.fillOval(width - height + 3, butMargin, butSize, butSize);
		int imgMargin = 5;
		int imgSize = butSize - imgMargin * 2;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        if(this.isFocusOwner())
        {
            this.setBorderColor(focusColor);
            this.revalidate();
            this.repaint();
            
            if(!getText().isEmpty())
    		{
    			if(getText() != getPlaceholder())
    			{
    				gp = new GradientPaint(0, 0, new Color(255, 255, 255), width, 0, new Color(244, 67, 54));
    				g2d.setPaint(gp);
    				g2d.fillOval(width - height + 3, butMargin, butSize, butSize);
    				image = Iconifier.removeIcon.getImage();
    			}
    			else
    			{
    				gp = new GradientPaint(0, 0, Color.WHITE, width, 0, animationColor);
    				g2d.setPaint(gp);
    				g2d.fillOval(width - height + 3, butMargin, butSize, butSize);
    				image = Iconifier.searchIcon.getImage();
    			}
    		}
    		else
    		{
    			gp = new GradientPaint(0, 0, Color.WHITE, width, 0, animationColor);
    			g2d.setPaint(gp);
    			g2d.fillOval(width - height + 3, butMargin, butSize, butSize);
    			image = Iconifier.searchIcon.getImage();
    		}
        }
        else if(!this.isFocusOwner())
        {
            this.setBorderColor(Color.BLACK);
            this.revalidate();
            this.repaint();
            
            gp = new GradientPaint(0, 0, Color.WHITE, width, 0, animationColor);
			g2d.setPaint(gp);
			g2d.fillOval(width - height + 3, butMargin, butSize, butSize);
			image = Iconifier.searchIcon.getImage();
        }
        this.repaint();
        this.revalidate();
        
		if(image != null)
		{
			g2d.drawImage(image, width - height + imgMargin + 3, butMargin + imgMargin, imgSize, imgSize, null);
		}
		g2d.dispose();
		this.repaint();
		this.revalidate();
    }	

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        super.paint(g);
        if(this.getText().isEmpty())
        {
            if(placeholder != null)
            {	
                int h = this.getHeight();
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                Insets ins = this.getInsets();
                FontMetrics fm = g.getFontMetrics();
                g2d.setColor(placeholderColor);
                g2d.setFont(this.getFont().deriveFont(Font.ITALIC));
                g2d.drawString(placeholder, ins.left, h / 2 + fm.getAscent() / 2 - 2);
            }
        }
        else
        {
            g2d.setColor(this.getForeground());
            g2d.setFont(this.getFont().deriveFont(Font.BOLD));
        }
    }

    @Override
    public void setText(String txt)
    {
        try 
        {
            Document doc = getDocument();
            if (doc instanceof AbstractDocument abstractDocument)
            {
                abstractDocument.replace(0, doc.getLength(), txt, null);
            }
            else
            {
                doc.remove(0, doc.getLength());
                doc.insertString(0, txt, null);
            }
        }
        catch (BadLocationException e) 
        {
            UIManager.getLookAndFeel().provideErrorFeedback(OSearchField.this);
        }
    }

    @Override
    public String getText()
    {
        Document doc = getDocument();
        String txt;
	    try 
	    {	
            txt = doc.getText(0, doc.getLength());
	    }
	    catch (BadLocationException e)
	    {
	        txt = null;
	    }
        return txt;
    }

    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
        this.repaint();
        this.revalidate();
    }

    public String getPlaceholder()
    {
        return placeholder;
    }

    @Override
    public void setBackground(Color background)
    {
        this.background = background;
        super.setBackground(background);
        this.revalidate();
        this.repaint();
    }

    @Nonnull
    public void setBorderColor(Color borderColor)
    {
        if(borderColor != null)
        {
        	this.borderColor = borderColor;
            this.revalidate();
            this.repaint();
            this.revalidate();
        }
    }
    
    @Nonnull
    public void setFocusColor(Color focusColor)
    {
    	if(focusColor != null)
    	{
    		this.focusColor = focusColor;
        	this.revalidate();
        	this.repaint();
    	}
    }

	public int getMaxLength()
	{
		return maxLength;
	}
	
	@Nonnull
	public void setMaxLength(int maxLength)
	{
		this.maxLength = maxLength;
	}
	
	public void setAnimationColor(Color color)
	{
		this.animationColor = color;
	}
}
