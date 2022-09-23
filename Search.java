package Student;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
public class Search implements ActionListener{
    static JFrame f = new JFrame();
    JLabel l1,l2;
    JTextField jtf;
    JTextArea jta;
    JPasswordField jpf;
    JButton jb ;
    FileReader fileReader;
    FileWriter fileWriter;
    String s1 = "";
    Search(){
        l1 = new JLabel("Enter the filename : ");
        l1.setBounds(50,50,130,30);
        jtf = new JTextField();
        jtf.setBounds(180,50,150,30);
        jb = new JButton("submit");
        jb.setBounds(100,150,150,30);
        f.add(l1);f.add(jtf);f.add(jb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        jb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand()==jb.getActionCommand()){
            File myObj = new File(jtf.getText());
            if(myObj.exists()){
                JOptionPane.showMessageDialog(null, " Search is sucess ! file is existed");
            }
            else{
                JOptionPane.showMessageDialog(null, "Search failed ! file is not existed");
            }
        }
    }
    public static void main(String args[]){
        new Search();
    }
}
