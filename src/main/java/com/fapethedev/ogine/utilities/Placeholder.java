package com.fapethedev.ogine.utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.fapethedev.ogine.view.component.field.OTextField;
import com.fapethedev.ogine.view.component.label.Message;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public final class Placeholder 
{
	public static void addPlaceholderStyle(JTextField text)
	{
		Font holderFont = text.getFont();
		holderFont = holderFont.deriveFont(Font.ITALIC);
		text.setFont(holderFont);
		text.setForeground(Color.GRAY);
	}

	public static void removePlaceholderStyle(JTextField text)
	{
		Font holderFont = text.getFont();
		holderFont = holderFont.deriveFont(Font.PLAIN | Font.BOLD);
		text.setFont(holderFont);
		text.setForeground(Color.BLACK);
	}
	
	public static void removePlaceholderStyle(OTextField text)
	{
		Font holderFont = text.getFont();
		holderFont = holderFont.deriveFont(Font.PLAIN | Font.BOLD);
		text.setFont(holderFont);
		text.setForeground(Color.BLACK);
	}
	
	public static void redPlaceholderStyle(JTextField text)
	{
		Font holderFont = text.getFont();
		holderFont = holderFont.deriveFont(Font.BOLD);
		text.setFont(holderFont);
		text.setForeground(Color.RED);
		
		if(text.getClass() == JPasswordField.class)
		{
			var jpField = (JPasswordField)text;
			jpField.setEchoChar((char)0);
			
			text.setText(Message.PASSWORD_ERROR_MSG);
		}
		if(text.getClass() == JTextField.class)
		{
			text.setText(Message.USERNAME_ERROR_MSG);
		}
	}
	
	public static void defaultRedPlaceholderStyle(JTextField text)
	{
		Font holderFont = text.getFont();
		holderFont = holderFont.deriveFont(Font.BOLD);
		text.setFont(holderFont);
		text.setForeground(Color.RED);
		text.setText(Message.EMPTY_FIELD_MSG);
	}
	
	public static void defaultRedPlaceholderStyle(OTextField text)
	{
		Font holderFont = text.getFont();
		holderFont = holderFont.deriveFont(Font.BOLD);
		text.setFont(holderFont);
		text.setForeground(Color.RED);
		text.setText(Message.EMPTY_FIELD_MSG);
	}
	
	public static void passFGetPlaceholder(JPasswordField text)
	{
		text.addFocusListener(new FocusListener() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(new String(text.getPassword()).length() == 0)
				{
					addPlaceholderStyle(text);
					text.setText(text.getToolTipText());
					text.setEchoChar((char)0);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e)
			{
				if(new String(text.getPassword()).equals(text.getToolTipText()) 
						|| new String(text.getPassword()).equals(Message.PASSWORD_ERROR_MSG))
				{
					text.setText(null);
					text.requestFocus();
					text.setEchoChar('¤');
					removePlaceholderStyle(text);
				}
			}
		});
		
	}
	
	public static void userFGetPlaceholder(JTextField text)
	{
		text.addFocusListener(new FocusListener() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(text.getText().length() == 0)
				{
					addPlaceholderStyle(text);
					text.setText(text.getToolTipText());
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(text.getText().equals(text.getToolTipText())
						|| text.getText().equals(Message.USERNAME_ERROR_MSG))
				{
					text.setText(null);
					text.requestFocus();
					removePlaceholderStyle(text);
				}
			}
		});
	}
	
	public static void defaultFGetPlaceholder(JTextField text)
	{
		text.addFocusListener(new FocusListener() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(text.getText().length() == 0)
				{
					addPlaceholderStyle(text);
					text.setText(text.getToolTipText());
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(text.getText().equals(text.getToolTipText())
						|| text.getText().equals(Message.EMPTY_FIELD_MSG))
				{
					text.setText(null);
					text.requestFocus();
					removePlaceholderStyle(text);
				}
			}
		});
	}
}
