/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;
import javax.swing.*;
 
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Sheetal
 */
public class Login extends JFrame implements ActionListener{
    JLabel WlcmMsg,LoginBg,Role,UserId,Password, LIcon;
    //JComboBox RoleCB;
    JTextField UserIdTF;
    JPasswordField UserPF;
    JButton b1,b2;
    JProgressBar bar;
    Login()
    {
        getContentPane().setLayout(null);
        
        LIcon = new JLabel();
        ImageIcon Image = new ImageIcon(getClass().getResource("LogIcon.jpg"));
        LIcon.setSize(200,200);
        LIcon.setIcon(Image);
        LIcon.setBounds(10,120,200,200);
        getContentPane().add(LIcon);
        
        //WlcmMsg Label
        WlcmMsg = new JLabel("Welcome You on Login Window");
        WlcmMsg.setFont(new Font("System",Font.BOLD,28));
        WlcmMsg.setBounds(160,50,450,40);
        WlcmMsg.setForeground(Color.WHITE);
        getContentPane().add(WlcmMsg);
        
        
        //Role Label
       /* Role = new JLabel("Select Role :");
        Role.setFont(new Font("System",Font.BOLD,24));
        Role.setBounds(250,150,200,40);
        Role.setForeground(Color.WHITE);
        getContentPane().add(Role);
        //Role ComboBox
        String[] Roles = {"Admin","Accountant","Doctor","Receptionist"};
        RoleCB = new JComboBox(Roles);
        RoleCB.setFont(new Font("System",Font.BOLD,18));
        RoleCB.setBounds(420,160,300,30);
        getContentPane().add(RoleCB);
        */

        //User Id Label
        UserId = new JLabel("User Id:");
        UserId.setFont(new Font("System",Font.BOLD,24));
        UserId.setBounds(298,150,200,40);
        UserId.setForeground(Color.WHITE);
        getContentPane().add(UserId);
        //User Id TextField
        UserIdTF = new JTextField();
        UserIdTF.setFont(new Font("System",Font.BOLD,18));
        UserIdTF.setBounds(420,150,300,30);
        UserIdTF.setForeground(Color.BLACK);
        getContentPane().add(UserIdTF);
        
        //Password Field code      
        
        Password = new JLabel("Password :");
        Password.setFont(new Font("System",Font.BOLD,24));
        Password.setBounds(266,200,200,40);
        Password.setForeground(Color.WHITE);
        getContentPane().add(Password);
        
        UserPF = new JPasswordField();
        UserPF.setFont(new Font("System",Font.BOLD,18));
        UserPF.setBounds(420,200,300,30);
        UserPF.setForeground(Color.BLACK);
        getContentPane().add(UserPF);
        
        
       //Back, and Login buttons
       b1 = new JButton();
       b1.setText("Back");
       b1.setFont(new Font("System",Font.BOLD,12));
       b1.setForeground(new Color(51,86,255));
       b1.setVerticalTextPosition(JButton.TOP);
       b1.setHorizontalTextPosition(JButton.CENTER);
       b1.setFocusable(false);
       b1.setIcon(new ImageIcon(getClass().getResource("/hospitalmanagementsystem/backArrow.png")));
       b1.setBounds(20,10,80,80);
       getContentPane().add(b1);

       b2 = new JButton("LOGIN");
       b2.setFont(new Font("System",Font.BOLD,18));
       b2.setBackground(new Color(0,171,255));
       b2.setFocusable(false);
       b2.setForeground(Color.WHITE);
       b2.setBounds(420,270,120,40);
       getContentPane().add(b2);
       
       
       b1.addActionListener(this);
       b2.addActionListener(this);
        //Login Background Label Code 
        
         
        LoginBg = new JLabel();
        LoginBg.setIcon(new ImageIcon(getClass().getResource("/hospitalmanagementsystem/LoginBG.jpg")));
         
        getContentPane().add(LoginBg);
        LoginBg.setBounds(0,0,760,450);
        
        
        //adding Action listener to the buttons
        
    
        
         
        setVisible(true);
        setLocation(300,150);
        setSize(760,470);
        setTitle("Login Page");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage();
         
    }

    public void actionPerformed(ActionEvent e)
    {
        try{
        
             Conn c1 = new Conn();
            //String a = (String)RoleCB.getSelectedItem();
            String b =UserIdTF.getText();
            String c =UserPF.getText();
            String q ="Select * From users where UserId='"+b+"' and Password='"+c+"'";
            ResultSet rs=c1.s.executeQuery(q);
           
            if(e.getSource()==b1)
            {
            new HMS1().setVisible(true);
            setVisible(false);
            }
        else if(e.getSource()==b2)
        {
            if(UserIdTF.getText().equals("") || UserPF.getText().equals(""))
            {
                 JOptionPane.showMessageDialog(null,"Fill both field","Unvalid Information",JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("exitIcon.png")));
            }
            else{
            if(rs.next())
            {
                String qqq ="Select * From usersdetails where id ='"+b+"'";
                rs = c1.s.executeQuery(qqq);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Welcome "+rs.getString(3)+" , You've Succefully logged in.","Login Information",JOptionPane.INFORMATION_MESSAGE);
               if(rs.getString(2).equals("Admin"))
                  {
                   new AdminLog().setVisible(true);
                   setVisible(false);
                  }
               else{
                   new Homepage().setVisible(true);
                   this.setVisible(false);
                  }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"User Type is not specified","Unvalid Information",JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("exitIcon.png")));
                }
            }
            else
            {
                //JOptionPane.showMessageDialog(null,"You are not a valid user.Please enter right password","Unvalid Information",JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null,"You are not a valid user. Please enter correct information","Unvalid Information",JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("exitIcon.png")));
            }
             
            }
             
            
        }
        }
            catch(Exception ae)
            {
               ae.printStackTrace();
               System.out.println(ae);
            }
                
        }
            
    public static void main(String[] args)
    {
        new Login().setVisible(true);
    }
     private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/hospitalmanagementsystem/WinIcon.png")));
    }
}
