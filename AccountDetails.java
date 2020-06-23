import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class AccountDetails extends JFrame
{
JLabel display_name,Bankname,image,display_lname,mobile,nic,address,nationality,branchid,accounttype,bal,interest;
JButton exit,back;
JPanel header;
int accno1,color;
AccountDetails(String title,int accno,int v)
{
color=v;
accno1=accno;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,15);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font username=new Font("SansSerif",Font.BOLD,20);
Color bgcolor=new Color(52, 152, 219);
Color btncolor=new Color(52, 73, 94);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
try
 {
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="select * from users where Accno="+accno+"";
     ResultSet rs=stn.executeQuery(sql);
     if(rs.next())
     {
         display_name=new JLabel("First Name: "+rs.getString("Fname"));
         display_name.setFont(username);
         display_name.setForeground(Color.BLACK);
         display_lname=new JLabel("Last Name: "+rs.getString("Lname"));
         display_lname.setFont(username);
         display_lname.setForeground(Color.BLACK);
         mobile=new JLabel("Mobile No: "+rs.getString("Mobile"));
         mobile.setFont(username);
         mobile.setForeground(Color.BLACK);
         nic=new JLabel("Nic No: "+rs.getString("NIC"));
         nic.setFont(username);
         nic.setForeground(Color.BLACK);
         address=new JLabel("Address: "+rs.getString("Address"));
         address.setFont(username);
         address.setForeground(Color.BLACK);
         nationality=new JLabel("Nationality: "+rs.getString("Nationality"));
         nationality.setFont(username);
         nationality.setForeground(Color.BLACK);
         branchid=new JLabel("Branch Id : "+rs.getString("BranchId"));
         branchid.setFont(username);
         branchid.setForeground(Color.BLACK);
         accounttype=new JLabel("Account Type: "+rs.getString("Accounttype"));
         accounttype.setFont(username);
         accounttype.setForeground(Color.BLACK);
         bal=new JLabel("Current Balance: "+rs.getString("Balance"));
         bal.setFont(username);
         bal.setForeground(Color.BLACK);
         interest=new JLabel("Interest Rate: "+rs.getString("Interest"));
         interest.setFont(username);
         interest.setForeground(Color.BLACK);
         display_name.setBounds(30,51,300,40);   
         display_lname.setBounds(30,91,300,40); 
         mobile.setBounds(30,131,300,40);
         nic.setBounds(30,171,300,40);
         address.setBounds(30,211,300,40);
         nationality.setBounds(30,251,300,40);
         branchid.setBounds(30,291,300,40);
         accounttype.setBounds(30,331,300,40);
         bal.setBounds(30,371,300,40);
         interest.setBounds(30,411,300,40);
     }
 }
 catch(Exception e)
 {
JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
 }

exit=new JButton("EXIT");
back=new JButton("BACK");
Bankname.setForeground(Color.WHITE);
Bankname.setFont(bankline);
exit.setFont(btnFont);
exit.setBackground(Color.RED);
exit.setForeground(Color.WHITE);
exit.setCursor(handpointer);
back.setFont(btnFont);
back.setBackground(btncolor);
back.setCursor(handpointer);
back.setForeground(Color.WHITE);
header.setBackground(btncolor);
this.setLayout(null);
header.setBounds(0,0,500,50);
image.setBounds(45,0,100,50);
Bankname.setBounds(121,10,400,50);
exit.setBounds(260,451,150,40);
back.setBounds(50,451,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(display_name);
this.add(display_lname);
this.add(mobile);
this.add(nic);
this.add(address);
this.add(nationality);
this.add(branchid);
this.add(accounttype);
this.add(bal);
this.add(interest);
this.add(exit);
this.add(back);
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ChangeColor(color);
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,450,530);
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
 header.setBackground(btncolor); 
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
public void hideFrame()
{
this.dispose();
}
public static void main(String args[])
{
AccountDetails obj=new AccountDetails("AccountDetails",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
AccountDetails.this.exitaudio();   
AccountDetails.this.hideFrame();
}
if(btnop.getSource()==back)
{
AccountDetails.this.backaudio();
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
AccountDetails.this.hideFrame();
}
}
}
}