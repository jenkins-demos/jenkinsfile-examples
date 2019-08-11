pipeline{
    agent any
    stages{
        stage('build'){
            steps{
                echo 'building'

            }
        }
        stage('run-tests') {
            parallel {
                stage('testone') {
                    steps {
                        echo 'testing'
                    }
                }
                stage('testtwo') {
                    steps {
                        echo 'testing'
                    }
                }
            }
        }
        stage('package'){
            steps {
                echo 'packaging'
            }
        }
        stage('deploy'){
            steps{
                echo "deploy"
            }
        }
    }
}