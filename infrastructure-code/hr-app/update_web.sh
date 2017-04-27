cd hr-web
echo 'Removing the old container ...'
docker rm -f hr-web-container

echo 'Removing the old image ...'
docker rmi --force hr-web-image:v1

echo 'Building Image with latest changes ...'
docker build -t hr-web-image:v1 .
docker run -d -p 9090:8080 --name hr-web-container hr-web-image:v1
cd ..

echo 'Access the Web application using this url:'
echo 'http://192.168.99.100:9090/hr-web'
