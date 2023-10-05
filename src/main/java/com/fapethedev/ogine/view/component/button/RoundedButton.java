package com.fapethedev.ogine.view.component.button;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.border.RoundedBorder;
import com.fapethedev.ogine.view.component.ui.RoundedButtonUI;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter @Setter
public class RoundedButton extends JButton
{
    private final Colors colors = Colors.getInstance();

    private int arc = 15;

    private RoundedBorder defaultBorder = new RoundedBorder(arc, Color.WHITE);

    private RoundedBorder hoverBorder = new RoundedBorder(arc, colors.GRAY);

    private RoundedBorder pressedBorder = new RoundedBorder(arc, colors.LIGHT_BLUE);

    private Color hoverColor = colors.LIGHT_GRAY;

    private Color pressedBackground = colors.LIGHT_BLUE;

    private Color pressedForeground = colors.BELGE;

    private Color focusColor = colors.DARK_BLUE;

    public RoundedButton(Icon icon) {
        super(icon);
        this.setUI(new RoundedButtonUI(arc));
    }

    public RoundedButton(String text) {
        super(text);
        this.setUI(new RoundedButtonUI(arc));
    }

    public RoundedButton(String text, Icon icon) {
        super(text, icon);
        this.setUI(new RoundedButtonUI(arc));
    }
    
    public RoundedButton(int arc, Icon icon) {
        super(icon);
        this.setUI(new RoundedButtonUI(arc));
    }

    public RoundedButton(int arc, String text) {
        super(text);
        this.setUI(new RoundedButtonUI(arc));
    }

    public RoundedButton(int arc, String text, Icon icon) {
        super(text, icon);
        this.setUI(new RoundedButtonUI(arc));
    }
}
