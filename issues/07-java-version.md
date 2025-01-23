## Java version too high

~$ docker run   --name=knote-k8s   --rm   --network=knote   -p 8080:8080   -e MONGO_URL=mongodb://mongo:27017/dev   knote-k8s:latest
Picked up JAVA_TOOL_OPTIONS:
Error: LinkageError occurred while loading main class org.springframework.boot.loader.launch.JarLauncher
        java.lang.UnsupportedClassVersionError: org/springframework/boot/loader/launch/JarLauncher has been compiled by a more recent version of the Java Runtime (class file version 61.0), this version of the Java Runtime only recognizes class file versions up to 55.0

sudo apt remove openjdk-17-jdk
wget https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.2%2B9/OpenJDK11U-jdk_x64_linux_hotspot_11.0.2_9.tar.gz
tar -xvzf OpenJDK11U-jdk_x64_linux_hotspot_11.0.2_9.tar.gz
sudo mv jdk-11.0.2+9 /usr/lib/jvm/
sudo rm OpenJDK11U-jdk_x64_linux_hotspot_11.0.2_9.tar.gz

vim ~/.bashrc
export JAVA_HOME=/usr/lib/jvm/jdk-11.0.2+9

source ~/.bashrc

~$ java -version
openjdk version "11.0.2" 2019-01-15
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.2+9)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.2+9, mixed mode)

mvn clean install

 knote-k8s: Compilation failure: Compilation failure:
[ERROR] /home/ubuntu/knote-k8s/src/main/java/dobarbobar/com/knote_k8s/KnoteK8sApplication.java:[11,52] cannot access org.springframework.beans.factory.annotation.Autowired
[ERROR]   bad class file: /home/ubuntu/.m2/repository/org/springframework/spring-beans/6.2.1/spring-beans-6.2.1.jar(/org/springframework/beans/factory/annotation/Autowired.class)
[ERROR]     class file has wrong version 61.0, should be 55.0
[ERROR]     Please remove or make sure it appears in the correct subdirectory of the classpath.
[ERROR] /home/ubuntu/knote-k8s/src/main/java/dobarbobar/com/knote_k8s/KnoteK8sApplication.java:[12,52] cannot access org.springframework.beans.factory.annotation.Value
[ERROR]   bad class file: /home/ubuntu/.m2/repository/org/springframework/spring-beans/6.2.1/spring-beans-6.2.1.jar(/org/springframework/beans/factory/annotation/Value.class)
[ERROR]     class file has wrong version 61.0, s
...

from

		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.4.1</version>
		<relativePath/> <!-- lookup parent from repository -->

to
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.6.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->

commit: cb4f0f178cfb6d9e8be8779b15cf6cd8ffef08f4
after this commit I was able to run the application in the browser.