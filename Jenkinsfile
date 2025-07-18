//***********************using shared library*************************
@Library('lendy-shared-lib@main') _

pipeline {
    agent any
    stages {
        stage('Execute Pipeline') {
            steps {
                script {
                    lendyPipeline(
                        dockerComposeFile: 'docker-compose.yml',
                        testCommand: 'python manage.py test loan_app'
                    )
                }
            }
        }
    }
}
