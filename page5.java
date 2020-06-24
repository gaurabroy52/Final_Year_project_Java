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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


//Departmental Book Search

class DigitalWatch5 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch5(){  
      
      
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
public class page5 extends DigitalWatch5 {
	static String dept4="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f5=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		JLabel l27;
		l27=new JLabel("Departmental Books Search");
		l27.setBounds(10, 10, 170, 20);
		l27.setForeground(Color.BLUE);
		f5.add(l27);
		
		JLabel l12,l13;
		l12=new JLabel("Cooch Behar Government Engineering College");
		l12.setBounds(230, 10, 600, 40);
		l12.setForeground(Color.BLUE);
		l12.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l13=new JLabel("Library Management System");
		l13.setBounds(400, 60, 400, 40);
		l13.setForeground(Color.BLUE);
		l13.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f5.add(l12);
		f5.add(l13);
		
		JLabel l28;
		l28=new JLabel("Department Name");
		l28.setBounds(50, 100, 150, 70);
		
		l28.setFont(new Font("Sylfaen",Font.PLAIN,18));
		f5.add(l28);
		JMenuBar mb3=new JMenuBar();
		JLabel l73;
		l73=new JLabel();
		l73.setBounds(270, 120, 250, 30);
		f5.add(l73);
		
		mb3.setBounds(195, 120, 70, 30);
		mb3.setFont(new Font("Times New Roman",Font.ITALIC,28));
		JMenu set3=new JMenu("Click Here");
		JMenuItem i19=new JMenuItem("Computer Science & Engineering");
		JMenuItem i20=new JMenuItem("Electronics & Communication Engineering");
		JMenuItem i21=new JMenuItem("Electrical Engineering");
		JMenuItem i22=new JMenuItem("Mechanical Engineering");
		JMenuItem i23=new JMenuItem("Civil Engineering");
		JMenuItem i24=new JMenuItem("Basic Science & Humanities");
		set3.add(i19);
		set3.add(i20);
		set3.add(i21);
		set3.add(i22);
		set3.add(i23);
		set3.add(i24);
		
		i19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept4="Computer Science & Engineering";
				l73.setText("Computer Science & Engineering");
				
			}
		});
		i20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept4="Electronics & Communication Engineering";
				l73.setText("Electronics & Communication Engineering");
				
			}
		});
		i21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept4="Electrical Engineering";
				l73.setText("Electrical Engineering");
				
			}
		});
		i22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept4="Mechanical Engineering";
				l73.setText("Mechanical Engineering");
				
			}
		});
		i23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept4="Civil Engineering";
				l73.setText("Civil Engineering");
				
			}
		});
		i24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dept4="Basic Science & Humanities";
				l73.setText("Basic Science & Humanities");
				
			}
		});
		
		mb3.add(set3);
		f5.add(mb3);
		
		JButton b17;
		b17=new JButton("Search");
		b17.setBounds(510, 110, 100, 40);
		b17.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f5.add(b17);
		
		JButton b44;
		b44=new JButton("Back");
		b44.setBounds(630, 110, 100, 40);
		b44.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f5.add(b44);
		b44.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					page3 p25=new page3();
					page3.main(null);;
					f5.dispose();
				}
		});
		
		String coloumn1[]= {"Book Id","Book Name","Quantity","Author Name"};
		JTable jt1=new JTable();
		DefaultTableModel model1=new DefaultTableModel();
		model1.setColumnIdentifiers(coloumn1);
		jt1.setModel(model1);
		
		jt1.setBackground(Color.lightGray);
		jt1.setForeground(Color.CYAN);
		
		JScrollPane sp1=new JScrollPane(jt1);
		sp1.setBounds(0,250,800,200);
		f5.add(sp1);
		
		
		b17.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<User1> list1=new ArrayList<>();
				jt1.setModel(new DefaultTableModel(null,coloumn1));
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con4=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst14=con4.prepareStatement("select * from table1 where DEPT=?");
					pst14.setString(1, dept4);
					ResultSet rst7=pst14.executeQuery();
					User1 user;
					while(rst7.next())
					{
						user=new User1(rst7.getInt("BOOKID"),rst7.getString("BOOKNAME"),rst7.getInt("QUANTITY"),rst7.getString("AUTHORNAME"));
						list1.add(user);
					}
					
					DefaultTableModel model2=(DefaultTableModel)jt1.getModel();
					Object[] row=new Object[4];
					for(int i=0;i<list1.size();i++)
					{
						row[0]=list1.get(i).getBookId5();
						row[1]=list1.get(i).getBookName5();
						row[2]=list1.get(i).getQuantity5();
						row[3]=list1.get(i).getAuthorName5();
						model2.addRow(row);
					}
					con4.close();
				}catch(Exception e4) {
					e4.printStackTrace();
				}
				
			}
			
		});
		DigitalWatch5 d=  new DigitalWatch5();
		Thread t1=new Thread(d);
		t1.start();
		f5.add(b);

		
		f5.setSize(800,500);
		f5.setLayout(null);
		f5.setVisible(true);

	}

}
class User1{
	private int bookId5;
	private String bookName5;
	private int quantity5;
	private String authorName5;
	public User1(int bookId5, String bookName5, int quantity5, String authorName5) {
		
		this.bookId5 = bookId5;
		this.bookName5 = bookName5;
		this.quantity5 = quantity5;
		this.authorName5 = authorName5;
	}
	/**
	 * @return the bookId5
	 */
	public int getBookId5() {
		return bookId5;
	}
	/**
	 * @param bookId5 the bookId5 to set
	 */
	public void setBookId5(int bookId5) {
		this.bookId5 = bookId5;
	}
	/**
	 * @return the bookName5
	 */
	public String getBookName5() {
		return bookName5;
	}
	/**
	 * @param bookName5 the bookName5 to set
	 */
	public void setBookName5(String bookName5) {
		this.bookName5 = bookName5;
	}
	/**
	 * @return the quantity5
	 */
	public int getQuantity5() {
		return quantity5;
	}
	/**
	 * @param quantity5 the quantity5 to set
	 */
	public void setQuantity5(int quantity5) {
		this.quantity5 = quantity5;
	}
	/**
	 * @return the authorName5
	 */
	public String getAuthorName5() {
		return authorName5;
	}
	/**
	 * @param authorName5 the authorName5 to set
	 */
	public void setAuthorName5(String authorName5) {
		this.authorName5 = authorName5;
	}
	
}
