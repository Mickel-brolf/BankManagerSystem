import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class Login extends JFrame
{
JLabel userid,password,signin,Bankname,image;
JButton login,back;
JPanel header;
JTextField tname;
JPasswordField tpassword;
int color;
Login(String title,int v)
{
    color=v;
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
Font formfont=new Font("SansSerif",Font.PLAIN,15);
Font btnFont=new Font("SansSerif",Font.PLAIN,15);
Font bankline=new Font("SansSerif",Font.BOLD,25);
Font signinfont=new Font("SansSerif",Font.BOLD,20);
Color bgcolor=new Color(52, 152, 219);
Color btncolor=new Color(52, 73, 94);
header=new JPanel(null);
Bankname=new JLabel("ACE BANK LIMITED");
ImageIcon img=new ImageIcon("logo.png");
image=new JLabel(img);
signin=new JLabel("SignIn");
userid=new JLabel("Enter the User Id No:");
tname=new JTextField();
tpassword=new JPasswordField();
password=new JLabel("Enter the password:");
login=new JButton("LOGIN");
back=new JButton("BACK");
Bankname.setForeground(Color.WHITE);
Bankname.setFont(bankline);
signin.setFont(signinfont);
signin.setForeground(Color.BLACK);
login.setFont(btnFont);
login.setBackground(btncolor);
login.setForeground(Color.WHITE);
login.setCursor(handpointer);
back.setFont(btnFont);
back.setBackground(btncolor);
back.setCursor(handpointer);
back.setForeground(Color.WHITE);
userid.setForeground(Color.BLACK);
userid.setFont(formfont);
password.setForeground(Color.BLACK);
password.setFont(formfont);
header.setBackground(btncolor);
this.setLayout(null);
header.setBounds(0,0,500,50);
image.setBounds(45,0,100,50);
Bankname.setBounds(121,10,400,50);
signin.setBounds(200,60,400,50);
userid.setBounds(43,110,150,40);
tname.setBounds(180,110,220,35);
password.setBounds(43,160,150,40);
tpassword.setBounds(180,165,220,35);
login.setBounds(260,220,150,40);
back.setBounds(50,220,150,40);
this.add(header);
header.add(image);
header.add(Bankname);
this.add(signin);
this.add(userid);
this.add(tname);
this.add(password);
this.add(tpassword);
this.add(login);
this.add(back);
ChangeColor(color);
back.addActionListener(new MyEvents());
login.addActionListener(new MyEvents());
ImageIcon icon=new ImageIcon("i2.jpg");
this.setIconImage(icon.getImage());
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,450,300);
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
 login.setBackground(btncolor);
  back.setBackground(btncolor);
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
public void hideFrame()
{
this.dispose();
}
public static void main(String args[])
{
Login obj=new Login("LOGIN",0);
} 
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent btnop)
{
if(btnop.getSource()==back)
{
Login.this.backaudio();
StartUp obj=new StartUp("HOME",color);
Login.this.hideFrame();
}
if(btnop.getSource()==login)
{
try
{
    String name=tname.getText();
    String pass=tpassword.getText();
    int flag=0;
   if(name.equals("")||name.equals("             Empty Field!"))
   {
       tname.setFont(new Font("SansSerif",Font.PLAIN,17));
       tname.setForeground(Color.RED);
       tname.setText("             Empty Field!");
       flag=1;
   }
    if(pass.equals(""))
   {
       tpassword.setBackground(Color.RED);
       flag=1;
   }
    if(flag==0)
    {
    Connection conn;
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
    Statement stn=conn.createStatement();
     String query3="select * from users where Accno="+name+"";
    ResultSet run=stn.executeQuery(query3);
    if(run.next())
    {
        String pass2=run.getString("Password");
        int name2=run.getInt("Accno");
        int name3=Integer.parseInt(name);
        if(pass.equals(pass2)&&name2==1)
        {
            Admin obj=new Admin("ADMIN DASHBOARD",name2,color);
            Login.this.backaudio();
            Login.this.hideFrame();
        }
        else if(pass.equals(pass2)&&name3==name2)
    {
    UserTransactions obj=new UserTransactions("Transactions",run.getInt("Accno"),color);
    Login.this.backaudio();
    Login.this.hideFrame();
    }
        if(!pass.equals(pass2))
        {
            
             Login.this.incorrectaudio();
    JOptionPane.showMessageDialog(null,"The Password is Incorrect!","Error message",JOptionPane.ERROR_MESSAGE); 
        }
    }
    else
    {
       Login.this.incorrectaudio();
    JOptionPane.showMessageDialog(null,"The ID is Incorrect!","Error message",JOptionPane.ERROR_MESSAGE); 
    }
    
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