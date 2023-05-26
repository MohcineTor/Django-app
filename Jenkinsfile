def gv 

pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    } 
    stages {
        stage('increment version') {
            steps {
                script {
                    echo 'incrementing version app version ....'
                    sh 'mvn build-helper:parse-version versions:set \
                       -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                       versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
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
                    gv.buildJar()
                }
            }
        }
        stage("Test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("Build Image") {
            steps {
                script {
                    gv.buildImage("${IMAGE_NAME}")
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
