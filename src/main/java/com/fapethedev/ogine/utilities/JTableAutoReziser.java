package com.fapethedev.ogine.utilities;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class JTableAutoReziser 
{
	public static synchronized void fitToData(JTable table)
	{	
		for(int i = 0 ;  i < table.getColumnCount() ; i++ )
		{
			var column = table.getColumn(table.getColumnName(i));
			var width = JTableAutoReziser.columnHeaderWidth(table, column) + 6;
			column.setMinWidth(width);
			column.setMaxWidth(width);
		}
		return;
	}
	
	private static int columnHeaderWidth(JTable table, TableColumn tableColumn)
	{
		TableCellRenderer cellRenderer = table.getTableHeader().getDefaultRenderer();
		Component compo = cellRenderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, 0);
		return compo.getPreferredSize().width;
	}
} 
