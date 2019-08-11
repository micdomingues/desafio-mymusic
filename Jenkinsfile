node {
    stage('FRONTEND - START') {
        echo 'FRONTEND STARTED' 
        sh 'cd frontend-web'
    }
    stage ('Front End Build') {
        sh 'cd frontend-web'
        sh 'npm test'
    }
    stage('FRONTEND - END'){
        echo 'FRONTEND ENDUP' 
        sh 'cd ..'
    }
}