package com.fapethedev.ogine.view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.utilities.Admin;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.OgineColor;
import com.fapethedev.ogine.view.component.border.UnderlineBorder;
import com.fapethedev.ogine.view.component.button.DashOButton;
import com.fapethedev.ogine.view.component.listeners.AdminLabelMouseAdapter;
import com.fapethedev.ogine.view.component.listeners.DashLogoutMouseAdapter;
import com.fapethedev.ogine.view.menu.MainMenu;

import lombok.Getter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
@Getter
public class Dashboard extends JPanel
{
	private final int DASH_WIDTH = 250;
	private final int DASH_HEIGTH = MainMenu.HEIGTH - 60;
	private final Dimension DASH_DIM = new Dimension(DASH_WIDTH, DASH_HEIGTH);
	private JPanel topPane;
	private JPanel dashPane;
	private JPanel optPane;
	private JPanel butPane;
	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;
	private GridBagConstraints gbc3;
	private Color forColor;
	private Font title;
	private Font standard;
	private JLabel adminProfile;
	private JLabel dashTitle;
	private JLabel adminName;
	private JLabel adminRole;
	
	private DashOButton enregBut;
	private DashOButton inscrBut;
	private DashOButton listBut;
	private DashOButton reportBut;
	private DashOButton optBut;
	private DashOButton logoutBut;
	
	
	public Dashboard()
	{
		super();
		initDash();
		dashBuild();
	}
	
	private void initDash()
	{	
		topPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		dashPane = new JPanel(new GridBagLayout());
		optPane = new JPanel(new GridBagLayout());
		butPane = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();
		gbc3 = new GridBagConstraints();
		forColor = new Color(0);
		title = new Font("Arial", Font.BOLD, 20);
		standard = new Font("Arial", Font.BOLD, 18);
		dashTitle = new JLabel(Message.DASH_TITLE);
		adminProfile = new JLabel(Iconifier.adminIcon);
		adminName = new JLabel(Admin.getName().toUpperCase());
		adminRole = new JLabel(Admin.getRole().toUpperCase());
		enregBut = new DashOButton(Message.ENREGIS_TAG);
		inscrBut = new DashOButton(Message.INSCRIS_TAG);
		listBut = new DashOButton(Message.LISTE_TAG);
		optBut = new DashOButton(Message.OPTION_TAG);
		reportBut = new DashOButton(Message.REPORT_TAG);
		logoutBut = new DashOButton(Message.LOGOUT_TAG);
	}
	
	public void dashBuild()
	{
		JPanel centerPane = new JPanel(new BorderLayout());
		this.setPreferredSize(new Dimension(DASH_WIDTH , DASH_HEIGTH));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(forColor, 2, true));
		this.add(topPane, BorderLayout.NORTH);
		this.add(centerPane, BorderLayout.CENTER);
		this.add(butPane, BorderLayout.SOUTH);
		centerPane.add(dashPane, BorderLayout.NORTH);
		centerPane.add(optPane, BorderLayout.SOUTH);
		centerPane.setBackground(forColor);
		
		topPBuilder();
		dashPBuilder();
		optPBuilder();
		butPBuilder();
	}

	private void topPBuilder()
	{
		topPane.setBackground(forColor);
		topPane.add(dashTitle);
		dashTitle.setFont(title);
		dashTitle.setForeground(Color.WHITE);
	}
	
	private void dashPBuilder()
	{
		dashPane.setBackground(forColor);
		adminProfile.setPreferredSize(new Dimension(130, 130));
		adminProfile.setHorizontalAlignment(JLabel.CENTER);
		adminName.setHorizontalAlignment(JLabel.CENTER);
		adminRole.setHorizontalAlignment(JLabel.CENTER);
		adminName.setFont(standard);
		adminRole.setFont(standard);
		adminName.setToolTipText(Message.USERNAME_TAG);
		adminRole.setToolTipText(Message.USERROLE_TAG);
		
		adminName.setPreferredSize(new Dimension(DASH_WIDTH - 10, 30));
		adminRole.setPreferredSize(new Dimension(DASH_WIDTH - 10, 30));
		adminName.setForeground(Color.WHITE);
		adminRole.setForeground(Color.WHITE);
		adminName.addMouseListener(new AdminLabelMouseAdapter());
		adminRole.addMouseListener(new AdminLabelMouseAdapter());
		adminProfile.setBorder(UnderlineBorder.createUnderlineBorder(Color.WHITE,1));
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 1, 5, 1);
		dashPane.add(adminProfile, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 1, 5, 1);
		dashPane.add(adminName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 1, 5, 1);
		dashPane.add(adminRole, gbc);
	}
	
	private void optPBuilder()
	{
		optPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, forColor));
		optPane.setBackground(forColor);
		enregBut.setPreferredSize(new Dimension(DASH_WIDTH - 15, 50));
		inscrBut.setPreferredSize(new Dimension(DASH_WIDTH - 15, 50));
		listBut.setPreferredSize(new Dimension(DASH_WIDTH - 15, 50));
		optBut.setPreferredSize(new Dimension(DASH_WIDTH - 15, 50));
		reportBut.setPreferredSize(new Dimension(DASH_WIDTH - 15, 50));
		
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.anchor = GridBagConstraints.CENTER;
		gbc2.insets = new Insets(1, 1, 4, 1);
		optPane.add(enregBut, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 2;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.anchor = GridBagConstraints.CENTER;
		gbc2.insets = new Insets(4, 1, 4, 1);
		optPane.add(inscrBut, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 3;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.anchor = GridBagConstraints.CENTER;
		gbc2.insets = new Insets(4, 1, 4, 1);
		optPane.add(listBut, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 4;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.anchor = GridBagConstraints.CENTER;
		gbc2.insets = new Insets(4, 1, 4, 1);
		optPane.add(reportBut, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 5;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.anchor = GridBagConstraints.CENTER;
		gbc2.insets = new Insets(4, 1, 16, 1);
		optPane.add(optBut, gbc2);
	}
	
	private void butPBuilder() 
	{
		butPane.setBackground(forColor);
		logoutBut.setBackground(OgineColor.RED);
		logoutBut.addMouseListener(new DashLogoutMouseAdapter());
		logoutBut.setPreferredSize(new Dimension(DASH_WIDTH - 15, 50));
		gbc3.gridx = 1;
		gbc3.gridy = 1;
		gbc3.fill = GridBagConstraints.HORIZONTAL;
		gbc3.anchor = GridBagConstraints.CENTER;
		gbc3.insets = new Insets(1, 1, 4, 1);
		butPane.add(logoutBut, gbc3);
	}
}
