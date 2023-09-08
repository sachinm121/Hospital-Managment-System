
/*4
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*
*
*
*
 */
//**
package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sheetal
 */
public class  updatePatientInformation extends JPanel implements ActionListener, KeyListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, datetime;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8,dob;
    JRadioButton r1, r2, r3;
    ButtonGroup bg;
    JComboBox cb1;
    //JComboBox date, month, year
    JCheckBox c1, c2;
    JList CList, AList;
    JScrollPane Csp, Asp;
    JButton b1, b2, b3, b4,close;
    JTextArea ta1, ta2;
    String Cselection, Aselection;
    Random ran;
    long first;

    //Constructer to create Panel
     updatePatientInformation(){

        //window header
        l1 = new JLabel();
        l1.setFont(new Font("Tahoma", 1, 24));
        l1.setForeground(new Color(153, 153, 153));
        l1.setText("Update Details");
        add(l1);
        l1.setBounds(20, 10, 300, 50);
//
//        datetime = new JLabel();
//        datetime.setFont(new Font("Tahoma", Font.BOLD, 16));
//        currentdatetime();
//        datetime.setBounds(20, 50, 200, 30);
//        add(datetime);

        b3 = new JButton();

        b3.setFont(new Font("Tahoma", 1, 18));
        b3.setForeground(new Color(153, 153, 153));
        b3.setText("Update");
        add(b3);
        b3.setFocusable(false);
        b3.setBounds(500, 50, 100, 30);

        close = new JButton();
        close.setFont(new Font("Tahoma", 1, 18));
        close.setForeground(new Color(153, 153, 153));
        close.setText("close");
        add(close);
        close.setFocusable(false);
        close.setBounds(620, 50, 100, 30);
        close.addActionListener(this);
        
        
        //unique id of patient
        
        l2 = new JLabel();
        l2.setText("Enter Patient ID: ");
        l2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        add(l2);
        l2.setBounds(20, 50, 210, 30);
        t3 = new JTextField();
        t3.setBounds(220, 50, 120, 30);
        add(t3);
        ImageIcon Image2 = new ImageIcon(getClass().getResource("search.png"));    
         b4 = new JButton();
         b4.setFont(new Font("System",Font.BOLD,16));
         b4.setText("Search");
         b4.setIcon(Image2);
         b4.setFocusable(false);
         b4.setBounds(355,50,120,30);
         add(b4);
         b4.addActionListener(this);
         
        

       // name field 
        l3 = new JLabel();
        l3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l3.setText("Name : ");
        add(l3);
        l3.setBounds(20, 100, 60, 30);

        t1 = new JTextField();
        t1.setBounds(100, 100, 250, 30);
        add(t1);
        t1.addKeyListener(this);

        //Father's name 
        l4 = new JLabel();
        l4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l4.setText("Father's Name: ");
        add(l4);
        l4.setBounds(410, 100, 120, 30);
        t2 = new JTextField();
        add(t2);
        t2.setBounds(540, 100, 250, 30);
        t2.addKeyListener(this);

        //Birthdate label and Field
        l5 = new JLabel();
        l5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l5.setText("Birth Date :");
        add(l5);
        l5.setBounds(20, 150, 90, 20);
        dob = new JTextField();
         add(dob);
        dob.setBounds(120, 150, 150, 30);
        dob.addKeyListener(this);
       
                /*
        
        add(t3);
        t3.setBounds(120, 150, 150, 30);
        t3.addKeyListener(this);
         */
        //Date, month, year combo boxes 
//        String dates[]
//                = {"1", "2", "3", "4", "5",
//                    "6", "7", "8", "9", "10",
//                    "11", "12", "13", "14", "15",
//                    "16", "17", "18", "19", "20",
//                    "21", "22", "23", "24", "25",
//                    "26", "27", "28", "29", "30",
//                    "31"};
//        String months[]
//                = {"Jan", "feb", "Mar", "Apr",
//                    "May", "Jun", "July", "Aug",
//                    "Sup", "Oct", "Nov", "Dec"};
//        String years[]
//                = {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910",
//                    "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920",
//                    "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930",
//                    "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940",
//                    "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950",
//                    "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1949", "1960",
//                    "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970",
//                    "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980",
//                    "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990",
//                    "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000",
//                    "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
//                    "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
//
//        date = new JComboBox(dates);
//        add(date);
//        date.setBounds(100, 150, 45, 30);
//
//        month = new JComboBox(months);
//        add(month);
//        month.setBounds(150, 150, 60, 30);
//
//        year = new JComboBox(years);
//        add(year);
//        year.setBounds(215, 150, 70, 30);

        //Gender 
        l6 = new JLabel();
        l6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l6.setText(" Gender : ");
        add(l6);
        l6.setBounds(320, 150, 80, 30);
        r1 = new JRadioButton();
        r1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        r1.setText("Male");
        add(r1);
        r1.setBounds(400, 150, 70, 30);

        r2 = new JRadioButton();
        r2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        r2.setText("Female");
        add(r2);
        r2.setBounds(480, 150, 93, 30);

        r3 = new JRadioButton();
        r3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        r3.setText("Other");
        add(r3);
        r3.setBounds(570, 150, 93, 30);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        //Age Field
        l7 = new JLabel();
        l7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l7.setText("Age : ");
        add(l7);
        l7.setBounds(670, 150, 40, 30);
        t4 = new JTextField();
        add(t4);
        t4.setBounds(720, 150, 70, 30);
        t4.addKeyListener(this);

        //Blood Group
        l8 = new JLabel();
        l8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l8.setText("  Blood Group :");
        add(l8);
        l8.setBounds(10, 200, 130, 20);
        String[] bgp = {" ", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        cb1 = new JComboBox(bgp);
        add(cb1);
        cb1.setBounds(140, 200, 130, 20);

        //Address Field
        l9 = new JLabel();
        l9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l9.setText("Address :");
        add(l9);
        l9.setBounds(320, 200, 80, 20);
        t5 = new JTextField();
        t5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(t5);
        t5.setBounds(410, 200, 380, 20);
        t5.addKeyListener(this);

        //Email and Contact Info
        l10 = new JLabel();
        l10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l10.setText("Gmail :");
        add(l10);
        l10.setBounds(20, 250, 60, 17);
        t6 = new JTextField();
        t6.setBounds(70, 250, 200, 20);
        add(t6);
        t6.addKeyListener(this);

        l11 = new JLabel();
        l11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l11.setText("Phone No. : ");
        add(l11);
        l11.setBounds(320, 250, 90, 14);
        t7 = new JTextField();
        t7.setBounds(410, 250, 160, 20);
        add(t7);
        t7.addKeyListener(this);
        t8 = new JTextField();
        t8.setBounds(599, 250, 190, 20);
        add(t8);
        t8.addKeyListener(this);

        //Chronical or Allergy
        c1 = new JCheckBox();
        c1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c1.setText(" Is Chronical ?");
        add(c1);
        c1.setBounds(50, 300, 123, 25);

        c2 = new JCheckBox();
        c2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c2.setText("  Is Allergy ?");
        add(c2);
        c2.setBounds(550, 300, 120, 25);

        //Scroll pane list for selecting Disease
        //For Chronical 
        String[] Cillness = {"Addison's disease", "Asthma", "Bronchiectasis", "Cardiac failure",
            "Cardiomyopathy", "Chronic obstructive pulmonary disorder", "Chronic renal disease",
            "Coronary artery disease", "Crohn's disease ", "Diabetes insipidus", "Diabetes mellitus types 1 & 2",
            "Dysrhythmias", "Epilepsy", "Glaucoma", "Haemophilia", "Hyperlipidaemia", "Hypertension",
            "Hypothyroidism", "Multiple sclerosis", "Parkinson's disease", "Rheumatoid arthritis",
            "Schizophrenia", "Systemic lupus erythematosus", "Ulcerative colitis", "ipolar Mood Disorder"};

        CList = new JList(Cillness);
        CList.setFont(new Font("System", Font.PLAIN, 14));
        Csp = new JScrollPane(CList);

        CList.setFixedCellWidth(350);
        CList.setFixedCellHeight(120);

        CList.setVisibleRowCount(7);
        CList.setSelectionBackground(Color.BLUE);
        CList.setFixedCellHeight(20);
        CList.setFixedCellWidth(250);
        Csp.setLocation(10, 350);
        Csp.setSize(150, 160);
        add(Csp);
        b1 = new JButton("Add");
        b1.setFont(new Font("System", Font.BOLD, 24));
        b1.setBounds(170, 350, 225, 35);
        add(b1);
        //text area for selected item 
        ta1 = new JTextArea();
        ta1.setBounds(170, 400, 225, 105);
        ta1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        ta1.setEditable(true);
        add(ta1);

        ta1.setColumns(2);
        //or Allergy 
        //Scroll pane list for selecting Disease

        //For Chronical 
        String[] Aillness = {"Addison's disease", "Asthma", "Bronchiectasis", "Cardiac failure",
            "Cardiomyopathy", "Chronic obstructive pulmonary disorder", "Chronic renal disease",
            "Coronary artery disease", "Crohn's disease ", "Diabetes insipidus", "Diabetes mellitus types 1 & 2",
            "Dysrhythmias", "Epilepsy", "Glaucoma", "Haemophilia", "Hyperlipidaemia", "Hypertension",
            "Hypothyroidism", "Multiple sclerosis", "Parkinson's disease", "Rheumatoid arthritis",
            "Schizophrenia", "Systemic lupus erythematosus", "Ulcerative colitis", "ipolar Mood Disorder"};

        AList = new JList(Aillness);
        AList.setFont(new Font("System", Font.PLAIN, 14));
        Asp = new JScrollPane(AList);

        AList.setFixedCellWidth(350);
        AList.setFixedCellHeight(120);

        add(Asp);

        AList.setVisibleRowCount(7);
        AList.setSelectionBackground(Color.BLUE);
        AList.setFixedCellHeight(20);
        AList.setFixedCellWidth(250);
        Asp.setLocation(445, 350);
        Asp.setSize(150, 160);

        b2 = new JButton("Add");
        b2.setFont(new Font("System", Font.BOLD, 24));
        b2.setBounds(605, 350, 225, 35);
        add(b2);
        //text area for selected item 
        ta2 = new JTextArea();
        ta2.setBounds(605, 400, 225, 105);
        ta2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        ta2.setEditable(true);
        add(ta2);

        //  CList.addListSelectionListener(this);
        //AList.addListSelectionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        //Panel Properties
        setLayout(null);
        setSize(850, 560);
        setVisible(true);

    }

    /* @Override
    public void valueChanged(ListSelectionEvent e) {
        
         Cselection =(String)CList.getSelectedValue();
         Aselection =(String)AList.getSelectedValue();
    }
     */
    @Override
    public void actionPerformed(ActionEvent e) {
               if(e.getSource()==b4)
               {
                   if(t3.getText().equals(""))
                   {
                       JOptionPane.showMessageDialog(null, "No Patient id entered", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                       
                       try{
                           Conn con = new Conn();
                           String pid = t3.getText();
                           String s1 = "Select * From patient Where patient_id = "+pid;
                           ResultSet rs = con.s.executeQuery(s1);
                           if(rs.next())
                           {
                               t1.setText(rs.getString(2));
                               t2.setText(rs.getString(3));
                               dob.setText(rs.getString(4));
                               if(rs.getString(5).equals("Male"))
                               {
                                    r1.setSelected(true);
                               }
                               else if(rs.getString(5).equals("Female"))
                               {
                                   r2.setSelected(true);
                               }
                               else if(rs.getString(5).equals("Other"))
                               {
                                     r3.setSelected(true);
                               }
                               cb1.setSelectedItem(rs.getString(6));
                               t4.setText(rs.getString(14));
                               t5.setText(rs.getString(7));
                               t6.setText(rs.getString(8));
                               t7.setText(rs.getString(9));
                               t8.setText(rs.getString(10));
                               if(rs.getString(11).equals("Chronical"))
                               {
                                   c1.setSelected(true);
                                   ta1.setText(rs.getString(12));
                               }
                               else if(rs.getString(11).equals("Chronical"))
                               {
                                   c2.setSelected(true);
                                   ta2.setText(rs.getString(12));
                                   
                               }
                                   
                               t3.setEditable(false);
                           }
                           else
                           {
                               JOptionPane.showMessageDialog(null, "Wrong Patient ID Entered", "Error", JOptionPane.ERROR_MESSAGE);
                           }
                       }
                       catch(Exception exc){
                           exc.getStackTrace();
                           System.out.println(exc);
                       }
                   }
               }
               else if(e.getSource()==close)
               {
                   int a = JOptionPane.showConfirmDialog(null, "Do you really want to close ?", "Close Confirmation", JOptionPane.YES_NO_OPTION);
                   if(a==0)
                   {
                   setVisible(false);
                   }
                   
                      
               }
            else if (e.getSource() == b1) {
                 if (c1.isSelected()) {
                ta1.append((String) CList.getSelectedValue()+"");

                //JOptionPane.showMessageDialog(null, "Disease added Successfulluy");
                                          } 
                                   } 
            else if (e.getSource() == b2) {
            if (c2.isSelected()) {

                ta2.append((String) AList.getSelectedValue());
                                 }
            else {
                JOptionPane.showMessageDialog(null, "Please Check CheckBox!!");
            }
            }
            else if(e.getSource() == b3) {
                if(t3.getText().equals(""))
                {
                        JOptionPane.showMessageDialog(null, "No patient searched to be updated");
                }
                else{
                    Pattern patt2 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.-]*@gmail[.]com");
                    Pattern pattmob = Pattern.compile("(0/91)?[6-9][0-9]{9}");
                    Matcher gmatch = patt2.matcher(t6.getText());
                    Matcher mobmatch = pattmob.matcher(t7.getText());

                    if (t1.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all Fields");
                    } else if (t2.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all Fields");
                    }  else if((!r1.isSelected()) && (!r2.isSelected()) && (!r3.isSelected()))
                     {
                            JOptionPane.showMessageDialog(null,"Please select gender!!");
                     }else if (t4.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all Fields");
                    } else if (t5.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all Fields");
                    } else if (t6.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all Fields");
                    } else if (t7.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please give contact number");
                    } else if ((!c1.isSelected()) && (!c2.isSelected())) {
                        JOptionPane.showMessageDialog(null, "Please Check check box!!");
                    } else if (c1.isSelected() && c2.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Please Don't Check check both check box!!");
                    } else if (!gmatch.matches()) {
                        JOptionPane.showMessageDialog(null, "Enter mail id in correct format!!", null, JOptionPane.ERROR_MESSAGE);
                        t6.setText("");
                    } else if (!mobmatch.matches()) {
                        JOptionPane.showMessageDialog(null, "Please enter phone valid contact number !!!!", null, JOptionPane.ERROR_MESSAGE);
                        t7.setText("");
                        if (!(t8.getText().equals(""))) {
                            mobmatch = pattmob.matcher(t8.getText());
                            if (!mobmatch.matches()) {
                                JOptionPane.showMessageDialog(null, "Additional contact number is not valid !!!!", null, JOptionPane.ERROR_MESSAGE);
                                t7.setText("");
                            }
                        } else {

                        }
                    } else {

                        //to insert data in datatable
                        try {
                            Conn con1 = new Conn();
                            String k = t1.getText();
                            String l = t2.getText();
                            String DOB = dob.getText();
                             String n = t4.getText();
                            String o = t5.getText();
                            String p = t6.getText();
                            String q = t7.getText();
                            String r = t8.getText();
                            String gen;
                            String bldgrp = (String) cb1.getSelectedItem();
                            String illnessType;
                            String diseases;

                            //gender selection
                            if (r1.isSelected()) {
                                gen = r1.getText();
                            } else if (r2.isSelected()) {
                                gen = r2.getText();
                            } else if (r3.isSelected()) {
                                gen = r3.getText();
                            } else {
                                gen = "Haven't been choosen";
                            }

                            //Disease type 
                            if (c1.isSelected()) {
                                illnessType = "Chronical";
                                
                                if(ta1.getText().equals(""))
                                {
                                   diseases ="No disease mentioned";
                                }
                                else
                                {
                                    diseases = ta1.getText();
                                }

                            } else {
                                illnessType = "Allergy";
                                diseases = ta2.getText();
                                if(ta2.getText().equals(""))
                                {
                                   diseases ="No disease mentioned";
                                }
                                 else
                                {
                                    diseases = ta2.getText();
                                }

                            }

                            //gmail id validation
                            // update query,
 String updateDetails = "update patient set name ='"+k+"', father_name='"+l+"',DOB = '"+DOB
                          +"',gender='"+gen+"',blood_group='"+bldgrp
                          +"',address='"+o+"',email='"+p+"',P_no1='"+q
                          +"',P_no2 = '"+r+"', disease_type ='"+illnessType+"',diseases ='"+diseases+"',Age='"+n+"' where patient_id="+t3.getText();
 
                           con1.s.executeUpdate(updateDetails);
                            JOptionPane.showMessageDialog(null, "Details Updated Successfully for Patient_id "+t3.getText());
                             
                             
                        } catch (Exception exc) {
                            exc.printStackTrace();
                            System.out.println(exc);
                        }
                    }
             }
    }
   }
//date time label 

//    private void currentdatetime() {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        datetime.setText(dtf.format(now));
//
//    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {

            String strname = "[a-zA-Z ]*$";
            // String strdate ="^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
            Pattern patt = Pattern.compile(strname);
            Pattern patt1 = Pattern.compile("[0-9]*$");

            Matcher m;
            if (e.getSource() == t1) {
                m = patt.matcher(t1.getText());
                if (!m.matches()) {
                    t1.setText("");
                    JOptionPane.showMessageDialog(null, "Name can't have digit and special character!!", null, JOptionPane.ERROR_MESSAGE);

                } else {

                }
            } else if (e.getSource() == t2) {
                m = patt.matcher(t2.getText());
                if (!m.matches()) {
                    t2.setText("");
                    JOptionPane.showMessageDialog(null, "Father's Name can't have digit and special character!!", null, JOptionPane.ERROR_MESSAGE);
                } else {

                }
            } else if (e.getSource() == t4) {
                m = patt1.matcher(t4.getText());
                if (!m.matches()) {
                    t4.setText("");
                    JOptionPane.showMessageDialog(null, "Enter only number!!", null, JOptionPane.ERROR_MESSAGE);
                } else {

                }
            } //Validation of father's name field 
            else {

            }
        } catch (Exception exce) {
            exce.printStackTrace();

            System.out.println(exce);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
 }
