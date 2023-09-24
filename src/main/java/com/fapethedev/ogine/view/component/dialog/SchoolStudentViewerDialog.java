package com.fapethedev.ogine.view.component.dialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.button.OButton;

import lombok.Getter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
@Getter
public class SchoolStudentViewerDialog extends JDialog
{
	private final Font infoFont = new Font("Arial", Font.BOLD, 18);
	private final Font labFont = new Font("Arial", Font.PLAIN, 18);
	private final Font logFont = new Font("Times New Roman", Font.ITALIC, 14);
	private JPanel mainpane;
	private JLabel pictureLab;
	private JLabel matriLab;
	private JLabel lastNameLab;
	private JLabel firstNameLab;
	private JLabel dateNLab;
	private JLabel sexeLab;
	private JLabel institutLab;
	private JLabel levelLab;
	private JLabel specLab;
	private JLabel phoneLab;
	private JLabel addrLab;
	private JLabel QRLab;
	private JLabel bloodLab;
	private JLabel parNameLab;
	private JLabel parPhoneLab;
	private OButton okBut;
	private OButton printBut;
	private OButton switchBut;
	private CardLayout card;
	
	public SchoolStudentViewerDialog(JFrame parent,  boolean modal)
	{
		super(parent, modal);
		this.setTitle("Carte étudiant".toUpperCase());
		this.setSize(800, 450);
		this.setLocationRelativeTo(parent);
		this.setResizable(false);
		initComponent();
		butListener();
	}
	
	private void initComponent()
	{
		JPanel frontpane = new JPanel();
		JPanel backpane = new JPanel();
		JPanel controlpane = new JPanel();
		JPanel logopane = new JPanel();
		JPanel backTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel backMid = new JPanel(new BorderLayout());
		JPanel backMidW = new JPanel(new GridLayout(6, 1, 5, 1));
		JPanel backMidE = new JPanel();
		JLabel logoLab = new JLabel("powered by StryG", new ImageIcon(Iconifier.cardLogo.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT)), JLabel.LEFT);
		JLabel matriInfo = new JLabel("Matricule :");
		JLabel lnInfo = new JLabel("Nom :");
		JLabel fnInfo = new JLabel("Prénoms :");
		JLabel dateInfo = new JLabel("Date de Naissance :");
		JLabel sexInfo = new JLabel("Sexe :");
		JLabel insInfo = new JLabel("Institut :");
		JLabel lvlInfo = new JLabel("Niveau :");
		JLabel specInfo = new JLabel("Specialié :");
		JLabel phoneInfo = new JLabel("Contact :");
		JLabel addrInfo = new JLabel("Adresse :");
		JLabel bloodInfo = new JLabel("Groupe Sanguin :");
		JLabel parNameInfo = new JLabel("Personne à prévenir :");
		JLabel parPhoneInfo = new JLabel("Numéro d'urgence :");
		JLabel infoSup = new JLabel("Information Supplémentaire".toUpperCase());
		
		pictureLab = new JLabel();
		matriLab = new JLabel();
		lastNameLab = new JLabel();
		firstNameLab = new JLabel();
		dateNLab = new JLabel();
		sexeLab = new JLabel();
		institutLab = new JLabel();
		levelLab = new JLabel();
		specLab = new JLabel();
		QRLab = new JLabel();
		phoneLab = new JLabel();
		addrLab = new JLabel();
		bloodLab = new JLabel();
		parNameLab = new JLabel();
		parPhoneLab = new JLabel();
		okBut = new OButton("OK");
		printBut = new OButton("IMPRIMER");
		switchBut = new OButton();
		card = new CardLayout();
		mainpane = new JPanel(card);
		
