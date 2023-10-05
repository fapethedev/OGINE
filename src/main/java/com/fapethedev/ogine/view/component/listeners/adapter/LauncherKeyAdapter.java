package com.fapethedev.ogine.view.component.listeners.adapter;

import com.fapethedev.ogine.controller.launcher.LauncherQuitController;
import com.fapethedev.ogine.view.launch.LauncherPage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LauncherKeyAdapter extends KeyAdapter {
    @Override
			public void keyPressed(KeyEvent e)
			{
				super.keyPressed(e);
				if(e.getKeyCode() == (KeyEvent.VK_F4) && e.getSource() instanceof LauncherPage page)
				{
					LauncherQuitController.quit(page);
				}
			}
}
