import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class SignUp extends JFrame{
    JLabel  background, Name, Username, Nid, Age, Location, Pass, Uni;
    static JTextArea name, username, nid, age, location, pass, uni;
    static JPasswordField password;
    JButton sign, back;
    JCheckBox cbx;

    SignUp(String s){
        super(s);
        setSize(1000, 600);

        // Back button
        back = new JButton("Back");
        back.setBounds(0, 0, 100, 30);
        back.setForeground(Color.blue);
        back.setFont(new Font("", Font.BOLD, 14));
        add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Authenticate("Authenticate").setVisible(true);;
            }
        });


        // Input Box
        Name = new JLabel("Name");
        Name.setBounds(20, 50, 200, 22);
        Name.setForeground(Color.white);
        add(Name);
        name = new JTextArea();
        name.setBounds(20, 75, 200, 25);
        add(name);

        Username = new JLabel("Username");
        Username.setBounds(20, 110, 200, 22);
        Username.setForeground(Color.white);
        add(Username);
        username = new JTextArea();
        username.setBounds(20, 130, 200, 25);
        add(username);

        Pass = new JLabel("Password");
        Pass.setBounds(20, 165, 200, 22);
        Pass.setForeground(Color.white);
        add(Pass);
        password = new JPasswordField();
        password.setBounds(20, 185, 200, 25);
        add(password);

        Nid = new JLabel("NID");
        Nid.setBounds(20, 220, 200, 25);
        Nid.setForeground(Color.WHITE);
        add(Nid);
        nid = new JTextArea();
        nid.setBounds(20, 245, 200, 25);
        add(nid);

        Age = new JLabel("Age");
        Age.setBounds(20, 280, 200, 25);
        Age.setForeground(Color.WHITE);
        add(Age);
        age = new JTextArea();
        age.setBounds(20, 305, 200, 25);
        add(age);

        Location = new JLabel("Location");
        Location.setBounds(20, 340, 200, 25);
        Location.setForeground(Color.WHITE);
        add(Location);
        location = new JTextArea();
        location.setBounds(20, 365, 200, 25);
        add(location);

        Uni = new JLabel("University Name");
        Uni.setBounds(20, 400, 200, 25);
        Uni.setForeground(Color.WHITE);
        add(Uni);
        uni = new JTextArea();
        uni.setBounds(20, 425, 200, 25);
        add(uni);

        cbx = new JCheckBox("Are you agree with our all terms and condition?");
        cbx.setBounds(20, 460, 500, 25);
        cbx.setForeground(Color.WHITE);
        cbx.setFont(new Font("", Font.BOLD, 14));
        add(cbx);

        // Sign-Up 
        sign = new JButton("Sign Up");
        sign.setBounds(20, 500, 200, 40);
        sign.setForeground(Color.BLUE);
        sign.setFont(new Font("", Font.BOLD, 16));
        add(sign);

        sign.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(countLine()>=5){
                    JOptionPane.showMessageDialog(null, "Moja koris na", "InfoBox: " + "Seat Limitation", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    try{
                        addStudent();
                        setVisible(false);
                        new Dashboard("Dashboard").setVisible(true);
                    }catch (IOException i){
                        i.printStackTrace();
                    }
                }
            }
        });

        // Background Image
        ImageIcon img = new ImageIcon("img/new.jpeg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1100, 800);
        add(background);


        // Frame Initialization
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);  
        setVisible(true);
        setLayout( null );       
        //getContentPane().setBackground(Color.MAGENTA)    
        getContentPane().setLayout(new BorderLayout()); 
    }

    public static int countLine(){
        Path path =  Paths.get("Files/Register.txt");
        int lines = 0;
        try{
            lines = (int) Files.lines(path).count();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void addStudent() throws IOException{
        Path p =  Paths.get("Files/Register.txt");
        Path d =  Paths.get("Files/Due.txt");
        Path tempFile = Files.createTempFile(p.getParent(), "temp", ".txt");
        Path tempFile2 = Files.createTempFile(d.getParent(), "temp2", ".txt");

        try (BufferedReader reader = Files.newBufferedReader(p); BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write(name.getText() + ",");
            writer.write(password.getPassword());
        }
        Files.copy(tempFile, p, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(tempFile);

        try (BufferedReader reader = Files.newBufferedReader(d); BufferedWriter writer = Files.newBufferedWriter(tempFile2)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write(name.getText() + ",");
            writer.write("0");
        }
        Files.copy(tempFile2, d, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(tempFile2);
    }
}
