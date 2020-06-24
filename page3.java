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
// Main Page

class DigitalWatch3 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch3(){  
      
      
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
public class page3 extends DigitalWatch3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f3=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		
		JLabel l8,l9,l20;
		l20=new JLabel("Main Manu Page");
		l20.setBounds(10, 10, 100, 20);
		l20.setForeground(Color.BLUE);
		l20.setFont(new Font("Times New Roman",Font.ITALIC,11));
		l8=new JLabel("Cooch Behar Government Engineering College");
		l8.setBounds(230, 10, 600, 40);
		l8.setForeground(Color.BLUE);
		l8.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l9=new JLabel("Library Management System");
		l9.setBounds(400, 60, 400, 40);
		l9.setForeground(Color.BLUE);
		l9.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f3.add(l8);
		f3.add(l9);
		f3.add(l20);
		JButton b7,b8,b9,b10,b11,b12,b30,b31,b32;
		b7=new JButton("Add Book");
		b8=new JButton("Stock Search");
		b9=new JButton("Issue Book");
		b10=new JButton("Return Book");
		b11=new JButton("Issued Books of a Student");
		b30=new JButton("Departmental Book Search");
		b31=new JButton("Delete Student Account");
		b32=new JButton("Delete  Book");
		b12=new JButton("Exit");
		b7.setBounds(130, 70, 200, 70);
		b7.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b8.setBounds(130, 160, 200, 70);
		b8.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b9.setBounds(130, 250, 200, 70);
		b9.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b10.setBounds(130, 340, 200, 70);
		b10.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b11.setBounds(370, 120, 235, 70);
		b11.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b12.setBounds(650, 330, 100, 40);
		b12.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b30.setBounds(370, 200, 235, 70);
		b30.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b31.setBounds(370, 280, 235, 70);
		b31.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b32.setBounds(370, 360, 235, 70);
		b32.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		b7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page4 p4=new page4();
				page4.main(null);
				f3.dispose();
			}
		});
		b8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page9 p9=new page9();
				page9.main(null);
				f3.dispose();
			}
		});
		b30.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page5 p5=new page5();
				page5.main(null);
				f3.dispose();
			}
		});
		b9.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page6 p6=new page6();
				page6.main(null);
				f3.dispose();
			}
		});
		b10.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page7 p7=new page7();
				page7.main(null);
				f3.dispose();
			}
		});
		b11.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page8 p8=new page8();
				page8.main(null);
				f3.dispose();
			}
		});
		
		b31.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page10 p20=new page10();
				page10.main(null);
				
				f3.dispose();
			}
		});

		b32.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				page11 p21=new page11();
				page11.main(null);
				f3.dispose();
		
	}
});
		b12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(f3, "Confrom if you want to exit","Library Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
		f3.add(b7);
		f3.add(b8);
		f3.add(b9);
		f3.add(b10);
		f3.add(b11);
		f3.add(b12);
		f3.add(b30);
		f3.add(b31);
		f3.add(b32);
		DigitalWatch3 d=  new DigitalWatch3();
		Thread t1=new Thread(d);
		t1.start();
		f3.add(b);
		
		f3.setSize(800,500);
		f3.setLayout(null);
		f3.setVisible(true);

	}

}
