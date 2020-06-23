import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class UserTransactions extends JFrame
{
JPanel header;
JLabel logo,bankname,selectline,display_name;
JButton bal,inst,dep,withd,tcash,search,currencyexc,accdetails,close,modifydet,complain,exit;
int accno1;
int color;
UserTransactions(String title,int accno,int v)
{
    color=v;
accno1=accno;
ImageIcon icon=new ImageIcon("i2.jpg");
ImageIcon img=new ImageIcon("logo.png");
logo=new JLabel(img);
Font banknamefont=new Font("SansSerif",Font.BOLD,25);
Font selectlinefont=new Font("SansSerif",Font.BOLD,20);
Font username=new Font("SansSerif",Font.BOLD,25);
Font btnfont=new Font("SansSerif",Font.PLAIN,15);
Color btncolor=new Color(52, 73, 94);
Color bgcolor=new Color(52, 152, 219);
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
 try
 {
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
     String sql="select * from users where Accno="+accno+"";
     ResultSet rs=stn.executeQuery(sql);
     if(rs.next())
     {
         display_name=new JLabel("Welcome"+"  "+rs.getString("Fname")+"  "+rs.getString("Lname"));
         display_name.setFont(username);
         display_name.setForeground(Color.BLACK);
         display_name.setBounds(190,51,300,40);   
     }
 }
 catch(Exception e)
 {
JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
 }
this.setLayout(null);
header=new JPanel(null);
bankname=new JLabel("ACE BANK LIMITED");
bankname.setFont(btnfont);
bankname.setForeground(Color.WHITE);
selectline=new JLabel("Select your transaction");
selectline.setFont(username);
selectline.setForeground(Color.BLACK);
bal=new JButton("Balance Inquiry");
bal.setFont(btnfont);
bal.setForeground(Color.WHITE);
bal.setCursor(handpointer);
bal.addActionListener(new MyEvents());
inst=new JButton("Interest Inquiry");
inst.setFont(btnfont);
inst.setForeground(Color.WHITE);
inst.setCursor(handpointer);
inst.addActionListener(new MyEvents());
dep=new JButton("Deposit");
dep.setFont(btnfont);
dep.setForeground(Color.WHITE);
dep.setCursor(handpointer);
dep.addActionListener(new MyEvents());
withd=new JButton("With Draw");
withd.setFont(btnfont);
withd.setForeground(Color.WHITE);
withd.setCursor(handpointer);
withd.addActionListener(new MyEvents());
tcash=new JButton("Transfer Cash");
tcash.setFont(btnfont);
tcash.setForeground(Color.WHITE);
tcash.setCursor(handpointer);
tcash.addActionListener(new MyEvents());
search=new JButton("Search");
search.setFont(btnfont);
search.setForeground(Color.WHITE);
search.setCursor(handpointer);
search.addActionListener(new MyEvents());
currencyexc=new JButton("Currency Exchange");
currencyexc.setFont(btnfont);
currencyexc.setForeground(Color.WHITE);
currencyexc.setCursor(handpointer);
currencyexc.addActionListener(new MyEvents());
accdetails=new JButton("Account Details");
accdetails.setFont(btnfont);
accdetails.setForeground(Color.WHITE);
accdetails.setCursor(handpointer);
accdetails.addActionListener(new MyEvents());
close=new JButton("Close Account");
close.setFont(btnfont);
close.setForeground(Color.WHITE);
close.setCursor(handpointer);
close.addActionListener(new MyEvents());
modifydet=new JButton("Modify Details");
modifydet.setFont(btnfont);
modifydet.setForeground(Color.WHITE);
modifydet.setCursor(handpointer);
modifydet.addActionListener(new MyEvents());
complain=new JButton("Complain");
complain.setFont(btnfont);
complain.setForeground(Color.WHITE);
complain.setCursor(handpointer);
complain.addActionListener(new MyEvents());
exit=new JButton("Exit");
exit.setFont(btnfont);
exit.setForeground(Color.WHITE);
exit.setBackground(Color.RED);
exit.setCursor(handpointer);
exit.addActionListener(new MyEvents());
header.setBounds(0,0,600,50);
selectline.setBounds(10,100,300,40);
bal.setBounds(350,102,230,40);
inst.setBounds(350,152,230,40);
dep.setBounds(350,202,230,40);
withd.setBounds(350,252,230,40);
tcash.setBounds(350,302,230,40);
search.setBounds(350,352,230,40);
currencyexc.setBounds(350,402,230,40);
accdetails.setBounds(350,452,230,40);
modifydet.setBounds(350,502,230,40);
complain.setBounds(350,552,230,40);
close.setBounds(350,602,230,40);
exit.setBounds(10,602,230,40);
bankname.setBounds(200,0,250,50);
bankname.setFont(banknamefont);
logo.setBounds(150,0,50,50);
ChangeColor(color);
this.add(header);
header.add(logo);
header.add(bankname);
this.add(selectline);
this.add(bal);
this.add(inst);
this.add(dep);
this.add(withd);
this.add(tcash);
this.add(search);
this.add(currencyexc);
this.add(accdetails);
this.add(close);
this.add(modifydet);
this.add(complain);
this.add(display_name);
this.add(exit);
this.setTitle(title);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setResizable(false);
this.setIconImage(icon.getImage());
this.setBounds(500,100,600,690);
this.setVisible(true);
}
public void closeFrame()
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
 bal.setBackground(btncolor);
 inst.setBackground(btncolor);
dep.setBackground(btncolor);
withd.setBackground(btncolor);
tcash.setBackground(btncolor);
search.setBackground(btncolor);
currencyexc.setBackground(btncolor);
accdetails.setBackground(btncolor);
close.setBackground(btncolor);
modifydet.setBackground(btncolor);
complain.setBackground(btncolor);
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
UserTransactions obj=new UserTransactions("Transactions",0,0);
}
public class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent op)
{
if(op.getSource()==bal)
{
    UserTransactions.this.backaudio();
    BalanceInquiry obj=new BalanceInquiry("BalanceInquiry",accno1,color);
    UserTransactions.this.closeFrame(); 
}
  if(op.getSource()==inst)
{
   UserTransactions.this.backaudio();
   InterestInquiry obj=new InterestInquiry("InterestInquiry",accno1,color);
   UserTransactions.this.closeFrame(); 
}
  if(op.getSource()==dep)
{
   UserTransactions.this.backaudio();
   Deposit obj=new Deposit("DEPOSIT",accno1,color);
   UserTransactions.this.closeFrame(); 
}
  if(op.getSource()==withd)
{
  UserTransactions.this.backaudio();  
  WithDraw obj=new WithDraw("WithDraw",accno1,color); 
  UserTransactions.this.closeFrame();  
}
  if(op.getSource()==tcash)
{
    UserTransactions.this.backaudio();
    TransferAmount obj=new TransferAmount("TransferAmount",accno1,color);
    UserTransactions.this.closeFrame();   
}
if(op.getSource()==search)
{  UserTransactions.this.backaudio();
   Search obj=new Search("Search",accno1,color);
   UserTransactions.this.closeFrame(); 
}
if(op.getSource()==currencyexc)
{   UserTransactions.this.backaudio();
    CurrencyExchange obj=new CurrencyExchange("CurrencyExchange",accno1,color);
    UserTransactions.this.closeFrame();
}
if(op.getSource()==accdetails)
{   UserTransactions.this.backaudio();
    AccountDetails obj=new AccountDetails("AccountDetails",accno1,color);
    UserTransactions.this.closeFrame();
}
if(op.getSource()==close)
{
    UserTransactions.this.backaudio();
    CloseAccount obj=new CloseAccount("CloseAccount",accno1,color);
    UserTransactions.this.closeFrame();
}
if(op.getSource()==modifydet)
{   UserTransactions.this.backaudio();
    ModifyDetails obj=new ModifyDetails("ModifyDetails",accno1,color);
    UserTransactions.this.closeFrame();  
}
if(op.getSource()==complain)
{   UserTransactions.this.backaudio();
    Complain obj=new Complain("Complain",accno1,color);
    UserTransactions.this.closeFrame();
}
if(op.getSource()==exit)
{
    UserTransactions.this.exitaudio();
    UserTransactions.this.closeFrame();
}
}
}
}