/**
 * Copyright (C) 2011 Angelo Zerr <angelo.zerr@gmail.com> and Pascal Leclercq <pascal.leclercq@gmail.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.apache.poi.xwpf.converter.itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.AbstractXWPFPOIConverterTest;
import org.apache.poi.xwpf.converter.Data;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class XWPFPOI2PDFViaiTextConverterTest extends
		AbstractXWPFPOIConverterTest {

	protected void doGenerate(String fileInName) throws IOException {

		// String
		// root=XWPFPOI2PDFViaiTextConverterTest.class.getClassLoader().getResource(".").getFile();
		String root = "target";
		String fileOutName = root + "/" + fileInName + ".pdf";

		long startTime = System.currentTimeMillis();

		XWPFDocument document = new XWPFDocument(
				Data.class.getResourceAsStream(fileInName));

		OutputStream out = new FileOutputStream(new File(fileOutName));
		PDFViaITextOptions options = PDFViaITextOptions.create().fontEncoding("windows-1250");
		XWPF2PDFViaITextConverter.getInstance().convert(document, out, options);

		System.out.println("Generate " + fileOutName + " with "
				+ (System.currentTimeMillis() - startTime) + " ms.");
	}
}
