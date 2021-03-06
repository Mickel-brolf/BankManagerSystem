import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class ModifyDetails extends JFrame
{
JLabel sign,Bankname,image,value;
JButton exit,back,modifybtn;
JTextField valuebox;
JPanel header;
JComboBox modifybox;
int accno1,color;
ModifyDetails(String title,int accno,int v)
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
modifybox=new JComboBox();
modifybox.addItem("Select Option");
modifybox.addItem("First name");
modifybox.addItem("Age");
modifybox.addItem("Mobile number");
modifybox.addItem("Address");
modifybox.addItem("Password");
modifybox.setBackground(Color.WHITE);
modifybtn=new JButton("ModifyDetails");
modifybtn.setFont(btnFont);
modifybtn.setForeground(Color.WHITE);
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
sign=new JLabel("Select field you want to modify: ");
sign.setFont(formfont);
sign.setForeground(Color.BLACK);
value=new JLabel("Enter the Value: ");
value.setFont(formfont);
value.setForeground(Color.BLACK);
valuebox=new JTextField();
this.setLayout(null); 
ChangeColor(color);
header.setBounds(0,0,550,50);
image.setBounds(95,0,100,50);
Bankname.setBounds(171,10,400,50);
sign.setBounds(20,60,300,40);
value.setBounds(20,120,300,40); 
valuebox.setBounds(180,120,300,40);
modifybox.setBounds(305,60,210,40);
modifybtn.setBounds(180,170,200,50);
exit.setBounds(350,230,150,40);
back.setBounds(50,230,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(sign);
this.add(value);
this.add(valuebox);
this.add(modifybox);
this.add(exit);
this.add(back);
this.add(modifybtn);
modifybtn.addActionListener(new MyEvents());
back.addActionListener(new MyEvents());
exit.addActionListener(new MyEvents());
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,550,320);
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
 modifybtn.setBackground(btncolor);
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
public void hideFrame()
{
this.dispose();
}
public static void main(String args[])
{
ModifyDetails obj=new ModifyDetails("ModifyDetails",0,0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==exit)
{
ModifyDetails.this.exitaudio();
ModifyDetails.this.hideFrame();
}
if(btnop.getSource()==modifybtn)
{
    int flag=0;
    String Choice=(String)modifybox.getSelectedItem();
    String newvalue=valuebox.getText();
    if(Choice.equals("")||Choice.equals("Select Option"))
    {
        flag=1; 
        modifybox.setForeground(Color.RED);
    }
    if(newvalue.equals("")||newvalue.equals("             Empty Field!"))
    {
        flag=1; 
        value.setFont(new Font("SansSerif",Font.PLAIN,17));
        value.setForeground(Color.RED);
        value.setText("            Empty Field!");
    
    }
       if(flag==0)
       {
           try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
     Statement stn=conn.createStatement();
         if(Choice.equals("First name"))
         {
             String sql="UPDATE users set Fname='"+newvalue+"' WHERE Accno="+accno1+"";
               stn.executeUpdate(sql);
               ModifyDetails.this.successaudio();
         }
         if(Choice.equals("Age"))
         {
             int val=Integer.parseInt(newvalue);
             String sql2="UPDATE users set Age="+val+" WHERE Accno="+accno1+"";
              stn.executeUpdate(sql2);
              ModifyDetails.this.successaudio();
         }
         if(Choice.equals("Mobile number"))
         {
             String sql3="UPDATE users set Mobile='"+newvalue+"' WHERE Accno="+accno1+"";
             stn.executeUpdate(sql3);
             ModifyDetails.this.successaudio();
         }  
         if(Choice.equals("Address"))
         {
             String sql4="UPDATE users set Address='"+newvalue+"' WHERE Accno="+accno1+"";
             stn.executeUpdate(sql4);
             ModifyDetails.this.successaudio();
         }
         if(Choice.equals("Password"))
         {
             String sql5="UPDATE users set Password='"+newvalue+"' WHERE Accno="+accno1+"";
             stn.executeUpdate(sql5);
             ModifyDetails.this.successaudio();
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
ModifyDetails.this.backaudio();
UserTransactions obj=new UserTransactions("Transactions",accno1,color);
ModifyDetails.this.hideFrame();
}
}
}
}