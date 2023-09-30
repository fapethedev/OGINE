package com.fapethedev.ogine.view.component.listeners;

import java.awt.Color;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.fapethedev.ogine.view.component.field.OTextField;
import com.fapethedev.ogine.controller.FieldController;
import com.fapethedev.ogine.utilities.Colors;

public class NumberCaretListener implements CaretListener
{
	public NumberCaretListener() {}

	@Override
	public void caretUpdate(CaretEvent e)
	{
		if(e.getSource() instanceof OTextField field)
		{
			if(field.isFocusOwner())
			{
				if(field.getText().length() != 12)
				{
					field.setForeground(Color.RED);
				}
				if(field.getText().length() == 12 )
				{
					if(FieldController.isPhoneNumber(field.getText()))
					{
						
						field.setForeground(Colors.DARK_GREEN);
						field.repaint();
						field.revalidate();
					}
				}
			}
			
			else
			{
				if(!field.getText().isEmpty())
				{
					field.setForeground(Color.BLACK);
				}
				if(field.getText().isEmpty())
				{
					field.setForeground(Color.LIGHT_GRAY);
				}
			}
		}
	}
}
