##### "Hello world" spring boot 2 project packed as "war". Deployed on dockerized JDK 10 and tomcat 9.x.y image. Dockerized image is runnable via docker-compose or kubernates/minikube.

* Change folder to project root
```
cd ./
```

* build by tomcat or maven
```
mvn install
```

* Create jdk 10 image with tag:
```
docker build --rm -t cwsfe_jdk10 -f src/docker/Dockerfile_jdk10 .
```

* Create tomcat image with tag:
```
docker build --rm -t cwsfe_tomcat -f src/docker/Dockerfile_tomcat .
```

* Create application image
```
cd src/docker/; docker-compose build;
```

* (Optionally) Run application from docker-compose
```
cd src/docker/; docker-compose up;
```

* Run kubernetes (or minicube on localhost)
```
minikube start;
eval $(minikube docker-env);
minikube dashboard;
```

* (Optionaly) move image to minicube:
```
docker save dev.cwsfe.eu/cwsfe/kubernetesdemo1:1 | pv | (eval $(minikube docker-env) && docker load)
docker save dev.cwsfe.eu/cwsfe/kubernetesdemo2:1 | pv | (eval $(minikube docker-env) && docker load)
```

* Deploy docker image on kubernetes:
```
kubectl apply -f src/kubernetes/namespace_dev.yaml
kubectl apply -f src/kubernetes/config_dev.yaml 
kubectl apply -f src/kubernetes/service_kubernetess_demo1_dev.yaml
kubectl apply -f src/kubernetes/service_kubernetess_demo2_dev.yaml
kubectl apply -f src/kubernetes/deployment_kubernetes_demo1_dev.yaml
kubectl apply -f src/kubernetes/deployment_kubernetes_demo2_dev.yaml
```

* Deploy gitlab on minikube - for hello world project:
```
kubectl apply -f src/kubernetes/ci/namespace_ci.yaml
kubectl apply -f src/kubernetes/ci/gitlab/minikube_storage.yaml
kubectl apply -f src/kubernetes/ci/gitlab/deployment_redis_ci.yaml
kubectl apply -f src/kubernetes/ci/gitlab/deployment_postgresql_ci.yaml
kubectl apply -f src/kubernetes/ci/gitlab/deployment_gitlab_ci.yaml
```
