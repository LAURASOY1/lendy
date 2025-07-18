Library('lendy-shared-lib@main') _

pipeline {
    agent any
    stages {
        stage('Checkout & Setup .env') {
            steps {
                checkout scm
                withCredentials([file(credentialsId: 'prod-env-file', variable: 'ENV_FILE')]) {
                    sh '''
                        cp $ENV_FILE .env
                        chmod 600 .env
                    '''
                }
            }
        }
        stage('Build') {
            steps {
                sh 'docker-compose -f docker-compose.yml build'
            }
        }
        stage('Test') {
            steps {
                sh 'python manage.py test loan_app'
            }
        }
    }
}
