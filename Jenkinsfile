pipeline {

    agent any

    tools {
        maven 'maven-3.6'
    }
    
    def branch = env.BITBUCKET_BRANCH
    stages {
  
        stage("test-branch"){
           steps {
              echo "$branch"
           }
        }
        stage("Build jar") {
            steps {
                echo "building the application ....."
                //sh 'mvn package'
            }
        }
        stage("Build image") {
            steps {
                echo "building the docker image"
                //withCredentials([usernamePassword(credentialsId:'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                //sh 'docker build -t dockermohcine/my-repo:jma-2.1 .'
                //sh "echo $PASS | docker login -u $USER --password-stdin"
                //sh 'docker push dockermohcine/my-repo:jma-2.1'

                }
            }
        }
        stage("Deploy App") {
            steps {
                echo "Deploying the application ....."
            }
        }
    }
}

