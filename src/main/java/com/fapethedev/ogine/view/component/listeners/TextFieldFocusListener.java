package com.fapethedev.ogine.view.component.listeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.border.UnderlineBorder;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class TextFieldFocusListener implements FocusListener 
{
	private JPanel panel;

	public TextFieldFocusListener() {
	}
	
	public TextFieldFocusListener(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() instanceof JTextField)
		{
			JTextField field = (JTextField)e.getSource();
			
			field.setBorder(UnderlineBorder.createUnderlineBorder(Colors.BLUE, 2));
			
			panel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(
							Colors.DARK_BLUE,
							2,
							true),
					Message.USERNAME_TITLE,
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION,
					new Font("Arial", Font.BOLD, 12),
					Colors.BLUE));
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() instanceof JTextField)
		{
			JTextField field = (JTextField)e.getSource();
			
			field.setBorder(BorderFactory.createSoftBevelBorder(EtchedBorder.RAISED, Color.WHITE, Color.BLACK));
			
			panel.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(
							Color.BLACK,
							2,
							true),
					Message.USERNAME_TITLE,
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION,
					new Font("Arial", Font.BOLD, 12),
					Color.BLACK));
		}
		
	}

}
