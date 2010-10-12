/*
 * $Id: JTableAutoModel.java 4113 2009-12-01 11:08:59Z blowagie $
 *
 * Copyright 2007 Bruno Lowagie.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.itextpdf.rups.view.models;

import javax.swing.table.AbstractTableModel;

/**
 * A reusable TableModel class for tables that implement the
 * JTableAutoModelInterface.
 */
public class JTableAutoModel extends AbstractTableModel {
	
	/** The serial version uid. */
	private static final long serialVersionUID = -2229431581745521537L;
	/** The table that knows how to model itself. */
	protected JTableAutoModelInterface table;

	/**
	 * Constructs an auto model for a JTable.
	 * @param	table	a JTable that knows information about its model.
	 */
	public JTableAutoModel(JTableAutoModelInterface table) {
		this.table = table;
	}
	
    /**
     * @see javax.swing.table.TableModel#getColumnCount()
     * @return int the number of columns
     */
    public int getColumnCount() {
		return table.getColumnCount();
	}

    /**
     * @see javax.swing.table.TableModel#getRowCount()
     * @return int the number of rows
     */
    public int getRowCount() {
		return table.getRowCount();
	}

	/**
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 * @param columnIndex a column number.
	 * @return the name of the column
	 */
	public String getColumnName(int columnIndex) {
		return table.getColumnName(columnIndex);
	}

    /**
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     * @param rowIndex int		a row number
     * @param columnIndex int	a column number
     * @return Object	an object corresponding with a cell in the table
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
    	return table.getValueAt(rowIndex, columnIndex);
	}
}
