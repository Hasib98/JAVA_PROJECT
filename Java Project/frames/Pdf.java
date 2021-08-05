package frames;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileOutputStream;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.*;
import repository.*;
 
//import com.itextpdf.awt.PdfGraphics2D;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfTemplate;
//import com.itextpdf.text.pdf.PdfWriter;
 
public class Pdf extends JFrame
{
 
  private static final long serialVersionUID = 1L;
  private JTable table;
  
    public Pdf(){
      getContentPane().setLayout(new BorderLayout());
      createTable();
    }
    private void createTable() {

      EmployeeRepo er= new EmployeeRepo();
    // Object[][] data = {{ "a", "b", "e", new Integer(5), new Boolean(false) } };
    // String[] columnNames = { "A", "B", "C", "D", "E" };
    String data[][] = er.getAllEmployee();;
    String head[] = {"EmployeeId", "EmployeeName", "Age", "Gender"," Designation","Salary"};
      table = new JTable(data,head);
  
      JPanel tPanel = new JPanel(new BorderLayout());
      tPanel.add(table.getTableHeader(), BorderLayout.NORTH);
      tPanel.add(table, BorderLayout.CENTER);
  
     getContentPane().add(tPanel, BorderLayout.CENTER);
    }
    public void print() {
      Document document = new Document();
      try {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Employeedata.pdf"));
  
        document.open();
        PdfContentByte cb = writer.getDirectContent();
  
        cb.saveState();
        Graphics2D g2 = cb.createGraphicsShapes(500, 500);
  
        Shape oldClip = g2.getClip();
        g2.clipRect(0, 0, 500, 500);
  
        table.print(g2);
        g2.setClip(oldClip);
  
        g2.dispose();
        cb.restoreState();
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
      document.close();
    }
    
    /*public static void main(String[] args) {
      Pdf frame = new Pdf();
      frame.pack();
      frame.setVisible(true);
      frame.print();
    }*/
  
}