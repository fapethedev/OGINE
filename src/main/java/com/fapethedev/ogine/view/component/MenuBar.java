package com.fapethedev.ogine.view.component;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.fapethedev.ogine.controller.menubar.MenuBarExitController;
import com.fapethedev.ogine.controller.menubar.MenuBarLogoutController;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.OgineColor;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class MenuBar extends JMenuBar 
{
	private JMenu menuFile;
	private JMenu menuHelp;
	private JMenu menuOption;
	private JMenu sousMenuFile;
	
	private JMenuItem openIt;
	private JMenuItem recentIt;
	private JMenuItem saveIt;
	private JMenuItem saveItU;
	private JMenuItem printIt;
	private JMenuItem expIt;
	private JMenuItem impIt;
	private JMenuItem logoutIt;
	private JMenuItem exitIt;
	
	private JMenuItem newIt1;
	private JMenuItem newIt2;
	private JMenuItem newIt3;
	
	private JMenuItem helpIt1;
	private JMenuItem helpIt2;
	private JMenuItem helpIt3;
	
	private JMenuItem optIt1;
	private JMenuItem optIt2;
	private JMenuItem optIt3;
	
	public MenuBar()
	{
		super();
		this.setBackground(Color.WHITE);
		initMenuBar();
		menuBarAdd();
		configMenuBar();
	}
	
	private void initMenuBar()
	{		
		menuFile = new JMenu("Fichier"); 
		menuHelp = new JMenu("Aide");
		menuOption = new JMenu("Options");
		sousMenuFile = new JMenu("Nouveau");
		
		openIt = new JMenuItem("Ouvrir", Iconifier.openIcon);
		recentIt= new JMenuItem("Recent");
		saveIt = new JMenuItem("Enregistrer", Iconifier.saveIcon);
		saveItU = new JMenuItem("Enregistrer sous");
		expIt = new JMenuItem("Exporter", Iconifier.exportIcon);
		impIt = new JMenuItem("Importer", Iconifier.importIcon);
		printIt = new JMenuItem("Imprimer", Iconifier.printIcon);
		logoutIt = new JMenuItem("Deconnexion", Iconifier.logoutIcon);
		exitIt = new JMenuItem("Quitter", Iconifier.exitIcon32);
		
		newIt1 = new JMenuItem("Fiche d'Inscription", Iconifier.formIcon);
		newIt2 = new JMenuItem("Fiche Etudiant", Iconifier.newFormIcon);
		newIt3= new JMenuItem("Liste des Etudiants", Iconifier.revFormIcon);
		
		helpIt1 = new JMenuItem("A Propos STRyG", Iconifier.aboutIcon);
		helpIt2 = new JMenuItem("Contact Developper", Iconifier.contactIcon);
		helpIt3= new JMenuItem("Raccourcis", Iconifier.shortcutIcon);
		
		optIt1 = new JMenuItem("Thème", Iconifier.paramIcon);
		optIt2 = new JMenuItem("Utilisateur(Not Available");
		optIt3 = new JMenuItem("A definir");
	}
	
	private void menuBarAdd()
	{
		this.add(menuFile);
		this.add(menuHelp);
		this.add(menuOption);
		
		menuFile.add(sousMenuFile);
		menuFile.add(openIt);
		menuFile.add(recentIt);
		menuFile.addSeparator();
		menuFile.add(saveIt);
		menuFile.add(saveItU);
		menuFile.addSeparator();
		menuFile.add(printIt);
		menuFile.addSeparator();
		menuFile.add(impIt);
		menuFile.add(expIt);
		menuFile.addSeparator();
		menuFile.add(logoutIt);
		menuFile.add(exitIt);
		
		sousMenuFile.add(newIt1);
		sousMenuFile.add(newIt2);
		sousMenuFile.add(newIt3);
		
		menuHelp.add(helpIt1);
		menuHelp.add(helpIt2);
		menuHelp.addSeparator();
		menuHelp.add(helpIt3);
		
		menuOption.add(optIt1);
		menuOption.add(optIt2);
		menuOption.addSeparator();
		menuOption.add(optIt3);
	}
	
	private void configMenuBar()
	{
		menuFile.setMnemonic('F');
		menuHelp.setMnemonic('A');
		sousMenuFile.setMnemonic('N');
		menuOption.setMnemonic('O');
		
		openIt.setMnemonic('O');
		recentIt.setMnemonic('R');
		
		saveIt.setMnemonic('E');
		saveItU.setMnemonic('G');
		
		printIt.setMnemonic('P');
		
		impIt.setMnemonic('I');
		expIt.setMnemonic('X');
		
		logoutIt.setMnemonic('D');
		exitIt.setMnemonic('Q');
		
		newIt1.setMnemonic('I');
		newIt2.setMnemonic('E');
		newIt3.setMnemonic('N');
		
		helpIt1.setMnemonic('A');
		helpIt2.setMnemonic('C');
		helpIt3.setMnemonic('R');
		
		optIt1.setMnemonic('T');
		optIt1.setMnemonic('U');
		optIt1.setMnemonic(0);
		
		openIt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		recentIt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		saveIt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		printIt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
		
		helpIt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		helpIt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		helpIt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		optIt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		optIt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));

		exitIt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
		
		logoutIt.setForeground(OgineColor.RED);
		exitIt.setForeground(OgineColor.RED);
		menuListener();
	}
	
	private void menuListener()
	{
		openIt.addActionListener(new OpenChooser());
		saveIt.addActionListener(this::onSaveClick);
		saveItU.addActionListener(this::onSaveClick);
		logoutIt.addActionListener(this::onLogoutClick);
		exitIt.addActionListener(this::onExitClick);
	}
	
	private void onSaveClick(ActionEvent e)
	{
		
		JFileChooser saveChooser = new JFileChooser();
		
		saveChooser.setFileHidingEnabled(true);
		saveChooser.setDialogTitle("Enregistrer");
		saveChooser.setCurrentDirectory(new File("C://Users//hp//Documents//"));
		saveChooser.setLocation(0, 0);
		saveChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		saveChooser.setLocale(new Locale("French", "France"));
		
		int action = saveChooser.showSaveDialog(null);
		
		if(action == JFileChooser.APPROVE_OPTION)
		{
			@SuppressWarnings("unused")
			File file = new File(saveChooser.getSelectedFile().getAbsolutePath());			
		}
	}
	
	private void onLogoutClick(ActionEvent e)
	{
		MenuBarLogoutController.logout(this);
	}
	
	private void onExitClick(ActionEvent e)
	{
		MenuBarExitController.exit(this);
	}

	/**
	 * @return the newIt1
	 */
	public JMenuItem getInsMenuIt()
	{
		return newIt1;
	}

	/**
	 * @return the newIt2
	 */
	public JMenuItem getEnrMenuIt()
	{
		return newIt2;
	}

	/**
	 * @return the newIt3
	 */
	public JMenuItem getLisMenuIt()
	{
		return newIt3;
	}
}
