@Library('shared-library') _
pipeline{
    agent any
    environment {
        FLOW_CREDS = credentials('flow-admin-creds')
        FLOW_SVR_URL = credentials('flow-server-url')
        //json_args="{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}"
        //json_args= '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}'

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
                environment{
                    json_args= '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}'

                }

                runFlowProc(flowCreds: "${env.FLOW_CREDS_USR}:${env.FLOW_CREDS_PSW}", flowServer: "${env.FLOW_SVR_URL}" ,jsonArgs: '${json_args}')

            }
        }
    }
}