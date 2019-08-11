@Library('shared-library') _
pipeline{
    agent any
    environment {
        FLOW_CREDS = credentials('flow-admin-creds')
    }
    stages{
        stage('build'){
            steps{
                helloWorldExternal()
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

                runFlowProc(flowCreds: "${env.FLOW_CREDS_USR}:${env.FLOW_CREDS_PSW}", flowServer: "https://ps9.ecloud-kdemo.com")

            }
        }
    }
}