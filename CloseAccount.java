import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.* ;
public class CloseAccount extends JFrame
{
JLabel display_name,Bankname,image;
JButton yes,no;
JPanel header;
int accno1,color;
CloseAccount(String title,int accno,int v)
{
color=v;
accno1=accno;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,15);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font username=new Font("SansSerif",Font.BOLD,20);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
 display_name=new JLabel("Are You Sure You Want to Close?");
 display_name.setFont(username);
 display_name.setForeground(Color.BLACK);
 display_name.setBounds(60,51,400,40);   
yes=new JButton("YES");
no=new JButton("NO");
Bankname.setForeground(Color.WHITE);
Bankname.setFont(bankline);
yes.setFont(btnFont);
yes.setBackground(Color.RED);
yes.setForeground(Color.WHITE);
yes.setCursor(handpointer);
no.setFont(btnFont);
no.setCursor(handpointer);
no.setForeground(Color.WHITE);
this.setLayout(null);
header.setBounds(0,0,500,50);
image.setBounds(45,0,100,50);
Bankname.setBounds(121,10,400,50);
yes.setBounds(50,101,150,40);
no.setBounds(260,101,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(display_name);
this.add(yes);
this.add(no);
no.addActionListener(new MyEvents());
yes.addActionListener(new MyEvents());
ImageIcon icon=new ImageIcon("i2.jpg");
ChangeColor(color);
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,450,200);
this.setVisible(true);
}
public void hideFrame()
{
this.dispose();
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
 no.setBackground(btncolor);

 header.setBackground(btncolor); 
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
CloseAccount obj=new CloseAccount("CloseAccount",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
    if(btnop.getSource()==yes)
    {      
     try
    {
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="Create Table ClosingRequests(Accno int(200) unsigned auto_increment primary key,Fname varchar(50),Lname varchar(20),Age Int(200),Gender varchar(15),Mobile varchar(11),NIC varchar(15),Address varchar(100),Nationality varchar(30),BranchId varchar(20),Accounttype varchar(30),Balance decimal(65),Interest decimal(64),Status varchar(15))";
     //stn.executeUpdate(sql);
     String sql2="select * from users where Accno="+accno1+"";
     ResultSet run=stn.executeQuery(sql2);
     if(run.next()){
     String sql3="Insert into ClosingRequests(Fname,Lname,Mobile,NIC,Nationality,BranchId,Address,Balance,Gender,Age,Accounttype,Interest,Status)values('"+run.getString("Fname")+"','"+run.getString("Lname")+"','"+run.getString("Mobile")+"','"+run.getString("NIC")+"','"+run.getString("Nationality")+"','"+run.getString("BranchId")+"','"+run.getString("Address")+"',"+run.getString("Balance")+",'"+run.getString("Gender")+"',"+run.getString("Age")+",'"+run.getString("Accounttype")+"',"+run.getString("Interest")+",'"+run.getString("Status")+"')";
     stn.executeUpdate(sql3);
     }
     CloseAccount.this.exitaudio();
     CloseAccount.this.hideFrame();
  }
 catch(Exception e)
 {
JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
 }   
    }
if(btnop.getSource()==no)
{
CloseAccount.this.backaudio();
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
CloseAccount.this.hideFrame();
}
}
}
}