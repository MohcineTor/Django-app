pipeline {

    agent any

    tools {
        maven 'Maven'
    }
    stages {
        stage("Build jar") {
            steps {
                echo "building the application ....."
                sh 'mvn package'
            }
        }
        stage("Build image") {
            steps {
                echo "building the docker image"
                withCredentials([usernamePassword(credentialsId:'	docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
                sh 'docker build -t dockermohcine/my-repo/demo-app:jma-2.0 .'
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh 'docker push dockermohcine/my-repo/demo-app:jma-2.0'
            }
        }
        stage("Deploy App") {
            steps {
                echo "Deploying the application ....."
            }
        }
    }
}
