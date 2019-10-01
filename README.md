## Installation
Please refer to this repo for instructions: [docker-setup](https://github.com/mbzama/docker-setup)
   
      
## Cheatsheet

  To view active containers
  
	   docker ps 
	
  To view all containers
  
	   docker ps -a
	
  To view images
  
	   docker images

  To remove container
  
	   docker rm -f {container_name}
	
  To remove image
  
	   docker rmi --image {image_name}
    

  To view logs
  
       docker logs -f {container_name}
       docker logs -f {container_name} --tail 100

  To clean up un-used resources
  
	   docker system prune
       
For more commands please refer to this [cheatsheet](https://github.com/mbzama/docker-training/blob/master/docker-cheatsheet.pdf)
     
     
       
## Working with Volumes
Create folder and file

	     mkdir data
	     nano run.sh
	
    
Add this content 

	echo <EMP_ID> Running run.sh file - '$(date)
    
	
Copy from Host machine to Docker Container:

    docker cp /host_dir container_name:/container_dir
    

Copy from Docker Container to Host machine:

    docker cp container_name:/container_dir /host_dir
   
    Example:
    	Copy file from host machine to container 
	   		docker cp data/ container_name:/data	
	
     	Login to the docker container
	   		docker exec -it container_name
	
     	Verify the file
	   		ls -l data
	   		cat data/run.sh
	
     	Run the file
	   		sh run.sh
 


## Upload image to public registry (dockerhub)

   1. Create account in dockerhub: 
   
              https://hub.docker.com

  2. Create docker repository with name as: 
  
              java8-app
	    	
  3. Login to dockerhub registry
  
	      docker login --username={user_name} 

  4. Tag the image
  
	     docker tag java8-app {user_name}/java8-app

  5. Upload the image to public docker registry:
  
	     docker push {user_name}/java8-app
	     
	     
    
## Examples
- [Java](https://github.com/mbzama/docker-examples-java)
- [NodeJs](https://github.com/mbzama/docker-training-nodejs)
- [Angular](https://github.com/mbzama/docker-examples-angular)
- [MEAN](https://github.com/mbzama/docker-examples-mean)
- [Python](https://github.com/mbzama/docker-examples-python)
- [Bonita](https://github.com/mbzama/docker-examples-bonita)



## References
- [Docker Hub](https://hub.docker.com)
- [AWS](https://aws.amazon.com/console)
- [Azure Cloud](https://portal.azure.com)
- [Google Cloud](http://cloud.google.com)
