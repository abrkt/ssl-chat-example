package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.net.Socket;


public abstract class Chatter {

  protected abstract Socket plainSocket() throws IOException;

  protected abstract Socket secureSocket() throws IOException;

  public void start() throws IOException {
    ChatForm.run(plainSocket(), secureSocket(), "Chat " + getType());
  }

  public abstract String getType();
}
