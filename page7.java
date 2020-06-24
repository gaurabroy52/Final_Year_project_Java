import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//Return Book

class DigitalWatch7 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch7(){  
      
      
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
public class page7 extends DigitalWatch7{
	static String dept3="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f7=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		
		JLabel l16,l17;
		l16=new JLabel("Cooch Behar Government Engineering College");
		l16.setBounds(230, 10, 600, 40);
		l16.setForeground(Color.BLUE);
		l16.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l17=new JLabel("Library Management System");
		l17.setBounds(400, 60, 400, 40);
		l17.setForeground(Color.BLUE);
		l17.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f7.add(l16);
		f7.add(l17);
		
		JLabel l37;
		l37=new JLabel("Return Book");
		l37.setBounds(10, 10, 100, 20);
		l37.setForeground(Color.BLUE);
		f7.add(l37);
		JLabel l38,l39,l40,l41,l42,l43,l44;
		l38=new JLabel("Roll No ");
		l39=new JLabel("Book Id");
		l40=new JLabel("Student Name");
		l41=new JLabel("Book Name");
		l42=new JLabel("Department");
		l43=new JLabel("Semister");
		l44=new JLabel("Date");
		
		l38.setBounds(50, 55, 130, 40);
		
		l38.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l39.setBounds(50, 105, 100, 40);
		
		l39.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l40.setBounds(50, 155, 130, 40);
		
		l40.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l41.setBounds(50, 205, 130, 40);
		
		l41.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l42.setBounds(50, 255, 100, 40);
		
		l42.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l43.setBounds(50, 305, 100, 40);
		
		l43.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l44.setBounds(50, 355, 100, 40);
		
		l44.setFont(new Font("Sylfaen",Font.PLAIN,18));
		f7.add(l38);
		f7.add(l39);
		f7.add(l40);
		f7.add(l41);
		f7.add(l42);
		f7.add(l43);
		f7.add(l44);
		
		JTextField ft15=new JTextField();
		ft15.setBounds(200, 60, 150, 30);
		f7.add(ft15);
		
		JTextField ft16=new JTextField();
		ft16.setBounds(200, 110, 150, 30);
		f7.add(ft16);
		
		JTextField ft17=new JTextField();
		ft17.setBounds(200, 160, 150, 30);
		f7.add(ft17);
		
		JTextField ft18=new JTextField();
		ft18.setBounds(200, 210, 150, 30);
		f7.add(ft18);
		
		
		JMenuBar mb2=new JMenuBar();
		JLabel l72;
		l72=new JLabel();
		l72.setBounds(280, 260, 250, 30);
		f7.add(l72);
		
		mb2.setBounds(200, 260, 70, 30);
		mb2.setFont(new Font("Times New Roman",Font.ITALIC,28));
		JMenu set2=new JMenu("Click Here");
		JMenuItem i13=new JMenuItem("Computer Science & Engineering");
		JMenuItem i14=new JMenuItem("Electronics & Communication Engineering");
		JMenuItem i15=new JMenuItem("Electrical Engineering");
		JMenuItem i16=new JMenuItem("Mechanical Engineering");
		JMenuItem i17=new JMenuItem("Civil Engineering");
		
