

package library_management_.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class change_password extends JFrame implements ActionListener
{
    String colorpanel_ = "#90A4AE";
    String colorTField_ = "#ECEFF1";
    String colorbutton_ = "#CFD8DC";
    
    
    JLabel l_uname = new JLabel("Username :");
    JTextField tf_uname = new JTextField(15);
    
    JLabel l_password = new JLabel("Password :");
    JPasswordField tf_password = new JPasswordField(15);
    
    JLabel  l_new_password = new JLabel("New password :");
    JPasswordField tf_new_password = new JPasswordField(15);
    
    JLabel  l_confirm_newpass = new JLabel("Confirm password :");
    JPasswordField tf_confirm_newpass = new JPasswordField(15);
    
    JButton b_back = new JButton("Back");
    JButton b_save = new JButton("   Save   ");
    
    JPanel panel = new JPanel();
    JButton btn = new JButton();
    JTextField fld = new JTextField();
    
    
    Font lfnt = new Font("Times New Roman", Font.PLAIN, 17);
    Font tfnt = new Font("Times New Roman", Font.PLAIN, 15);
    Connection con=null;
    Statement st = null;
    ResultSet rs=null;

    change_password() 
    {
        super("Change password");
        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.decode(colorpanel_));
        setSize(480, 400);
        setVisible(true);
        setLocation(800, 100);
        setResizable(false);
        label_and_tex();
        button();

    }
    void label_and_tex()
    {
        l_uname.setBounds(80, 30,200,60);
        l_uname.setFont(lfnt);
        l_uname.setForeground(Color.black);
        panel.add(l_uname);
        
        l_password.setBounds(80, 80, 200, 80);
        l_password.setFont(lfnt);
        l_password.setForeground(Color.black);
        panel.add(l_password);
        
        l_new_password.setBounds(80, 140, 200, 80);
        l_new_password.setFont(lfnt);
        l_new_password.setForeground(Color.black);
        panel.add(l_new_password);
        
        l_confirm_newpass.setBounds(80, 200, 200, 80);
        l_confirm_newpass.setFont(lfnt);
        l_confirm_newpass.setForeground(Color.black);
        panel.add(l_confirm_newpass);

        tf_uname.setBounds(240, 45, 140, 35);
        tf_uname.setForeground(Color.black);
        tf_uname.setFont(tfnt);
        tf_uname.setBackground(Color.decode(colorbutton_));
        panel.add(tf_uname);
        
        tf_password.setBounds(240, 105, 140, 35);
        tf_password.setForeground(Color.black);
        tf_password.setFont(tfnt);
        tf_password.setBackground(Color.decode(colorbutton_));
        panel.add(tf_password);
         
        tf_new_password.setBounds(240, 165, 140, 35);
        tf_new_password.setForeground(Color.black);
        tf_new_password.setFont(tfnt);
        tf_new_password.setBackground(Color.decode(colorbutton_));
        panel.add(tf_new_password);
        
        tf_confirm_newpass.setBounds(240, 225, 140, 35);
        tf_confirm_newpass.setForeground(Color.black);
        tf_confirm_newpass.setFont(tfnt);
        tf_confirm_newpass.setBackground(Color.decode(colorbutton_));
        panel.add(tf_confirm_newpass);
        
        
        
     }
    
    void button()
    {
        b_save.setBounds(90, 300, 110, 30);
        b_save.addActionListener(this);
        b_save.setForeground(Color.black);
        b_save.setBackground(Color.decode(colorbutton_));
        panel.add(b_save);
        
        b_back.setBounds(260, 300, 110, 30);
        b_back.addActionListener(this);
        b_back.setForeground(Color.black);
        b_back.setBackground(Color.decode(colorbutton_));
        panel.add(b_back);
    }
    
      
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b_back)
        {
            new Login();
            dispose();
        
        }
    }
    
}
