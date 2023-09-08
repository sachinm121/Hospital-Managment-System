 
package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Sheetal
 */
public class HMS1 extends JFrame implements ActionListener {
    HMS1()
    {
          
          setTitle("Hospital Management System");
          getContentPane().setLayout(null);
          //backgroud of homepage
          JLabel bg= new JLabel();
          bg.setIcon(new ImageIcon(getClass().getResource("/hospitalmanagementsystem/ImageandIcon_1.jpg")));
          getContentPane().add(bg);
          bg.setBounds(1,1,1024,530);
         
        //Login Button 
          JButton b1 = new JButton();
          b1.setIcon(new ImageIcon(getClass().getResource("Log.png")));
          getContentPane().add(b1);
          b1.setBounds(450,400,80,80);
        
        
        
         setVisible(true);
         setSize(1024,530);
         setLocation(180,80);
         this.setResizable(false);
         setIconImage();  
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         b1.addActionListener(this);
    
    }//end of constructor
    
    //button b1 actionListenet
    
    public void actionPerformed(ActionEvent e)
    {
          new Login().setVisible(true);
          setVisible(false);
          
          
    }
     public static void main(String[] args) {
         
            new HMS1().setVisible(true);
     }
    
  
    private void setIconImage() {
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("WinIcon.png")));
    }
}//end of class Homeopage
  
