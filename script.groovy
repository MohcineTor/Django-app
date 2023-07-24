
def increment_version() {
    echo 'incrementing version app version ....'
    sh 'mvn build-helper:parse-version versions:set \
            -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
            versions:commit'
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
}

def buildJar() {
    echo "Building the Jar of Application....."
    sh 'mvn clean package'
}

def testApp() {
    echo "Testing the Application ..."
    sh 'mvn test'
}

def buildImage(IMAGE_NAME) {
    echo "Building the Image docker for our Application and push this in dockerHub repo ..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker build -t dockermohcine/my-repo:${IMAGE_NAME} ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push dockermohcine/my-repo:${IMAGE_NAME}"
    }
}
def deployApp(IMAGE_NAME) {
    echo "Deploying application...."
    sh "docker run -d -p 8080:8080 dockermohcine/my-repo:${IMAGE_NAME}"
}

return this 
