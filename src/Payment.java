import javax.swing.table.JTableHeader;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Payment extends JFrame{
    JLabel label, background, bazar, clean, name, cname, next, list, next2, list2, dueHeader, paymentHeader, payname, paynid, paymoney, advanceHeader;
    JPanel panel;
    JMenuBar mb;
    JMenu home, payment, mile, rules, help, logout;
    JButton login, pay;
    JTable due, advance;
    JScrollPane sp, sp2;
    JTableHeader header, adheader;
    static JTextArea pname, nid, money;
    static String data[][];

    Payment(String Title){
        super(Title);
        setSize( 1100, 800 );

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

        data = new String[4][4];
        try {
          getDueData();
        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        }
        for(int i=0; i<4; i++){
          data[i][0] = data[i][0].substring(0, 1).toUpperCase() + data[i][0].substring(1);
        }

        dueHeader = new JLabel("Due Payment", SwingConstants.CENTER);
        dueHeader.setBounds(20, 150, 200, 30);
        dueHeader.setOpaque(true);
        dueHeader.setBackground(Color.white);
        dueHeader.setFont(new Font("", Font.BOLD, 18));
        dueHeader.setForeground(Color.BLUE);
        add(dueHeader);
        String column[]={"NAME","DUE"};         
        due = new JTable(data, column);
        sp = new JScrollPane(due);
        due.setFont(new Font("", Font.CENTER_BASELINE, 14));
        sp.setBounds(20, 200, 200, 200);
        sp.setFont(new Font("", Font.CENTER_BASELINE, 16));
        due.setRowHeight(30);
        header = due.getTableHeader();
        header.setPreferredSize(new Dimension(200, 40));
        header.setFont(new Font("", Font.CENTER_BASELINE, 16));
        add(sp);

        // Advanced Table
        String data2[][]={
          {"Frabi", "0"},
          {"Taukir", "0"},
          {"Sagor Akon", "0"},
          {"Munna", "0"},
          {"Rakib", "7000"}
        };    
        advanceHeader = new JLabel("Advanced Paid", SwingConstants.CENTER);
        advanceHeader.setBounds(20, 430, 200, 30);
        advanceHeader.setOpaque(true);
        advanceHeader.setBackground(Color.white);
        advanceHeader.setFont(new Font("", Font.BOLD, 18));
        advanceHeader.setForeground(Color.BLUE);
        add(advanceHeader);
        String column2[]={"NAME","ADVANCE"};         
        advance = new JTable(data2, column2);
        sp2 = new JScrollPane(advance);
        advance.setFont(new Font("", Font.CENTER_BASELINE, 14));
        sp2.setBounds(20, 470, 200, 200);
        sp2.setFont(new Font("", Font.CENTER_BASELINE, 16));
        advance.setRowHeight(30);
        header = advance.getTableHeader();
        header.setPreferredSize(new Dimension(200, 40));
        header.setFont(new Font("", Font.CENTER_BASELINE, 16));
        add(sp2);

        // Payment Field
        paymentHeader = new JLabel("Payment", SwingConstants.CENTER);
        paymentHeader.setBounds(850, 150, 200, 30);
        paymentHeader.setOpaque(true);
        paymentHeader.setBackground(Color.white);
        paymentHeader.setFont(new Font("", Font.BOLD, 18));
        paymentHeader.setForeground(Color.blue);
        add(paymentHeader);

        pname = new JTextArea();
        nid = new JTextArea();
        money = new JTextArea();
        pname.setBounds(850, 215, 200, 27);
        nid.setBounds(850, 270, 200, 27);
        money.setBounds(850, 325, 200, 27);
        add(pname);
        add(nid);
        add(money);

        // Input Field Lavel
        payname = new JLabel("Enter your name");
        paynid = new JLabel("Enter your NID");
        paymoney = new JLabel("Enter Amount");
        payname.setBounds(850, 190, 200, 27);
        paynid.setBounds(850, 245, 200, 27);
        paymoney.setBounds(850, 300, 200, 27);
        payname.setForeground(Color.white);
        paynid.setForeground(Color.white);
        paymoney.setForeground(Color.white);
        add(payname);
        add(paynid);
        add(paymoney);

        // Pay Button
        pay = new JButton("Pay");
        pay.setBounds(850, 380, 200, 35);
        pay.setFont(new Font("", Font.BOLD, 18));
        pay.setForeground(Color.blue);
        add(pay);

        pay.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
            try {
              duePay();
              setVisible(true);
              new Payment("Payment").setVisible(true);
            } catch (IOException e1) {
              e1.printStackTrace();
            }
          }
      });

        // Background Image
        ImageIcon img = new ImageIcon("img/payment.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 0, 0);
        add(background);


        // Frame Initialization
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setVisible(true);
        setLayout( null );       
        //getContentPane().setBackground(Color.MAGENTA)    
        getContentPane().setLayout(new BorderLayout()); 
    }

    public static void getDueData() throws FileNotFoundException{
      Scanner scan = new Scanner(new File("Files/Due.txt"));
        int i=0;
        while(scan.hasNext()){
          String line = scan.nextLine().toLowerCase().toString();
          String[] dat = line.split(",");
          data[i][0] = dat[0];
          data[i][1] = dat[1];
          i++;
        }
    }

    public static void duePay() throws IOException{
        Path p =  Paths.get("Files/Due.txt");
        Path tempFile = Files.createTempFile(p.getParent(), "temp", ".txt");

        try (BufferedReader reader = Files.newBufferedReader(p); BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
              String[] data;
              if(line.contains(pname.getText())){
                data = line.split(",");
                writer.write(data[0] + ",");
                int t = Integer.parseInt(data[1]);
                int m = Integer.parseInt(money.getText());
                if(m>=t){
                  writer.write("0");
                }else{
                  writer.write(Integer.toString(t-m));
                }
                writer.newLine();
                continue;
              }
              writer.write(line);
              writer.newLine();
            }
            
        }
        Files.copy(tempFile, p, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(tempFile);
    }
}
