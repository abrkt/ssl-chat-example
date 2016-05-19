Client-Server Chat Using SSL
============================
An example of how to use SSL to secure communications between Client and Server using SSL, Created using Intellij forms.

How to run:
-----------
Build the project as a jar using Intellij. The jar can run as both server and client, to see how it works use the following steps:
* Generate Self-signed SSL certificate using java keytool `keytool -genkey -keystore <keystore name> -keyalg RSA`
* Run the server using the created keystore `java -Djavax.net.ssl.keyStore=<keystore name> -Djavax.net.ssl.keyStorePassword=<keystore password> -jar ssl-swing-example.jar server`
* Run the client passing the keystore as trusted key store `java -Djavax.net.ssl.trustStore=<keystore name> -Djavax.net.ssl.trustStorePassword=<keystore password> -jar ssl-swing-example.jar`
* To send text over SSL check the SSL checkbox beside the text input.
* you may use wireshark or similar tool to see the encrypted text.
