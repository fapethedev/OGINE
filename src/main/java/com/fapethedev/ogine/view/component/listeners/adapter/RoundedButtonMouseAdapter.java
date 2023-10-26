package com.fapethedev.ogine.view.component.listeners.adapter;

import com.fapethedev.ogine.view.component.button.RoundedButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButtonMouseAdapter extends MouseAdapter
{
        @Override
        public void mousePressed(MouseEvent e)
        {
            super.mousePressed(e);
            if (e.getSource() instanceof RoundedButton button)
            {
                if (button.isEnabled())
                {
                    button.setFont(button.getFont().deriveFont(com.lowagie.text.Font.UNDERLINE));
                    button.setForeground(button.getPressedForeground());
                    button.setBackground(button.getPressedBackground());
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
                    button.setBackground(button.getHoverColor());
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
                    button.setBackground(Color.WHITE);
                    button.setBorder(button.getDefaultBorder());
                    button.repaint();
                }
            }
        }

}