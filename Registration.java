package Student;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.IOException;
public class Registration implements ActionListener {
    static JFrame f = new JFrame();
    JLabel  l1,l2,l3,l4,l5,l6,l7;
    JTextField jt1,jt2,jt3,jt4;
    JRadioButton Male , Female;
    JTextArea ta1,ta2;
    ButtonGroup btn_gp;
    JButton jb1,jb2;
    FileWriter fileWriter;
    Registration(){
        System.out.println("sucess");
        l1 = new JLabel("Enter the firstname : ");
        l1.setBounds(100,50,130,30);
        jt1 = new JTextField();
        jt1.setBounds(250,50,150,30);
        l2 = new JLabel("Enter the lastname : ");
        l2.setBounds(100,100,130,30);
        jt2 = new JTextField();
        jt2.setBounds(250,100,150,30);
        l3 = new JLabel("Enter the E-mail : ");
        l3.setBounds(100,150,130,30);
        jt3 = new JTextField();
        jt3.setBounds(250,150,150,30);
        l4 = new JLabel("Enter the gender: ");
        l4.setBounds(100,195,130,30);
        Male = new JRadioButton("male");
        Female = new JRadioButton("Female"); 
        Male.setBounds(250,200,80,20);
        Female.setBounds(350,200,100,20);
        btn_gp = new ButtonGroup();
        btn_gp.add(Male);btn_gp.add(Female);
        l5 = new JLabel("Skills :");
        l5.setBounds(100,250,130,30);
        ta1 = new JTextArea();
        ta1.setBounds(250,250,200,50);
        l6 = new JLabel("Address :");
        l6.setBounds(100,310,130,30);
        ta2 = new JTextArea();
        ta2.setBounds(250,310,200,50);
        jb1 = new JButton("submit");
        jb1.setBounds(170,370,90,50);
        l7 = new JLabel("Enter the reg No : ");
        l7.setBounds(100,10,130,30);
        jt4 = new JTextField();
        jt4.setBounds(250,10,150,30);
        f.add(jb1);
        jb1.addActionListener(this);
        f.add(l1);f.add(jt1);
        f.add(l2);f.add(jt2);
        f.add(l3);f.add(jt3);
        f.add(l4);f.add(Male);f.add(Female);
        f.add(l5);f.add(ta1);
        f.add(l6);f.add(ta2);
        f.add(l7);f.add(jt4);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand()==jb1.getActionCommand())
        {
            try{
                fileWriter = new FileWriter("C:/Users/PANDU/Desktop/"+jt4.getText());
                fileWriter.write("Registrstion no   " +jt4.getText()+"\n");
                fileWriter.write("Name     "+jt1.getText()+" "+jt2.getText()+"\n");
                fileWriter.write("E-mail   "+jt3.getText()+"\n");
                if(Male.isSelected()){
                    fileWriter.write("Gender   "+Male.getActionCommand()+"\n");;
                }
                if(Female.isSelected()){
                    fileWriter.write("Gender    "+Female.getActionCommand()+"\n");
                }
                fileWriter.write("Skills   "+ta1.getText()+"\n");
                fileWriter.write("Address  "+ta2.getText()+"\n");
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "file is sucessfully written");
            }catch (IOException e) {
                JOptionPane.showMessageDialog(null, e+"");
            }
        }
    }
    public static void main (String args[]){
      new Registration();
    }
}
