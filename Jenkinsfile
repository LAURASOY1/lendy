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
                        preBuildSteps: {
                            stage('Setup Environment') {
                                steps {
                                    withCredentials([file(credentialsId: 'prod-env-file', variable: 'ENV_FILE')]) {
                                        sh '''
                                            cp $ENV_FILE .env
                                            # Ensure proper permissions
                                            chmod 600 .env
                                        '''
                                    }
                                }
                            }
                        },
                        buildSteps: {
                            stage('Build') {
                                steps {
                                    sh 'docker-compose -f docker-compose.yml build'
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
