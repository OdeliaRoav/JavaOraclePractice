package oracle.awt.text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginFrame implements ActionListener{
   private Frame f;
   private TextField tfid,tfpwd,tfmsg;
   private Button btn;

   public LoginFrame() {
      f=new Frame("login");
      f.setSize(370,130);
      f.setLayout(null);
      
      Label lid=new Label("ID :",Label.RIGHT);
      lid.setBounds(10,30,100,20);
      
      
      Label lpwd=new Label("password :",Label.RIGHT);
      lpwd.setBounds(10,60,100,20);
      
      
      tfid=new TextField(10);
      tfid.setBounds(150,30,150,20);
      
      tfpwd=new TextField(10);
      tfpwd.setEchoChar('*');
      tfpwd.setBounds(150,60,150,20);

      tfmsg=new TextField(10);
      tfmsg.setEchoChar('*');
      tfmsg.setBounds(100,90,340,20);
      tfmsg.setEditable(false);
      
      
      btn=new Button("login");
      btn.setBounds(300,30,50,50);
      btn.addActionListener(this);
      
      
      f.add(lid);
      f.add(lpwd);
      f.add(tfid);
      f.add(tfpwd);
      f.add(tfmsg);
      f.add(btn);
      f.setVisible(true);
   }
      public static void main(String[] args)
      {
         new LoginFrame();
      }
      
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         if(e.getActionCommand().equals("login"))
         {
            System.out.println("login button clicked");
            
            
            	
            
         }
      }

}
