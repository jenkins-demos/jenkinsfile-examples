@Library('shared-library') _
pipeline{
    agent any
    stages{
        stage('build'){
            steps{
                helloWorldExternal()
            }
        }
        parallel {
            stage('testone') {
                steps {
                    echo 'testing'
                }
            }
            stage('testone') {
                steps {
                    echo 'testing'
                }
            }
        }
        stage('package'){
            steps {
                echo 'packaging'
            }
        }
    }
}