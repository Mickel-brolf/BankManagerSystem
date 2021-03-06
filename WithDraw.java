import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class WithDraw extends JFrame
{
JLabel sign,Bankname,image;
JButton exit,back,withdrawbtn;
JPanel header;
JTextField withdrawbox;
int accno1,color;
WithDraw(String title,int accno,int v)
{
color=v;
accno1=accno;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,20);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font username=new Font("SansSerif",Font.BOLD,20);
Color bgcolor=new Color(52, 152, 219);
Color btncolor=new Color(52, 73, 94);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
withdrawbox=new JTextField();
withdrawbtn=new JButton("WithDraw");
withdrawbtn.setFont(btnFont);
withdrawbtn.setBackground(btncolor);
withdrawbtn.setForeground(Color.WHITE);
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
sign=new JLabel("Enter the amount:");
sign.setFont(formfont);
sign.setForeground(Color.BLACK);
sign.setBounds(25,60,300,40); 
withdrawbox.setBounds(210,60,210,40);
withdrawbtn.setBounds(120,120,200,50);
exit.setBounds(260,201,150,40);
back.setBounds(50,201,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(sign);
this.add(withdrawbox);
this.add(exit);
this.add(back);
this.add(withdrawbtn);
ChangeColor(color);
withdrawbtn.addActionListener(new MyEvents());
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,450,280);
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
 withdrawbtn.setBackground(btncolor);
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
WithDraw obj=new WithDraw("WithDraw",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
WithDraw.this.exitaudio();     
WithDraw.this.hideFrame();
}
if(btnop.getSource()==withdrawbtn)
{
    double currentbal=0;
    int flag=0;
    String withdrawamount=withdrawbox.getText();
       if(withdrawamount.equals("")||withdrawamount.equals("             Empty Field!"))
       {
       withdrawbox.setFont(new Font("SansSerif",Font.PLAIN,17));
       withdrawbox.setForeground(Color.RED);
       withdrawbox.setText("            Empty Field!");
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
       currentbal=rs.getDouble("Balance");
       double withdrawamount2=Double.parseDouble(withdrawamount);
       if(withdrawamount2<=currentbal)
       {
       currentbal-=withdrawamount2;
       String sql2="UPDATE users set Balance="+currentbal+" WHERE Accno="+accno1+"";
       stn.executeUpdate(sql2);
       WithDraw.this.successaudio(); 
       }
       else
       {
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
WithDraw.this.backaudio();    
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
WithDraw.this.hideFrame();
}
}
}
}