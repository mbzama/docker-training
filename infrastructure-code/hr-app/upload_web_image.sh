cd hr-web
echo 'Removing the old container ...'
docker rm -f hr-web-container

echo 'Removing the old image ...'
docker rmi --force hr-web-image:v2

docker build -t hr-web-image:v2 .
docker tag hr-web-image:v2 zamadockertraining/hr-web-image:v2

docker login -u zamadockertraining -p zamadockertraining@1
docker push zamadockertraining/hr-web-image:v2
cd ..
echo 'Image uploaded to Docker Hub!!!'
