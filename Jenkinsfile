pipeline {
    agent none
    stages {
         stage('Back-end - Build') {
            agent {
                docker { image 'maven:3-alpine' }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Front-end - Build') {
            agent {
                docker { image 'node:7-alpine' }
            }
            steps {
                sh 'cd frontend-web && npm install'
            }
        }
        stage('Front-end - Test') {
            steps {
                sh 'cd frontend-web && npm run ci:test'
            }
        }
        stage('Front-end - Lint') {
            steps {
                sh 'cd frontend-web && npm run lint'
            }
        }
    }
}