docker build -t hr-web-image:v1 .
docker tag hr-web-image:v1 zamadockertraining/hr-web-image:v1

docker login -u zamadockertraining -p zamadockertraining@1
docker push zamadockertraining/hr-web-image:v1

echo 'Image uploaded to Docker Hub!!!'
