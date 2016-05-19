package edu.aastmt.security.sslchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.*;

public class Receiver implements Runnable {

  private final JTextPane chat;
  private final boolean secure;
  BufferedReader in;

  public Receiver(InputStream in, JTextPane chat, boolean secure) {
    this.in = new BufferedReader(new InputStreamReader(in));
    this.chat = chat;
    this.secure = secure;
  }

  public void run() {
    try {
      String string;
      while ((string = in.readLine()) != null) {
        chat.setText(chat.getText() + "\nIncoming" + (secure ? " (secured)" : "") + ": "+ string);
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
