package com.fapethedev.ogine.view.component.listeners.adapter;

import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.button.RoundedButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButtonMouseAdapter extends MouseAdapter
{
    private final Colors colors = Colors.getInstance();

        @Override
        public void mousePressed(MouseEvent e)
        {
            super.mousePressed(e);
            if (e.getSource() instanceof RoundedButton button)
            {
                if (button.isEnabled())
                {
                    button.setFont(button.getFont().deriveFont(com.lowagie.text.Font.UNDERLINE));
                    button.setForeground(Color.WHITE);
                    button.setBackground(colors.LIGHT_BLUE);
                    button.setBorder(button.getPressedBorder());
                    button.repaint();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            super.mouseReleased(e);
            if (e.getSource() instanceof RoundedButton button)
            {
                if (button.isEnabled())
                {
                    button.setFont(button.getFont().deriveFont(java.awt.Font.BOLD));
                    button.setForeground(Color.BLACK);
                    button.setBorder(button.getDefaultBorder());
                    button.setBackground(Color.WHITE);
                    button.repaint();
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            super.mouseEntered(e);
            if (e.getSource() instanceof RoundedButton button)
            {
                if (button.isEnabled())
                {
                    button.setForeground(Color.BLACK);
                    button.setBackground(colors.GRAY);
                    button.setBorder(button.getHoverBorder());
                    button.repaint();
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            super.mouseExited(e);
            if (e.getSource() instanceof RoundedButton button)
            {
                if (button.isEnabled())
                {
                    button.setForeground(Color.BLACK);
                    button.setBorder(button.getDefaultBorder());
                    button.setBackground(Color.WHITE);
                    button.repaint();
                }
            }
        }

}