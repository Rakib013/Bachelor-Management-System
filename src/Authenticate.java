import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class Authenticate extends JFrame{
    JLabel label, user, pass, background;
    JPanel panel;
    JMenuBar mb;
    JMenu info, signUp;
    static JTextArea username;
    static JPasswordField password;
    JButton login;
    JCheckBox cbx;
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
        login.setBounds(230, 265, 210, 40);
        add(login);

        // Login Button Listener
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    if(checkUser()){
                        setVisible(false);
                        new Dashboard("Dashboard").setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Tumi dada nai!", "Username or Password Doesn't match", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
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
        
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              setVisible(false);
              new SignUp("Sign-Up").setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
  
            @Override
            public void mouseReleased(MouseEvent e) {
            }
  
            @Override
            public void mouseEntered(MouseEvent e) {
            }
  
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // Main Frame
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setLayout( null );   
        setVisible(false);    
    }

    public static boolean checkUser() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("Files/Register.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase().toString();
            String[] data;
            if(line.contains(username.getText())){
                data = line.split(",");
                int i = 0;
                for(char c:password.getPassword()){
                    if(data[1].charAt(i)!=c){
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }
}