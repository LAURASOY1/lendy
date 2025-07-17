def lib = load 'lendy-shared-lib/vars/lendyPipeline.groovy'

pipeline {
    agent any
    stages {
        stage('Run Pipeline') {
            steps {
                script {
                    lib.call(
                        dockerComposeFile: 'docker-compose.yml',
                        testCommand: 'python manage.py test loan_app'
                    )
                }
            }
        }
    }
}