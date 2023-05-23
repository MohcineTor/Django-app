pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    
   // environment {
     //   DOCKER_HUB_CREDENTIALS = credentials('docker-hub-repo')
     //   DOCKER_IMAGE_NAME = "dockermohcine/my-repo:jma-2.1"
   // }
    stages {
        stage("Test branch") {
            steps {
                //sh "echo 'Branch: ${GITHUB_REF#refs/heads/}'"
               script {
                    def branchName = env.GITHUB_REF
                    println "GITHUB_REF: ${branchName}"
                   if (branchName == null) {
                        branchName = env.GITHUB_HEAD_REF
                    }
                    if (branchName != null && branchName.startsWith("refs/heads/")) {
                        branchName = branchName.substring("refs/heads/".length())
                        echo "Branch name: ${branchName}"
                    } else {
                        echo "Unable to determine branch name"
                    }
                }
            }
        }
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
               // sh 'mvn package'
            }
        }
        stage("Build image") {
            steps {
                echo "Building the Docker image..."
               // sh 'docker build -t ${DOCKER_IMAGE_NAME} .'
               // withCredentials([usernamePassword(credentialsId: DOCKER_HUB_CREDENTIALS, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                 //   sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
                  //  sh "docker push ${DOCKER_IMAGE_NAME}"
               // }
            }
        }
        stage("Deploy app") {
            steps {
                echo "Deploying the application..."
                // Add deployment steps here
            }
        }
    }
}
