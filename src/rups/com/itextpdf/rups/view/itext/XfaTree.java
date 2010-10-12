/*
 * $Id: XfaTree.java 4113 2009-12-01 11:08:59Z blowagie $
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

package com.itextpdf.rups.view.itext;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import com.itextpdf.rups.model.XfaFile;
import com.itextpdf.rups.view.icons.IconTreeCellRenderer;
import com.itextpdf.rups.view.icons.IconTreeNode;
import com.itextpdf.rups.view.itext.treenodes.XdpTreeNode;

/**
 * Tree that visualizes the XFA information.
 */
public class XfaTree extends JTree {

	/**
	 * Constructs an XfaTree.
	 */
	public XfaTree() {
		super();
	}
	
	public void clear() {
		setCellRenderer(new IconTreeCellRenderer());
		setModel(new DefaultTreeModel(new IconTreeNode("xfa.png")));
	}
	public void load(XfaFile file) {
		setCellRenderer(new IconTreeCellRenderer());
		setModel(new DefaultTreeModel(new XdpTreeNode(file.getXfaDocument())));
	}

	/** A Serial Version UID. */
	private static final long serialVersionUID = -5072971223015095193L;

}