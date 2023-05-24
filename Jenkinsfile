def branchName1
pipeline {
    agent any
  
    
   // environment {
     //   DOCKER_HUB_CREDENTIALS = credentials('docker-hub-repo')
     //   DOCKER_IMAGE_NAME = "dockermohcine/my-repo:jma-2.1"
   // }
    //vm
    //lkjkljj
    
    stages {
        stage("show branch"){
            steps {
                script {
                    def branchv1 = env.GIT_BRANCH
                    branchName1 = branchv1.substring("origin/".length())
                    echo "Branch name v7:${branchName1}"
                }
            }
        }
        stage("Build jar") {
            steps {
                echo "Building the application..."
               
            }
        }
        stage("Build image") {
            steps {
                echo "Building the Docker image..."
               
            }
        }
        stage("Deploy app") {
            steps {
                echo "Deploying the application..."
                
            }
        }
    }
}
