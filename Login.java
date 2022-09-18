package Student;  
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Login implements ActionListener {
    static JFrame f = new JFrame();
    JLabel l1,l2;
    JTextField jtf;
    JTextArea jta;
    JPasswordField jpf;
    JButton jb ;
    FileReader fileReader;
    FileWriter fileWriter;
    String s1 = "";
    Login(){
        l1 = new JLabel("Enter the email : ");
        l1.setBounds(50,50,130,30);
        jtf = new JTextField();
        jtf.setBounds(180,50,150,30);
        l2 = new JLabel("Enter the password : ");
        l2.setBounds(50,100,130,30);
        jpf = new JPasswordField();
        jpf.setBounds(180,100,150,30);
        jb = new JButton("submit");
        jb.setBounds(100,150,150,30);
        jta = new JTextArea();
        jta.setBounds(50,200,250,150);
        f.add(l1);f.add(jtf);
        f.add(l2);f.add(jpf);
        f.add(jb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.add(jta);
        jb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        StringBuilder sb = new StringBuilder();
        try {
            File myObj = new File(jtf.getText());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                sb.append(data);
                sb.append("\n");
                jta.setText(sb.toString());
            }
            JOptionPane.showMessageDialog(null, "file open");
            myReader.close();
          } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e+"");
          } 
    }
    public static void main(String args[]){
        new Login();
    }
}
