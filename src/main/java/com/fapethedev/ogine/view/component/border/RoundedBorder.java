package com.fapethedev.ogine.view.component.border;

import com.fapethedev.ogine.utilities.Colors;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class RoundedBorder extends AbstractBorder {
    private int arc = 15;
    private Color borderColor = Color.BLACK;
    private Color borderBackground = new Color(0, 0, 0, 0);

    public RoundedBorder() {
    }

    public RoundedBorder(int arc) {
        this.arc = arc;
    }

    public RoundedBorder(Color borderColor) {
        this.borderColor = borderColor;
    }

    public RoundedBorder(int arc, Color borderColor) {
        this.arc = arc;
        this.borderColor = borderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g.translate(x, y);
        g2.setColor(borderBackground);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessine un rectangle arrondi avec des coins arrondis
        RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(x, y, width, height, arc, arc);
        g2.fill(roundRectangle);
        roundRectangle = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc);
        g2.setColor(c instanceof JComboBox<?> box ?
                box.getEditor().getEditorComponent().hasFocus() ?
                        Colors.getInstance().BLUE :
                        borderColor == null ? Color.BLACK :
                                borderColor :
                borderColor == null ? Color.BLACK :
                                borderColor
        );
        g2.draw(roundRectangle);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(1, 1, 1, 6);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.top = insets.bottom = 1;
        return insets;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorderBackground(Color borderBackground) {
        this.borderBackground = borderBackground;
    }
}
