package com.fapethedev.ogine.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/** 
 * @author FATIGBA Abiola Pierre-Edy
 */
public class PicResizer 
{
	public final static int W = 128;
	public final static int H = 128;
	private BufferedImage inputImage;
	private ImageIcon outputIcon;
	private Image scaleImage;
	
	private static PicResizer singleton;
	
	private PicResizer()
	{
		
	}
	
	public synchronized static PicResizer getSingleton()
	{
		if(singleton == null)
		{
			singleton = new PicResizer();
		}
		
		return singleton;		
	}
	
	/**
	 * @param inputFile 
	 * @return an image of ImagaIcon type with a scaled size
	 * @throws PicRezierException
	 */
	public ImageIcon imageResizer(File inputFile) throws PicResizerException
	{
		try
		{
			inputImage = ImageIO.read(inputFile);
		}
		catch(IOException e) 
		{
			throw new PicResizerException(e.getMessage(), e.getCause());
		}
		
		scaleImage = inputImage.getScaledInstance(W, H, Image.SCALE_DEFAULT);	
		outputIcon = new ImageIcon(scaleImage);
		return outputIcon;
	}
	
	/**
	 * @return a buffered image from reading the input file 
	 */
	public BufferedImage getInputImage() 
	{
		return inputImage;
	}

	/**
	 * @return an image with the predifined dimension
	 */
	public Image getScaleImage()
	{
		return scaleImage;
	}
}
