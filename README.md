docker build -t docker-app .

docker run -p 8085:8085 docker-app


Docker Swarm


Today we will learn :

1. What is Docker Swarm
2. Why to use it
3. How to create and manage Docker Swarm
4. Create service on docker swarm
5. Scaling services up and down
6. Features/Helpful Tips



A swarm is a group of machines that are running Docker and joined into a cluster 



Docker Swarm is a tool for Container Orchestration


Let’s take an example

You have 100 containers

You need to do 
- Health check on every container
- Ensure all containers are up on every system
- Scaling the containers up or down depending on the load
- Adding updates/changes to all the containers

Orchestration - managing and controlling multiple docker containers as a single service
Tools available - Docker Swarm, Kubernetes, Apache Mesos



Pre-requisites
1. Docker 1.13 or higher
2. Docker Machine (pre installed for Docker for Windows and Docker for Mac)https://docs.docker.com/machine/insta...
https://docs.docker.com/get-started/p...





Step 1 :  Create Docker machines (to act as nodes for Docker Swarm)   Create one machine as manager and others as workers
    docker-machine create --driver hyperv manager1    docker-machine create --driver virtualbox manager1

   docker-machine:Error with pre-create check: “exit status 126”
   https://stackoverflow.com/questions/3...
   brew cask install virtualbox;

   Create one manager machine
   and other worker machines


Step 2 :  Check machine created successfully
    docker-machine ls
    docker-machine ip manager1


Step 3 :  SSH (connect) to docker machine
    docker-machine ssh manager1


Step 4 :  Initialize Docker Swarm    docker swarm init --advertise-addr MANAGER_IP
    docker node ls
    (this command will work only in swarm manager and not in worker)


Step 5 :  Join workers in the swarm
    Get command for joining as worker
    In manager node run command
    docker swarm join-token worker
    This will give command to join swarm as worker

    docker swarm join-token manager
    This will give command to join swarm as manager

    SSH into worker node (machine) and run command to join swarm as worker
   
    In Manager Run command - docker node ls to verify worker is registered and is ready
  
    Do this for all worker machines


Step 6 :  On manager run standard docker commands
    docker info
    check the swarm section 
    no of manager, nodes etc

    Now check docker swarm command options 
    docker swarm 


Step 7 :  Run containers on Docker Swarm
    docker service create --replicas 3 -p 80:80 --name serviceName nginx

    Check the status:
    docker service ls
    docker service ps serviceName
   
    Check the service running on all nodes
    Check on the browser by giving ip for all nodes


Step 8 :  Scale service up and down
   On manager node 
   docker service scale serviceName=2
 

Inspecting Nodes (this command can run only on manager node)
docker node inspect nodename
docker node inspect self
docker node inspect worker1


Step 9 : Shutdown node
   docker node update --availability drain worker1


Step 10 :  Update service
   docker service update --image imagename:version web
   docker service update --image nginx:1.14.0 serviceName


Step 11 :  Remove service
   docker service rm serviceName


docker swarm leave : to leave the swarm
docker-machine stop machineName : to stop the machine
docker-machine rm machineName : to remove the machine


REFERENCES:
https://docs.docker.com/get-started/p...
https://rominirani.com/docker-swarm-t...





FAQs & Helpful Tips:

A swarm is a group of machines that are running Docker and joined into a cluster

A cluster is managed by swarm manager

The machines in a swarm can be physical or virtual. After joining a swarm, they are referred to as nodes

Swarm managers are the only machines in a swarm that can execute your commands, or authorise other machines to join the swarm as workers

Workers are just there to provide capacity and do not have the authority to tell any other machine what it can and cannot do

you can have a node join as a worker or as a manager. At any point in time, there is only one LEADER and the other manager nodes will be as backup in case the current LEADER opts out






#DockerSwarm #WhatIsDockerSwarm #DockerTutorials #DockerTraining #DevOpsTools #DevOpsTraining #DockerCommands #DockerForBeginners #DockerFreeTutorials #DockerforDevOps


DOCKER PLAYLIST
https://www.youtube.com/playlist?list...

YOUTUBE PLAYLIST
https://www.youtube.com/channel/UCTt7...


YOUTUBE
https://www.youtube.com/automationste...

FACEBOOK
https://www.facebook.com/automationst...

TWITTER
https://twitter.com/automationsbs



LIKE, SHARE and SUBSCRIBE


Help in my mission of education

PATREON
https://www.patreon.com/raghavpal

