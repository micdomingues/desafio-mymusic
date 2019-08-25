pipeline {
    agent none
    stages {
         stage('Back-end') {
            agent {
                docker { image 'maven:3-alpine' }
            }
            steps {
                sh 'mvn --version'
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
            agent {
                docker { image 'node:7-alpine' }
            }
            steps {
                sh 'cd frontend-web && npm run ci:test'
            }
        }
        stage('Front-end - Lint') {
            agent {
                docker { image 'node:7-alpine' }
            }
            steps {
                sh 'cd frontend-web && npm run lint'
            }
        }
    }
}