package com.fapethedev.ogine.view.component.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.fapethedev.ogine.utilities.Colors;
import com.lowagie.text.Font;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class BoldTableCellRenderer extends DefaultTableCellRenderer
{
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    /**
     * A border without focus.
     */
    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;
	private Color unselectedForeground;

	public BoldTableCellRenderer()
	{
		super();
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
        setBorder(new EmptyBorder(1, 1, 1, 1));
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, 
			int row, int column)
	{
		if(table == null)
		{
            return this;
        }

        Color fg = null;
        Color bg = null;

        JTable.DropLocation dropLocation = table.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsertRow()
                && !dropLocation.isInsertColumn()
                && dropLocation.getRow() == row
                && dropLocation.getColumn() == column)
        {

            fg = table.getForeground();
            bg = table.getBackground();

            isSelected = true;
        }

        if (isSelected) 
        {
            super.setForeground(fg == null ? table.getSelectionForeground() : fg);
            super.setBackground(bg == null ? table.getSelectionBackground() : bg);
        } 
        else 
        {
            Color background = Color.WHITE;
            if (background == null || background instanceof javax.swing.plaf.UIResource) 
            {
                Color alternateColor = Color.WHITE;
                if (alternateColor != null && row % 2 != 0) 
                {
                    background = alternateColor;
                }
            }
            super.setForeground(unselectedForeground != null ? unselectedForeground : table.getForeground());
            super.setBackground(background);
        }

        setFont(table.getFont().deriveFont(Font.BOLD));

        if(hasFocus)
        {
            Border border = null;
            if(isSelected) 
            {
                border = BorderFactory.createLineBorder(Colors.BELGE, 1);
            }
            if(border == null) 
            {
                border = BorderFactory.createLineBorder(Colors.BELGE, 1);
            }
            setBorder(border);

            if(!isSelected && table.isCellEditable(row, column))
            {
                Color col;
                col = Color.BLACK;
                if(col != null) 
                {
                    super.setForeground(col);
                }
                col = Color.WHITE;
                if(col != null) 
                {
                    super.setBackground(col);
                }
            }
        }
        else
        {
            setBorder(new EmptyBorder(1, 1, 1, 1));
        }

        setValue(value);

        return this;
	}	
}