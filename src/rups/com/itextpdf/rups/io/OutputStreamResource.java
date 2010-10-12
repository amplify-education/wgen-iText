/*
 * $Id: OutputStreamResource.java 4113 2009-12-01 11:08:59Z blowagie $
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

package com.itextpdf.rups.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * An object that implements this interface is a resource that
 * can be written to an OutputStream.
 */
public interface OutputStreamResource {
	/**
	 * Writes a resource to an OutputStream.
	 * @param os	the OutputStream to which the XML is written.
	 * @throws IOException	usual exception when there's a problem writing to an OutputStream
	 */
	public void writeTo(OutputStream os) throws IOException;
}
