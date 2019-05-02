package library_management_.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class Add_book extends JFrame implements ActionListener {

    String colorpanel_ = "#90A4AE";
    String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    JPanel panel = new JPanel();

    JLabel b_id = new JLabel("Book ID  : ");
    JTextField t_id = new JTextField(15);

    JLabel b_name = new JLabel("Book Name :  ");
    JTextField tf_bname = new JTextField(15);

    JLabel author = new JLabel("Author :  ");

    JTextField t_author = new JTextField(15);

    JLabel publisher = new JLabel("Publisher  :");
    ;
    JTextField tf_publisher = new JTextField(15);

    JLabel quantity = new JLabel("Quantity  :");
    JTextField tf_quantity = new JTextField(15);

    JButton sb = new JButton("Save", new ImageIcon("images/Save.gif"));
    JButton bb = new JButton("Back", new ImageIcon("images/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 25);
    ImageIcon ic = new ImageIcon();
    //JDesktopPane pane = new JDesktopPane();

    Add_book() {

        super("Save Books Information");
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorpanel_));
      
        add(panel);
        setSize(550, 600);
     
        setVisible(true);
        setLocationRelativeTo(null);
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

        author.setBounds(90, 240, 130, 40);
        t_author.setBounds(210, 240, 150, 40);
        panel.add(author);
        panel.add(t_author);

        publisher.setBounds(90, 320, 130, 40);
        tf_publisher.setBounds(210, 320, 150, 40);
        panel.add(publisher);
        panel.add(tf_publisher);

        quantity.setBounds(90, 400, 130, 40);
        tf_quantity.setBounds(210, 400, 150, 40);
        panel.add(quantity);
        panel.add(tf_quantity);

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

        t_id.setBackground(Color.decode(colorbutton_));
        tf_bname.setBackground(Color.decode(colorbutton_));
        t_author.setBackground(Color.decode(colorbutton_));
        tf_publisher.setBackground(Color.decode(colorbutton_));
        tf_quantity.setBackground(Color.decode(colorbutton_));

        sb.setBackground(Color.decode(colorbutton_));
        bb.setBackground(Color.decode(colorbutton_));

    }

  /*  public static void main(String args[]) {

        Add_book ob = new Add_book();
    }*/

    public void actionPerformed(ActionEvent einfo) {

        if (einfo.getSource() == sb) {

            try {

                String quant = tf_quantity.getText().toString();
                int quantity = Integer.parseInt(quant);

                String s_id = t_id.getText().toString();
                int b_id = Integer.parseInt(s_id);

                String book_name = tf_bname.getText();
                String publisher = tf_publisher.getText();

                String author = t_author.getText();

                int i = BookDao.save(b_id, book_name, author, publisher, quantity);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                } else {
                    System.out.println(einfo.toString());
                }

            } catch (Exception ee) {

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
