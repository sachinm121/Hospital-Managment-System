/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sheetal Sachin 
 */
public class AssignWR extends JFrame implements ActionListener, MouseListener {

    JPanel p1;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2;
    JComboBox c1, c2;
    JButton b1, b3;
    String wno[] = {"01", "02", "03"};

    AssignWR(){
        p1 = new JPanel();
        p1.setLayout(null);
        this.add(p1);
        l1 = new JLabel("Assign a ward and room no.");
        l1.setFont(new Font("System", Font.BOLD, 30));
        l1.setBounds(150, 30, 400, 50);
        p1.add(l1);

        l2 = new JLabel("Patient Id: ");
        l2.setFont(new Font("System", Font.BOLD, 22));
        l2.setBounds(180, 100, 110, 30);
        p1.add(l2);
        t1 = new JTextField();
        t1.setFont(new Font("System", Font.BOLD, 22));
        t1.setBounds(300, 100, 200, 30);
        p1.add(t1);

        l3 = new JLabel("Patient Name: ");
        l3.setFont(new Font("System", Font.BOLD, 22));
        l3.setBounds(140, 140, 180, 30);
        p1.add(l3);
        t2 = new JTextField();
        t2.setFont(new Font("System", Font.BOLD, 22));
        t2.setBounds(300, 140, 200, 30);
        p1.add(t2);

        l4 = new JLabel("Ward No.: ");
        l4.setFont(new Font("System", Font.BOLD, 22));
        l4.setBounds(180, 180, 110, 30);
        p1.add(l4);

        c1 = new JComboBox(wno);
        c1.setFont(new Font("System", Font.BOLD, 18));
        c1.setBounds(300, 180, 200, 30);
        p1.add(c1);

        l5 = new JLabel("Room No.: ");
        l5.setFont(new Font("System", Font.BOLD, 22));
        l5.setBounds(172, 220, 120, 30);
        p1.add(l5);

        c2 = new JComboBox();
        UpdateC2();
        c2.setFont(new Font("System", Font.BOLD, 18));
        c2.setBounds(300, 220, 200, 30);
        p1.add(c2);
        c2.addMouseListener(this);

        b1 = new JButton("Assign");
        b1.setFont(new Font("System", Font.BOLD, 22));
        b1.setFocusable(false);
        b1.setBounds(270, 280, 150, 40);
        p1.add(b1);
        b1.addActionListener(this);

        b3 = new JButton();
        b3.setFocusable(false);
        b3.setIcon(new ImageIcon(getClass().getResource("/hospitalmanagementsystem/backArrow.png")));
        b3.setBounds(20, 10, 50, 50);
        p1.add(b3);
        b3.addActionListener(this);

        this.setSize(700, 400);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocation(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIcontImage();

    }

    public static void main(String[] args) {
        new AssignWR();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {

            new Homepage().setVisible(true);
            setVisible(false);

        } else if (e.getSource() == b1) {
            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Id", "Unvalid Information", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("exitIcon.png")));
            } else if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Name", "Unvalid Information", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("exitIcon.png")));
            } else {
                try {

                    Conn con = new Conn();
                    String pid = t1.getText();
                    String name = t2.getText();
                    String wno = (String) c1.getSelectedItem();
                    String rno = (String) c2.getSelectedItem();
                    String q1 = "Select * From assigned_room where patient_id ='" + t1.getText() + "'";
                    String q2 = "Select * From patient where patient_id =" + t1.getText() + " and name ='" + t2.getText() + "'";
                    String q3 = "insert into assigned_room values('" + pid + "'," + wno + "," + rno + ")";
                    String updateRoomStatus = "Update room set RoomStatus ='Unavail' Where wardno = " + wno + " and roomno = " + rno;
                    ResultSet rs1 = con.s.executeQuery(q1);

                    if (rs1.next()) {
                        int wano = rs1.getInt("ward_no");
                        int rono = rs1.getInt("room_no");
                        JOptionPane.showMessageDialog(null, "Patient already admitted in room no " + rono + " of ward no " + wano);
                    } else {

                        rs1 = con.s.executeQuery(q2);

                        if (rs1.next()) {
                            con.s.executeUpdate(q3);
                            con.s.executeUpdate(updateRoomStatus);
//                     AssignDoctor d1 = new AssignDoctor(this,true);
//                     d1.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Admitted Succesfully!!", "Successfully", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("exitIcon.png")));
                        } else {

                            JOptionPane.showMessageDialog(null, "Wrong Patient Id or Name");
                        }

                    }
                } catch (Exception exc) {
                    exc.printStackTrace();
                    System.out.println(exc);
                }
            }
        }
    }

    private void setIcontImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/hospitalmanagementsystem/WinIcon.png")));
    }

    private void UpdateC2() {

        try {
            Conn con = new Conn();
            String s = (String) c1.getSelectedItem();
            c2.removeAllItems();
            String q = "Select roomno from room where wardno = " + s + " and RoomStatus='Available'";
            ResultSet rs = con.s.executeQuery(q);
            while (rs.next()) {
                c2.addItem(rs.getString("roomno"));
            }
        } catch (Exception exc) {

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == c2) {
            UpdateC2();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
