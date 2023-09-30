package com.fapethedev.ogine.view.component.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.background.Background;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.component.button.OButton;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class OMessageDialog extends JDialog
{
	// option
    public static final int YES_NO_OPTION = 0;
    public static final int OK_CANCEL_OPTION = 1;
    //
    public static final int YES_OPTION = 0;
    public static final int OK_OPTION = YES_OPTION;
    public static final int NO_OPTION = 1;
    public static final int CANCEL_OPTION = 2;
    
    // type
    public static final int  ERROR_MESSAGE = 0;
    public static final int  INFORMATION_MESSAGE = 1;
    public static final int  CONFIRM_MESSAGE = 2;
    public static final int  WARNING_MESSAGE = 3;
    public static final int  QUESTION_MESSAGE = 4;
	// field
	public static int type;
	public static int option;
	// button
	private OButton yesOkButton;
	private OButton noCancelButton;
	
	private OMessageDialog(JFrame owner, String title, String message, int type, int option)
	{
		super(owner, title, true);
		this.setTitle(title.toUpperCase());
		this.setSize(400, 200);
		this.setLocationRelativeTo(owner);
		this.setResizable(false);
		this.setType(Type.POPUP);
		yesOkButton = new OButton();
		noCancelButton = new OButton();
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel westPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 25, 25));
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel iconLabel = new JLabel(imageFromType(type));
		Message messageInformation = new Message(message);
		Box b1 = Box.createHorizontalBox();
		Background background = new Background();
		JPanel framePanel = new JPanel(new BorderLayout());
		background.setImage(new ImageIcon(getClass().getResource("/blank.jpg")));
		background.setBlurPanel(framePanel);
		buttonTextFromOption(option);
		custumButtomUI();
		b1.add(westPanel);
		mainPanel.add(b1, BorderLayout.WEST);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		westPanel.add(iconLabel);
		westPanel.add(messageInformation);
		southPanel.add(btnPanel);
		btnPanel.add(noCancelButton);
		btnPanel.add(yesOkButton);
		framePanel.add(mainPanel, BorderLayout.CENTER);
		this.getContentPane().add(background);
		this.setVisible(true);
		this.repaint();
		this.revalidate();
	}
	
	public static int showMessageDialog(JFrame owner, String title, String message, int type, int option) 
	{
		new OMessageDialog(owner,  title,  message,  type,  option);
		return option;
	}
	
	public void buttonTextFromOption(int option)
	{
		switch(option) 
		{
			case YES_NO_OPTION:
				yesOkButton.setText("OUI");
				noCancelButton.setText("NON");
				break;
			
			case OK_CANCEL_OPTION:
				yesOkButton.setText("CONFIRMER");
				noCancelButton.setText("ANNULER");
				break;
				
			default:
				throw new IllegalArgumentException("L'option specifier n'existe pas " + option);
		}
	}
	
	private void custumButtomUI()
	{
		yesOkButton.setBackground(Colors.DARK_GREEN);
		noCancelButton.setBackground(Colors.DARK_RED);
		yesOkButton.setBorderColor(Colors.DARK_GREEN);
		noCancelButton.setBorderColor(Colors.DARK_RED);
		yesOkButton.setForeground(Color.WHITE);
		noCancelButton.setForeground(Color.WHITE);
		
		
	}
	
	public void choiceFromSelectedButton(JButton ... button)
	{
		for(JButton jButton : button)
		{
			jButton.addActionListener(e ->{
				if(e.getSource() == yesOkButton)
				{
					if(yesOkButton.getText().compareTo("OUI") == 0)
					{
						
					}
				}
			});
		}
	}
	
	public ImageIcon imageFromType(int type)
	{
		return switch(type) 
		{ 
			case 
				ERROR_MESSAGE -> Iconifier.errorIcon;
			case 
				INFORMATION_MESSAGE -> Iconifier.infoIcon;
			case 
				CONFIRM_MESSAGE -> Iconifier.confirmIcon;
			case 
				WARNING_MESSAGE -> Iconifier.warningIcon;
			case
				QUESTION_MESSAGE -> Iconifier.questionIcon;
			default 
				-> throw new IllegalArgumentException("Ce type de Message n'existe pas: " + type);
		};
	}
}