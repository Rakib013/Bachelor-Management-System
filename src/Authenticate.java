import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class Authenticate extends JFrame{
    JLabel label, user, pass;
    JPanel panel;
    JMenuBar mb;
    JMenu info, signUp;
    JTextArea username;
    JPasswordField password;
    JButton login;
    Authenticate(String title){
        super( title );                      
        setSize( 700, 600 );

        // Input Box and Level In Panel 
        user = new JLabel("Enter Your Username");
        user.setBounds(230, 110, 200, 50);
        pass = new JLabel("Enter Your Password");
        pass.setBounds(230, 165, 200, 50);
        add(user);
        add(pass);
        username = new JTextArea();
        password = new JPasswordField();
        username.setBounds(230,150, 200,20);  
        password.setBounds(230,200, 210,30);  
        add(username);
        add(password);

        //Login Button
        login = new JButton("Login");
        login.setBounds(230, 250, 210, 40);
        add(login);

        //Login Pannel
        panel = new JPanel();
        panel.setBounds(190,100,300,250);
        panel.setBackground(Color.lightGray);
        add(panel); 


        // Menu Bar
        mb = new JMenuBar();
        info = new JMenu("Info");
        signUp = new JMenu("Sign Up");
        mb.add(info);
        mb.add(signUp);
        mb.setBackground(Color.CYAN);
        setJMenuBar(mb);

        // Main Frame
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setLayout( null );       
        getContentPane().setBackground(Color.gray);
    }
}