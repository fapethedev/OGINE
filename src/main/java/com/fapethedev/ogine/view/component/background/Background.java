package com.fapethedev.ogine.view.component.background;

import com.twelvemonkeys.image.ImageUtil;
import lombok.Getter;
import lombok.Setter;
import org.jdesktop.swingx.graphics.ShadowRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
@Getter @Setter
public class Background extends JPanel
{
	protected BufferedImage imgBG;
	protected LayoutManager lm;
	protected ImageIcon image;
	private JPanel blurPanel;
	
	public Background()
	{
		super();
		setOpaque(false);
		SwingUtilities.invokeLater(() ->{
			createImage();
			repaint();
		});
	}
	
	public Background(LayoutManager lm)
	{
		super(lm);
		this.lm = lm;
		SwingUtilities.invokeLater(() ->{
			createImage();
			repaint();
		});
	}
	
	public void setBlurPanel(JPanel blurPanel)
	{
		blurPanel.setOpaque(false);
		this.blurPanel = blurPanel;
		this.blurPanel.setOpaque(false);
		SwingUtilities.invokeLater(() ->{
			createImage();
			repaint();
		});
	}
	
	private void createImage()
	{
//		if(image != null)
//		{
			int width = getWidth();
			int heigth = getHeight();
			if(width > 0 && heigth > 0)
			{ 
				imgBG = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = imgBG.createGraphics();
				g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
//				Rectangle rectangle = getAutoSize(image);
//				g2d.drawImage(
//						image.getImage(), rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
				if(blurPanel != null)
				{
					createBlurImage(g2d);
				}
				g2d.dispose();
			}
//		}
	}
	
	private void createBlurImage(Graphics2D g2d)
	{
		int x = blurPanel.getX();
		int y = blurPanel.getY();
		int width = blurPanel.getWidth();
		int heigth = blurPanel.getHeight();
		int shadow = 8;
		if(width > 0 && heigth > 0)
		{
			BufferedImage bufferedImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = bufferedImage.createGraphics();
			g2.drawImage(ImageUtil.blur(imgBG.getSubimage(x, y, width, heigth), 10f), 0, 0, null);
			g2.dispose();
			g2d.drawImage(
					new ShadowRenderer(shadow, 0.3f, new Color(0, 0, 0)).createShadow(bufferedImage),
							 (int)(x - shadow * 0.8f), (int)(y - shadow * 0.8f), null);
			g2d.drawImage(bufferedImage, x, y, null);
		}
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		SwingUtilities.invokeLater(() ->{
			createImage();
			repaint();
		});
	}
	
	private Rectangle getAutoSize(ImageIcon image)
	{
		int w = getWidth();
		int h = getHeight();
		int iw = image.getIconWidth();
		int ih = image.getIconHeight();
		
		double xScale = (double) w / iw;
		double yScale = (double) h / ih;
		double scale = Math.max(xScale, yScale);
		
		int width = (int) (scale * iw);
		int height = (int) (scale * ih);
		
		if(width < 1)
		{
			width = 1;
		}
		
		if (height < 1) 
		{
			height = 1;
		}
		
		int x = (w - width) / 2;
		int y = (h - height) / 2;
		
		return new Rectangle(new Point(x, y), new Dimension(width, height));
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(imgBG, 0, 0, this);
	}
}
