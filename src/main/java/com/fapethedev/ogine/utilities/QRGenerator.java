package com.fapethedev.ogine.utilities;

import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class QRGenerator
{
	/**
	 * 
	 * @param data <p>The information to encode into the QRcode<p>
	 * @param text1 <p>First QCRcode name specializer<p>
	 * @param text2 <p>Second QRCode name specialize<p>
	 * @return {@code path} the path of the specific QRCode created
	 * @throws WriterException 
	 * @throws IOException 
	 */
	public static ImageIcon createQRCode(String data, String text1, String text2) throws WriterException, IOException
	{
		if(data == null || text1 == null || text2 == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			String path = Path.QRPath.concat("QRC-" + text1 + text2 + ".jpg");
			BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 256, 256);
			MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
			
			return new ImageIcon(path);
		}
	}
	
	/**
	 * 
	 * @param <p>strings an array witch represents all
	 * 			 the concerns student informations<p>
	 * @return the prepared string 
	 */
	public static String prepareData(String...strings)
	{
		String preparedData = ("Matricule : " + strings[0] + "\n" 
        		+ "Nom : " + strings[1] + "\n" 
        		+ "Prénom(s) : " + strings[2] + "\n" 
        		+ "Date de Naissance : " + strings[3] + "\n" 
        		+ "Sexe : " + strings[4] + "\n" 
        		+ "Institut : " + strings[5] + "\n" 
        		+ " Niveau : " + strings[6] + "\n" 
        		+ "Spécialité : " + strings[7] + "\n" 
        		+ "Contact : " + strings[8] + "\n" 
        		+ "Adresse : " + strings[9] + "\n" 
        		+ "Group Sanguin : " + strings[10]  + "\n" 
        		+ "Personne à Prévenir : " + strings[11] + ", " + strings[12]);
		
		return preparedData;
	}
}