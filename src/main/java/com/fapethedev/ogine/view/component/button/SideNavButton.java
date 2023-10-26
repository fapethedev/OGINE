package com.fapethedev.ogine.view.component.button;

import java.awt.Color;
import java.awt.Graphics;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.listeners.adapter.SideNavButtonMouseAdapter;

public class SideNavButton extends OButton
{

	public SideNavButton(String text)
	{
		super(text, new SideNavButtonMouseAdapter());
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setBorderColor(Color.BLACK);
		this.setFocusPainted(true);
	}
}
