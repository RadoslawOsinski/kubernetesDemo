* cd ./

* build by tomcat or maven

* Create jdk 10 image with tag:

`
docker build --rm -t cwsfe_jdk10 -f src/docker/Dockerfile_jdk10 .
`

* Create tomcat image with tag:

`
docker build --rm -t cwsfe_tomcat -f src/docker/Dockerfile_tomcat .
`

* Create application image

`
docker build --rm -t='dev.cwsfe.eu/cwsfe/dancingpair:1' -f src/docker/Dockerfile .
`

* Run kubernetes (or minicube on localhost)

`
minikube start;
eval $(minikube docker-env);
minikube dashboard;
`

* (Optionaly) move image to minicube:

`
docker save dev.cwsfe.eu/cwsfe/dancingpair:1 | pv | (eval $(minikube docker-env) && docker load)
`

* Deploy docker image on kubernetes:

`
kubectl apply -f src/kubernetes/namespace_dev.yaml
kubectl apply -f src/kubernetes/config_dev.yaml 
kubectl apply -f src/kubernetes/service_dev.yaml
kubectl apply -f src/kubernetes/deployment_dev.yaml
`

---

"config.yaml" and "deployment.yaml" are files for creating entire environments i.e.: DEV, STAGE, RC, PROD 