docker build -t event-processor-image:v2 .
docker tag event-processor-image:v2 zamadockertraining/event-processor-image:v2

docker login -u zamadockertraining -p zamadockertraining@1
docker push zamadockertraining/event-processor-image:v2

echo 'Image uploaded to Docker Hub!!!'
