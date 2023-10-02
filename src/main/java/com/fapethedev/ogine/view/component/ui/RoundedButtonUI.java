package com.fapethedev.ogine.view.component.ui;

import com.fapethedev.ogine.view.component.border.RoundedBorder;
import com.fapethedev.ogine.view.component.button.RoundedButton;
import com.fapethedev.ogine.view.component.listeners.RoundedButtonMouseAdapter;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseListener;

public class RoundedButtonUI extends BasicButtonUI
{
    private final int arc;

    private final boolean hover = false;

    private final RoundedBorder border;

    private final MouseListener mouseListener;

    public RoundedButtonUI(int arc)
    {
        this.arc = arc;
        border = new RoundedBorder(arc);
        mouseListener = new RoundedButtonMouseAdapter();
    }

    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setOpaque(false);
        b.setBorder(border);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        RoundedButton button = (RoundedButton) c;
        ButtonModel model = button.getModel();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = button.getWidth();
        int height = button.getHeight();

        if (hover)
        {
            g2.setColor(button.getHoverColor());
        }
        else
        {
            g2.setColor(button.getBackground());
        }
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        if (button.isEnabled() && model.isPressed()){
            paintButtonPressed(g2, button);
        }

        if (!button.hasFocus()){
            border.setBorderColor(Color.BLACK);
            button.setFont(button.getFont().deriveFont(Font.BOLD));
        }

        super.paint(g2, button);
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b)
    {
        Graphics2D g2 = (Graphics2D) g;
        RoundedButton button = (RoundedButton) b;

        if (b.isEnabled()) {
            g2.setColor(button.getPressedBackground());
            g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), arc, arc);
            b.setBackground(button.getPressedBackground());
            b.setForeground(button.getPressedForeground());
        }
        super.paintButtonPressed(g, b);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect)
    {
        Graphics2D g2 = (Graphics2D) g;
        RoundedButton button = (RoundedButton) b;
        if (b.isEnabled()) {
            g2.setColor(button.getFocusColor());
            border.setBorderColor(button.getFocusColor());
            b.setFont(b.getFont().deriveFont(Font.PLAIN));
        }
        super.paintFocus(g2, b, viewRect, textRect, iconRect);
    }

    @Override
    public void installListeners(AbstractButton b) {
        super.installListeners(b);
        b.addMouseListener(mouseListener);
    }

    @Override
    protected void uninstallListeners(AbstractButton b) {
        super.uninstallListeners(b);
        b.removeMouseListener(mouseListener);
    }

}
