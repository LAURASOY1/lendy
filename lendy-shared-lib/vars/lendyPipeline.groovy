def call(Map config=[:]) {
    pipeline {
        agent any
        stages {
            stage('Example') {
                steps {
                    echo "Hello from lendyPipeline"
                }
            }
        }
    }
}
