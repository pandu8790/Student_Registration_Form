import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
public class MainStu implements ActionListener{  
JFrame f;  
JTextArea ta;
JButton jb,jb1,jb2;
MainStu(){  
    f=new JFrame();  
    JPanel p1=new JPanel();   
    JPanel p2=new JPanel();  
    JPanel p3=new JPanel();  
    JTabbedPane tp=new JTabbedPane();  
    tp.setBounds(50,50,300,300);  
    tp.add("Registration",p1);
    tp.add("Login",p2);  
    tp.add("Search",p3); 
    jb = new JButton("Register");
    jb.addActionListener(this);
    p1.add(jb);
    jb1 = new JButton("Login");
    jb1.addActionListener(this);
    p2.add(jb1);
    jb2 = new JButton("Search");
    jb2.addActionListener(this);
    p3.add(jb2);
    f.add(tp);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}
public void actionPerformed(ActionEvent e){
    if(e.getActionCommand()==jb.getActionCommand()){
        new Registration();
    }
    if(e.getActionCommand()==jb1.getActionCommand()){
        new Login();
    }
    if(e.getActionCommand()==jb2.getActionCommand()){
        new Search();
    }
}
public static void main(String[] args) {  
    new MainStu();  
}}  
