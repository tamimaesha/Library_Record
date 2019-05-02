package library_management_.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main extends JFrame implements ActionListener {

    String colorlayout_ = "#607D8B";
    String colorlabel_ = "#263238";
    String colorpane_ = "#B0BEC5";
    //String colorWhite100_ = "#ffffff";
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    JLabel l_welcome = new JLabel("Welcome To Library Management System");
    JLabel l_reserve_book = new JLabel("Reserve Books");
    JLabel l_view_reserve_book = new JLabel("View Reserve Books");
    JLabel l_view_issue_book = new JLabel("View Issued Books");
    JLabel l_store_books = new JLabel("Stock Available");
    JLabel l_issue_book = new JLabel("Issue Book");

    JLabel l_return_book = new JLabel("Return Book");

    JButton b_reserve_book = new JButton("", new ImageIcon("image/kk.jpg"));
    JButton b_view_reserve_book = new JButton("", new ImageIcon("image/r.jpg"));
    JButton b_issue_book = new JButton("", new ImageIcon("image/books.jpg"));
    JButton b_view_issue_book = new JButton("", new ImageIcon("image/bv.png"));
    JButton b_store_books = new JButton("", new ImageIcon("image/member.png"));

    JButton b_return_book = new JButton("", new ImageIcon("image/rb.jpg"));
    //JPanel panel = new JPanel();
    JDesktopPane pane = new JDesktopPane();
    ImageIcon ic = new ImageIcon();
    Font menufnt = new Font("Times New Roman", Font.PLAIN, 35);
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 23);
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    Main() {
        super("Main");
        Container conn = this.getContentPane();
        conn.setLayout(new BorderLayout());
        conn.setBackground(Color.decode(colorlayout_));

        l_welcome.setHorizontalAlignment(SwingConstants.CENTER);
        l_welcome.setPreferredSize(new Dimension(80, 100));
        conn.add(l_welcome, BorderLayout.NORTH);
        setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        setLocationRelativeTo(null);
        //pane.setLayout(null);
        conn.add(pane, BorderLayout.CENTER);
        pane.setBackground(Color.decode(colorpane_));
        pane.setLayout(null);
        add(pane);
        //pane.setBackground(Color.LIGHT_GRAY);
        setSize(dim);
        setVisible(true);
        //setLocation(400, 70);
        //setResizable(false);
        label();
        button();

    }

    void label() {
        // Lwelcome.setBounds(430, 30,900,60);
        l_welcome.setFont(menufnt);
        l_welcome.setForeground(Color.decode(colorlabel_));

        l_reserve_book.setBounds(140, 40, 200, 60);
        l_reserve_book.setFont(lfnt);
        l_reserve_book.setForeground(Color.BLACK);
        pane.add(l_reserve_book);

        l_issue_book.setBounds(485, 30, 200, 80);
        l_issue_book.setFont(lfnt);
        l_issue_book.setForeground(Color.BLACK);
        pane.add(l_issue_book);

        l_view_reserve_book.setBounds(270, 300, 200, 60);
        l_view_reserve_book.setFont(lfnt);
        l_view_reserve_book.setForeground(Color.BLACK);
        pane.add(l_view_reserve_book);

        l_view_issue_book.setBounds(610, 300, 200, 60);
        l_view_issue_book.setFont(lfnt);
        l_view_issue_book.setForeground(Color.BLACK);
        pane.add(l_view_issue_book);

        l_store_books.setBounds(755, 30, 200, 80);
        l_store_books.setFont(lfnt);
        l_store_books.setForeground(Color.black);
        pane.add(l_store_books);

        l_return_book.setBounds(1110, 30, 200, 80);
        l_return_book.setFont(lfnt);
        l_return_book.setForeground(Color.black);
        pane.add(l_return_book);

    }

    void button() {

        b_reserve_book.setBounds(105, 100, 200, 150);
        b_reserve_book.addActionListener(this);
        pane.add(b_reserve_book);

        b_issue_book.setBounds(435, 100, 200, 150);
        b_issue_book.addActionListener(this);
        pane.add(b_issue_book);

        b_view_reserve_book.setBounds(275, 360, 200, 150);
        b_view_reserve_book.addActionListener(this);
        pane.add(b_view_reserve_book);

        b_view_issue_book.setBounds(595, 360, 200, 150);
        b_view_issue_book.addActionListener(this);
        pane.add(b_view_issue_book);

        b_store_books.setBounds(755, 100, 200, 150);
        b_store_books.addActionListener(this);
        pane.add(b_store_books);

        b_return_book.setBounds(1075, 100, 200, 150);
        b_return_book.addActionListener(this);
        pane.add(b_return_book);

    }
    /*  public static void main(String[] args)
     {
     Main ob=new Main();
     }*/

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b_reserve_book) {
            new Add_book();
            dispose();

        }
        if (e.getSource() == b_issue_book) {
            new Book_issue();
            dispose();

        }
        if (e.getSource() == b_view_reserve_book) {
            new View_Reserve_Books();

        }
        if (e.getSource() == b_view_issue_book) {
            new View_issue_books();

        }

        if (e.getSource() == b_return_book) {
            new Return_book();
            dispose();

        }

        if (e.getSource() == b_store_books) {
            new View_Library_Books();

        }

    }

}
