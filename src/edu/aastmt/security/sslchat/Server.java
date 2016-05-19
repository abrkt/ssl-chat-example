package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

public class Server extends Chatter {

  protected Socket plainSocket() throws IOException {
    return ServerSocketFactory.getDefault().createServerSocket(9998).accept();
  }

  protected Socket secureSocket() throws IOException {
    return SSLServerSocketFactory.getDefault().createServerSocket(9999).accept();
  }

  public String getType() {
    return "Server";
  }

}
