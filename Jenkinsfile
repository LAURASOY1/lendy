//***********************using shared library*************************
@Library('lendy-shared-lib@main') _  

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                lendyPipeline(
                    dockerComposeFile: 'docker-compose.yml',
                    testCommand: 'python manage.py test loan_app'
                )
            }
        }
    }
}
