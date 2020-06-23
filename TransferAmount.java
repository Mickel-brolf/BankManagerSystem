import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class TransferAmount extends JFrame
{
JLabel sign,Bankname,image,receipientid;
JButton exit,back,transferamountbtn;
JPanel header;
JTextField transferamountbox,receipientbox;
int accno1,color;
TransferAmount(String title,int accno,int v)
{
color=v;    
accno1=accno;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,19);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font username=new Font("SansSerif",Font.BOLD,20);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
sign=new JLabel("Enter the amount:");
sign.setFont(formfont);
sign.setForeground(Color.BLACK);
receipientid=new JLabel("Enter The Receipient Accno:");
receipientbox=new JTextField();
receipientid.setFont(formfont);
receipientid.setForeground(Color.BLACK);
receipientid.setBounds(18,120,300,40); 
receipientbox.setBounds(270,120,210,40);
transferamountbox=new JTextField(); 
transferamountbtn=new JButton("TransferAmount");
transferamountbtn.setFont(btnFont);
transferamountbtn.setForeground(Color.WHITE);
transferamountbox.setBounds(270,60,210,40);
sign.setBounds(110,60,300,40); 
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
header.setBounds(0,0,500,50);
image.setBounds(45,0,100,50);
Bankname.setBounds(121,10,400,50);
transferamountbtn.setBounds(150,201,200,50);
exit.setBounds(300,301,150,40);
back.setBounds(50,301,150,40);
ChangeColor(color);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(sign);
this.add(receipientid);
this.add(receipientbox);
this.add(transferamountbox);
this.add(exit);
this.add(back);
this.add(transferamountbtn);
transferamountbtn.addActionListener(new MyEvents());
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,500,400);
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
 transferamountbtn.setBackground(btncolor);
 header.setBackground(btncolor); 
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
public void incorrectaudio()
{
    try{
 InputStream mysoundfile=new FileInputStream(new File("in.wav"));
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
TransferAmount obj=new TransferAmount("TransferAmount",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
TransferAmount.this.exitaudio();
TransferAmount.this.hideFrame();
}
if(btnop.getSource()==transferamountbtn)
{
    int receivercurrentbal=0;
    double currentbal=0;
    int flag=0;
    String transferamount=transferamountbox.getText();
    String receipientid=receipientbox.getText();
       if(transferamount.equals("")||transferamount.equals("             Empty Field!"))
       {
       transferamountbox.setFont(new Font("SansSerif",Font.PLAIN,17));
       transferamountbox.setForeground(Color.RED);
       transferamountbox.setText("            Empty Field!");
       flag=1;
       }
       if(receipientid.equals("")||receipientid.equals("             Empty Field!"))
       {
       receipientbox.setFont(new Font("SansSerif",Font.PLAIN,17));
       receipientbox.setForeground(Color.RED);
       receipientbox.setText("            Empty Field!");
       flag=1;
       }
       int receiveraccno=Integer.parseInt(receipientid);
       if(flag==0)
       {
           try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="select * from users where Accno="+accno1+"";
     String sql2="select * from users where Accno="+receiveraccno+"";
       ResultSet rs=stn.executeQuery(sql2);
       if(rs.next())
       {
         receivercurrentbal=rs.getInt("Balance");
       }
     rs=stn.executeQuery(sql);
     if(rs.next())
     {
       currentbal=rs.getDouble("Balance");
       double transferamount2=Double.parseDouble(transferamount);
       if(transferamount2<=currentbal)
       {
       currentbal-=transferamount2;
       receivercurrentbal+=transferamount2;
       String sql3="UPDATE users set Balance="+currentbal+" WHERE Accno="+accno1+"";
       String sql4="UPDATE users set Balance="+receivercurrentbal+" WHERE Accno="+receiveraccno+"";
       stn.executeUpdate(sql3);
       stn.executeUpdate(sql4);
       TransferAmount.this.successaudio();
       }
       else
       {
            TransferAmount.this.incorrectaudio();
         JOptionPane.showMessageDialog(null,"Insufficent amount in the account","Error message",JOptionPane.ERROR_MESSAGE);   
       }
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
TransferAmount.this.backaudio();
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
TransferAmount.this.hideFrame();
}
}
}
}