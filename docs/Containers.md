## Containers

------
<!-- TOC -->
  * [Containers](#containers)
    * [Offical Java Images](#offical-java-images)
        * [Oracle JDK (NFTC)](#oracle-jdk--nftc-)
    * [Docker Commands](#docker-commands)
    * [Java Container logs](#java-container-logs)
    * [App Running on K8S/Docker](#app-running-on-k8sdocker)
    * [JVM default GC](#jvm-default-gc)
    * [Access Docker desktop LinuxKit VM on MacOS](#access-docker-desktop-linuxkit-vm-on-macos)
    * [Multi Architecture Support](#multi-architecture-support)
        * [Netcat Webserver](#netcat-webserver)
      * [Container Tools](#container-tools)
      * [Jlink](#jlink)
      * [Distroless](#distroless)
      * [Documentation](#documentation)
  * [Kubernetes](#kubernetes)
        * [https://github.com/kubernetes-client/java](#httpsgithubcomkubernetes-clientjava)
  * [Git](#git)
<!-- TOC -->

### Offical Java Images

```bash
# Distroless Java Base (For Jlink apps based on debian bullseye)
# https://console.cloud.google.com/gcr/images/distroless/GLOBAL
$ docker pull gcr.io/distroless/java:base
$ docker pull gcr.io/distroless/java:base-nonroot
$ docker pull gcr.io/distroless/java-base:nonroot
$ docker pull gcr.io/distroless/java-base-debian11:nonroot (For ARM64/AMD64)

# OS specific
$ docker pull gcr.io/distroless/java-debian11:base
$ docker pull gcr.io/distroless/java-debian11:base-nonroot

# Distroless OpenJDK
# https://github.com/GoogleContainerTools/distroless/tree/main/java
$ docker pull gcr.io/distroless/java:latest # OR
$ docker pull gcr.io/distroless/java-debian11:latest

# Distroless Static & Base
$ docker pull gcr.io/distroless/static:latest
$ docker pull gcr.io/distroless/base:latest

# Openjdk
# https://github.com/docker-library/openjdk
$ docker pull openjdk:20-slim
$ docker pull openjdk:19-alpine
$ docker pull openjdk:19-jdk-oracle

# Eclipse Temurin
# https://github.com/adoptium/containers#supported-images
$ docker pull eclipse-temurin:18-focal
$ docker pull eclipse-temurin:18-alpine
$ docker pull eclipse-temurin:17-jre-focal
$ docker pull eclipse-temurin:17-jre-alpine

# Oracle OpenJDK
$ docker pull container-registry.oracle.com/java/openjdk:latest

# Oracle Java (NFTC)
# https://github.com/oracle/docker-images/tree/main/OracleJava
$ docker pull container-registry.oracle.com/java/jdk:latest

# Microsoft OpenJDK
# https://docs.microsoft.com/en-us/java/openjdk/containers
$ docker pull mcr.microsoft.com/openjdk/jdk:17-ubuntu

# Azul Zulu
# https://github.com/zulu-openjdk/zulu-openjdk
$ docker pull azul/zulu-openjdk-debian:17-jre
$ docker pull azul/zulu-openjdk-alpine:17-jre

# Azul Zulu OpenJDK & Mission Control (Homebrew on MacOS)
# https://github.com/mdogan/homebrew-zulu
$ brew tap mdogan/zulu
$ brew install <name>

# Azul Prime
$ docker pull azul/prime-debian:latest

# Liberica
# https://github.com/bell-sw/Liberica/tree/master/docker/repos/liberica-openjre-debian
$ docker pull bellsoft/liberica-openjdk-debian:latest
$ docker pull bellsoft/liberica-openjdk-alpine-musl:latest
$ docker pull bellsoft/liberica-openjdk-alpine:latest (libc)

# Amazon Corretto
# https://github.com/corretto/corretto-docker
$ docker pull amazoncorretto:18
$ docker pull amazoncorretto:18-alpine

# GraalVM CE & EE
# https://github.com/orgs/graalvm/packages
$ docker pull ghcr.io/graalvm/graalvm-ce:latest
$ docker pull ghcr.io/graalvm/native-image:latest
$ docker pull ghcr.io/graalvm/native-image:muslib
$ docker pull container-registry.oracle.com/graalvm/enterprise:latest

# Eclipse OpenJ9
$ docker pull ibm-semeru-runtimes:open-17-jre

# GraalVM CE Dev Builds (No docker images available)
https://github.com/graalvm/graalvm-ce-dev-builds/releases/

# GraalVM builds from Gluon
https://github.com/gluonhq/graal/releases

# Jetbrains Runtime (No docker images available)
https://github.com/JetBrains/JetBrainsRuntime/releases

# Examples
$ docker run -it --rm gcr.io/distroless/java-debian11:base-nonroot openssl s_client --connect google.com:443
```

- https://hub.docker.com/_/openjdk
- https://github.com/docker-library/docs/tree/master/openjdk
- https://container-registry.oracle.com/java/openjdk
- https://www.graalvm.org/docs/getting-started/container-images/

##### Oracle JDK (NFTC)

* [Oracle Java SE Downloads](https://www.oracle.com/javadownload)

* [Oracle Java Archive](https://www.oracle.com/java/technologies/java-archive.html)

* [JDK Script Friendly URLs](https://www.oracle.com/java/technologies/jdk-script-friendly-urls/)

### Docker Commands

```bash
# Remove all unused images, not just dangling ones
$ docker system prune -af

# Docker Run
$ docker run -it --rm \
      --volume /var/run/docker.sock:/var/run/docker.sock \
      --volume "$HOME/app.yaml":"$HOME/app.yaml" \
      --volume  "$(pwd)":"$(pwd)":rw \
      --workdir "$(pwd)" \
      --entrypoint="run" \
      suresh/openjdk-playground:latest

# CMD (windows)
$ docker run -it --rm ^
    --volume /var/run/docker.sock:/var/run/docker.sock ^
    --volume "%cd%"/app:/app:rw ^
    --entrypoint="run" ^
    suresh/openjdk-playground:latest

# POWERSHELL
$ docker run -it --rm ,
    --volume /var/run/docker.sock:/var/run/docker.sock ,
    --volume ${pwd}/app:/app:rw ,
    --entrypoint="run" ,
    suresh/openjdk-playground:latest
```



### Java Container logs

```bash
$ docker run \
        -it \
        --rm \
        --cpus=2 \
        --memory=256m \
        --pull always \
        -v "$HOME":/app \
        -v /:/host \
        --name openjdk \
        openjdk:20-slim \
        java \
        -XX:+UnlockExperimentalVMOptions \
        -XX:+UnlockDiagnosticVMOptions \
        -XX:+PrintFlagsFinal \
        -XX:MaxRAMPercentage=0.8 \
        -XX:-MaxFDLimit \
        -Xlog:gc\*,os=trace,os+container=trace --version \
        | grep -e "Use.*GC" -e "Active" -e "Using" -e "Max.*Limit" -e "OpenJDK" -e "Container"

# Override the default container CPU quota detection mechanism
# -XX:ActiveProcessorCount=<n>
```



### App Running on K8S/Docker

```bash
$ docker run \
     -it \
     --rm \
     openjdk:20-slim \
     sh -c "cat /proc/self/cgroup | grep -i '/docker'"
```

* [Check if the container is running inside K8S](https://kubernetes.io/docs/concepts/services-networking/connect-applications-service/#environment-variables:~:text=printenv%20%7C%20grep%20SERVICE-,KUBERNETES_SERVICE_HOST,-%3D10.0.0.1%0AKUBERNETES_SERVICE_PORT%3D443)



### JVM default GC

```bash
# https://github.com/openjdk/jdk/blob/master/src/hotspot/share/runtime/os.cpp#L1637
# OpenJDK reverts to Serial GC when it detects < 2 CPUs or < 2GB RAM
$ docker run -it --rm --cpus=1 --memory=1G openjdk:20-slim java -Xlog:gc --version
  #[0.007s][info][gc] Using Serial
```

* https://github.com/openjdk/jdk/blob/master/src/hotspot/share/runtime/os.cpp#:~:text=is_server_class_machine
* https://github.com/brunoborges/jvm-ergonomics (https://vimeo.com/748031919)
* https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/



### Access Docker desktop LinuxKit VM on MacOS

```bash
$ docker run -it --rm --memory=256m --cpus=1 -v /:/host --name alpine alpine
 /# chroot /host
  # docker version
```



### [Multi Architecture Support](https://docs.docker.com/desktop/multi-arch/)

* [**tonistiigi/binfmt**](https://github.com/tonistiigi/binfmt)

  ```bash
  $ docker run --rm --privileged tonistiigi/binfmt --install all
  ```

* [**multiarch/qemu-user-static**](https://github.com/multiarch/qemu-user-static)

  ```bash
  $ docker run --rm --privileged multiarch/qemu-user-static --reset -p yes
  ```

* [Supported Targets - qemu-binfmt-conf.sh](https://github.com/qemu/qemu/blob/master/scripts/qemu-binfmt-conf.sh)

* [Dockerhub Supported Archs](https://github.com/docker-library/official-images#architectures-other-than-amd64)

* Examples

  ```bash
  $ docker run -it --rm --platform=linux/aarch64  alpine uname -m
    aarch64
  $ docker run -it --rm --platform=linux/amd64 alpine uname -m
    x86_64

  $ docker run --rm arm64v8/alpine uname -a
  $ docker run --rm arm32v7/alpine uname -a
  $ docker run --rm ppc64le/alpine uname -a
  $ docker run --rm s390x/alpine uname -a
  $ docker run --rm tonistiigi/debian:riscv uname -a
  ```

##### Netcat Webserver

```bash
FROM alpine

ENTRYPOINT while :; do nc -k -l -p $PORT -e sh -c 'echo -e "HTTP/1.1 200 OK\n\n hello, world"'; done
# https://github.com/jamesward/hello-netcat
# docker build -t hello-netcat .
# docker run -p 8080:80 -e PORT=80 -it hello-netcat
```

Forwards Logs

```bash
# forward request and error logs to docker log collector
RUN ln -sf /dev/stdout /var/log/nginx/access.log \
 && ln -sf /dev/stderr /var/log/nginx/error.log

# OR output directly to
/proc/self/fd/1 (STDOUT)
/proc/self/fd/2 (STDERR)

# https://docs.docker.com/config/containers/logging/configure/
```

[Shutdown signals and EnytryPoint](https://medium.com/@madflojo/shutdown-signals-with-docker-entry-point-scripts-5e560f4e2d45)

```bash
#!/bin/bash
## Entrypoint script for my-app. This script is to show how to write
## an entrypoint script that actually passes down signals from Docker.

## Load our DB Password into a runtime only Environment Variable
if [ -f /run/secrets/password ]
then
  echo "Loading DB password from secrets file"
  DB_PASS=$(cat /run/secrets/password)
  export DB_PASS
fi

## Run the Application
exec my-app
```

```dockerfile
ENTRYPOINT ["../../myapp-entrypoint.sh"]
```

- ##### [Docker stats GraalVM app](https://github.com/vasilmkd/docker-stats-monitor/blob/master/Dockerfile)

**HTTP Proxy**

```bash
FROM ubuntu:20.04

ENV HTTP_PROXY="http://proxy.test.com:8080"
ENV HTTPS_PROXY="http://proxy.test.com:8080"
ENV NO_PROXY="*.test1.com,*.test2.com,127.0.0.1,localhost"

RUN apt-get update && apt-get upgrade -y && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y \
    openjdk \
    rm -rf /var/lib/apt/lists/*
```

#### Container Tools

------

* https://github.com/rancher-sandbox/rancher-desktop

* https://github.com/containerd/containerd

* https://github.com/lima-vm/lima (Linux on Mac)

* https://github.com/containerd/nerdctl

* https://github.com/k3s-io/k3s

* https://github.com/rancher/k3d/

* https://kind.sigs.k8s.io/

* https://github.com/k0sproject/k0s

* https://github.com/canonical/multipass (Running Ubuntu VM)

* https://podman.io/blogs/2021/09/06/podman-on-macs.html

* https://github.com/wagoodman/dive

* https://github.com/google/cadvisor

* https://github.com/google/go-containerregistry/tree/main/cmd/crane

* [Trivy - Container Scanning](https://github.com/aquasecurity/trivy)

* [CoSign - Container Signing](https://github.com/sigstore/cosign)

* [Kaniko - Build Images In Kubernetes](https://github.com/GoogleContainerTools/kaniko)

* [Colima - Container runtimes on MacOS ](https://github.com/abiosoft/colima)

#### Jlink

------

* https://www.morling.dev/blog/smaller-faster-starting-container-images-with-jlink-and-appcds/

* https://blog.adoptium.net/2021/08/using-jlink-in-dockerfiles/

* https://docs.microsoft.com/en-us/java/openjdk/java-jlink-runtimes

    * https://github.com/dsyer/sample-docker-microservice/

* https://mbien.dev/blog/entry/custom-java-runtimes-with-jlink

* https://jpetazzo.github.io/2020/03/01/quest-minimal-docker-images-part-2/

#### Distroless

------

https://github.com/GoogleContainerTools/distroless/blob/master/base/README.md

#### Documentation

------

https://spring-gcp.saturnism.me/deployment/docker/container-awareness

https://spring-gcp.saturnism.me/deployment/docker

https://www.infoq.com/presentations/openjdk-containers/

https://www.youtube.com/watch?v=Yj0sx1dvEdo

https://www.youtube.com/watch?v=2IpJABPzpvw

https://developers.redhat.com/devnation/tech-talks/containerjfr

http://blog.gilliard.lol/2019/12/04/Clojure-Containers.html

https://www.morling.dev/blog/smaller-faster-starting-container-images-with-jlink-and-appcds/

https://blog.arkey.fr/2020/06/28/using-jdk-flight-recorder-and-jdk-mission-control/

## Kubernetes

------

##### https://github.com/kubernetes-client/java

https://github.com/fabric8io/kubernetes-client

https://kubernetes.io/blog/2019/11/26/develop-a-kubernetes-controller-in-java/

https://github.com/ContainerSolutions/java-operator-sdk

https://operatorhub.io/

## Git

------

* https://github.com/newren/git-filter-repo
