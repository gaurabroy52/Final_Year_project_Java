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

//Add Books

class DigitalWatch4 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch4(){  
      
      
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
public class page4 extends DigitalWatch4 {
	static String dept2="";
	public static void main(Object object) {
		// TODO Auto-generated method stub
		JFrame f4=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		
		JLabel l10,l11;
		l10=new JLabel("Cooch Behar Government Engineering College");
		l10.setBounds(230, 10, 600, 40);
		l10.setForeground(Color.BLUE);
		l10.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l11=new JLabel("Library Management System");
		l11.setBounds(400, 60, 400, 40);
		l11.setForeground(Color.BLUE);
		l11.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f4.add(l10);
		f4.add(l11);
		JLabel l21,l22,l23,l24,l25;
		
		l21=new JLabel("Book Id");
		l22=new JLabel("Book Name");
		l23=new JLabel("Department");
		l24=new JLabel("Aurthor Name");
		l25=new JLabel("Quantity");

		l21.setBounds(100, 100, 100, 50);
		
		l21.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l22.setBounds(100, 160, 100, 50);
		
		l22.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l23.setBounds(100, 220, 130, 50);
		
		l23.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l24.setBounds(100, 280, 130, 50);
		
		l24.setFont(new Font("Sylfaen",Font.PLAIN,18));
		
		l25.setBounds(100, 340, 130, 50);
		
		l25.setFont(new Font("Sylfaen",Font.PLAIN,18));
		JTextField ft2=new JTextField();
		ft2.setBounds(215, 105, 150, 30);
		f4.add(ft2);
		JTextField ft3=new JTextField();
		ft3.setBounds(215, 165, 150, 30);
		f4.add(ft3);
		JMenuBar mb1=new JMenuBar();
		JLabel l71;
		l71=new JLabel();
		l71.setBounds(290, 225, 250, 30);
		f4.add(l71);
		
		mb1.setBounds(215, 225, 70, 30);
		mb1.setFont(new Font("Times New Roman",Font.ITALIC,28));
		JMenu set1=new JMenu("Click Here");
		JMenuItem i7=new JMenuItem("Computer Science & Engineering");
		JMenuItem i8=new JMenuItem("Electronics & Communication Engineering");
		JMenuItem i9=new JMenuItem("Electrical Engineering");
		JMenuItem i10=new JMenuItem("Mechanical Engineering");
		JMenuItem i11=new JMenuItem("Civil Engineering");
		JMenuItem i12=new JMenuItem("Basic Science & Humanities");
		set1.add(i7);
		set1.add(i8);
		set1.add(i9);
		set1.add(i10);
		set1.add(i11);
		set1.add(i12);
		
		i7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept2="Computer Science & Engineering";
				l71.setText("Computer Science & Engineering");
			}
		});
		i8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept2="Electronics & Communication Engineering";
				l71.setText("Electronics & Communication Engineering");
			}
		});
		i9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept2="Electrical Engineering";
				l71.setText("Electrical Engineering");
			}
		});
		i10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept2="Mechanical Engineering";
				l71.setText("Mechanical Engineering");
			}
		});
		i11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept2="Civil Engineering";
				l71.setText("Civil Engineering");
			}
		});
		i12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept2="Basic Science & Humanities";
				l71.setText("Basic Science & Humanities");
			}
		});
		
		mb1.add(set1);
		f4.add(mb1);

		JTextField ft5=new JTextField();
		ft5.setBounds(215, 285, 150, 30);
		f4.add(ft5);
		JTextField ft6=new JTextField();
		ft6.setBounds(215, 350, 150, 30);
		f4.add(ft6);
		
		JButton b13,b14,b15,b16;
		b13=new JButton("Submit");
		b14=new JButton("Reset");
		b15=new JButton("Exit");
		b16=new JButton("Back");
		
		b13.setBounds(580, 200, 100, 40);
		b13.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b14.setBounds(580, 250, 100, 40);
		b14.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b15.setBounds(580, 300, 100, 40);
		b15.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		b16.setBounds(580, 350, 100, 40);
		b16.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		
		f4.add(b13);
		f4.add(b14);
		f4.add(b15);
		f4.add(b16);
		JLabel l26;
		l26=new JLabel("Add Book");
		l26.setBounds(10, 10, 100, 20);
		l26.setForeground(Color.BLUE);
		f4.add(l26);
		f4.add(l21);
		f4.add(l22);
		f4.add(l23);
		f4.add(l24);
		f4.add(l25);
		b13.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bookId1=Integer.parseInt(ft2.getText());
				String bookName1=ft3.getText();
				String authorName1=ft5.getText();
				int quantity1=Integer.parseInt(ft6.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst1=con1.prepareStatement("select * from table1 where BOOKID=?");
					pst1.setInt(1,bookId1);
					
					ResultSet rst1=pst1.executeQuery();
					if(rst1.next()) {
						int quantity2=rst1.getInt("QUANTITY");
						int total1=quantity2+quantity1;
						PreparedStatement pst3=con1.prepareStatement("update table1 set QUANTITY=? where BOOKID=?");
						pst3.setInt(1, total1);
						pst3.setInt(2, bookId1);
						int ok2=JOptionPane.showConfirmDialog(f4, "Conform to update stock of the book","Are you sure..",JOptionPane.YES_NO_OPTION);
						if(ok2==0) {
							pst3.executeUpdate();
							JOptionPane.showMessageDialog( f4, "Submitted Successfully");
						}
					}
					else
					{
						PreparedStatement pst2=con1.prepareStatement("insert into table1(BOOKID,BOOKNAME,DEPT,AUTHORNAME,QUANTITY) values(?,?,?,?,?)");
						pst2.setInt(1,bookId1);
						pst2.setString(2,bookName1);
						pst2.setString(3,dept2);
						pst2.setString(4,authorName1);
						pst2.setInt(5,quantity1);
						int ok1=JOptionPane.showConfirmDialog(f4, "Conform to add new type of book","Are you sure..",JOptionPane.YES_NO_OPTION);
						if(ok1==0) {
							pst2.execute();
							JOptionPane.showMessageDialog( f4, "Submitted Successfully");
						}
					}
					
					con1.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
					}
				
			
		});
		b14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ft2.setText(null);
				ft3.setText(null);
				l71.setText(null);
				dept2="";
				ft5.setText(null);
				ft6.setText(null);
			}
		});
		b15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(f4, "Confrom if you want to exit","Library Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
		b16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				page3 p9=new page3();
				page3.main(null);
				f4.dispose();
			}
		});
		DigitalWatch4 d=  new DigitalWatch4();
		Thread t1=new Thread(d);
		t1.start();
		f4.add(b);
		
		f4.setSize(800,500);
		f4.setLayout(null);
		f4.setVisible(true);
	}

}
