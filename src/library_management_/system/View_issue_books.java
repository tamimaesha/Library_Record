

package library_management_.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class View_issue_books extends JFrame implements ActionListener {
    
      Font lb_fnt=new Font("",Font.BOLD,15);


    View_issue_books() {

      
        disPlayData();
    }

    void disPlayData() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Vector data = new Vector();
        JPanel panel = new JPanel();
        JTable table;

        
        try {
            con = DB.getConnection();

            
            ps = con.prepareStatement("select book_id,book_name,student_name,student_id,issue_date from issue_books");
            ps.execute();
            rs = ps.getResultSet();
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i));
            }
            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                
                
                data.add(row);
            }
            Vector columnNames = new Vector();
            columnNames.addElement("Book ID");
            columnNames.addElement("Book Name");
            columnNames.addElement("Student Name");
            columnNames.addElement("Student ID");
            columnNames.addElement("Issue Date");

            
            table = new JTable(data, columnNames);
            
            JFrame frame = new JFrame("Issued Books");
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            JScrollPane pane = new JScrollPane(table);
          
            panel.setLayout(new BorderLayout());
            panel.add(pane, BorderLayout.CENTER);
            
            frame.setContentPane(panel);
            
            frame.setVisible(true);
        }
        catch (Exception e) 
        {
            
            System.out.println(e.toString());
        }

    }

   /* public static void main(String args[]) {

        View_issue_books ob = new View_issue_books();

    }*/

    public void actionPerformed(ActionEvent e) {
            
      
    }

}
