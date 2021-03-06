import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
import net.proteanit.sql.DbUtils ;
public class ViewAccountOpeningRequest extends JFrame
{
JLabel accountno,password,Bankname,image;
JButton exit,back;
JTextField taccountno;
JPasswordField tpassword;
JButton verify;
JPanel header;
int accno1,color;
ViewAccountOpeningRequest(String title,int accno,int v)
{
accno1=accno;
color=v;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,15);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font username=new Font("SansSerif",Font.BOLD,20);
Font tablefont=new Font("SansSerif",Font.PLAIN,20);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
JTable complaintable=new JTable(){
public boolean isCellEditable(int data,int column)
{ 
  return false;  
}

}; 
complaintable.setPreferredScrollableViewportSize(new Dimension(1200,200));
complaintable.setFillsViewportHeight(true);
complaintable.setFont(tablefont);
complaintable.setBackground(Color.WHITE);
complaintable.setForeground(Color.BLACK);
complaintable.getTableHeader().setOpaque(false);
complaintable.getTableHeader().setBackground(Color.WHITE);
try
 {
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="select * from accountopeningrequests";
     ResultSet rows=stn.executeQuery(sql);
     complaintable.setModel(DbUtils.resultSetToTableModel(rows));
     
 }
 catch(Exception e)
 {
JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
 }
JPanel tablecontainer=new JPanel();
JScrollPane tablescrollbar=new JScrollPane(complaintable);
tablescrollbar.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
exit=new JButton("EXIT");
back=new JButton("BACK");
accountno=new JLabel("Enter Account Number:");
accountno.setFont(username);
accountno.setForeground(Color.BLACK);
accountno.setBounds(310,260,300,50);
password=new JLabel("Assign Password:");
password.setBounds(340,330,300,50);
password.setFont(username);
password.setForeground(Color.BLACK);
taccountno=new JTextField();
taccountno.setBounds(540,270,300,40);
tpassword=new JPasswordField();
tpassword.setBounds(540,340,300,40);
verify=new JButton("VERIFY");
verify.setFont(btnFont);
verify.setForeground(Color.WHITE);
verify.setCursor(handpointer);
verify.setBounds(560,400,200,50);
Bankname.setForeground(Color.WHITE);
Bankname.setFont(bankline);
exit.setFont(btnFont);
exit.setBackground(Color.RED);
exit.setForeground(Color.WHITE);
exit.setCursor(handpointer);
back.setFont(btnFont);
back.setCursor(handpointer);
back.setForeground(Color.WHITE);
this.setLayout(null);
tablecontainer.setBounds(30,60,1260,200);
header.setBounds(0,0,1320,50);
tablescrollbar.setBounds(20,20,1240,200);
image.setBounds(470,0,100,50);
Bankname.setBounds(550,10,400,50);
exit.setBounds(1110,401,150,40);
back.setBounds(50,401,150,40);
this.add(header);
this.add(tablecontainer);
header.add(image);
header.add(Bankname);
tablecontainer.add(tablescrollbar);
this.add(accountno);
this.add(taccountno);
this.add(password);
this.add(tpassword);
this.add(verify);
this.add(exit);
this.add(back);
verify.addActionListener(new MyEvents());
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ChangeColor(color);
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(20,150,1320,500);
this.setVisible(true);
}
public void ChangeColor(int v)
{
   int rgb[]={52, 73, 94};
        switch(v)
                {
                    case 1:
                    rgb[0]=26;
                    rgb[1]=188;
                    rgb[2]=156;
                    break;
                    case 2:
                    rgb[0]=22;
                    rgb[1]=160;
                    rgb[2]=133;
                    break;
                    case 3:
                    rgb[0]=46;
                    rgb[1]= 204;
                    rgb[2]=133;
                    break;  
                    case 4:
                    rgb[0]=39;
                    rgb[1]=174;
                    rgb[2]=96;
                    break; 
                    case 5:
                    rgb[0]=241;
                    rgb[1]=196;
                    rgb[2]=15;
                    break; 
                   case 6:
                    rgb[0]=243;
                    rgb[1]=156;
                    rgb[2]=181;
                    break; 
                    case 7:
                    rgb[0]=211;
                    rgb[1]=84;
                    rgb[2]=0;
                    break; 
                    case 8:
                    rgb[0]=155;
                    rgb[1]=89;
                    rgb[2]=182;
                    break; 
                   case 9:
                    rgb[0]=142;
                    rgb[1]=68;
                    rgb[2]=173;
                    break; 
                    case 10:
                    rgb[0]=52;
                    rgb[1]=73;
                    rgb[2]=94;
                    break; 
                    case 11:
                    rgb[0]=44;
                    rgb[1]=62;
                    rgb[2]=80;
                    break; 
                    case 12:
                    rgb[0]=189;
                    rgb[1]=195;
                    rgb[2]=199; 
                    break; 
                    case 13:
                    
                    rgb[0]=149;
                    rgb[1]=165;
                    rgb[2]=166;
                    break; 
                    case 14:
                   
                    rgb[0]=127;
                    rgb[1]=140;
                    rgb[2]=141;
                    color=0;
                    break;          
                }
 Color btncolor=new Color(rgb[0],rgb[1],rgb[2]);   

 back.setBackground(btncolor);
 verify.setBackground(btncolor);
 header.setBackground(btncolor); 
}
public void hideFrame()
{
this.dispose();
}
public void backaudio()
{
    try{
 InputStream mysoundfile=new FileInputStream(new File("back.wav"));
 AudioStream mysound=new AudioStream(mysoundfile);
 AudioPlayer.player.start(mysound);
    }
    catch(Exception e)
    {
        
          JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE);
        
    }
    
    
    
}
public void successaudio()
{
    try{
 InputStream mysoundfile=new FileInputStream(new File("play.wav"));
 AudioStream mysound=new AudioStream(mysoundfile);
 AudioPlayer.player.start(mysound);
    }
    catch(Exception e)
    {
        
          JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE);
        
    }
    
    
    
}
public void exitaudio()
{
    try{
 InputStream mysoundfile=new FileInputStream(new File("mario.wav"));
 AudioStream mysound=new AudioStream(mysoundfile);
 AudioPlayer.player.start(mysound);
    }
    catch(Exception e)
    {
          JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
    }
}
public static void main(String args[])
{
ViewAccountOpeningRequest obj=new ViewAccountOpeningRequest("ViewAccountOpeningRequest",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
ViewAccountOpeningRequest.this.exitaudio();
ViewAccountOpeningRequest.this.hideFrame();
}
if(btnop.getSource()==back)
{
ViewAccountOpeningRequest.this.backaudio();
Admin obj=new Admin("ADMIN DASHBOARD",accno1,color);
ViewAccountOpeningRequest.this.hideFrame();
}
if(btnop.getSource()==verify)
{
int flag=0;
 String acc=taccountno.getText();
     String status="Activated";
     String passwordvalue=tpassword.getText();
if(acc.equals("")||acc.equals("            Empty Field!"))
{
 flag=1;
       taccountno.setFont(new Font("SansSerif",Font.PLAIN,17));
       taccountno.setForeground(Color.RED);
       taccountno.setText("            Empty Field!");
    
}
if(passwordvalue.equals("")||passwordvalue.equals("                              Empty Field!"))
{
 flag=1;
       tpassword.setFont(new Font("SansSerif",Font.PLAIN,17));
       tpassword.setBackground(Color.RED);
    
}

if(flag==0)
{
 try
 {
    
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
       Statement stn1=conn.createStatement();
         Statement stn2=conn.createStatement();
     String sql="select * from accountopeningrequests where Accno="+acc+"";
     ResultSet records=stn.executeQuery(sql);
     if(records.next())
     {
     String mobile=records.getString("Mobile");
     String sql3="Delete from  accountopeningrequests where Mobile="+mobile+"";
     stn1.executeUpdate(sql3);
     String sql2="Insert into users(Fname,Lname,Age,Gender,Mobile,NIC,Address,Nationality,BranchId,Accounttype,Balance,Password,Interest,Status)values('"+records.getString("Fname")+"','"+records.getString("Lname")+"',"+records.getInt("Age")+",'"+records.getString("Gender")+"','"+records.getString("Mobile")+"','"+records.getString("NIC")+"','"+records.getString("Address")+"','"+records.getString("Nationality")+"','"+records.getString("BranchId")+"','"+records.getString("Accounttype")+"',"+records.getDouble("Balance")+",'"+passwordvalue+"',"+records.getDouble("Interest")+",'"+status+"')";
     stn2.executeUpdate(sql2);
     ViewAccountOpeningRequest.this.successaudio();
     }
 }
 catch(Exception e)
 {
JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
 }
}
}
}
}
}