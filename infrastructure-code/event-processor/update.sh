echo 'Removing the old container ...'
docker rm -f event-processor-container

echo 'Removing the old image ...'
docker rmi --force event-processor-image:v1

echo 'Building Image with latest changes ...'
docker build -t event-processor-image:v1 .
docker run -d --name event-processor-container event-processor-image:v1