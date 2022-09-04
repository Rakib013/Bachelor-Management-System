import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame{
    JLabel label, background;
    JPanel panel;
    JMenuBar mb;
    JMenu info, signUp;
    JButton login;

    Dashboard(String Title){
        super(Title);
        setSize( 700, 600 );

        login = new JButton("Login");
        login.setBounds(230, 260, 210, 40);
        add(login);

        // Login Button Listener
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Authenticate a =  new Authenticate("Dashboard");
                a.setVisible(true);
            }
        });

        ImageIcon img = new ImageIcon("img/Bg.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 700, 600);
        add(background);


        // Frame Initialization
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setVisible(true);
        setLayout( null );       
        //getContentPane().setBackground(Color.MAGENTA);
    }
}
