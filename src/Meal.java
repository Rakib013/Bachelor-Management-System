import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.*;

public class Meal extends JFrame{
    JLabel  background, todayHeader, addHeader, dueHeader, mealH;
    JPanel panel;
    JMenuBar mb;
    JTable due;
    JTableHeader header;
    JMenu home, payment, mile, rules, help, logout;
    JButton add;
    JScrollPane sp;
    JComboBox<String> cb;
    JTextArea meal;

    Meal(String title){
        super(title);
        setSize( 900, 800 );

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

        // Menu bar listener
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
  
          home.addMouseListener(new MouseListener() {
              @Override
              public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Dashboard("Dashboard").setVisible(true);
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
  

        // Today Header
        todayHeader = new JLabel("Today's Meal", SwingConstants.CENTER);
        todayHeader.setBounds(350, 50, 200, 30);
        todayHeader.setOpaque(true);
        todayHeader.setBackground(Color.black);
        todayHeader.setFont(new Font("", Font.BOLD, 18));
        todayHeader.setForeground(Color.blue);
        add(todayHeader);

        // Meal List
        String data[][]={
            {"Dal, Aluvorta", "Kacchi", "Dim pos, Ruti"}
        };    
        String column[]={"Breakfast","Lunch", "Diner"};         
        due = new JTable(data, column);
        sp = new JScrollPane(due);
        due.setFont(new Font("", Font.CENTER_BASELINE, 14));
        sp.setBounds(50, 100, 800, 80);
        sp.setFont(new Font("", Font.CENTER_BASELINE, 16));
        due.setRowHeight(30);
        header = due.getTableHeader();
        header.setPreferredSize(new Dimension(200, 40));
        header.setFont(new Font("", Font.CENTER_BASELINE, 16));
        add(sp);

        // Add Menu
        addHeader = new JLabel("Add Meal", SwingConstants.CENTER);
        addHeader.setBounds(350, 300, 200, 30);
        addHeader.setOpaque(true);
        addHeader.setBackground(Color.WHITE);
        addHeader.setForeground(Color.BLUE);
        addHeader.setFont(new Font("", Font.BOLD, 16));
        add(addHeader);

        // Dropdown
        String[] option = {"Breakfast", "Lunch", "Diner"};
        cb = new JComboBox<>(option);
        cb.setBounds(350, 350, 200, 30);
        add(cb);

        mealH = new JLabel("Enter the meal name");
        mealH.setBounds(350, 385, 200, 30);
        mealH.setForeground(Color.WHITE);
        mealH.setFont(new Font("", Font.BOLD, 14));
        add(mealH);

        meal = new JTextArea();
        meal.setBounds(350, 410, 200, 30);
        add(meal);

        // Add Button
        add = new JButton("Add");
        add.setBounds(350, 450, 200, 30);
        add.setForeground(Color.BLUE);
        add.setFont(new Font("", Font.BOLD, 15));
        add(add);
        
        // Background Image
        ImageIcon img = new ImageIcon("img/ind.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 0, 0);
        add(background);

        // Frame Initialization
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setVisible(true);
        setLayout( null );       
    }
}
