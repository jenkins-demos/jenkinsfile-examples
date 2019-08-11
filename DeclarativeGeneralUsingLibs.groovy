@Library('shared-library') _
pipeline{
    agent any
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
                echo "deploy"
                runFlowProc(creds: "sbrown:sbrown", flowSvr: "https://ps9.ecloud-kdemo.com" )
            }
        }
    }
}