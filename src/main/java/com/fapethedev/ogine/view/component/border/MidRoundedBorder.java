package com.fapethedev.ogine.view.component.border;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class MidRoundedBorder extends AbstractBorder {
    private final int arc;

    public MidRoundedBorder(int arc) {
        this.arc = arc;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g.translate(x, y);
        g2.setColor(c.getForeground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessine un rectangle arrondi avec des coins arrondis
        RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, 1);
        g2.draw(roundRectangle);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(1, 1, 1, 1);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.top = insets.bottom = 1;
        return insets;
    }
}
