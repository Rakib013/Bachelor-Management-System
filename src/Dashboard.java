import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame{
    JLabel label, background, bazar, clean, name, cname, next, list, next2, list2;
    JPanel panel;
    JMenuBar mb;
    JMenu home, payment, mile, rules, help, logout;
    JButton login;

    Dashboard(String Title){
        super(Title);
        setSize( 700, 600 );

        // Menu bar
        mb = new JMenuBar();
        home = new JMenu("Home");
        payment = new JMenu("Payment");
        mile = new JMenu("Meal");
        rules = new JMenu("Rules");
        help = new JMenu("Help");
        logout = new JMenu("Log Out");
        mb.add(home);
        mb.add(payment);
        mb.add(mile);
        mb.add(rules);
        mb.add(help);
        mb.add(logout);
        setJMenuBar(mb);

        mile.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
            setVisible(false);
            new Meal("Meal").setVisible(true);
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

        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              setVisible(false);
              new Authenticate("Authenticate").setVisible(true);
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

        payment.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
            setVisible(false);
            new Payment("Payment").setVisible(true);
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
        
        // Panel
        bazar = new JLabel("Market Responsibility", SwingConstants.CENTER);
        bazar.setBounds(60, 100, 180, 20);
        bazar.setOpaque(true);
        bazar.setBackground(Color.CYAN);
        bazar.setFont(new Font("", Font.BOLD, 15));
        add(bazar);
        name = new JLabel("* A.B.M Ilman Farabi", SwingConstants.CENTER);
        name.setBounds(60, 150, 180, 100);
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setFont(new Font("", Font.BOLD, 15));
        add(name);

        next = new JLabel("Next Responsibility", SwingConstants.CENTER);
        next.setBounds(60, 270, 180, 20);
        next.setOpaque(true);
        next.setBackground(Color.CYAN);
        next.setFont(new Font("", Font.BOLD, 15));
        add(next);

        list = new JLabel("<html>1. Md. Taukir Khan<br>2. Sagor Ahmed Munna<br>3. Sagor Akon<br>4. Md. Rakibul Islam</html>", SwingConstants.CENTER);
        list.setBounds(20, 300, 300, 130);
        list.setOpaque(true);
        list.setBackground(Color.white);
        list.setFont(new Font("", Font.BOLD, 15));
        add(list);

        clean = new JLabel("Room Cleaning Responsibility!", SwingConstants.CENTER);
        clean.setBounds(370, 100, 240, 20);
        clean.setOpaque(true);
        clean.setBackground(Color.CYAN);
        clean.setFont(new Font("", Font.BOLD, 15));
        add(clean);
        cname = new JLabel("* Mahamudul Hasan", SwingConstants.CENTER);
        cname.setBounds(420, 150, 180, 100);
        cname.setOpaque(true);
        cname.setBackground(Color.white);
        cname.setFont(new Font("", Font.BOLD, 15));
        add(cname);

        next2 = new JLabel("Next Responsibility", SwingConstants.CENTER);
        next2.setBounds(420, 270, 180, 20);
        next2.setOpaque(true);
        next2.setBackground(Color.CYAN);
        next2.setFont(new Font("", Font.BOLD, 15));
        add(next2);

        list2 = new JLabel("<html>1. Md. Taukir Khan<br>2. Sagor Ahmed Munna<br>3. Sagor Akon<br>4. Md. Rakibul Islam</html>", SwingConstants.CENTER);
        list2.setBounds(380, 300, 300, 130);
        list2.setOpaque(true);
        list2.setBackground(Color.white);
        list2.setFont(new Font("", Font.BOLD, 15));
        add(list2);
        
        ImageIcon img = new ImageIcon("img/ind.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 0, 0);
        add(background);


        // Frame Initialization
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setVisible(true);
        setLayout( null );       
        //getContentPane().setBackground(Color.MAGENTA);
    }
}
