package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.util.Arrays;

public class Application {

  public static void main(String[] args) throws IOException {
    Arrays.sort(args);
    boolean server = Arrays.binarySearch(args, "server") > -1;
    if (server) {
      System.out.println("Starting Serve");
      new Server().start();
    } else {
      System.out.println("Connecting Client");
      new Client().start();
    }
  }
}
