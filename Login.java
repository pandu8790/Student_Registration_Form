import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.String;
import java.util.*;
public class Login implements ActionListener {
    static JFrame f = new JFrame();
    JFrame f1 = new JFrame();
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField jtf,jtf1;
    JTextArea jta;
    JButton jb ;
    FileReader fileReader;
    FileWriter fileWriter;
    String pass,revpassword;
    File myObjecFile;
    ArrayList<String> arr  = new ArrayList<String>();
    Login(){
        l1 = new JLabel("Enter the username : ");
        l1.setBounds(50,50,130,30);
        jtf = new JTextField();
        jtf.setBounds(180,50,150,30);
        l2 = new JLabel("Enter the password : ");
        l2.setBounds(50,100,130,30);
        jtf1 = new JTextField();
        jtf1.setBounds(180,100,150,30);
        jb = new JButton("submit");
        jb.setBounds(100,150,150,30);
        jta = new JTextArea();
        jta.setBounds(50,50,250,250);
        f.add(l1);f.add(jtf);
        f.add(l2);f.add(jtf1);
        f.add(jb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        jb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        myObjecFile = new File("C:/Users/PANDU/Desktop/"+jtf.getText());
        if(myObjecFile.exists())
        {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(new FileReader(myObjecFile))){
            String str;
            while ((str = buffer.readLine()) != null){
                builder.append(str).append("\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try{
            String str =  builder.toString();
            String[] parts = str.split(" ");
            String lastWord = parts[parts.length - 1];
            sb.append(lastWord);
            String sBuilder2 = sb.reverse().toString();
            revpassword = sBuilder2.toString();
            pass = jtf1.getText();
            Scanner myReader = new Scanner(myObjecFile);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                sb1.append(data);
                sb1.append("\n");
                arr.add(data);
            }
            myReader.close();
            if(ae.getActionCommand()==jb.getActionCommand()){
                if(pass.equals(revpassword.trim())){
                    l3 = new JLabel();
                    l3.setBounds(50,50,300,30);
                    l3.setText(arr.get(0));
                    f1.add(l3);
                    l4 = new JLabel();
                    l4.setBounds(50,100,300,30);
                    l4.setText(arr.get(1));
                    f1.add(l4);
                    l5 = new JLabel();
                    l5.setBounds(50,150,300,30);
                    l5.setText(arr.get(2));
                    f1.add(l5);
                    l6 = new JLabel();
                    l6.setBounds(50,200,300,30);
                    l6.setText(arr.get(3));
                    f1.add(l6);
                    l7 = new JLabel();
                    l7.setBounds(50,250,300,30);
                    l7.setText(arr.get(4));
                    f1.add(l7);
                    l8 = new JLabel();
                    l8.setBounds(50,300,250,30);
                    l8.setText(arr.get(5));
                    f1.add(l8);
                    f1.setSize(450,400);
                    f1.setLayout(null);
                    f1.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"password is  incorrect!");
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"username and password is doesnot enter!");
        }
    }
    else{
        JOptionPane.showMessageDialog(null,"username is not correct! ");
    }
}
    public static void main(String args[]){
        new Login();
    }
}
