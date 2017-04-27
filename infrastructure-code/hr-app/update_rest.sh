cd hr-rest
echo 'Removing the old container ...'
docker rm -f hr-rest-container

echo 'Removing the old image ...'
docker rmi --force hr-rest-image:v1

echo 'Building Image with latest changes ...'
docker build -t hr-rest-image:v1 .
docker run -d -p 9090:9090 --name hr-rest-container hr-rest-image:v1


