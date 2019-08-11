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
            echo 'testing'
        }
        stage('package'){
            echo 'packaging'

        }
    }
}