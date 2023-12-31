package com.fapethedev.ogine.view.component.listeners.adapter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.button.OButton;

public class NewFormButAdapter extends MouseAdapter 
{
	private Colors colors = Colors.getInstance();
	@Override
	public void mousePressed(MouseEvent e)
	{
		if(e.getSource() instanceof OButton newStudentRegisterFormBut)
		{
			newStudentRegisterFormBut.setFont(newStudentRegisterFormBut.getFont().deriveFont(com.lowagie.text.Font.UNDERLINE));
			newStudentRegisterFormBut.setForeground(colors.BELGE);
			newStudentRegisterFormBut.setBackground(Color.DARK_GRAY);
			newStudentRegisterFormBut.setBorderColor(Color.DARK_GRAY);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(e.getSource() instanceof OButton newStudentRegisterFormBut)
		{
			newStudentRegisterFormBut.setFont(newStudentRegisterFormBut.getFont().deriveFont(Font.BOLD));
			newStudentRegisterFormBut.setBackground(colors.BELGE);
	    	newStudentRegisterFormBut.setForeground(Color.BLACK);
	    	newStudentRegisterFormBut.setBorderColor(Color.BLACK);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		if(e.getSource() instanceof OButton newStudentRegisterFormBut)
		{
			newStudentRegisterFormBut.setBackground(colors.BELGE);
	    	newStudentRegisterFormBut.setForeground(Color.BLACK);
	    	newStudentRegisterFormBut.setBorderColor(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		if(e.getSource() instanceof OButton newStudentRegisterFormBut)
		{
			newStudentRegisterFormBut.setBackground(colors.BELGE);
	    	newStudentRegisterFormBut.setForeground(Color.BLACK);
	    	newStudentRegisterFormBut.setBorderColor(Color.BLACK);
		}
	}
}
