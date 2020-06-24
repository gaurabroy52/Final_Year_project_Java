import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


//Issued Books of a student

class DigitalWatch8 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch8(){  
      
      
    t = new Thread(this);  
        t.start();  
      
        b=new JButton();
        b.setBounds(0,200,100,50);
          
      
      
 
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
public class page8 extends DigitalWatch8{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f8=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		
		JLabel l18,l19;
		l18=new JLabel("Cooch Behar Government Engineering College");
		l18.setBounds(230, 10, 600, 40);
		l18.setForeground(Color.BLUE);
		l18.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l19=new JLabel("Library Management System");
		l19.setBounds(400, 60, 400, 40);
		l19.setForeground(Color.BLUE);
		l19.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f8.add(l18);
		f8.add(l19);
		JLabel l45;
		l45=new JLabel("Issued Books of a Student");
		l45.setBounds(10, 10, 170, 20);
		l45.setForeground(Color.BLUE);
		f8.add(l45);
		JLabel l46;
		l46=new JLabel("Roll No");
		l46.setBounds(130, 100, 150, 70);
		
		l46.setFont(new Font("Sylfaen",Font.PLAIN,18));
		f8.add(l46);
		
		JTextField ft22=new JTextField();
		ft22.setBounds(270, 120, 150, 30);
		f8.add(ft22);
		JButton b26;
		b26=new JButton("Search");
		b26.setBounds(450, 110, 100, 40);
		b26.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f8.add(b26);
		
		JButton b45;
		b45=new JButton("Back");
		b45.setBounds(580, 110, 100, 40);
		b45.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f8.add(b45);
		b45.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					page3 p26=new page3();
					page3.main(null);;
					f8.dispose();
			}
		});
		String coloumn2[]= {"Book Id","Book Name","Sem","Department","Date"};
		JTable jt2=new JTable();
		DefaultTableModel model2=new DefaultTableModel();
		model2.setColumnIdentifiers(coloumn2);
		jt2.setModel(model2);
		
		jt2.setBackground(Color.lightGray);
		jt2.setForeground(Color.CYAN);
		
		JScrollPane sp2=new JScrollPane(jt2);
		sp2.setBounds(0,250,800,200);
		f8.add(sp2);
		b26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rollNo8=Integer.parseInt(ft22.getText());
				ArrayList<User3> list3=new ArrayList<>();
				jt2.setModel(new DefaultTableModel(null,coloumn2));
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con6=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst16=con6.prepareStatement("select * from table3 where ROLLNO=?");
					pst16.setInt(1,rollNo8);
					ResultSet rst9=pst16.executeQuery();
					User3 user;
					while(rst9.next())
					{
						user=new User3(rst9.getInt("BOOKID"),rst9.getString("BOOKNAME"),rst9.getInt("SEM"),rst9.getString("DEPT"),rst9.getString("DATE"));
						list3.add(user);
					}
					DefaultTableModel model4=(DefaultTableModel)jt2.getModel();
					Object[] row1=new Object[5];
					for(int i=0;i<list3.size();i++)
					{
						row1[0]=list3.get(i).getBookId8();
						row1[1]=list3.get(i).getBookName8();
						row1[2]=list3.get(i).getSem8();
						row1[3]=list3.get(i).getDepartment8();
						row1[4]=list3.get(i).getDate8();
						model4.addRow(row1);
					}
					con6.close();
				}catch(Exception e6)
				{
					e6.printStackTrace();
				}
			}
		});
		DigitalWatch8 d=  new DigitalWatch8();
		Thread t1=new Thread(d);
		t1.start();
		f8.add(b);
		
		f8.setSize(800,500);
		f8.setLayout(null);
		f8.setVisible(true);
	}

}
class User3{
	private int bookId8;
	private String bookName8;
	private int sem8;
	private String department8;
	private String date8;
	public User3(int bookId8, String bookName8, int sem8, String department8, String date8) {
		super();
		this.bookId8 = bookId8;
		this.bookName8 = bookName8;
		this.sem8 = sem8;
		this.department8 = department8;
		this.date8 = date8;
	}
	/**
	 * @return the bookId8
	 */
	public int getBookId8() {
		return bookId8;
	}
	/**
	 * @param bookId8 the bookId8 to set
	 */
	public void setBookId8(int bookId8) {
		this.bookId8 = bookId8;
	}
	/**
	 * @return the bookName8
	 */
	public String getBookName8() {
		return bookName8;
	}
	/**
	 * @param bookName8 the bookName8 to set
	 */
	public void setBookName8(String bookName8) {
		this.bookName8 = bookName8;
	}
	/**
	 * @return the sem8
	 */
	public int getSem8() {
		return sem8;
	}
	/**
	 * @param sem8 the sem8 to set
	 */
	public void setSem8(int sem8) {
		this.sem8 = sem8;
	}
	/**
	 * @return the department8
	 */
	public String getDepartment8() {
		return department8;
	}
	/**
	 * @param department8 the department8 to set
	 */
	public void setDepartment8(String department8) {
		this.department8 = department8;
	}
	/**
	 * @return the date8
	 */
	public String getDate8() {
		return date8;
	}
	/**
	 * @param date8 the date8 to set
	 */
	public void setDate8(String date8) {
		this.date8 = date8;
	}
	
}