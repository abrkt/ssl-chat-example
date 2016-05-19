package edu.aastmt.security.sslchat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Sender {

  BufferedWriter out;

  public Sender(OutputStream out) {
    this.out = new BufferedWriter(new OutputStreamWriter(out));
  }

  public void send(String text) {
    try {
      this.out.write(text + "\n");
      out.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
