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

//Delete Book


class DigitalWatch11 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch11(){  
      
      
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
public class page11 extends DigitalWatch11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f11=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		JLabel l56;
		l56=new JLabel("Delete Book");
		l56.setBounds(10, 10, 100, 20);
		l56.setForeground(Color.BLUE);
		f11.add(l56);
		
		JLabel l57,l58;
		l57=new JLabel("Cooch Behar Government Engineering College");
		l57.setBounds(230, 10, 600, 40);
		l57.setForeground(Color.BLUE);
		l57.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l58=new JLabel("Library Management System");
		l58.setBounds(400, 60, 400, 40);
		l58.setForeground(Color.BLUE);
		l58.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f11.add(l57);
		f11.add(l58);
		JLabel l65;
		l65=new JLabel("Book Id");
		l65.setBounds(10, 100, 100, 20);
		l65.setForeground(Color.BLUE);
		f11.add(l65);
		JTextField ft32=new JTextField("Enter the Book Id");
		ft32.setBounds(120, 100, 150, 20);
		f11.add(ft32);
		
		JButton b38,b39,b40,b41;
		b38=new JButton("Search");
		b39=new JButton("Reset");
		b40=new JButton("Delete");
		b41=new JButton("Back");
		b38.setBounds(50, 130, 100, 40);
		b38.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b39.setBounds(300, 130, 100, 40);
		b39.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		
		b40.setBounds(600, 300, 100, 50);
		b40.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b41.setBounds(550, 130, 100, 40);
		b41.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f11.add(b38);
		f11.add(b39);
		f11.add(b40);
		f11.add(b41);
		JLabel l66;
		l66=new JLabel("Book Name");
		l66.setBounds(20, 200, 100, 20);
		l66.setForeground(Color.BLUE);
		f11.add(l66);
		JLabel l67;
		l67=new JLabel("Department");
		l67.setBounds(20, 240, 100, 20);
		l67.setForeground(Color.BLUE);
		f11.add(l67);
		JLabel l68;
		l68=new JLabel("Author Name");
		l68.setBounds(20, 280, 100, 20);
		l68.setForeground(Color.BLUE);
		f11.add(l68);
		JLabel l69;
		l69=new JLabel("Quantity");
		l69.setBounds(20, 320, 100, 20);
		l69.setForeground(Color.BLUE);
		f11.add(l69);
		JLabel l70;
		
		
		JTextField ft33=new JTextField();
		ft33.setBounds(150, 200, 250, 30);
		f11.add(ft33);
		JTextField ft34=new JTextField();
		ft34.setBounds(150, 240, 250, 30);
		f11.add(ft34);
		JTextField ft35=new JTextField();
		ft35.setBounds(150, 280, 250, 30);
		f11.add(ft35);
		JTextField ft36=new JTextField();
		ft36.setBounds(150, 320, 250, 30);
		f11.add(ft36);
	
		
		
		b38.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bookId10=Integer.parseInt(ft32.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con9=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst19=con9.prepareStatement("select * from table1 where BOOKID=?");
					pst19.setInt(1, bookId10);
					ResultSet rst11=pst19.executeQuery();
					if(rst11.next())
					{
						String BookName11=rst11.getString("BOOKNAME");
						String DEPT11=rst11.getString("DEPT");
						String AuthorName11=rst11.getString("AUTHORNAME");
						int quantity11=rst11.getInt("QUANTITY");
						String str4=String.valueOf(quantity11);
						ft33.setText(BookName11);
						ft34.setText(DEPT11);
						ft35.setText(AuthorName11);
						ft36.setText(str4);
						
					}
					else {
						JOptionPane.showMessageDialog( f11, "The System don't have any data regarding this Book");
					}
					con9.close();
				}catch(Exception e11) {
					e11.printStackTrace();
				}
			
				
			}
		});
		b39.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				ft32.setText(null);
				ft33.setText(null);
				ft34.setText(null);
				ft35.setText(null);
				ft36.setText(null);
			
				
			}
		});
		b40.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				int bookId11=Integer.parseInt(ft32.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con10=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst20=con10.prepareStatement("delete from table1 where BOOKID=?");
					pst20.setInt(1,bookId11);
					pst20.execute();
					PreparedStatement pst21=con10.prepareStatement("delete from table3 where BOOKID=?");
					pst21.setInt(1, bookId11);
					pst21.execute();
					JOptionPane.showMessageDialog( f11, "The Book Entity is remove from the System");
					ft32.setText(null);
					ft33.setText(null);
					ft34.setText(null);
					ft35.setText(null);
					ft36.setText(null);
					
					con10.close();
				}catch(Exception e12)
				{
					e12.printStackTrace();
				}
		
			}
		});
		b41.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		page3 p23=new page3();
		page3.main(null);
		
		f11.dispose();
			}
		});
		
		
		
		DigitalWatch11 d=  new DigitalWatch11();
		Thread t1=new Thread(d);
		t1.start();
		f11.add(b);

		
		f11.setSize(800,500);
		f11.setLayout(null);
		f11.setVisible(true);
	}

}
