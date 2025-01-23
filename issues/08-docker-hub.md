## Docker Hub

docker login
user your docker hub username and password

Because I didn't tag corretly the image I couldn't push at the beginning.

Using default tag: latest
The push refers to repository [docker.io/library/knote-k8s]
32e4514a485c: Preparing
8b338a10df53: Preparing
238b684bbac1: Preparing
faed2c48e448: Preparing
b57c79f4a9f3: Preparing
d60e01b37e74: Waiting
e45cfbc98a50: Waiting
762d8e1a6054: Waiting
denied: requested access to the resource is denied

change tag
docker tag knote-k8s yourusername/knote-k8s:latest
docker push