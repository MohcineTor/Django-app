pipeline {
    agent any
    stages {
       stage("show branch"){
            steps {
                script {
                    def branchv1 = env.GIT_BRANCH
                    branchName1 = branchv1.substring("origin/".length())
                    echo "Branch name v7:${branchName1}"
                    //iji
                }
            }
        }
    }
}
