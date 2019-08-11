@Library('shared-library') _
pipeline{
    agent any
    stages{
        stage('first stage'){
            steps{
                helloWorldExternal()
            }
        }
    }
}