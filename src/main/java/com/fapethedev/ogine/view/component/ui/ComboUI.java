package com.fapethedev.ogine.view.component.ui;

import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.fapethedev.ogine.view.component.button.ArrowButton;

import javax.swing.*;
import java.awt.*;

public class ComboUI extends FlatComboBoxUI {

    @Override
    protected JButton createArrowButton() {
        return new ArrowButton(
                SwingConstants.SOUTH,
                arrowType,
                Color.BLACK,
                null,
                Color.BLACK,
                Color.LIGHT_GRAY,
                Color.WHITE,
                Color.LIGHT_GRAY);
    }
}
