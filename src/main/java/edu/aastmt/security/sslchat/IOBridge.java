package edu.aastmt.security.sslchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class IOBridge implements Runnable {

  BufferedReader in;
  BufferedWriter out;

  public IOBridge(InputStream in, OutputStream out) {
    this.in = new BufferedReader(new InputStreamReader(in));
    this.out = new BufferedWriter(new OutputStreamWriter(out));
  }

  public void run() {
    try {
      String string;
      while ((string = in.readLine()) != null) {
        out.write("> " + string + '\n');
        out.flush();
        if (string.equalsIgnoreCase("Bye")) {
          break;
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
