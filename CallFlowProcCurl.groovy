@Library('shared-library') _
pipeline{
    agent any
    environment {
        FLOW_CREDS = credentials('flow-admin-creds')
        FLOW_SVR_URL = credentials('flow-server-url')
        PROJ_NAME = 'default'
        PROC_NAME = 'Echo'
        CURL_OPTIONS = '--insecure -vvv'
        JOBID=""

    }
    stages{

        stage('deploy'){
            environment{
                json_args= '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}'

            }
            steps{

                script {
                 JOBID = runFlowProc(flowCreds: "${env.FLOW_CREDS_USR}:${env.FLOW_CREDS_PSW}", flowServer: "${env.FLOW_SVR_URL}", jsonArgs: '${json_args}', procName: '$PROC_NAME', projName: '$PROJ_NAME', curlOptions: '$CURL_OPTIONS')
                }
            }
        }
        stage('test'){
            steps{
                echo "$JOBID"
            }
        }
    }
}
