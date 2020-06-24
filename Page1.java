import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//Font Page


class Mypic extends Canvas{
	
	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image i=t.getImage("file:///C:/Users/Gaurab/eclipse-workspace/Final_year_project/image/cgec1.jpg");
		g.drawImage(i, 50, 10, this);
		
	}
}
class DigitalWatch1 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch1(){  
      
      
    t = new Thread(this);  
        t.start();  
      
        b=new JButton();
        b.setBounds(0,410,100,50);
          
      
      
 
}  
  
 public void run() {  
      try {  
         while (true) {  
  
            Calendar cal = Calendar.getInstance();  
            hours = cal.get( Calendar.HOUR_OF_DAY );  
            if ( hours > 12 ) hours -= 12;  
            minutes = cal.get( Calendar.MINUTE );  
            seconds = cal.get( Calendar.SECOND );  
  
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
            Date date = cal.getTime();  
            timeString = formatter.format( date );  
  
            printTime();  
  
            t.sleep( 1000 );  // interval given in milliseconds  
         }  
      }  
      catch (Exception e) { }  
 }  
  
public void printTime(){  
b.setText(timeString);  
}  
  

}  

public class Page1  extends DigitalWatch1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f1=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		JLabel l1,l2;
		l1=new JLabel("Cooch Behar Government Engineering College");
		l1.setBounds(130, 70, 600, 100);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l2=new JLabel("Library Management System");
		l2.setBounds(200, 50, 400, 200);
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Times New Roman",Font.ITALIC,28));
		JButton b1,b2;
		b1=new JButton("Admin Login");
		b2=new JButton("Exit");
		b1.setBounds(200, 350, 200, 70);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b2.setBounds(500, 350, 100, 70);
		b2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f1.add(b1);
		f1.add(b2);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page2 p1=new page2();
				page2.main(null);
				f1.dispose();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(f1, "Confrom if you want to exit","Library Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		Mypic m=new Mypic();
		f1.add(m);
		f1.add(l1);
		f1.add(l2);
		DigitalWatch1 d=  new DigitalWatch1();
		Thread t1=new Thread(d);
		t1.start();
		f1.add(b);
	
    
		f1.setSize(800,500);
		f1.setLayout(null);
		f1.setVisible(true);

	}

}
