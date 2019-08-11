node {

    stage ('Front End Build') {
        echo 'FRONTEND STARTED' 
        dir("frontend-web") {
            sh "pwd"
            sh 'npm test'
        }
    }
}