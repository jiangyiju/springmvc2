package com.ebiz.interactive.todo.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MapMessage;

public class Receiver implements MessageListener {

  @Override
  public void onMessage(Message message) {
    // TODO Auto-generated method stub
    MapMessage msg=null;
    try {
      if(message instanceof MapMessage){
        msg=(MapMessage)message;
        System.out.println("Reading message:"+msg.getString("lastName"));
      } else {
                System.out.println("Message of wrong type: "
                        + message.getClass().getName());
            }
    } catch (JMSException e) {
      // TODO: handle exception
      System.out.println("JMSEXCEPTION:"+e.toString());
    } catch (Throwable e) {
      // TODO: handle exception
      System.out.println("EXCEPTION:"+e.getMessage());
    }
  }

}