# knote-k8s
Simple Spring Boot App Deployment

Here I will write the issues I faced and then I will make detiled ReadMe

First issue. I mistakenly select Gradle instead of Maven


```bash
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.
13.0:compile (default-compile) on project knote-k8s: Compilation failure: Compil
ation failure:
[ERROR] /C:/Users/SAP/Nextcloud2/github/knote-k8s/src/main/java/dobarbobar/com/k
note_k8s/KnoteK8sApplication.java:[7,27] package org.commonmark.node does not ex
ist
[ERROR] /C:/Users/SAP/Nextcloud2/github/knote-k8s/src/main/java/dobarbobar/com/k
note_k8s/KnoteK8sApplication.java:[8,29] package org.commonmark.parser does not
exist
[ERROR] /C:/Users/SAP/Nextcloud2/github/knote-k8s/src/main/java/dobarbobar/com/k
note_k8s/KnoteK8sApplication.java:[9,36] package org.commonmark.renderer.html do
es not exist
[ERROR] /C:/Users/SAP/Nextcloud2/github/knote-k8s/src/main/java/dobarbobar/com/k
note_k8s/KnoteK8sApplication.java:[101,13] cannot find symbol
[ERROR]   symbol:   class Parser
[ERROR]   location: class dobarbobar.com.knote_k8s.KNoteController
[ERROR] /C:/Users/SAP/Nextcloud2/github/knote-k8s/src/main/java/dobarbobar/com/k
note_k8s/KnoteK8sApplication.java:[102,13] cannot find symbol
[ERROR]   symbol:   class HtmlRenderer
[ERROR]   location: class dobarbobar.com.knote_k8s.KNoteController
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e swit
ch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please rea
d the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureExc
eption
```

<dependencies>
    <dependency>
        <groupId>org.commonmark</groupId>
        <artifactId>commonmark</artifactId>
        <version>0.21.0</version>  <!-- Use the latest version -->
    </dependency>
</dependencies>

Source: https://learnk8s.io/spring-boot-kubernetes-guide

Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.
Tue Jan 21 21:01:05 CET 2025
There was an unexpected error (type=Internal Server Error, status=500).


$mvn -version
The JAVA_HOME environment variable is not defined correctly,
this environment variable is needed to run this program.

to fix:
sudo apt update
sudo apt install openjdk-17-jdk
readlink -f $(which java)
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/

$mvn -version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /mnt/c/apache-maven-3.9.9
Java version: 17.0.13, vendor: Ubuntu, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.15.167.4-microsoft-standard-wsl2", arch: "amd64", family: "unix"

<h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p><div id="created">Tue Jan 21 21:01:05 CET 2025</div><div>There was an unexpected error (type=Internal Server Error, status=500).</div>

remove test folder to ommit tests.
