package com.fapethedev.ogine.view.component.listeners.adapter;

import com.fapethedev.ogine.view.launch.LauncherPage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LauncherWindowAdapter extends WindowAdapter {
    @Override
    public void windowGainedFocus(WindowEvent e)
    {
        if (e.getSource() instanceof LauncherPage page) {
            page.requestFocusInWindow();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        super.windowOpened(e);
        if (e.getSource() instanceof LauncherPage page) {
            page.getVideoBackground().getPlayer().overlay().set(page.getVideoOverlay());
            page.getVideoBackground().getPlayer().overlay().enable(true);
            page.getVideoBackground().play("videos/vid001.mov");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        if (e.getSource() instanceof LauncherPage page) {
            page.getVideoBackground().stop();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
        super.windowIconified(e);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        super.windowDeactivated(e);
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        super.windowStateChanged(e);
    }
}
