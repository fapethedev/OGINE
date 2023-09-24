package com.fapethedev.ogine.view.component.field;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.view.component.border.UnderlineBorder;

public class OJTextField extends JTextField
{

	public OJTextField() {
		super();
		this.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
		Placeholder.addPlaceholderStyle(this);
		Placeholder.defaultFGetPlaceholder(this);
	}

	public OJTextField(String text) 
	{
		super(text);
		this.setText(text);
		this.setToolTipText(text);
		this.setFont(new Font("Arial", Font.BOLD, 14));
		this.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
		Placeholder.addPlaceholderStyle(this);
		Placeholder.defaultFGetPlaceholder(this);
	}
	
	public void setBorderColor(Color c)
	{
		this.setBorder(UnderlineBorder.createUnderlineBorder(c));
	}
	
	public void setBorderColor(Color c, int thickness)
	{
		this.setBorder(UnderlineBorder.createUnderlineBorder(c, thickness));
	}
}
