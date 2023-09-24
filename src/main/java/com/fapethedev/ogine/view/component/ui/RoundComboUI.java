package com.fapethedev.ogine.view.component.ui;

import com.fapethedev.ogine.view.component.field.OTextField;
import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.fapethedev.ogine.utilities.OgineColor;
import com.fapethedev.ogine.view.component.border.RoundedBorder;
import com.fapethedev.ogine.view.component.button.ArrowButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RoundComboUI extends FlatComboBoxUI {

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new RoundComboUI();
    }

    @Override
    public void addEditor() {
        super.addEditor();
    }

    @Override
    protected JButton createArrowButton() {
        return new ArrowButton(
                SwingConstants.SOUTH,
                arrowType,
                Color.LIGHT_GRAY,
                null,
                OgineColor.BLUE,
                Color.WHITE,
                Color.BLACK,
                Color.WHITE);
    }

    @Override
    public void configureArrowButton() {
        super.configureArrowButton();
        if (comboBox.isPopupVisible()) ((ArrowButton)arrowButton).setDirection(SwingConstants.NORTH);
        else ((ArrowButton)arrowButton).setDirection(SwingConstants.SOUTH);
    }

    @Override
    protected void configureEditor() {
        super.configureEditor();

        if (editor instanceof OTextField field){
            field.setDefaultBorderColor(Color.WHITE);
            field.setBorderFocusColor(Color.WHITE);
            field.setPlaceholder(comboBox.getToolTipText());
            field.setToolTipText(comboBox.getToolTipText());
            field.setColumns(editorColumns);
            field.setFont(field.getFont().deriveFont(Font.BOLD));
        }
        else System.out.println("eeeeeeeeee");
    }

    @Override
    protected ComboBoxEditor createEditor() {
        return new RoundedComboBoxEditor();
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new RoundCellRenderer();
    }

    @Override
    protected ComboPopup createPopup(){
        return new RoundedComboPopup(comboBox);
    }

    private static class RoundCellRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            list.setOpaque(false);
            list.setBackground(new Color(0, true));
            list.setFont(list.getFont().deriveFont(Font.BOLD));

            JComponent component = (JComponent) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            component.setBorder(new EmptyBorder(5, 5, 5, 5));
            component.setForeground(isSelected || cellHasFocus ?
                    OgineColor.BLUE :
                    Color.BLACK);
            component.setOpaque(false);

            return component;
        }
    }

    private static class RoundedComboPopup extends BasicComboPopup {

        public RoundedComboPopup(JComboBox<Object> combo) {
            super(combo);
            int arc = 15;
            setBorder(new RoundedBorder(arc));
            list.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int index = list.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        String tooltip = "Group: " + combo.getItemAt(index).toString();
                        list.setToolTipText(tooltip);
                    }
                }
            });
        }


        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroller = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scroller.getViewport().setOpaque(false);
            scroller.setOpaque(false);
            return scroller;
        }
    }

    private static class RoundedScrollBarUI extends BasicScrollBarUI {
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new BasicArrowButton(orientation);
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createDecreaseButton(orientation);
        }
    }

    private static class RoundedComboBoxEditor extends BasicComboBoxEditor {
        private final String placeholder;
        public RoundedComboBoxEditor() {
            this.placeholder = editor.getToolTipText();
        }

        @Override
        protected OTextField createEditorComponent() {
            return new OTextField(placeholder);
        }
    }
}
