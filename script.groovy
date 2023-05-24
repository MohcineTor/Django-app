def buildJar() {
    echo "Building the Jar of Application....."
    sh 'mvn package'
}
def testApp() {
    echo "Testing the Application ..."
    sh 'mvn test'
}
def buildImage() {
    echo "Building the Image docker for our Application and push this in dockerHub repo ..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t dockermohcine/my-repo/test-app:jma-3.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push dockermohcine/my-repo/test-app:jma-3.0'
    }
}
def deployApp() {
    echo "Deploying application...."
    sh 'docker run -d -p 8080:8080 dockermohcine/my-repo/test-app:jma-3.0'
}
return this 