		mainpane.setBackground(Color.WHITE);
		frontpane.setBackground(Color.WHITE);
		backMid.setBackground(Color.WHITE);
		backMidE.setBackground(Color.WHITE);
		backMidW.setBackground(Color.WHITE);
		backTop.setBackground(Color.WHITE);
		frontpane.setLayout(null);
		backpane.setBackground(Color.WHITE);
		backpane.setLayout(new BorderLayout(5, 5));
		controlpane.setBackground(Color.LIGHT_GRAY);
		logopane.setBackground(Color.WHITE);
		logopane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
		QRLab.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.LIGHT_GRAY));
		
		pictureLab.setLocation(new Point(5, 5));
		pictureLab.setSize(new Dimension(135, 135));
		pictureLab.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Iconifier.deleteIcon16px));
		
		matriInfo.setLocation(new Point(145, 5));
		matriInfo.setSize(new Dimension(120, 25));
		matriInfo.setFont(infoFont);
		matriLab.setLocation(new Point(255, 5));
		matriLab.setSize(new Dimension(180, 25));
		matriLab.setFont(labFont);
		
		lnInfo.setLocation(new Point(145, 38));
		lnInfo.setSize(new Dimension(120, 25));
		lnInfo.setFont(infoFont);
		lastNameLab.setLocation(new Point(255, 38));
		lastNameLab.setSize(new Dimension(180, 25));
		lastNameLab.setFont(labFont);
		
		fnInfo.setLocation(new Point(145, 71));
		fnInfo.setSize(new Dimension(120, 25));
		fnInfo.setFont(infoFont);
		firstNameLab.setLocation(new Point(255, 71));
		firstNameLab.setSize(new Dimension(180, 25));
		firstNameLab.setFont(labFont);
		
		dateInfo.setLocation(new Point(145, 110));
		dateInfo.setSize(new Dimension(180, 25));
		dateInfo.setFont(infoFont);
		dateNLab.setLocation(new Point(335, 110));
		dateNLab.setSize(new Dimension(180, 25));
		dateNLab.setFont(labFont);
		
		sexInfo.setLocation(new Point(5, 154));
		sexInfo.setSize(new Dimension(120, 25));
		sexInfo.setFont(infoFont);
		sexeLab.setLocation(new Point(140, 154));
		sexeLab.setSize(new Dimension(120, 25));
		sexeLab.setFont(labFont);
		
		insInfo.setLocation(new Point(5, 188));
		insInfo.setSize(new Dimension(120, 25));
		insInfo.setFont(infoFont);
		institutLab.setLocation(new Point(140, 188));
		institutLab.setSize(new Dimension(180, 25));
		institutLab.setFont(labFont);
		
		lvlInfo.setLocation(new Point(5, 222));
		lvlInfo.setSize(new Dimension(120, 25));
		lvlInfo.setFont(infoFont);
		levelLab.setLocation(new Point(140, 222));
		levelLab.setSize(new Dimension(180, 25));
		levelLab.setFont(labFont);
		
		specInfo.setLocation(new Point(5, 256));
		specInfo.setSize(new Dimension(120, 25));
		specInfo.setFont(infoFont);
		specLab.setLocation(new Point(140, 256));
		specLab.setSize(new Dimension(180, 25));
		specLab.setFont(labFont);
		
		phoneInfo.setLocation(new Point(5, 290));
		phoneInfo.setSize(new Dimension(120, 25));
		phoneInfo.setFont(infoFont);
		phoneLab.setLocation(new Point(140, 290));
		phoneLab.setSize(new Dimension(180, 25));
		phoneLab.setFont(labFont);
		
		addrInfo.setLocation(new Point(5, 324));
		addrInfo.setSize(new Dimension(120, 25));
		addrInfo.setFont(infoFont);
		addrLab.setLocation(new Point(140, 324));
		addrLab.setSize(new Dimension(180, 25));
		addrLab.setFont(labFont);
		
		bloodInfo.setFont(infoFont);
		bloodLab.setFont(labFont);
		parNameInfo.setFont(infoFont);
		parNameLab.setFont(labFont);
		parPhoneInfo.setFont(infoFont);
		parPhoneLab.setFont(labFont);
		
		logoLab.setHorizontalTextPosition(SwingConstants.CENTER);
		logoLab.setVerticalTextPosition(SwingConstants.BOTTOM);
		logoLab.setFont(logFont);
		logoLab.setIconTextGap(50);
		
		switchBut.setText("SUIVANT");
		//
		logopane.add(logoLab);
		mainpane.add(frontpane, "front");
		mainpane.add(backpane, "back");
		//
		frontpane.add(pictureLab);
		frontpane.add(matriInfo);
		frontpane.add(matriLab);
		frontpane.add(lnInfo);
		frontpane.add(lastNameLab);
		frontpane.add(fnInfo);
		frontpane.add(firstNameLab);
		frontpane.add(dateInfo);
		frontpane.add(dateNLab);
		frontpane.add(sexInfo);
		frontpane.add(sexeLab);
		frontpane.add(insInfo);
		frontpane.add(institutLab);
		frontpane.add(lvlInfo);
		frontpane.add(levelLab);
		frontpane.add(specInfo);
		frontpane.add(specLab);
		frontpane.add(phoneInfo);
		frontpane.add(phoneLab);
		frontpane.add(addrInfo);
		frontpane.add(addrLab);
		//
		backpane.add(backTop, BorderLayout.NORTH);
		backpane.add(backMid, BorderLayout.CENTER);
		backTop.add(infoSup);
		backMid.add(backMidW, BorderLayout.CENTER);
		backMid.add(backMidE, BorderLayout.EAST);
		backMidW.add(bloodInfo);
		backMidW.add(bloodLab);
		backMidW.add(parNameInfo);
		backMidW.add(parNameLab);
		backMidW.add(parPhoneInfo);
		backMidW.add(parPhoneLab);
		backMidE.add(QRLab);
		//
		controlpane.add(okBut);
		controlpane.add(printBut);
		controlpane.add(switchBut, BorderLayout.EAST);
		//
		this.getContentPane().add(mainpane, BorderLayout.CENTER);
		this.getContentPane().add(controlpane, BorderLayout.SOUTH);
		this.getContentPane().add(logopane, BorderLayout.WEST);
	}
	
	private void butListener()
	{
		switchBut.addActionListener(e ->{
			if(e.getSource() instanceof OButton button)
			{
				if(button.getText().compareToIgnoreCase("SUIVANT") == 0)
				{
					card.next(mainpane);
					button.setText("PRECEDENT");
				}
				else
				{
					card.next(mainpane);
					button.setText("SUIVANT");
				}
			}
		});
		okBut.addActionListener(e -> {this.dispose();});
	}
}