

package library_management_.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;


public class Book_issue extends JFrame implements ActionListener 
{
    String colorpanel_ = "#90A4AE";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();
    JLabel b_id = new JLabel("Book ID  : ");
    JTextField t_id = new JTextField(15);

    JLabel b_name = new JLabel("Book Name            :  ");
    JTextField tf_bname = new JTextField(15);

    JLabel stu_name = new JLabel("Student Name :  ");

    JTextField tf_stu_name = new JTextField(15);

    JLabel stu_id = new JLabel("Student ID: ");
    JTextField tf_stu_id = new JTextField(15);

    JLabel issue_date = new JLabel("Issue Date");
    JTextField tf_issue_date = new JTextField(15);

    JButton sb = new JButton("Save", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();

    Book_issue() {

        super("Issue Book.");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
        add(panel);
        setSize(550, 600);
        setVisible(true);
        setLocation(480, 70);
        Add_Component_E();

    }

    void Add_Component_E() {

        b_id.setBounds(90, 70, 130, 40);
        t_id.setBounds(210, 70, 150, 40);
        panel.add(b_id);
        panel.add(t_id);

        b_name.setBounds(90, 160, 130, 40);
        tf_bname.setBounds(210, 160, 150, 40);
        panel.add(b_name);
        panel.add(tf_bname);

        stu_name.setBounds(90, 240, 130, 40);
        tf_stu_name.setBounds(210, 240, 150, 40);
        panel.add(stu_name);
        panel.add(tf_stu_name);

        stu_id.setBounds(90, 320, 130, 40);
        tf_stu_id.setBounds(210, 320, 150, 40);
        panel.add(stu_id);
        panel.add(tf_stu_id);

        issue_date.setBounds(90, 400, 130, 40);
        tf_issue_date.setBounds(210, 400, 150, 40);
        panel.add(issue_date);
        panel.add(tf_issue_date);
        
        t_id.setBackground(Color.decode(colorbutton_));
        tf_bname.setBackground(Color.decode(colorbutton_));
        tf_stu_name.setBackground(Color.decode(colorbutton_));
        tf_stu_id.setBackground(Color.decode(colorbutton_));
        tf_issue_date.setBackground(Color.decode(colorbutton_));

        sb.setBounds(100, 500, 140, 40);
        sb.setForeground(Color.BLACK);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(290, 500, 140, 40);
        bb.setForeground(Color.BLACK);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);
        
        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));

    }

    /*public static void main(String args[]) {

        Book_issue ob = new Book_issue();
    }*/

    public void actionPerformed(ActionEvent einfo) {
        if (einfo.getSource() == sb) {

            try {

                String stu_name = tf_stu_name.getText();
                String s_id = t_id.getText().toString();
                int b_id = Integer.parseInt(s_id);
                String book_name = tf_bname.getText();
                String stu_id = tf_stu_id.getText();
                String issue_dat = tf_issue_date.getText();
                int i = Issue_BookDao.save(b_id, book_name, stu_name, stu_id, issue_dat);
                if (i > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } 
                else 
                {
                    System.out.println(einfo.toString());
                }

            } 
            catch (Exception ee) 
            {

                // System.out.println(ee.toString());
                JOptionPane.showMessageDialog(null, "Please!!! Enter Correct Information.");
            }
        }
        if (einfo.getSource() == bb)
        {
            new Main();
            dispose();
        }

    }

}
