def gv 

pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    } 
    stages {
        stage("Init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build") {
            steps {
                script {
                    gv.BuildJar()
                }
            }
        }
        stage("Test") {
            steps {
                script {
                    gv.TestApp()
                }
            }
        }
        stage("Build Image") {
            steps {
                script {
                    gv.BuildImage()
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    gv.DeployApp()
                }
            }
        }
    }
}
