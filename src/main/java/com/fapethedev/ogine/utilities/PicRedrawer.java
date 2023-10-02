package com.fapethedev.ogine.utilities;

import com.fapethedev.ogine.controller.form.StudentController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class PicRedrawer 
{
	/**
	 * <p>Recreate a copy of client Profile into a new location<p>
	 * 
     * @param lastName
     * @param firstName
	 * @return the name of the copy
	 */
	public static String redrawerPath(String lastName, String firstName)
	{
		String inputPath = StudentController.getInputfile().getAbsolutePath();
        String imageFullpath = null;
        try
        {
            BufferedImage newImage = ImageIO.read(new File(inputPath));
            Image image = newImage.getScaledInstance(PicResizer.W, PicResizer.H, Image.SCALE_DEFAULT);
            String imageFormat = inputPath.substring(inputPath.lastIndexOf(".") + 1);
            String imageName = lastName.concat(firstName);
            imageFullpath = Path.picturePath.concat("PPIMG-" + imageName + "." + imageFormat);

			boolean success = ImageIO.write(convertToBufferedImage(image), imageFormat, new File(imageFullpath));
			if(success)
			{
				System.out.println("SUCCESS");
			}
			else
			{
				System.out.println("FAILURE");
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		return imageFullpath;
	}
        
        public static BufferedImage convertToBufferedImage(Image img)
        {
            if(img instanceof BufferedImage bufferedImage)
            {
                return bufferedImage;
            }
            BufferedImage newImage = new BufferedImage
			(
					img.getWidth(null),
					img.getHeight(null),
					PicResizer.getSingleton().getInputImage().getType()
			);
            Graphics2D g2d = newImage.createGraphics();
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();
            
            return newImage;
        }
}