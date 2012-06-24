Install:
Install Eclipse JEE and Web Developer Tools
Install M2E m2e-wtp connector
Download Jetty: http://www.eclipse.org/jetty
Eclipse Jetty Plugin: http://download.eclipse.org/jetty/updates/jetty-wtp
Define a Jetty v8.1 server on localhost 

Run:
mvn package
then
  Right click on project and Run on server (localhost)
  or
  java -Dorg.eclipse.jetty.LEVEL=DEBUG -cp kriswuollett-sandbox-foursquare-api\target\classes;"kriswuollett-sandbox-foursquare-api\target\dependency\*"kriswuollett.sandbox.foursquare.api.HelloServlet

References:
Heroku Maven Multi Module setup: https://github.com/jamesward/maven-multi-module-example
Jetty Classpath: http://pipecuts.wordpress.com/2011/01/30/classnotfoundexception-org-objectweb-asm-classvisitor/

