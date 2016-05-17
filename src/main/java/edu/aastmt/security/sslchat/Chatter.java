package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.net.Socket;


public abstract class Chatter {

  protected abstract Socket createSocket(boolean secured) throws IOException;

  public void start(boolean secured) throws IOException {
    Socket socket = createSocket(secured);
    new Thread(new IOBridge(socket.getInputStream(), System.out)).start();
    new Thread(new IOBridge(System.in, socket.getOutputStream())).start();
  }
}
