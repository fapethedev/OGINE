package com.fapethedev.ogine.view.launch;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.fapethedev.ogine.controller.launcher.LauncherLoginController;
import com.fapethedev.ogine.controller.launcher.LauncherQuitController;
import com.fapethedev.ogine.controller.launcher.LauncherResetController;
import com.fapethedev.ogine.controller.launcher.LauncherShowController;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.utilities.SwingUtils;
import com.fapethedev.ogine.view.component.background.LauncherBackground;
import com.fapethedev.ogine.view.component.border.UnderlineBorder;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.component.listeners.ExitButtonMouseAdapter;
import com.fapethedev.ogine.view.component.listeners.PwFieldFocusListener;
import com.fapethedev.ogine.view.component.listeners.ShowKeyListener;
import com.fapethedev.ogine.view.component.listeners.TextFieldFocusListener;
import com.fapethedev.ogine.view.component.panel.OPanel;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class LauncherPage extends JFrame
{
	private static LauncherPage singleton;

	private final int WIDTH  = SwingUtils.getMainWidth();
	private final int HEIGTH = SwingUtils.getHeight();
	
	private OPanel mainPane;
	private JPanel fieldPane1;
	private JPanel fieldPane2;
	private JPanel butPane;
	private OPanel guestPane;
	
	private GridBagConstraints gbc;
	
	private LauncherBackground background;
	
	private BufferedImage appImage;
	
	private Font police;
	private Font paneTitleFont;
	
	private JLabel pageTitle;
	private JLabel userProfileLabel;
	private JLabel userIDLabel;
	private JLabel userPasswordLabel;
	private JLabel guestNameLabel;
	private JLabel guestProfileLabel;
	
	private JTextField userIDField;
	private JPasswordField userPasswordField;
	
	private static JButton loginButton;
	private static JButton resetButton;
	private static JButton showButton;
	private JButton guestLoginButton;
	private JButton exitButton;

	private LauncherPage(boolean splashEnable)
	{
		super();
		this.setUndecorated(true);
		this.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				super.keyPressed(e);
				if(e.getKeyCode() == (KeyEvent.VK_F4))
				{
					LauncherQuitController.quit(LauncherPage.this);
				}
			}
		});
		this.addWindowFocusListener(new WindowAdapter()
		{
			@Override
			public void windowGainedFocus(WindowEvent e) 
			{
				LauncherPage.this.requestFocusInWindow();
			}
		});
		
		if(splashEnable)
		{	
			new SplashScreen(this).begin();
//			Path path = Path.of("C:\\Users\\hp\\eclipse-workspace\\OGINE\\src\\main\\java\\com\\ogine");
//			try(FileInputStream fis = new FileInputStream(path.toFile()))
//			{
//				SplashScreenInputStream stream = new SplashScreenInputStream(LauncherPage.this, fis);
////				stream.close();
//			}
//			catch (IOException excp)
//			{
//				System.out.println(excp.getMessage()+" "+excp.getCause());
//			}
		}
		SwingUtils.centerFrame(this);
		initComponent();
		buildPane();
		buildContentPane();
		configContentPane();
	}
	
	public static synchronized LauncherPage getInstance(boolean splashEnable)
	{
		if(singleton == null)
		{
			singleton = new LauncherPage(splashEnable);
		}
		
		return singleton;
	}

	private void initComponent()
	{
		try 
		{
			appImage = ImageIO.read(new File(getClass().getResource("/icon.png").toURI()));
		} 
		catch(IOException | URISyntaxException e) 
		{
			System.out.println(e.getMessage());
		} 
		
		mainPane = new OPanel(10);
		fieldPane1 = new JPanel();
		fieldPane2 = new JPanel();
		butPane = new JPanel();
		guestPane = new OPanel(25);
		
		gbc = new GridBagConstraints();
		
		background = new LauncherBackground();
		
		pageTitle = new JLabel(Message.CON_TITLE_MSG);
	
		userProfileLabel = new JLabel(Iconifier.userProfileIcon);
		userIDLabel = new JLabel(Iconifier.userFieldIcon);
		userPasswordLabel = new JLabel(Iconifier.passwordLabelIcon);
		guestProfileLabel = new JLabel(Iconifier.userProfileIcon64);
		guestNameLabel = new JLabel("Invité".toUpperCase());
		
		police = new Font("Arial", Font.BOLD, 14);
		paneTitleFont = new Font("Arial", Font.BOLD, 12);
				
		userIDField = new JTextField(2);
		userPasswordField = new JPasswordField(2);
		
		loginButton = new JButton("Connexion", Iconifier.loginIcon);
		guestLoginButton = new JButton("Se Connecter en tant qu'invité".toUpperCase(), Iconifier.loginIcon);
		resetButton = new JButton("Reset", Iconifier.resetIcon);
		showButton = new JButton(Iconifier.showIcon);
		exitButton = new JButton(Iconifier.exitIcon);
	}
	
	private void buildContentPane()
	{
		this.setTitle("STRyG");
		this.setSize(new Dimension(WIDTH, HEIGTH));
		this.setPreferredSize(new Dimension(WIDTH, HEIGTH));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setAlwaysOnTop(false);
		this.setIconImage(appImage);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1, 10, 10));
		this.setContentPane(background);
		this.getContentPane().add(mainPane);
		JPanel bp = new JPanel();
		bp.setLocation((WIDTH / 2) - 240, 20);
		bp.setSize(new Dimension(500, 600));
		background.setBlurPanel(bp);
		mainPane.add(fieldPane1);
		mainPane.add(fieldPane2);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(1, 1, 1, 1);
		fieldPane1.add(userIDLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(1, 1, 1, 1);
		fieldPane1.add(userIDField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(1, 1, 1, 1);
		fieldPane2.add(userPasswordLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(1, 1, 1, 1);
		fieldPane2.add(userPasswordField, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(1, 1, 1, 1);
		fieldPane2.add(showButton, gbc);
		
		butPane.add(loginButton);
		butPane.add(resetButton);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(1, 1, 1, 1);
		guestPane.add(guestProfileLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(1, 1, 1, 1);
		guestPane.add(guestNameLabel, gbc);
		
		this.getContentPane().add(pageTitle);
		this.getContentPane().add(userProfileLabel);
		this.getContentPane().add(butPane);
		this.getContentPane().add(exitButton);
		this.getContentPane().add(guestPane);
		this.getContentPane().add(guestLoginButton);
		this.getContentPane().setBackground(Color.getHSBColor(83.7f, 83.7f, 83.7f));
	}
	
	private void buildPane()
	{
		mainPane.setLayout(new GridLayout(2, 1, 3, 3));
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorderColor(Color.WHITE);
		mainPane.setSize(new Dimension(400, 200));
		mainPane.setLocation(new Point((WIDTH / 2) - 190, (HEIGTH / 2) - 10));
		
		fieldPane1.setLayout(new GridBagLayout());
		fieldPane1.setBackground(Color.WHITE);
		fieldPane1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(
						Color.BLACK,
						2,
						true),
				Message.USERNAME_TITLE,
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				paneTitleFont,
				Color.BLACK));
		
		fieldPane2.setLayout(new GridBagLayout());
		fieldPane2.setBackground(Color.WHITE);
		fieldPane2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(
						Color.BLACK,
						2,
						true),
				Message.PASSWORD_TITLE,
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				paneTitleFont,
				Color.BLACK));
		
		butPane.setSize(new Dimension(400, 35));
		butPane.setLocation(new Point((WIDTH / 2) - 190, (HEIGTH / 2) + 190));
		butPane.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		butPane.setBackground(new Color(0, true));
		butPane.setOpaque(false);
		
		guestPane.setSize(new Dimension(256, 68));
		guestPane.setLocation(new Point(16, HEIGTH - 80));
		guestPane.setLayout(new GridBagLayout());
		guestPane.setBorderColor(new Color(0, true));
		guestPaneListening();
	}

	private void configContentPane()
	{
		pageTitle.setBounds((WIDTH / 2) - 160, (HEIGTH / 24) , 325, 45);
		pageTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.LIGHT_GRAY, 4));
		pageTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
		
		userProfileLabel.setBounds((WIDTH / 2) - 128, (HEIGTH / 4) - 96 , 256, 256);
		userProfileLabel.setBorder(UnderlineBorder.createUnderlineBorder(Color.LIGHT_GRAY, 4));
				
		userIDLabel.setPreferredSize(new Dimension(32, 32));
		userPasswordLabel.setPreferredSize(new Dimension(32, 32));
		
		guestNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		guestNameLabel.setForeground(Color.WHITE);
		
		userIDField.setPreferredSize(new Dimension(250, 25));
		userIDField.setToolTipText(Message.USERNAME_TAG);
		userIDField.setText(Message.USERNAME_TAG);
		userIDField.setFont(police);
		userIDField.setBorder(BorderFactory.createSoftBevelBorder(EtchedBorder.RAISED, Color.WHITE, Color.BLACK));
		userIDField.addFocusListener(new TextFieldFocusListener(fieldPane1));
		Placeholder.addPlaceholderStyle(userIDField);
		Placeholder.userFGetPlaceholder(userIDField);
		
		userPasswordField.setPreferredSize(new Dimension(250, 25));
		userPasswordField.setToolTipText(Message.PASSWORD_TAG);
		userPasswordField.setText(Message.PASSWORD_TAG);
		userPasswordField.setEchoChar((char)0);
		userPasswordField.setFont(police);
		userPasswordField.setBorder(BorderFactory.createSoftBevelBorder(EtchedBorder.RAISED, Color.WHITE, Color.BLACK));
		userPasswordField.addKeyListener(new ShowKeyListener());
		userPasswordField.addFocusListener(new PwFieldFocusListener(fieldPane2));
		Placeholder.addPlaceholderStyle(userPasswordField);
		Placeholder.passFGetPlaceholder(userPasswordField);
		
		showButton.setPreferredSize(new Dimension(24, 24));
		showButton.setContentAreaFilled(false);
		showButton.setBorderPainted(true);
		showButton.setToolTipText(Message.SHOW_TAG);
		showButton.setFocusable(true);
		showButton.setVisible(false);
		showButton.setFocusPainted(true);
		showButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getShowButton().addActionListener(this::onShowClick);
		
		loginButton.setPreferredSize(new Dimension(180, 30));
		loginButton.setToolTipText(Message.LOGIN_TAG);
		loginButton.setFocusable(true);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setFont(loginButton.getFont().deriveFont(Font.BOLD));
		getLoginButton().addActionListener(this::onLoginClick);
		
		guestLoginButton.setSize(new Dimension(256, 32));
		guestLoginButton.setVisible(false);
		guestLoginButton.setToolTipText(Message.LOGIN_TAG);
		guestLoginButton.setFocusable(true);
		guestLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		guestLoginButton.setFont(guestLoginButton.getFont().deriveFont(Font.BOLD));
		guestLoginButton.setLocation(new Point((WIDTH / 2) - 125, (HEIGTH / 2) + 80));
		guestLoginButton.addActionListener(this::onGuestLoginClick);
		guestLoginButtonListening();
		
		resetButton.setPreferredSize(new Dimension(100, 30));
		resetButton.setToolTipText(Message.CANCEL_TAG);
		resetButton.setFocusable(true);
		resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetButton.setFont(resetButton.getFont().deriveFont(Font.BOLD));
		getResetButton().addActionListener(this::onResetClick);
		
		exitButton.setBounds(WIDTH - 68, HEIGTH - 68, 64, 64);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(true);
		exitButton.setToolTipText(Message.EXIT_TAG);
		exitButton.setFocusable(true);
		exitButton.setFocusPainted(true);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getExitButton().addActionListener(this::onExitClick);
		getExitButton().addMouseListener(new ExitButtonMouseAdapter());
	}
	
	private void guestPaneListening() 
	{
		guestPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				guestPane.setBackground(Color.WHITE);
				guestPane.setBorderColor(Color.WHITE);
				guestNameLabel.setForeground(Colors.getInstance().BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				guestPane.setBackground(new Color(0, true));
				guestPane.setBorderColor(new Color(0, true));
				guestNameLabel.setForeground(Color.WHITE);
			}
			
		});
		guestPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				guestPane.setBackground(Color.LIGHT_GRAY);
				guestPane.setBorderColor(Color.LIGHT_GRAY);
				guestNameLabel.setForeground(Colors.getInstance().DARK_BLUE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if( (e.getY() > 0 && e.getY() < ((JPanel)e.getSource()).getHeight()) 
						&& (e.getX() > 0 && e.getX() < ((JPanel)e.getSource()).getWidth()) )
				{
					guestPane.setBackground(Color.WHITE);
					guestPane.setBorderColor(Color.WHITE);
					guestNameLabel.setForeground(Colors.getInstance().BLUE);
				}
				else 
				{
					guestPane.setBackground(new Color(0, true));
					guestPane.setBorderColor(new Color(0, true));
					guestNameLabel.setForeground(Color.WHITE);
				}
			}
			
		});
		guestPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				guestLoginButton.setVisible(!guestLoginButton.isVisible());
			}
		});
	}
	
	private void guestLoginButtonListening()
	{
		guestLoginButton.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent e) {
				super.componentShown(e);
				guestNameLabel.setText("Utilisateur".toUpperCase());
				mainPane.setVisible(false);
				butPane.setVisible(false);
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				super.componentHidden(e);
				guestNameLabel.setText("Invité".toUpperCase());
				mainPane.setVisible(true);
				butPane.setVisible(true);
			}
			
		});
	}
	
	private void onShowClick(ActionEvent e)
	{
		LauncherShowController.show(this);
	}

	private void onLoginClick(ActionEvent e)
	{
		LauncherLoginController.login(this);
	}
	
	private void onResetClick(ActionEvent e)
	{
		LauncherResetController.reset(this);
	}

	private void onExitClick(ActionEvent e)
	{
		LauncherQuitController.quit(this);
	}
	
	private void onGuestLoginClick(ActionEvent e)
	{
		LauncherLoginController.loginAsGuest(this);
	}
	
	public static JButton getLoginButton() 
	{
		return loginButton;
	}

	public static JButton getResetButton() 
	{
		return resetButton;
	}

	public static JButton getShowButton() 
	{
		return showButton;
	}

	public JButton getExitButton() 
	{
		return exitButton;
	}

	public JTextField getUserIDField() 
	{
		return userIDField;
	}

	public JPasswordField getUserPasswordField() 
	{
		return userPasswordField;
	}
}
