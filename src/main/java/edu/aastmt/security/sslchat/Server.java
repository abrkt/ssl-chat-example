package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

public class Server extends Chatter {

  @Override
  protected Socket createSocket(boolean secured) throws IOException {
    return (secured ? SSLServerSocketFactory.getDefault() : ServerSocketFactory.getDefault())
      .createServerSocket(9999).accept();
  }

}
