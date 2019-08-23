pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                echo 'sending helloWorld'
                publishEvent(event:jsonEvent('{"event":"helloWorld","MySpecificInfo":"This is value for helloWorld"}'),verbose: true)
            }
        }
    }
}
