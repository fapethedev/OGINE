package com.fapethedev.ogine.view.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class OpenChooser extends JFileChooser implements ActionListener 
{
	private String directorypath = "C://Users//hp//Documents//";
	private FileFilter filter = new FileNameExtensionFilter("Documents", new String[] {"PDF", "DOCX", "TXT"});
		
	public OpenChooser() 
	{
		super();
		this.addChoosableFileFilter(filter);
		this.setDialogTitle("Ouvrir");
		this.setDialogType(OPEN_DIALOG);
		this.setCurrentDirectory(new File(directorypath));
		this.setFileHidingEnabled(true);
		this.setLocation(0, 0);
		this.addActionListener(this::actionPerformed);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
}

