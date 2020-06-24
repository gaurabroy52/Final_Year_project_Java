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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Issue Book
class DigitalWatch6 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch6(){  
      
      
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
public class page6 extends DigitalWatch6{
	static String dept1="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f6=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		
		JLabel l14,l15;
		l14=new JLabel("Cooch Behar Government Engineering College");
		l14.setBounds(230, 10, 600, 40);
		l14.setForeground(Color.BLUE);
		l14.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l15=new JLabel("Library Management System");
		l15.setBounds(400, 60, 400, 40);
		l15.setForeground(Color.BLUE);
		l15.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f6.add(l14);
		f6.add(l15);
		
		JLabel l29;
		l29=new JLabel("Issue Book");
		l29.setBounds(10, 10, 100, 20);
		l29.setForeground(Color.BLUE);
		f6.add(l29);
		
		JLabel l30,l31,l32,l33,l34,l35,l36;
		l30=new JLabel("Roll No");
		l31=new JLabel("Book Id");
		l32=new JLabel("Student Name");
		l33=new JLabel("Book Name");
		l34=new JLabel("Department");
		l35=new JLabel("Semister");
		l36=new JLabel("Date");
		l30.setBounds(50, 55, 130, 40);
		
		l30.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l31.setBounds(50, 105, 100, 40);
		
		l31.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l32.setBounds(50, 155, 120, 40);
		
		l32.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l33.setBounds(50, 205, 100, 40);
		
		l33.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l34.setBounds(50, 255, 100, 40);
		
		l34.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l35.setBounds(50, 305, 100, 40);
		
		l35.setFont(new Font("Sylfaen",Font.PLAIN,18));
		l36.setBounds(50, 355, 100, 40);
		
		l36.setFont(new Font("Sylfaen",Font.PLAIN,18));
		f6.add(l30);
		f6.add(l31);
		f6.add(l32);
		f6.add(l33);
		f6.add(l34);
		f6.add(l35);
		f6.add(l36);
		
		JTextField ft8=new JTextField();
		ft8.setBounds(200, 60, 150, 30);
		f6.add(ft8);
		
		JTextField ft9=new JTextField();
		ft9.setBounds(200, 110, 150, 30);
		f6.add(ft9);
		
		JTextField ft10=new JTextField();
		ft10.setBounds(200, 160, 150, 30);
		f6.add(ft10);
		
		JTextField ft11=new JTextField();
		ft11.setBounds(200, 210, 150, 30);
		f6.add(ft11);
		
		JMenuBar mb=new JMenuBar();
		JLabel l70;
		l70=new JLabel();
		l70.setBounds(280, 260, 250, 30);
		f6.add(l70);
		
		mb.setBounds(200, 260, 70, 30);
		mb.setFont(new Font("Times New Roman",Font.ITALIC,28));
		JMenu set=new JMenu("Click Here");
		JMenuItem i1=new JMenuItem("Computer Science & Engineering");
		JMenuItem i2=new JMenuItem("Electronics & Communication Engineering");
		JMenuItem i3=new JMenuItem("Electrical Engineering");
		JMenuItem i4=new JMenuItem("Mechanical Engineering");
		JMenuItem i5=new JMenuItem("Civil Engineering");
		
		set.add(i1);
		set.add(i2);
		set.add(i3);
		set.add(i4);
		set.add(i5);
		
		
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept1="Computer Science & Engineering";
				l70.setText("Computer Science & Engineering");
			}
		});
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept1="Electronics & Communication Engineering";
				l70.setText("Electronics & Communication Engineering");
			}
		});
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept1="Electrical Engineering";
				l70.setText("Electrical Engineering");
			}
		});
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept1="Mechanical Engineering";
				l70.setText("Mechanical Engineering");
			}
		});
		i5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept1="Civil Engineering";
				l70.setText("Civil Engineering");
			}
		});
		
		
		mb.add(set);
		f6.add(mb);
		
		JTextField ft13=new JTextField();
		ft13.setBounds(200, 310, 150, 30);
		f6.add(ft13);
		
		JTextField ft14=new JTextField();
		ft14.setBounds(200, 360, 150, 30);
		f6.add(ft14);
		
		JButton b18,b19,b20,b21;
		b18=new JButton("Submit");
		b19=new JButton("Reset");
		b20=new JButton("Exit");
		b21=new JButton("Back");
		
		b18.setBounds(580, 200, 100, 40);
		b18.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b19.setBounds(580, 250, 100, 40);
		b19.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b20.setBounds(580, 300, 100, 40);
		b20.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b21.setBounds(580, 350, 100, 40);
		b21.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		f6.add(b18);
		f6.add(b19);
		f6.add(b20);
		f6.add(b21);
		b18.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rollNo2=Integer.parseInt(ft8.getText());
				int bookId2=Integer.parseInt(ft9.getText());
				String studentName2=ft10.getText();
				String bookName2=ft11.getText();
				int sem2=Integer.parseInt(ft13.getText());
				String date1=ft14.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst4=con2.prepareStatement("select * from table1 where BOOKID=?");
					pst4.setInt(1,bookId2);
					ResultSet rst2=pst4.executeQuery();
					if(rst2.next())
					{
						int quantity3=rst2.getInt("QUANTITY");
						if(quantity3>0)
						{
						int quantity4=(quantity3-1);
						PreparedStatement pst5=con2.prepareStatement("select * from table2 where ROLLNO=?");
						pst5.setInt(1,rollNo2);
						ResultSet rst3=pst5.executeQuery();
						if(rst3.next())
						{
							
						}
						else{
							PreparedStatement pst6=con2.prepareStatement("insert into table2(ROLLNO,STUDENTNAME,DEPT,SEMISTER) values(?,?,?,?)");
							pst6.setInt(1,rollNo2);
							pst6.setString(2,studentName2);
							pst6.setString(3,dept1);
							pst6.setInt(4, sem2);
							pst6.execute();
							
						}
						PreparedStatement pst7=con2.prepareStatement("update table1 set QUANTITY=? where BOOKID=?");
						pst7.setInt(1,quantity4 );
						pst7.setInt(2,bookId2 );
						pst7.executeUpdate();
						
						PreparedStatement pst8=con2.prepareStatement("insert into table3(ROLLNO,BOOKID,STUDENTNAME,BOOKNAME,DEPT,SEM,DATE) values(?,?,?,?,?,?,?)");
						pst8.setInt(1,rollNo2);
						pst8.setInt(2,bookId2);
						pst8.setString(3,studentName2);
						pst8.setString(4, bookName2);
						pst8.setString(5, dept1);
						pst8.setInt(6, sem2);
						pst8.setString(7, date1);
						pst8.execute();
						JOptionPane.showMessageDialog( f6, "The Book was Issued Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog( f6, "The Library don't have any copy of this book");
						}
					}
					else {
						JOptionPane.showMessageDialog( f6, "We Don't have the Book right now");
					}
					
					con2.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			
					}
				
			
		});
		b19.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ft8.setText(null);
				ft9.setText(null);
				ft10.setText(null);
				ft11.setText(null);
				l70.setText(null);
				dept1="";
				ft13.setText(null);
				ft14.setText(null);
			}
		});
		b20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(f6, "Confrom if you want to exit","Library Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		b21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page3 p10=new page3();
				page3.main(null);
				f6.dispose();
			}
		});
		DigitalWatch6 d=  new DigitalWatch6();
		Thread t1=new Thread(d);
		t1.start();
		f6.add(b);
		
		
		f6.setSize(800,500);
		f6.setLayout(null);
		f6.setVisible(true);

	}

}
