import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
public class MainStu implements ActionListener{
    JButton b1,b2,b3;
    MainStu(){
        JFrame f = new JFrame();
        b1 = new JButton("Registration");
        b1.setBounds(50,50,150,20);
        b2 = new JButton("login");
        b2.setBounds(50,100,150,20);
        b3 = new JButton("Search");
        b3.setBounds(50,150,150,20);
        f.add(b1);f.add(b2);f.add(b3);
        f.setSize(450,450);
        f.setLayout(null);
        f.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()==b1.getActionCommand()){
            new Registration();
        }
        else if(e.getActionCommand()==b2.getActionCommand()){
            new Login();
        }
        else if(e.getActionCommand()==b3.getActionCommand()){
            new Search();
        }
    }
    public static void main(String args[]){
        new MainStu();
    }
}
