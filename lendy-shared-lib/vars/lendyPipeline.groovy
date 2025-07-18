// lendy-shared-lib/vars/lendyPipeline.groovy
def call(Map config = [:]) {
    // Remove the pipeline block and steps{} wrappers
    stage('Checkout') {
        checkout scm
    }
    stage('Build') {
        sh "docker-compose -f ${config.dockerComposeFile ?: 'docker-compose.yml'} build"
    }
    stage('Test') {
        sh config.testCommand ?: 'python manage.py test'
    }
    stage('Deploy') {
        when {
            branch 'main'
        }
        sh 'docker-compose up -d'
    }
}
