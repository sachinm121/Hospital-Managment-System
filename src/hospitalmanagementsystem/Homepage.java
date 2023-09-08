/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 

/**
 *
 * @author Sheetal
 * Now this is Our Homepage of HMS Which direct to all the facilities of Hospital
 * and First window after login, if you take exit you will have to do login again
 */
public class Homepage extends JFrame implements ActionListener{
    JLabel l1,HpBg,HN;
    JMenuBar menuBar;
  PatientRegistrationPane r1 = new PatientRegistrationPane();
  updatePatientInformation upi = new updatePatientInformation();
  AboutHospital asp = new AboutHospital();
          
   //emp menu
   JMenu employeeMenu ;
    JMenuItem empItem1;
    JMenuItem empItem2;
    JMenuItem empItem3;
    
    
    //Daily Tasks Menu
    JMenu dailyTaskMenu;
    JMenuItem dtItem1;
    JMenuItem dtItem2;
    JMenuItem dtItem3;
    JMenuItem dtItem4;
    
    //search Dialog Component 
    JTable table;
     JButton cButton,searchButton;
     JTextField SearchBar;
    
    //Buttons
    JButton b1,b2,b3,b4,b5,b6,b7,dis;
    JPanel p1,p;
     
    JScrollBar bar = new JScrollBar();
         
     
    JDialog d1 = new JDialog();
    Homepage()
    {
          
         HN = new JLabel();
         HN.setText("Royal Hospital");
         HN.setFont(new Font("Sylfaen",Font.BOLD,42));
         HN.setForeground(Color.DARK_GRAY);
         HN.setBounds(340,20,300,50);
         this.add(HN);
        /* Menu Bar Coding*/
         
//        menuBar = new JMenuBar();
//         this.setJMenuBar(menuBar);
//
//         
//          
//          //emp menu
//         employeeMenu = new JMenu("Employee");
//         menuBar.add(employeeMenu);
//         empItem1 = new JMenuItem("Add");
//         employeeMenu.add(empItem1);
//       
//           empItem2 = new JMenuItem("Search");
//         employeeMenu.add(empItem2);
//       
//         empItem3 = new JMenuItem("Update");
//         employeeMenu.add(empItem3);
//         
         
        //Daily Tasks Menu  
        
        /* dailyTaskMenu = new JMenu("Daily Tasks");
         menuBar.add(dailyTaskMenu);
         dtItem1 = new JMenuItem("Daily Attendence");
         dailyTaskMenu.add(dtItem1);
         
         dtItem2 = new JMenuItem("View Attendence");
         dailyTaskMenu.add(dtItem2);
         
         dtItem3 = new JMenuItem("View Patients Visit");
         dailyTaskMenu.add(dtItem3);
         
         dtItem4 = new JMenuItem("View Daily Work");
         dailyTaskMenu.add(dtItem4);*/
         //   
    
         //Buttons Coding for Panel
        p1 = new JPanel();
        p1.setBounds(890,0,230,650);
        p1.setLayout(null);
       
       ImageIcon Image1 = new ImageIcon(getClass().getResource("add new patient.png"));    
         b1 = new JButton();
         b1.setFont(new Font("System",Font.BOLD,18));
         b1.setText("Add Patient");
         b1.setIcon(Image1);
         b1.setBounds(0,10,220,60);
         b1.setFocusable(false);
         p1.add(b1);
             
         ImageIcon Image2 = new ImageIcon(getClass().getResource("search.png"));    
         b2 = new JButton();
         b2.setFont(new Font("System",Font.BOLD,18));
         b2.setText("Patient Search");
         b2.setIcon(Image2);
         b2.setFocusable(false);
         b2.setBounds(0,100,220,60);
         
         p1.add(b2);
         
         ImageIcon Image3 = new ImageIcon(getClass().getResource("admitPatient.jpg"));    
         b3 = new JButton();
         b3.setFont(new Font("System",Font.BOLD,18));
         b3.setText("Admit");
         b3.setIcon(Image3);
         b3.setFocusable(false);
         b3.setBounds(0,190,220,60);
         p1.add(b3);
       
         ImageIcon Image4 = new ImageIcon(getClass().getResource("dischargePatient.png"));
          dis = new JButton();
         dis.setFont(new Font("System",Font.BOLD,18));
         dis.setText("Discharge");
         dis.setIcon(Image4);
         dis.setFocusable(false);
         dis.setBounds(0,270,220,60);
         p1.add(dis);
         dis.addActionListener(this);
       
         
         ImageIcon Image5 = new ImageIcon(getClass().getResource("rsz_update_details.png"));   
         b4 = new JButton();
         b4.setFont(new Font("System",Font.BOLD,12));
         b4.setText("Update Patient Details");
         b4.setIcon(Image5);
         b4.setFocusable(false);
         b4.setBounds(0,350,240,60);
         p1.add(b4);
         
         ImageIcon Image6 = new ImageIcon(getClass().getResource("rsz_hospital_information.png"));   
         b5 = new JButton();
         b5.setFont(new Font("System",Font.BOLD,18));
         b5.setText("About Hospital");
         b5.setIcon(Image6);
         b5.setFocusable(false);
         b5.setBounds(0,440,220,60);
         p1.add(b5);
         
         ImageIcon Image7 = new ImageIcon(getClass().getResource("exitnew.png"));   
         b6 = new JButton();
         b6.setFont(new Font("System",Font.BOLD,18));
         b6.setText("Logout");
         b6.setIcon(Image7);
         b6.setFocusable(false);
         b6.setBounds(0,530,220,60);
          p1.add(b6);
         /*
        b7 = new JButton();
        b7.setFocusable(false);
        b7.setIcon(new ImageIcon(getClass().getResource("/hospitalmanagementsystem/backArrow.png")));
        b7.setBounds(20, 10, 50, 50);
        add(b7);
        */ 

         b1.addActionListener(this);
         b2.addActionListener(this);   
         b3.addActionListener(this);   
         b4.addActionListener(this);   
         b5.addActionListener(this);
         b6.addActionListener(this);
         //b7.addActionListener(this);
         
         //First Window Panel;
       //BackGround    
        HpBg = new JLabel();
        HpBg.setIcon(new ImageIcon(getClass().getResource("/hospitalmanagementsystem/defaultbg.jpg")));
        HpBg.setBounds(0, 0,850,560);
          

         p = new JPanel();
         p.setBounds(10,70,850,560);
         p.add(HpBg);
         add(p);
         p.setVisible(true);
        
         
        
          
         //Registration pel
         //Frame Properties
         add(p1);
         
         setTitle("Homepage");
         setLayout(null);
        setVisible(true);
        setSize(1120,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(120,50);
         
         
        setIcontImage();
        
    }
      
    @Override
    public void actionPerformed(ActionEvent ae)
    { 
       
        if(ae.getSource()==b1)
        {
            r1 = new PatientRegistrationPane();
             add(r1);
            r1.setBounds(10,70,850,560);
            
            
            if(p.isShowing()){
           
                 r1.setVisible(true);
//                 try {
//                     Thread.sleep(10, 10);
//                 } catch (InterruptedException ex) {
//                     Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
//                 }
            
                 p.setVisible(false);
           
            }
            else if(r1.isShowing())
            {   
                r1.create_unique_Id();
            }
           else if(asp.isShowing())
           {
            r1.setVisible(true);
            asp.setVisible(false);
           }
           
           else if(upi.isShowing())
           {
             r1.setVisible(true);
             upi.setVisible(false);
           }
         }
         
        else if(ae.getSource()==b2)
        { 
            jdb searchD = new jdb(this,true);
               searchD.setLocation(300,200);
               searchD.setResizable(false);
               searchD.setSize(848,315);
              
           if(r1.isShowing())
             {
              r1.setVisible(false);
               p.setVisible(true);
               searchD.setVisible(true);
             }
           else if(asp.isShowing()){
 
              asp.setVisible(false);
                p.setVisible(true);
                searchD.setVisible(true);
            }
           else if(p.isShowing())
           {
                searchD.setVisible(true);
               
           }else if(upi.isShowing())
           {
               upi.setVisible(true);
                p.setVisible(true);
                searchD.setVisible(true);
           }
        }
        else if(ae.getSource()==dis)
        {
            new discharge().setVisible(true);
            setVisible(false);
        }
        else if (ae.getSource()==b3)
        {
            setVisible(false);
            new AssignWR().setVisible(true);
        }
        else if(ae.getSource()==b4)
        {
            upi = new updatePatientInformation();
             add(upi);
            upi.setBounds(10,70,850,560);
            if(asp.isShowing())
           {
             upi.setVisible(true);
            asp.setVisible(false);
           
            }
           else if(p.isShowing()){
            upi.setVisible(true);
            p.setVisible(false);
            }
           else if(r1.isShowing())
           {
             upi.setVisible(true);
             r1.setVisible(false);
           }
        }
        else if(ae.getSource()==b5)
        {
            add(asp);
             
            asp.setBounds(10,70,850,560);
           
            
            if(r1.isShowing()){
             asp.setVisible(true);
            r1.setVisible(false);
                
            }
            else if(p.isShowing())
            {
                 
              
            asp.setVisible(true);
            p.setVisible(false);
            
            }
            else if(upi.isShowing())
            {
                 
            asp.setVisible(true);
           upi.setVisible(false);
            
            }
            else
            {
               asp.setVisible(true);    
            }
        }
        else if(ae.getSource()==b6)
            {
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to close ?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                   if(a==0)
                   {
                new Login().setVisible(true);
                setVisible(false);
            
                   }
                }
        
    }

    
    public static void main(String[]  args)
     {
        new Homepage().setVisible(true);
     }

    private void setIcontImage() {
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/hospitalmanagementsystem/WinIcon.png")));
    }
      
     
    
}

