## Maven not have JAVA_HOME env in WSL

```bash
$mvn -version
The JAVA_HOME environment variable is not defined correctly,
this environment variable is needed to run this program.
```
to fix (jdk-17 version is too high for my build you see how to fix this later)
```bash
sudo apt update
sudo apt install openjdk-17-jdk
readlink -f $(which java)
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
````

make permanent
```bash
echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/' | sudo tee -a ~/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' | sudo tee -a ~/.bashrc

$mvn -version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /mnt/c/apache-maven-3.9.9
Java version: 17.0.13, vendor: Ubuntu, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.15.167.4-microsoft-standard-wsl2", arch: "amd64", family: "unix"
```