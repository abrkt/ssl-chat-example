package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class Client extends Chatter {

  @Override
  protected Socket createSocket(boolean secured) throws IOException {
    return (secured ? SSLSocketFactory.getDefault() : SocketFactory.getDefault()).createSocket("localhost", 9999);
  }

}
