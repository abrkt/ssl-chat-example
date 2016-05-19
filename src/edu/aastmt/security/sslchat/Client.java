package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class Client extends Chatter {

  protected Socket plainSocket() throws IOException {
    return SocketFactory.getDefault().createSocket("localhost", 9998);
  }

  protected Socket secureSocket() throws IOException {
    return SSLSocketFactory.getDefault().createSocket("localhost", 9999);
  }

  public String getType() {
    return "Client";
  }

}
