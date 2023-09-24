package com.fapethedev.ogine.view.component;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fapethedev.ogine.utilities.Path;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class SaveChooser extends JFileChooser 
{
	private FileFilter filter = new FileNameExtensionFilter("Images (*.JPG, *.JPEG, *.PNG)", new String[] {"JPG", "JPEG", "PNG"});
	
	public SaveChooser() 
	{
		super();
		this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.addChoosableFileFilter(filter);
		this.setFileFilter(filter);
		this.setDialogTitle("Enregister");
		this.setDialogType(SAVE_DIALOG);
		this.setApproveButtonText("Enregister");
		this.setApproveButtonToolTipText("Enregister le fichier");
		this.setMultiSelectionEnabled(false);
		this.setCurrentDirectory(new File(Path.chartPath));
		this.setFileHidingEnabled(true);
		this.setLocation(0, 0);
	}
}
