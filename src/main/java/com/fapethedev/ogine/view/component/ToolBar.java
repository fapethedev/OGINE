package com.fapethedev.ogine.view.component;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.fapethedev.ogine.utilities.Iconifier;

import lombok.Getter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
@Getter
public class ToolBar extends JToolBar
{
	private JButton newButtonIcon;
	private JButton newInscButtonIcon;
	private JButton newEnregButtonIcon;
	private JButton listButtonIcon;
	private JButton openButtonIcon;
	private JButton saveButtonIcon;
	private JButton printButtonIcon;
	private JButton expButtonIcon;
	private JButton impButtonIcon;
	private JButton aboutButtonIcon;
	private JButton contButtonIcon;
	private JButton shortButtonIcon;
	private JButton customButtonIcon;
	private JButton undoButtonIcon;
	private JButton redoButtonIcon;
	private JButton screenshotButtonIcon;
	private JButton showRButtonIcon;
	private JButton showIButtonIcon;
	private JButton showLButtonIcon;
	private JButton showPButtonIcon;
	private JButton showOButtonIcon;
	/**
	 * @param name
	 */
	public ToolBar(String name)
	{
		super(name);
		this.setBackground(Color.WHITE);
		this.setAlignmentX(CENTER_ALIGNMENT);
		initIcon();
		add();
		configToolBar();
	}
	
	private void initIcon()
	{
		newButtonIcon = new JButton(Iconifier.newIcon);
		newInscButtonIcon = new JButton(Iconifier.formIcon);
		newEnregButtonIcon = new JButton(Iconifier.validateIcon);
		listButtonIcon = new JButton(Iconifier.revFormIcon);
		openButtonIcon = new JButton(Iconifier.openIcon);
		saveButtonIcon = new JButton(Iconifier.saveIcon);
		printButtonIcon = new JButton(Iconifier.printIcon);
		expButtonIcon = new JButton(Iconifier.exportIcon);
		impButtonIcon = new JButton(Iconifier.importIcon);
		aboutButtonIcon = new JButton(Iconifier.aboutIcon);
		contButtonIcon = new JButton(Iconifier.contactIcon);
		shortButtonIcon = new JButton(Iconifier.shortcutIcon);
		customButtonIcon = new JButton(Iconifier.paramIcon);
				
		undoButtonIcon = new JButton(Iconifier.undoIcon);
		redoButtonIcon = new JButton(Iconifier.redoIcon);
		screenshotButtonIcon = new JButton(Iconifier.sshotIcon);
		showRButtonIcon = new JButton("ENREGISTREMENT");
		showIButtonIcon = new JButton("INSCRIPTION");
		showLButtonIcon = new JButton("ETUDIANTS");
		showPButtonIcon = new JButton("IMPRESSION");
		showOButtonIcon = new JButton("OPTIONS");
	}
	
	private void add()
	{
		this.add(newButtonIcon);
		this.addSeparator();
		this.add(newInscButtonIcon);
		this.add(newEnregButtonIcon);
		this.add(listButtonIcon);
		this.addSeparator();
		this.add(openButtonIcon);
		this.add(saveButtonIcon);
		this.add(printButtonIcon);
		this.add(expButtonIcon);
		this.add(impButtonIcon);
		this.addSeparator();
		this.add(aboutButtonIcon);
		this.add(contButtonIcon);
		this.add(shortButtonIcon);
		this.add(customButtonIcon);
		this.addSeparator();
		this.add(undoButtonIcon);
		this.add(redoButtonIcon);
		this.addSeparator();
		this.add(screenshotButtonIcon);
		this.addSeparator();
		this.add(showRButtonIcon);
		this.add(showIButtonIcon);
		this.addSeparator();
		this.add(showLButtonIcon);
		this.addSeparator();
		this.add(showPButtonIcon);
		this.add(showOButtonIcon);
		this.addSeparator();
	}
	
	private void configToolBar()
	{
		newButtonIcon.setToolTipText("Nouvelle Session");
		newInscButtonIcon.setToolTipText("Nouvelle Inscription");
		newEnregButtonIcon.setToolTipText("Nouvel Enregistrement");
		listButtonIcon.setToolTipText("Afficher Les Inscrits");
		openButtonIcon.setToolTipText("Ouvrir un fichier");
		saveButtonIcon.setToolTipText("Enregistrer La Session");
		printButtonIcon.setToolTipText("Imprimer");
		expButtonIcon.setToolTipText("Exporter La Session");
		impButtonIcon.setToolTipText("Importer Une Session");
		shortButtonIcon.setToolTipText("Afficher Les Raccourcis");
		aboutButtonIcon.setToolTipText("À Propos");
		contButtonIcon.setToolTipText("Messagerie");
		customButtonIcon.setToolTipText("Option De Thème");
		undoButtonIcon.setToolTipText("Undo");
		redoButtonIcon.setToolTipText("Redo");
		screenshotButtonIcon.setToolTipText("Faire Une Capture D'Ecran");
		showRButtonIcon.setFocusable(false);
		showIButtonIcon.setFocusable(false);
		showLButtonIcon.setFocusable(false);
		showPButtonIcon.setFocusable(false);
		showOButtonIcon.setFocusable(false);
		showRButtonIcon.setFocusPainted(false);
		showIButtonIcon.setFocusPainted(false);
		showLButtonIcon.setFocusPainted(false);
		showPButtonIcon.setFocusPainted(false);
		showOButtonIcon.setFocusPainted(false);
	}
}