import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Admin Login Page
class DigitalWatch21 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch21(){  
      
      
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

public class page2  extends DigitalWatch21{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f2=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		JLabel l3=new JLabel("User Name");
		JLabel l4=new JLabel("Password");
		l3.setBounds(100, 150, 120, 50);
		
		l3.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l4.setBounds(100, 210, 80, 50);
		
		l4.setFont(new Font("Sylfaen",Font.PLAIN,18));
		f2.add(l3);
		f2.add(l4);
		JTextField ft1=new JTextField("Enter your user id");
		ft1.setBounds(220, 152, 150, 30);
		f2.add(ft1);
		JPasswordField jp1=new JPasswordField();
		jp1.setBounds(220, 220, 150, 30);
		f2.add(jp1);
		JLabel l5,l6,l7;
		l5=new JLabel("Cooch Behar Government Engineering College");
		l5.setBounds(230, 10, 600, 40);
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l6=new JLabel("Library Management System");
		l6.setBounds(400, 60, 400, 40);
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l7=new JLabel("Admin Login Page");
		l7.setBounds(10, 10, 100, 20);
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Times New Roman",Font.ITALIC,11));
		f2.add(l3);
		f2.add(l4);
		f2.add(l5);
		f2.add(l6);
		f2.add(l7);
		JButton b3,b4,b5,b6;
		b3=new JButton("Login");
		b4=new JButton("Reset");
		b5=new JButton("Exit");
		b6=new JButton("Back");
		
		b3.setBounds(100, 350, 100, 70);
		b3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b4.setBounds(250, 350, 100, 70);
		b4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b5.setBounds(400, 350, 100, 70);
		b5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b6.setBounds(550, 350, 100, 70);
		b6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userid=ft1.getText();
				String password=jp1.getText();
				if(userid.contains("Admin") && password.contains("cgec2016")) {
					page3 p2=new page3();
					page3.main(null);
					f2.dispose();
			}
				else {
					JOptionPane.showMessageDialog( f2, "Invalid Input");
				}
					}
				
			
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ft1.setText(null);
				jp1.setText(null);
			}
		});
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(f2, "Confrom if you want to exit","Library Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Page1 p3=new Page1();
				Page1.main(null);
				f2.dispose();
			}
		});
		f2.add(b3);
		f2.add(b4);
		f2.add(b5);
		f2.add(b6);
		DigitalWatch21 d=  new DigitalWatch21();
		Thread t1=new Thread(d);
		t1.start();
		f2.add(b);
		
		f2.setSize(800,500);
		f2.setLayout(null);
		f2.setVisible(true);

	}

}
