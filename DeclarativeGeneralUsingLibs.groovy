@Library('shared-library') _
pipeline{
    agent any
    stages{
        stage('build'){
            steps{
                helloWorldExternal()
            }
        }
        stage('test'){
            steps {
                echo 'testing'
            }
        }
        stage('package'){
            steps {
                echo 'packaging'
            }
        }
    }
}