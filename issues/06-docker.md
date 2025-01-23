## install Docker
sudo apt install docker.io

change permissions
sudo usermod -aG docker $USER
sudo systemctl restart docker
and you need to logout and login (or close WSL windows and open it)

 java.lang.UnsupportedClassVersionError: org/springframework/boot/loader/launch/JarLauncher has been compiled by a more recent version of the Java Runtime (class file version 61.0), this version of the Java Runtime only recognizes class file versions up to 55.0


docker network create knote

change docker FROM image

 docker run \
  --name=mongo \
  --rm \
  --network=knote mongo

   docker run
    --detach \
    --name=mongo \
    --rm \
    --network=knote mongo \