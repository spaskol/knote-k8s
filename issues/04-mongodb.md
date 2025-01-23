## DB not connecting


Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.
Tue Jan 21 21:01:05 CET 2025
There was an unexpected error (type=Internal Server Error, status=500).


change application.properties
instead of 
spring.data.mongodb.uri=mongodb://localhost:27017/dev
i put 
spring.data.mongodb.uri=${MONGO_URL:mongodb://localhost:27017/dev}

maybe this is because I missed the step with the mongoDB local install

com.mongodb.MongoSocketOpenException: Exception opening socket
        at com.mongodb.internal.connection.SocketStream.lambda$open$0(SocketStream.java:85) ~[mongodb-driver-core-5.2.1.jar!/:na]
        at java.base/java.util.Optional.orElseThrow(Optional.java:403) ~[na:na]
        at com.mongodb.internal.connection.SocketStream.open(SocketStream.java:85) ~[mongodb-driver-core-5.2.1.jar!/:na]
        at com.mongodb.internal.connection.InternalStreamConnection.open(InternalStreamConnection.java:233) ~[mongodb-driver-core-5.2.1.jar!/:na]
        at com.mongodb.internal.connection.DefaultServerMonitor$ServerMonitor.lookupServerDescription(DefaultServerMonitor.java:219) ~[mongodb-driver-core-5.2.1.jar!/:na]
        at com.mongodb.internal.connection.DefaultServerMonitor$ServerMonitor.run(DefaultServerMonitor.java:176) ~[mongodb-driver-core-5.2.1.jar!/:na]
Caused by: java.net.ConnectException: Connection refused
        at java.base/sun.nio.ch.Net.pollConnect(Native Method) ~[na:na]
        at java.base/sun.nio.ch.Net.pollConnectNow(Net.java:672) ~[na:na]
        at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(NioSocketImpl.java:542) ~[na:na]
        at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:597) ~[na:na]
        at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327) ~[na:na]
        at java.base/java.net.Socket.connect(Socket.java:633) ~[na:na]
        at com.mongodb.internal.connection.SocketStreamHelper.initialize(SocketStreamHelper.java:76) ~[mongodb-driver-core-5.2.1.jar!/:na]
        at com.mongodb.internal.connection.SocketStream.initializeSocket(SocketStream.java:104) ~[mongodb-driver-core-5.2.1.jar!/:na]
        at com.mongodb.internal.connection.SocketStream.open(SocketStream.java:79) ~[mongodb-driver-core-5.2.1.jar!/:na]
        ... 3 common frames omitted