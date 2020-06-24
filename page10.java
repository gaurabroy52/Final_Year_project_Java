import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//Delete Student account

class DigitalWatch10 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch10(){  
      
      
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
public class page10 extends DigitalWatch10{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f10=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		
		JLabel l53;
		l53=new JLabel("Delete Student Account");
		l53.setBounds(10, 10, 150, 20);
		l53.setForeground(Color.BLUE);
		f10.add(l53);
		
		JLabel l54,l55;
		l54=new JLabel("Cooch Behar Government Engineering College");
		l54.setBounds(230, 10, 600, 40);
		l54.setForeground(Color.BLUE);
		l54.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l55=new JLabel("Library Management System");
		l55.setBounds(400, 60, 400, 40);
		l55.setForeground(Color.BLUE);
		l55.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f10.add(l54);
		f10.add(l55);
		
		JLabel l59;
		l59=new JLabel("Roll No");
		l59.setBounds(10, 100, 100, 20);
		l59.setForeground(Color.BLUE);
		f10.add(l59);
		JTextField ft26=new JTextField("Enter the Roll No");
		ft26.setBounds(120, 100, 150, 20);
		f10.add(ft26);
		
		JButton b34,b35,b36,b37;
		b34=new JButton("Search");
		b35=new JButton("Reset");
		b36=new JButton("Delete");
		b37=new JButton("Back");
		b34.setBounds(50, 130, 100, 40);
		b34.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b35.setBounds(300, 130, 100, 40);
		b35.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		
		b36.setBounds(600, 300, 100, 50);
		b36.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b37.setBounds(550, 130, 100, 40);
		b37.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f10.add(b34);
		f10.add(b35);
		f10.add(b36);
		f10.add(b37);
		JLabel l60;
		l60=new JLabel("Student Name");
		l60.setBounds(20, 200, 100, 20);
		l60.setForeground(Color.BLUE);
		f10.add(l60);
		JLabel l61;
		l61=new JLabel("Department");
		l61.setBounds(20, 240, 100, 20);
		l61.setForeground(Color.BLUE);
		f10.add(l61);
		JLabel l62;
		l62=new JLabel("Phone No");
		l62.setBounds(20, 280, 100, 20);
		l62.setForeground(Color.BLUE);
		f10.add(l62);
		JLabel l63;
		l63=new JLabel("Semister");
		l63.setBounds(20, 320, 100, 20);
		l63.setForeground(Color.BLUE);
		f10.add(l63);
		JLabel l64;
		l64=new JLabel("Fine");
		l64.setBounds(20, 360, 100, 20);
		l64.setForeground(Color.BLUE);
		f10.add(l64);
		
		JTextField ft27=new JTextField();
		ft27.setBounds(150, 200, 250, 30);
		f10.add(ft27);
		JTextField ft28=new JTextField();
		ft28.setBounds(150, 240, 250, 30);
		f10.add(ft28);
		JTextField ft29=new JTextField();
		ft29.setBounds(150, 280, 250, 30);
		f10.add(ft29);
		JTextField ft30=new JTextField();
		ft30.setBounds(150, 320, 250, 30);
		f10.add(ft30);
		JTextField ft31=new JTextField();
		ft31.setBounds(150, 360, 250, 30);
		f10.add(ft31);
		
		
		b34.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rollno9=Integer.parseInt(ft26.getText());
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con7=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst17=con7.prepareStatement("select * from table2 where ROLLNO=?");
					pst17.setInt(1,rollno9);
					ResultSet rst10=pst17.executeQuery();
					if(rst10.next())
					{
						String Studentname=rst10.getString("STUDENTNAME");
						String Dept=rst10.getString("DEPT");
						int Phone=rst10.getInt("PHONE");
						int Sem=rst10.getInt("SEMISTER");
						int Fine=rst10.getInt("FINE");
						String str1=String.valueOf(Phone);
						String str2=String.valueOf(Sem);
						String str3=String.valueOf(Fine);
						ft27.setText(Studentname);
						ft28.setText(Dept);
						ft29.setText(str1);
						ft30.setText(str2);
						ft31.setText(str3);
						
					}
					else {
						JOptionPane.showMessageDialog( f10, "The System don't have any data regarding this student");
					}
					con7.close();
				}catch(Exception e9)
				{
					e9.printStackTrace();
				}
				
			}
		});
		b35.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				ft26.setText(null);
				ft27.setText(null);
				ft28.setText(null);
				ft29.setText(null);
				ft30.setText(null);
				ft31.setText(null);
				
			}
		});
		b36.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rollno10=Integer.parseInt(ft26.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con8=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst18=con8.prepareStatement("delete from table2 where ROLLNO=?");
					pst18.setInt(1,rollno10);
					pst18.executeUpdate();
					JOptionPane.showMessageDialog( f10, "The Student Entity is remove from the System");

					ft26.setText(null);
					ft27.setText(null);
					ft28.setText(null);
					ft29.setText(null);
					ft30.setText(null);
					ft31.setText(null);
					con8.close();
				}catch(Exception e10) {
					e10.printStackTrace();
				}
		
		}
		});
		b37.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		page3 p22=new page3();
		page3.main(null);
		
		f10.dispose();
			}
		});
		
		
		
		DigitalWatch10 d=  new DigitalWatch10();
		Thread t1=new Thread(d);
		t1.start();
		f10.add(b);

		
		f10.setSize(800,500);
		f10.setLayout(null);
		f10.setVisible(true);
	}

}
