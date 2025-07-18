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
                        testCommand: 'python manage.py test loan_app',
                        buildSteps: {
                            // Custom build steps including .env handling
                            stage('Build') {
                                steps {
                                    script {
                                        // Create empty .env file if it doesn't exist
                                        sh 'touch .env || true'
                                        sh 'docker-compose -f docker-compose.yml build'
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
