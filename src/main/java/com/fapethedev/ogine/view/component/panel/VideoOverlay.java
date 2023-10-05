package com.fapethedev.ogine.view.component.panel;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.background.LauncherBackground;

import javax.swing.*;
import java.awt.*;

public class VideoOverlay extends JWindow
{
    private LauncherBackground background;

    public VideoOverlay(JFrame owner) {
        super(owner);
        initVideoOverlay();
    }

    private void initVideoOverlay()
    {
        this.setBackground(new Color(0, 73, 97, 100));
        this.setLayout(new BorderLayout());
        this.background = new LauncherBackground();
        this.add(background);
    }

    public LauncherBackground getContentBackground() {
        return background;
    }
}
