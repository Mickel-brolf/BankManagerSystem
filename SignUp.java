import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import sun.audio.*;
public class SignUp extends JFrame
{
JPanel header;
JLabel bankname,signup,name,lastname,age,nicno,initialdeposit,accounttype,mobilenumber,address,gender,nationality,branchid;
JTextField tname,tlastname,tnicno,tinitialdeposit,tmobileno,tnationality,tbranchid;
JTextArea taddress;
JComboBox tage,taccounttype,tgender;
JButton back,signupbtn;
int color;
SignUp(String title,int v)
{
    color=v;
ImageIcon icon=new ImageIcon("i2.jpg");
ImageIcon image=new ImageIcon("logo.png");
JLabel img=new JLabel(image);
Font signupfont=new Font("SansSerif",Font.BOLD,20);
Font banknamefont=new Font("SansSerif",Font.BOLD,25);
Font label=new Font("SansSerif",Font.PLAIN,15);
Color bgcolor=new Color(52, 152, 219);
Color btncolor=new Color(52, 73, 94);
Color labelcolor=new Color(0,0,0);
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
header=new JPanel(null);
header.setBackground(btncolor);
bankname=new JLabel("ACE BANK LIMITED");
bankname.setForeground(Color.WHITE);
bankname.setFont(banknamefont);
signup=new JLabel("Sign Up");
signup.setForeground(Color.BLACK);
signup.setFont(signupfont);
name=new JLabel("Enter Your First Name:");
name.setForeground(labelcolor);
name.setFont(label);
lastname=new JLabel("Enter Your Last Name:");
lastname.setForeground(labelcolor);
lastname.setFont(label);
age=new JLabel("Select Your Age:");
age.setForeground(labelcolor);
age.setFont(label);
nicno=new JLabel("Enter Your NIC Number:");
nicno.setForeground(labelcolor);
nicno.setFont(label);
initialdeposit=new JLabel("Enter The Initial Deposit:");
initialdeposit.setForeground(labelcolor);
initialdeposit.setFont(label);
accounttype=new JLabel("Select the account type:");
accounttype.setForeground(labelcolor);
accounttype.setFont(label);
mobilenumber=new JLabel("Enter Your Mobile Number:");
mobilenumber.setForeground(labelcolor);
mobilenumber.setFont(label);
address=new JLabel("Enter Your Address:");
address.setForeground(labelcolor);
address.setFont(label);
gender=new JLabel("Select Your Gender:");
gender.setForeground(labelcolor);
gender.setFont(label);
nationality=new JLabel("Enter Your Nationality:");
nationality.setForeground(labelcolor);
nationality.setFont(label);
branchid=new JLabel("Enter BranchId:");
branchid.setForeground(labelcolor);
branchid.setFont(label);
tname=new JTextField();
tlastname=new JTextField();
tnicno=new JTextField();
tinitialdeposit=new JTextField();
taddress=new JTextArea(8,5);
tmobileno=new JTextField();
tnationality=new JTextField();
tbranchid=new JTextField();
back=new JButton("BACK");
back.setForeground(Color.WHITE);
back.setFont(label);
back.setCursor(handpointer);
back.setBackground(Color.RED);
signupbtn=new JButton("SIGN UP");
signupbtn.setForeground(Color.WHITE);
signupbtn.setFont(label);
signupbtn.setCursor(handpointer);
signupbtn.setBackground(btncolor);
tage=new JComboBox();
tage.addItem(0);
tage.addItem(18);
tage.addItem(19);
tage.addItem(20);
tage.addItem(21);
tage.addItem(22);
tage.addItem(23);
tage.addItem(24);
tage.addItem(25);
tage.addItem(26);
tage.addItem(27);
tage.addItem(28);
tage.addItem(29);
tage.addItem(30);
tage.addItem(31);
tage.addItem(32);
tage.addItem(33);
tage.addItem(34);
tage.addItem(35);
tage.addItem(36);
tage.addItem(37);
tage.addItem(38);
tage.addItem(39);
tage.addItem(40);
tage.addItem(41);
tage.addItem(42);
tage.addItem(43);
tage.addItem(44);
tage.addItem(45);
tage.addItem(46);
tage.addItem(47);
tage.addItem(48);
tage.addItem(49);
tage.addItem(50);
tage.addItem(51);
tage.addItem(52);
tage.addItem(53);
tage.addItem(54);
tage.addItem(55);
tage.addItem(56);
tage.addItem(57);
tage.addItem(58);
tage.addItem(59);
tage.addItem(60);
tage.addItem(61);
tage.addItem(62);
tage.addItem(63);
tage.addItem(64);
tage.addItem(65);
tage.addItem(66);
tage.addItem(67);
tage.addItem(68);
tage.addItem(69);
tage.addItem(70);
tage.addItem(71);
tage.addItem(72);
tage.addItem(73);
tage.addItem(74);
tage.addItem(75);
tage.addItem(76);
tage.addItem(77);
tage.addItem(78);
tage.addItem(79);
tage.addItem(80);
tage.addItem(81);
tage.addItem(82);
tage.addItem(83);
tage.addItem(84);
tage.addItem(85);
tage.addItem(86);
tage.addItem(87);
tage.addItem(88);
tage.addItem(89);
tage.addItem(90);
tage.addItem(91);
tage.addItem(92);
tage.addItem(93);
tage.addItem(94);
tage.addItem(95);
tage.addItem(96);
tage.addItem(97);
tage.addItem(98);
tage.addItem(99);
tage.addItem(100);
taccounttype=new JComboBox();
taccounttype.addItem("Select Account Type");
taccounttype.addItem("Current");
taccounttype.addItem("Savings");
tgender=new JComboBox();
tgender.addItem("Select Gender");
tgender.addItem("Male");
tgender.addItem("Female");
tgender.addItem("Other");
this.setLayout(null);
header.setBounds(0,0,500,50);
signup.setBounds(220,51,150,40);
name.setBounds(10,100,150,40);
tname.setBounds(220,100,240,30);
lastname.setBounds(10,140,150,40);
tlastname.setBounds(220,140,240,30);
age.setBounds(10,180,150,40);
tage.setBounds(220,190,240,20);
gender.setBounds(10,210,150,40);
tgender.setBounds(220,220,240,20);
mobilenumber.setBounds(10,250,180,40);
tmobileno.setBounds(220,250,240,30);
nicno.setBounds(10,290,180,40);
tnicno.setBounds(220,290,240,30);
address.setBounds(10,340,150,40);
taddress.setBounds(220,330,240,70);
nationality.setBounds(10,410,150,40);
tnationality.setBounds(220,410,240,30);
branchid.setBounds(10,450,150,40);
tbranchid.setBounds(220,450,240,30);
accounttype.setBounds(10,490,180,40);
taccounttype.setBounds(220,500,240,20);
initialdeposit.setBounds(10,530,180,40);
tinitialdeposit.setBounds(220,530,240,30);
back.setBounds(20,600,200,40);
signupbtn.setBounds(280,600,200,40);
bankname.setBounds(121,10,400,50);
this.ChangeColor(color);
img.setBounds(45,0,100,50);
back.addActionListener(new MyEvents());
signupbtn.addActionListener(new MyEvents());
this.add(header);
header.add(img);
header.add(bankname);
this.add(tlastname);
this.add(tnicno);
this.add(tinitialdeposit);
this.add(taddress);
this.add(tmobileno);
this.add(tnationality);
this.add(tbranchid);
this.add(tage);
this.add(taccounttype);
this.add(tgender);
this.add(tmobileno);
this.add(signup);
this.add(name);
this.add(lastname);
this.add(age);
this.add(gender);
this.add(nationality);
this.add(nicno);
this.add(mobilenumber);
this.add(address);
this.add(accounttype);
this.add(initialdeposit);
this.add(branchid);
this.add(tname);
this.add(tage);
this.add(back);
this.add(signupbtn);
this.setIconImage(icon.getImage());
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,150,500,680);
this.setResizable(false);
this.setVisible(true);

}
public void hideFrame()
{
this.dispose();
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
 signupbtn.setBackground(btncolor);
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
SignUp obj=new SignUp("Create Account",0);
}
class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent op)
{
if(op.getSource()==signupbtn)
{
    try{
    Connection conn;
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
    Statement stn=conn.createStatement();
    String query="Create Table users(Accno int(200) unsigned auto_increment primary key,Fname varchar(50),Lname varchar(20),Age Int(200),Gender varchar(15),Mobile varchar(11),NIC varchar(15),Address varchar(100),Nationality varchar(30),BranchId varchar(20),Accounttype varchar(30),Balance decimal(65),Password varchar(10),Interest decimal(64),Status varchar(15))";
    //stn.executeUpdate(query);
    String query5="Create Table accountopeningrequests(Accno int(200) unsigned auto_increment primary key,Fname varchar(50),Lname varchar(20),Age Int(200),Gender varchar(15),Mobile varchar(11),NIC varchar(15),Address varchar(100),Nationality varchar(30),BranchId varchar(20),Accounttype varchar(30),Balance decimal(65),Interest decimal(64))";
    //stn.executeUpdate(query5);
    String fname=tname.getText();
    String lname=tlastname.getText();
    String nic=tnicno.getText();
    String mobile=tmobileno.getText();
    String nationality=tnationality.getText();
    String bid=tbranchid.getText();
    String address=taddress.getText();
    String gender=(String)tgender.getSelectedItem();
    String accountype=(String)taccounttype.getSelectedItem();
    int age=(int)tage.getSelectedItem();
    float bal=0;
    String initial=tinitialdeposit.getText();
    int flag=0;
      if(mobile.length()<11||mobile.length()>11)
    {
        flag=1; 
        tmobileno.setFont(new Font("SansSerif",Font.BOLD,17));
        tmobileno.setForeground(Color.RED);
        tmobileno.setText("             Mobile number is of length 11!");
    }
       if(nic.length()<15||nic.length()>15)
    {
        flag=1; 
        tnicno.setFont(new Font("SansSerif",Font.BOLD,17));
        tnicno.setForeground(Color.RED);
        tnicno.setText("             NIC number is of length 15!");
    }
    if(accountype.equals("Select Account Type"))
    {
        flag=1; 
        taccounttype.setForeground(Color.RED);
    }
    if(gender.equals("Select Gender"))
    {
        flag=1; 
        tgender.setForeground(Color.RED);
    }
      if(age==0)
    {
        flag=1; 
        tage.setForeground(Color.RED);
    }
     if(initial.equals("")||initial.equals("             Empty Field!"))
    {
        flag=1; 
        tinitialdeposit.setFont(new Font("SansSerif",Font.BOLD,17));
        tinitialdeposit.setForeground(Color.RED);
        tinitialdeposit.setText("             Empty Field!");
    }
    if(bid.equals("")||bid.equals("             Empty Field!"))
    {
        flag=1; 
        tbranchid.setFont(new Font("SansSerif",Font.BOLD,17));
        tbranchid.setForeground(Color.RED);
        tbranchid.setText("             Empty Field!");
    }
    if(address.equals("")||address.equals("             Empty Field!"))
    {
        flag=1; 
        taddress.setFont(new Font("SansSerif",Font.BOLD,17));
        taddress.setForeground(Color.RED);
        taddress.setText("             Empty Field!");
    }
    if(nationality.equals("")||nationality.equals("             Empty Field!"))
    {
        flag=1; 
        tnationality.setFont(new Font("SansSerif",Font.BOLD,17));
        tnationality.setForeground(Color.RED);
        tnationality.setText("             Empty Field!");
    }
    if(fname.equals("")||fname.equals("             Empty Field!"))
    {
        flag=1; 
        tname.setFont(new Font("SansSerif",Font.BOLD,17));
        tname.setForeground(Color.RED);
        tname.setText("             Empty Field!");
    }
     if(lname.equals("")||lname.equals("             Empty Field!"))
    {
        flag=1; 
        tlastname.setFont(new Font("SansSerif",Font.BOLD,17));
        tlastname.setForeground(Color.RED);
        tlastname.setText("             Empty Field!");
    }
    if(flag==0)
    {
    bal=Float.parseFloat(initial);
    int inter=0;
    if(accountype.equals("Current"))
    {
        inter=5;
    }
    if(accountype.equals("Savings"))
    {
        inter=0;
    }
    String query2="Insert into accountopeningrequests(Fname,Lname,Mobile,NIC,Nationality,BranchId,Address,Balance,Gender,Age,Accounttype,Interest)values('"+fname+"','"+lname+"','"+mobile+"','"+nic+"','"+nationality+"','"+bid+"','"+address+"',"+bal+",'"+gender+"',"+age+",'"+accountype+"',"+inter+")";
    stn.executeUpdate(query2);
    SignUp.this.backaudio();
    SignUp.this.hideFrame();
    }
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(null,e,"Error message",JOptionPane.ERROR_MESSAGE); 
    }
}
if(op.getSource()==back)
{
    System.out.println(color);
StartUp obj=new StartUp("HOME",color);
SignUp.this.backaudio();
SignUp.this.hideFrame();
}
}
} 
}