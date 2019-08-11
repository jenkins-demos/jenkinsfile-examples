@Library('shared-library') _
pipeline{
    agent any
    stages{
        stage(){
            steps{
                helloWorldExternal()
            }
        }
    }
}