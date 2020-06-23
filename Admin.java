import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;
public  class Admin extends JFrame
{
    int color;
JPanel header;
JLabel bankname,availableline,img;
JButton viewacccreationreq,viewaccclosurereq,viewcomplains,exit;
int accno1;
Admin(String title,int accno,int v)
{
    color=v;
accno1=accno;
ImageIcon image=new ImageIcon("logo.jpg");
img=new JLabel(image);
ImageIcon icon=new ImageIcon("i2.png");
header=new JPanel(null);
bankname=new JLabel("ACE BANK LIMITED");
availableline=new JLabel("Available Actions");
viewacccreationreq=new JButton("VIEW ACCOUNT OPENING REQUEST");
viewaccclosurereq=new JButton("VIEW ACCOUNT CLOSURE REQUEST");
viewcomplains=new JButton("VIEW COMPLAINS");
exit=new JButton("EXIT");
Font banknamefont=new Font("SansSerif",Font.BOLD,25); 
Font availablelinefont=new Font("SansSerif",Font.BOLD,20);
Font btnfont=new Font("SansSerif",Font.PLAIN,15);
Color btncolor=new Color(52, 73, 94);
Color bgcolor=new Color(52, 152, 219);
Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
this.setLayout(null);
header.setBounds(0,0,500,50);
header.setBackground(btncolor);
availableline.setForeground(Color.BLACK);
availableline.setFont(availablelinefont);
availableline.setBounds(160,51,200,40);
viewacccreationreq.setForeground(Color.WHITE);
viewacccreationreq.setBackground(btncolor);
viewacccreationreq.setCursor(handpointer);
viewacccreationreq.setBounds(110,100,250,35);
viewacccreationreq.addActionListener(new MyEvents());
viewaccclosurereq.setForeground(Color.WHITE);
viewaccclosurereq.setBackground(btncolor);
viewaccclosurereq.setCursor(handpointer);
viewaccclosurereq.setBounds(110,150,250,35);
viewaccclosurereq.addActionListener(new MyEvents());
viewcomplains.setForeground(Color.WHITE);
viewcomplains.setBackground(btncolor);
viewcomplains.setCursor(handpointer);
viewcomplains.setBounds(110,200,250,35);
viewcomplains.addActionListener(new MyEvents());
exit.setForeground(Color.WHITE);
exit.setBackground(Color.RED);
exit.setCursor(handpointer);
exit.setBounds(110,250,250,35);
exit.addActionListener(new MyEvents());
img.setBounds(71,0,50,50);
bankname.setForeground(Color.WHITE);
bankname.setFont(banknamefont);
bankname.setBounds(121,0,380,50);
this.add(header);
header.add(img);
header.add(bankname);
this.add(availableline);
this.add(viewacccreationreq);
this.add(viewaccclosurereq);
this.add(viewcomplains);
this.add(exit);
ChangeColor(color);
this.setIconImage(icon.getImage());
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle(title);
this.setBounds(520,225,480,330);
this.setVisible(true);
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

 viewcomplains.setBackground(btncolor);
 viewaccclosurereq.setBackground(btncolor);
 viewacccreationreq.setBackground(btncolor);
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
public void hideFrame()
{
this.dispose();
}
public static void main(String args[])
{
Admin obj=new Admin("ADMIN DASHBOARD",0,0);
}
public class MyEvents implements ActionListener
{
public void actionPerformed(ActionEvent op)
{
if(op.getSource()==exit)
{
Admin.this.exitaudio();
Admin.this.hideFrame();
}

if(op.getSource()==viewacccreationreq)
{

ViewAccountOpeningRequest obj1=new ViewAccountOpeningRequest("ViewAccountOpeningRequest",accno1,color);
Admin.this.backaudio();
Admin.this.hideFrame();
}

if(op.getSource()==viewaccclosurereq)
{
    ViewAccountClosureRequest obj2=new ViewAccountClosureRequest("ViewAccountClosureRequest",accno1,color);
    Admin.this.backaudio();
    Admin.this.hideFrame();
}
if(op.getSource()==viewcomplains)
{
    ComplainRequests obj=new ComplainRequests("ComplainRequests",accno1,color);
    Admin.this.backaudio();
    Admin.this.hideFrame();
}





}
}
}


