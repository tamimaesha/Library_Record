package library_management_.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class Return_book extends JFrame implements ActionListener {

    String colorpanel_ = "#90A4AE";

    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();

    JLabel b_name = new JLabel("Book Name  :  ");
    JTextField tf_bname = new JTextField(15);

    JLabel stu_id = new JLabel("Student ID : ");
    JTextField tf_stu_id = new JTextField(15);

    JButton ob = new JButton("Ok", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();

    Return_book() {

        super("Return Book");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(480, 400);
        setVisible(true);
        setLocation(480, 150);
        Add_Component_E();

    }

    void Add_Component_E() {

        b_name.setBounds(110, 150, 100, 30);
        tf_bname.setBounds(200, 150, 150, 30);
        panel.add(b_name);
        panel.add(tf_bname);

        stu_id.setBounds(110, 75, 100, 30);
        tf_stu_id.setBounds(200, 75, 150, 30);
        panel.add(stu_id);
        panel.add(tf_stu_id);

        tf_stu_id.setBackground(Color.decode(colorbutton_));
        tf_bname.setBackground(Color.decode(colorbutton_));

        ob.setBounds(90, 250, 110, 30);
        ob.setBackground(Color.decode(colorbutton_));
        ob.setForeground(Color.BLACK);
        ob.addActionListener(this);
        ob.setToolTipText("Save");
        ob.setMnemonic(KeyEvent.VK_S);
        panel.add(ob);

        bb.setBounds(240, 250, 110, 30);
        bb.setBackground(Color.decode(colorbutton_));
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);

    }

   /* public static void main(String args[]) {

        Return_book ob = new Return_book();
    }*/

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ob) {

            try {

                String stu_id = tf_stu_id.getText();
                String book_name = tf_bname.getText();

                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement("delete from issue_books where student_id=? and book_name =?");
                //ps.setInt(1, b_id);
                ps.setString(1, stu_id);
                ps.setString(2, book_name);
                int i = ps.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! Return book successfully.");
                } else {
                    System.out.println(e.toString());
                }

            } catch (Exception ee) {

               // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");

            }
        }
        if (e.getSource() == bb)
        {
            new Main();
            dispose();
        }

    }

}
