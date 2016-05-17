package edu.aastmt.security.sslchat;

import java.io.IOException;
import java.util.Arrays;

public class Application {

  public static void main(String[] args) throws IOException {
    Arrays.sort(args);
    boolean server = Arrays.binarySearch(args, "server") > -1;
    boolean secure = Arrays.binarySearch(args, "secure") > -1;
    if (server) {
      System.out.println("Starting " + (secure ? "Secure" : "Plain") + " Serve");
      new Server().start(secure);
    } else {
      System.out.println("Connecting " + (secure ? "Secure" : "Plain") + " Client");
      new Client().start(secure);
    }
  }
}