		set2.add(i13);
		set2.add(i14);
		set2.add(i15);
		set2.add(i16);
		set2.add(i17);

		
		i13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept3="Computer Science & Engineering";
				l72.setText("Computer Science & Engineering");
				
			}
		});
		i14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept3="Electronics & Communication Engineering";
				l72.setText("Electronics & Communication Engineering");
				
			}
		});
		i15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept3="Electrical Engineering";
				l72.setText("Electrical Engineering");
				
			}
		});
		i16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept3="Mechanical Engineering";
				l72.setText("Mechanical Engineering");
				
			}
		});
		i17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept3="Civil Engineering";
				l72.setText("Civil Engineering");
				
			}
		});
	
		mb2.add(set2);
		f7.add(mb2);

	
		
		
		JTextField ft20=new JTextField();
		ft20.setBounds(200, 310, 150, 30);
		f7.add(ft20);
		
		JTextField ft21=new JTextField();
		ft21.setBounds(200, 360, 150, 30);
		f7.add(ft21);
		
		JButton b22,b23,b24,b25;
		b22=new JButton("Submit");
		b23=new JButton("Reset");
		b24=new JButton("Exit");
		b25=new JButton("Back");
		
		b22.setBounds(580, 200, 100, 40);
		b22.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b23.setBounds(580, 250, 100, 40);
		b23.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b24.setBounds(580, 300, 100, 40);
		b24.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b25.setBounds(580, 350, 100, 40);
		b25.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		f7.add(b22);
		f7.add(b23);
		f7.add(b24);
		f7.add(b25);
		b22.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rollNo3=Integer.parseInt(ft15.getText());
				int bookId3=Integer.parseInt(ft16.getText());
				String studentName3=ft17.getText();
				String bookName3=ft18.getText();
				int sem3=Integer.parseInt(ft20.getText());
				String date2=ft21.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst9=con3.prepareStatement("select * from table3 where ROLLNO=? and BOOKID=?");
					pst9.setInt(1, rollNo3);
					pst9.setInt(2, bookId3);
					ResultSet rst4=pst9.executeQuery();
					if(rst4.next())
					{
						String date3=rst4.getString("DATE");
						SimpleDateFormat myformat=new SimpleDateFormat("dd/mm/yyyy");
						int days=0;
						try {
							Date date4=myformat.parse(date3);
							Date date5=myformat.parse(date2);
							long diff=date5.getTime()-date4.getTime();
							days=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						}catch(ParseException e3) {
							e3.printStackTrace();
						}
						if(days>15)
						{
							int days_for_fine=(days-15);
							int fine1=(days_for_fine*1);
							
							PreparedStatement pst10=con3.prepareStatement("select * from table2 where ROLLNO=?");
							pst10.setInt(1,rollNo3 );
							ResultSet rst5=pst10.executeQuery();
							if(rst5.next())
							{
								int fine2=rst5.getInt("FINE");
								int fine3=(fine1+fine2);
								PreparedStatement pst11=con3.prepareStatement("update table2 set FINE=? where ROLLNO=?");
								pst11.setInt(1, fine3);
								pst11.setInt(2, rollNo3);
								pst11.executeUpdate();
							}
						}
						PreparedStatement pst12=con3.prepareStatement("select * from table1 where BOOKID=?");
						pst12.setInt(1, bookId3);
						ResultSet rst6=pst12.executeQuery();
						if(rst6.next())
						{
							int quantity5=rst6.getInt("QUANTITY");
							int quantity6=(quantity5+1);
							PreparedStatement pst13=con3.prepareStatement("update table1 set QUANTITY=? where BOOKID=?");
							pst13.setInt(1,quantity6 );
							pst13.setInt(2, bookId3);
							pst13.executeUpdate();
						}
						PreparedStatement pst14=con3.prepareStatement("delete from table3 where ROLLNO=? and BOOKID=?");
						pst14.setInt(1, rollNo3);
						pst14.setInt(2, bookId3);
						pst14.executeUpdate();
						JOptionPane.showMessageDialog( f7, "The Book is returned successfully to the Library");
					}else {
						JOptionPane.showMessageDialog( f7, "The Book Was not Issued from the Library");
					}
					
					con3.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			
					}
				
			
		});
		b23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ft15.setText(null);
				ft16.setText(null);
				ft17.setText(null);
				ft18.setText(null);
				l72.setText(null);
				dept3="";
				
				ft20.setText(null);
				ft21.setText(null);
			}
		});
		b24.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(f7, "Confrom if you want to exit","Library Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		b25.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page3 p11=new page3();
				page3.main(null);
				f7.dispose();
			}
		});
		DigitalWatch7 d=  new DigitalWatch7();
		Thread t1=new Thread(d);
		t1.start();
		f7.add(b);
		
		f7.setSize(800,500);
		f7.setLayout(null);
		f7.setVisible(true);

	}

}
