import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class Complain extends JFrame
{
JLabel sign,Bankname,image;
JButton exit,back,complainbtn;
JPanel header;
JTextArea complainbox;
int accno1,color;
Complain(String title,int accno,int v)
{
color=v;
accno1=accno;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,20);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font username=new Font("SansSerif",Font.BOLD,20);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
complainbox=new JTextArea();
complainbtn=new JButton("Complain");
complainbtn.setFont(btnFont);

complainbtn.setForeground(Color.WHITE);
exit=new JButton("EXIT");
back=new JButton("BACK");
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
header.setBounds(0,0,600,50);
image.setBounds(95,0,100,50);
Bankname.setBounds(171,10,400,50);
sign=new JLabel("Enter Your Complain:");
sign.setFont(formfont);
sign.setForeground(Color.BLACK);
sign.setBounds(25,60,300,40); 
complainbox.setBounds(20,100,560,100);
complainbtn.setBounds(190,220,200,50);
exit.setBounds(400,301,150,40);
back.setBounds(50,301,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(sign);
this.add(complainbox);
this.add(exit);
this.add(back);
this.add(complainbtn);
complainbtn.addActionListener(new MyEvents());
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ChangeColor(color);
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,600,400);
this.setVisible(true);
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
 back.setBackground(btncolor);
 complainbtn.setBackground(btncolor);
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
public void hideFrame()
{
this.dispose();
}
public static void main(String args[])
{
Complain obj=new Complain("Complain",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
Complain.this.exitaudio();    
Complain.this.hideFrame();
}
if(btnop.getSource()==complainbtn)
{
    int flag=0;
    String complain=complainbox.getText();
       if(complain.equals("")||complain.equals("             Empty Field!"))
       {
       complainbox.setFont(new Font("SansSerif",Font.PLAIN,17));
       complainbox.setForeground(Color.RED);
       complainbox.setText("                                                   Empty Field!");
       flag=1;
       }
       if(flag==0)
       {
           try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="select * from users where Accno="+accno1+"";
     ResultSet rs=stn.executeQuery(sql);
     if(rs.next())
     {
        String name=rs.getString("Fname")+" "+rs.getString("Lname");
        String sql2="Create Table Complains(Complain varchar(300),Name varchar(50),Accno int(250))";
        //stn.executeUpdate(sql2);
        String sql3="Insert into Complains(Complain,Name,Accno)Values('"+complain+"','"+name+"',"+accno1+")";
        stn.executeUpdate(sql3);
        Complain.this.successaudio();
     }
           }
           catch(Exception e)
           {
           JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
           }
       }
    
}
if(btnop.getSource()==back)
{
Complain.this.backaudio();
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
Complain.this.hideFrame();
}
}
}
}