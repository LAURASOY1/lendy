// lendy-shared-lib/vars/lendyPipeline.groovy
def call(Map config = [:]) {
    // Remove the pipeline block - just define the stages
    stage('Checkout') {
        steps {
            checkout scm
        }
    }
    stage('Build') {
        steps {
            sh "docker-compose -f ${config.dockerComposeFile ?: 'docker-compose.yml'} build"
        }
    }
    stage('Test') {
        steps {
            sh config.testCommand ?: 'python manage.py test'
        }
    }
    stage('Deploy') {
        when {
            branch 'main'
        }
        steps {
            sh 'docker-compose up -d'
        }
    }
}
