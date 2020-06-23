import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.io.*;
import sun.audio.*;
public class CurrencyExchange extends JFrame
{
JLabel sign,Bankname,image;
JButton exit,back,currencyexchangebtn;
JPanel header;
JComboBox currencyexchangebox;
int accno1,color;
CurrencyExchange(String title,int accno,int v)
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
currencyexchangebox=new JComboBox();
currencyexchangebox.addItem("Select Option");
currencyexchangebox.addItem("US Dollar");
currencyexchangebox.addItem("Pound");
currencyexchangebox.addItem("Euro");
currencyexchangebox.addItem("Franc");
currencyexchangebox.addItem("Dinar");
currencyexchangebox.addItem("Riyal");
currencyexchangebox.setBackground(Color.WHITE);
currencyexchangebtn=new JButton("CurrencyExchange");
currencyexchangebtn.setFont(btnFont);
currencyexchangebtn.setForeground(Color.WHITE);
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
sign=new JLabel("Select the Currency:");
sign.setFont(formfont);
sign.setForeground(Color.BLACK);
sign.setBounds(25,60,300,40); 
currencyexchangebox.setBounds(210,60,210,40);
currencyexchangebtn.setBounds(120,120,200,50);
exit.setBounds(260,201,150,40);
back.setBounds(50,201,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(sign);
this.add(currencyexchangebox);
this.add(exit);
this.add(back);
this.add(currencyexchangebtn);
currencyexchangebtn.addActionListener(new MyEvents());
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ChangeColor(color);
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,450,280);
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
 currencyexchangebtn.setBackground(btncolor);

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
CurrencyExchange obj=new CurrencyExchange("CurrencyExchange",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
CurrencyExchange.this.exitaudio();
CurrencyExchange.this.hideFrame();
}
if(btnop.getSource()==currencyexchangebtn)
{
    double currentbal=0;
    int flag=0;
    String Choice=(String)currencyexchangebox.getSelectedItem();
    DecimalFormat df = new DecimalFormat("#.##");
    if(Choice.equals("")||Choice.equals("Select Option"))
    {
        flag=1; 
        currencyexchangebox.setForeground(Color.RED);
    }
       if(flag==0)
       {
           try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="select * from users where Accno="+accno1+"";
     String send="Your Balance is equal to ";
     ResultSet rs=stn.executeQuery(sql);
     if(rs.next())
     {
       currentbal=rs.getDouble("Balance");
       if(Choice.equals("US Dollar"))
       {
       currentbal*=0.0095;
       send+=df.format(currentbal)+" dollars";
       SearchResult obj=new SearchResult("SearchResult",accno1,send,color);
       CurrencyExchange.this.successaudio();
       CurrencyExchange.this.hideFrame();
       }
       if(Choice.equals("Pound"))
       {
           
       currentbal*=0.0073;
       send+=df.format(currentbal)+" pounds";
       SearchResult obj=new SearchResult("SearchResult",accno1,send,color);
       CurrencyExchange.this.successaudio();
       CurrencyExchange.this.hideFrame();
       }
       if(Choice.equals("Euro"))
       {
       currentbal*=0.0085;
       send+=df.format(currentbal)+" euros";
       SearchResult obj=new SearchResult("SearchResult",accno1,send,color);
       CurrencyExchange.this.successaudio();
       CurrencyExchange.this.hideFrame();
       }
       if(Choice.equals("Franc"))
       {
       currentbal*=0.0559;
       send+=df.format(currentbal)+" francs";
       SearchResult obj=new SearchResult("SearchResult",accno1,send,color);
       CurrencyExchange.this.successaudio();
       CurrencyExchange.this.hideFrame();
       }
       if(Choice.equals("Dinar"))
       {
       currentbal*=0.0029;
       send+=df.format(currentbal)+" dinars";
       SearchResult obj=new SearchResult("SearchResult",accno1,send,color);
       CurrencyExchange.this.successaudio();
       CurrencyExchange.this.hideFrame();
       }
       if(Choice.equals("Riyal"))
       {
       currentbal*=0.036;
       send+=df.format(currentbal)+" riyals";
       SearchResult obj=new SearchResult("SearchResult",accno1,send,color);
       CurrencyExchange.this.successaudio();
       CurrencyExchange.this.hideFrame();
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
CurrencyExchange.this.backaudio();
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
CurrencyExchange.this.hideFrame();
}
}
}
}