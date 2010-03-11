/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bram Gadeyne
 */
public class PDFCreator {
    private static PDFCreator creator;

    private Document document;
    
    private PDFCreator() {
        registerFonts();
    }

    public static PDFCreator getInstance()
    {
        if(creator==null)
        {
            creator=new PDFCreator();
        }
        return creator;
    }

    private void registerFonts()
    {
        FontFactory.register("/resources/VRaam.TTF", "raamschrift"); //seems to work
    }

    public void createPDF(String location, String text)
    {
        document=new Document();
        document.open();
        //addMetaData();

        Paragraph p=new Paragraph(text);
        try {
            document.add(p);
            PdfWriter.getInstance(document, new FileOutputStream(location));
        } catch (DocumentException ex) {
            Logger.getLogger(PDFCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addMetaData()
    {
        document.addAuthor("Bram Gadeyne");
        document.addTitle("Coded with voetje.bramgadeyne.be");
    }

    private void addTitlePage()
    {
     /*   Paragraph preface = new Paragraph();
		// We add one empty line
        addEmptyLine(preface, 1);
		// Lets write a big header
        preface.add(new Paragraph("Generated with voetje.bramgadeyne.be", FontFactory.getFont(FontFactory.COURIER, 24f) ));


        addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
        preface.add(new Paragraph()"Report generated by: " + System.getProperty("user.name") + ", " + new Date(),smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("This document describes something which is very important ",smallBold));

	addEmptyLine(preface, 8);

        preface.add(new Paragraph("This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.de ;-).",redFont));

        document.add(preface);
		// Start a new page
        document.newPage();
      * */

    }

    private void addEmptyLine(Paragraph paragraph, int number) {
            for (int i = 0; i < number; i++) {
                    paragraph.add(new Paragraph(" "));
            }
    }


}
