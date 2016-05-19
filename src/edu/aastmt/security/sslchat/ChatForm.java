package edu.aastmt.security.sslchat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

public class ChatForm {

  private JPanel panel;
  public JTextPane chat;
  private JTextArea message;
  private JCheckBox ssl;

  public ChatForm() {
  }

  public ChatForm(final Socket plain, final Socket secure) {
    this();
    try {
      final Sender secureSender = new Sender(secure.getOutputStream());
      final Sender plainSender = new Sender(plain.getOutputStream());
      message.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
          if (e.getKeyCode() == 13 || e.getKeyCode() == 10) {
            String text = message.getText().trim();
            if (text.length() > 0) {
              (ssl.isSelected() ? secureSender : plainSender).send(text);
              chat.setText(chat.getText() + "\nYou: " + text);
              message.setText("");
            }
          }
        }
      });
      new Thread(new Receiver(plain.getInputStream(), chat, false)).start();
      new Thread(new Receiver(secure.getInputStream(), chat, true)).start();
    } catch (IOException x) {
      x.printStackTrace();
    }
  }

  public static void run(Socket plain, Socket secure, String name) {

    JFrame frame = new JFrame(name);
    ChatForm form = new ChatForm(plain, secure);
    frame.setContentPane(form.panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
