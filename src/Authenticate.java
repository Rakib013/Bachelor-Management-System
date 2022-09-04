import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Authenticate extends JFrame{
    JLabel label, user, pass, background;
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
        user.setBounds(230, 110, 200, 30);
        pass = new JLabel("Enter Your Password");
        pass.setBounds(230, 195, 200, 30);
        add(user);
        add(pass);
        username = new JTextArea();
        password = new JPasswordField();
        username.setBackground(Color.GRAY);
        username.setBounds(230,150, 200,25);  
        password.setBounds(230,225, 210,35);
        password.setBackground(Color.GRAY);  
        add(username);
        add(password);
        
        //Login Button
        login = new JButton("Login");
        login.setBounds(230, 260, 210, 40);
        add(login);

        // Login Button Listener
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Dashboard("Dashboard");
            }
        });
        
        //Login Pannel
        panel = new JPanel();
        panel.setBounds(190,100,300,250);
        panel.setBackground(Color.lightGray);
        add(panel); 
        
        // Set Background Image
        setLayout(null);
        ImageIcon img = new ImageIcon("img/login.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 700, 600);
        add(background);

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
        setVisible(false);    
    }
}