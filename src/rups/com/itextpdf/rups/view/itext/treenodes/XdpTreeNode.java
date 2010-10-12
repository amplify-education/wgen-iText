/*
 * $Id: XdpTreeNode.java 4242 2010-01-02 23:22:20Z xlv $
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

package com.itextpdf.rups.view.itext.treenodes;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Branch;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Text;

import com.itextpdf.rups.view.icons.IconFetcher;
import com.itextpdf.rups.view.icons.IconTreeNode;

public class XdpTreeNode extends IconTreeNode {

	/** A serial version UID. */
	private static final long serialVersionUID = -6431790925424045933L;

	/**
	 * Constructs an XdpTreeNode
	 * @param node	the XML node
	 */
	@SuppressWarnings("unchecked")
    public XdpTreeNode(Node node) {
		super(null, node);
		if (node instanceof Element) {
			Element element = (Element)node;
			addChildNodes(element.attributes());
		}
		if (node instanceof Branch) {
			Branch branch = (Branch) node;
			addChildNodes(branch.content());
		}
		if (node instanceof Attribute) {
			icon = IconFetcher.getIcon("attribute.png");
			return;
    	}
    	if (node instanceof Text) {
    		icon = IconFetcher.getIcon("text.png");
    		return;
    	}
    	if (node instanceof ProcessingInstruction) {
    		icon = IconFetcher.getIcon("pi.png");
    		return;
    	}
    	if (node instanceof Document) {
    		icon = IconFetcher.getIcon("xfa.png");
    		return;
    	}
    	icon = IconFetcher.getIcon("tag.png");
	}

	private void addChildNodes(List <Node>list) {
		for (Node node : list) {
			Node n = node;
			if (n instanceof Namespace) continue;
			if (n instanceof Comment) continue;
			this.add(new XdpTreeNode(n));
		}
	}

	public Node getNode() {
    	return (Node)getUserObject();
	}

	@Override
    public String toString() {
		Node node = getNode();
		if (node instanceof Element) {
			Element e = (Element)node;
			return e.getName();
		}
		if (node instanceof Attribute) {
			Attribute a = (Attribute)node;
			StringBuffer buf = new StringBuffer();
			buf.append(a.getName());
			buf.append("=\"");
			buf.append(a.getValue());
			buf.append('"');
			return buf.toString();
		}
		if (node instanceof Text) {
			Text t = (Text)node;
			return t.getText();
		}
		if (node instanceof ProcessingInstruction) {
			ProcessingInstruction pi = (ProcessingInstruction)node;
			StringBuffer buf = new StringBuffer("<?");
			buf.append(pi.getName());
			buf.append(' ');
			buf.append(pi.getText());
			buf.append("?>");
			return buf.toString();
		}
		if (node instanceof Document) {
			return "XFA Document";
		}
		return getNode().toString();
	}
}