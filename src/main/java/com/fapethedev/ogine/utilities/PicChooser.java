package com.fapethedev.ogine.utilities;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class PicChooser extends JFileChooser 
{
	private String directorypath;
	private FileFilter filter;
	
	/**
	 * Constructor whitout args
	 */
	public PicChooser() 
	{
		super();
		directorypath = "C://Users//hp//Documents//";
		filter = new FileNameExtensionFilter("Images(*.jpg *.jpeg *.png)", new String[] {"JPG", "JPEG", "PNG"});
		this.addChoosableFileFilter(filter);
		this.setFileFilter(filter);
		this.setDialogTitle("Choisir une image");
		this.setDialogType(OPEN_DIALOG);
//		this.setApproveButtonText("Ouvrir");
		this.setApproveButtonToolTipText("Ouvrir le fichier selectioné");
		this.setMultiSelectionEnabled(false);
		this.setCurrentDirectory(new File(directorypath));
		this.setFileHidingEnabled(true);
		this.setLocation(0, 0);
	}
}


