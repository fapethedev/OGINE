package com.fapethedev.ogine.utilities;

import java.io.File;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class Path 
{
	public static String picturePath = "C:\\STRyG\\data\\studentProfilePicture\\";
	public static String QRPath = "C:\\STRyG\\data\\studentIDCard\\";
	public static String ScreenPath = "C:\\STRyG\\data\\screenshot\\";
	public static String chartPath = "C:\\STRyG\\data\\chart\\";
	public static String confPath = "C:\\STRyG\\conf\\properties\\";
	public static String logPath = "C:\\STRyG\\journal\\";

	/**
	 * Create all directories for app
	 */
	public static void createDirectory()
	{
		File pictureDir = new File(picturePath);
		File QRDir = new File(QRPath);
		File screenDir = new File(ScreenPath);
		File chartDir = new File(chartPath);
		File confDir = new File(confPath);
		File logDir = new File(logPath);
		
		if(!pictureDir.exists() || !QRDir.exists() || !screenDir.exists() || !chartDir.exists() || !confDir.exists() || !logDir.exists())
		{
			boolean cP = pictureDir.mkdirs();
			boolean cQ = QRDir.mkdirs();
			boolean cS = screenDir.mkdirs();
			boolean cC = chartDir.mkdirs();
			boolean cF = confDir.mkdirs();
			boolean cL = logDir.mkdirs();
			
			if(cP && cQ && cS && cC  && cF)
			{
				System.out.println("Repertoires créer avec succes");
			}
			else
			{
				System.err.println("Le repertoire existe déja ou n'a pas pu être créée");
			} 
		}
	}
}
