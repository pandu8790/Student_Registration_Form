import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
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
    String regno;
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
            File myObj = new File("C:/Users/PANDU/Desktop/"+jtf.getText());
            if(myObj.exists()){
                JOptionPane.showMessageDialog(null, " Search is sucess ! file is existed");
                JFrame jFrame = new JFrame();
                ArrayList<String> arrayList = new ArrayList<String>();
                try{
                    Scanner sc = new Scanner(myObj);
                    while(sc.hasNextLine()){
                        arrayList.add(sc.nextLine());
                    }
                    sc.close();
                    } 
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"file not found!");
                    }
                    try{
                    String[] arrregno = arrayList.get(0).split(" ");
                    String regno = arrregno[4];
                    String[] arrname = arrayList.get(1).split(" ");
                    String name = arrname[5];
                    String name1 = arrname[6];
                    String[] arremail = arrayList.get(2).split(" ");
                    String email = arremail[3];
                    String[] arrgender = arrayList.get(3).split(" ");
                    String gender = arrgender[3];
                    String[][] data = {{"Regno",regno},{"Name",name+" "+name1},{"E-mail",email},{"Gender",gender}};
                    String[] col = {"",""};
                    JTable jTable = new JTable(data,col);
                    jTable.setBounds(30,30,30,30);
                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jFrame.add(jScrollPane);
                    jFrame.setSize(400,300);
                    jFrame.setVisible(true);
                    }
                    finally{

                    }
                    
                }
            else{
                JOptionPane.showMessageDialog(null, "Search failed ! file is not existed");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"file is not found!");
        }
    }
    public static void main(String args[]){
        new Search();
    }
}
