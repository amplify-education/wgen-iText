/*
 * $Id: MessageAction.java 4113 2009-12-01 11:08:59Z blowagie $
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

package com.itextpdf.rups.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;

public class MessageAction implements ActionListener {
	
	public void actionPerformed(ActionEvent evt) {
		String message = "Unspecified message";
		if (RupsMenuBar.ABOUT.equals(evt.getActionCommand())) {
			message = "RUPS is a tool by 1T3XT BVBA.\nIt uses iText, a Free Java-PDF Library.\nVisit http://www.1t3xt.com/ for more info.";
		}
		else if (RupsMenuBar.VERSION.equals(evt.getActionCommand())) {
			message = "iText version: " + Document.getVersion();
		}
        JOptionPane.showMessageDialog(null, message);
	}

}
