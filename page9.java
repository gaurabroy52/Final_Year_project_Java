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

//Stock Search


class DigitalWatch9 implements Runnable{  

Thread t=null;  
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
protected static JButton b;
  
DigitalWatch9(){  
      
      
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
public class page9 extends DigitalWatch9{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f9=new JFrame("Cooch Behar Government Engineering College_Library Management System");
		JLabel l50;
		l50=new JLabel("Stock Search");
		l50.setBounds(10, 10, 100, 20);
		l50.setForeground(Color.BLUE);
		f9.add(l50);
		
		JLabel l51,l52;
		l51=new JLabel("Cooch Behar Government Engineering College");
		l51.setBounds(230, 10, 600, 40);
		l51.setForeground(Color.BLUE);
		l51.setFont(new Font("Times New Roman",Font.ITALIC,28));
		l52=new JLabel("Library Management System");
		l52.setBounds(400, 60, 400, 40);
		l52.setForeground(Color.BLUE);
		l52.setFont(new Font("Times New Roman",Font.ITALIC,28));
		f9.add(l51);
		f9.add(l52);
		
		JLabel l53;
		l53=new JLabel("Book Id");
		l53.setBounds(200, 100, 150, 70);
		
		l53.setFont(new Font("Sylfaen",Font.PLAIN,18));
		f9.add(l53);
		JTextField ft25=new JTextField();
		ft25.setBounds(280, 120, 150, 30);
		f9.add(ft25);
		JButton b33;
		b33=new JButton("Search");
		b33.setBounds(470, 110, 100, 40);
		b33.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f9.add(b33);
		JButton b43;
		b43=new JButton("Back");
		b43.setBounds(580, 110, 100, 40);
		b43.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		f9.add(b43);
		b43.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					page3 p24=new page3();
					page3.main(null);;
					f9.dispose();
				}
	    });
		
		String coloumn2[]= {"Book Name","Department","Quantity"};
		JTable jt4=new JTable();
		DefaultTableModel model1=new DefaultTableModel();
		model1.setColumnIdentifiers(coloumn2);
		jt4.setModel(model1);
		
		jt4.setBackground(Color.lightGray);
		jt4.setForeground(Color.CYAN);
		
		JScrollPane sp1=new JScrollPane(jt4);
		sp1.setBounds(0,250,800,200);
		f9.add(sp1);
		
		
		b33.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bookId7=Integer.parseInt(ft25.getText());
				ArrayList<User2> list2=new ArrayList<>();
				jt4.setModel(new DefaultTableModel(null,coloumn2));
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
					PreparedStatement pst15=con5.prepareStatement("select * from table1 where BOOKID=?");
					pst15.setInt(1,bookId7);
					ResultSet rst8=pst15.executeQuery();
					User2 user1;
					while(rst8.next())
					{
						user1=new User2(rst8.getString("BOOKNAME"),rst8.getString("DEPT"),rst8.getInt("QUANTITY"));
						list2.add(user1);
					}
					DefaultTableModel model3=(DefaultTableModel)jt4.getModel();
					Object[] row1=new Object[3];
					for(int i=0;i<list2.size();i++)
					{
						row1[0]=list2.get(i).getBookName6();
						row1[1]=list2.get(i).getDepartment6();
						row1[2]=list2.get(i).getQuantity6();
						
						model3.addRow(row1);
					}
					con5.close();
				}catch(Exception e5) {
					e5.printStackTrace();
				}
			}
		});
		
		
		DigitalWatch9 d=  new DigitalWatch9();
		Thread t1=new Thread(d);
		t1.start();
		f9.add(b);

		
		f9.setSize(800,500);
		f9.setLayout(null);
		f9.setVisible(true);

	}

}
class User2{
	private String bookName6;
	private String department6;
	private int quantity6;
	public User2(String bookName6, String department6, int quantity6) {
		super();
		this.bookName6 = bookName6;
		this.department6 = department6;
		this.quantity6 = quantity6;
	}
	/**
	 * @return the bookName6
	 */
	public String getBookName6() {
		return bookName6;
	}
	/**
	 * @param bookName6 the bookName6 to set
	 */
	public void setBookName6(String bookName6) {
		this.bookName6 = bookName6;
	}
	/**
	 * @return the department6
	 */
	public String getDepartment6() {
		return department6;
	}
	/**
	 * @param department6 the department6 to set
	 */
	public void setDepartment6(String department6) {
		this.department6 = department6;
	}
	/**
	 * @return the quantity6
	 */
	public int getQuantity6() {
		return quantity6;
	}
	/**
	 * @param quantity6 the quantity6 to set
	 */
	public void setQuantity6(int quantity6) {
		this.quantity6 = quantity6;
	}
	
}
