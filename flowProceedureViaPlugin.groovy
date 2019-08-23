pipeline{
    agent any
    parameters{
        choice(choices: ['dev', 'prd', 'ist'], description: 'What environment ?', name: 'envtarget')
        string(defaultValue: "MyCompoenent", description: 'Component Name ?', name: 'component')
    }
    stages{
        stage('check'){
            steps{
            echo "${params.envtarget}"
        
            }
        }
        stage('call proceedure'){
            
            
            steps{
                step([$class: 'ElectricFlowRunProcedure',
                      configuration: 'flow',
                      projectName : 'Training_sbrown',
                      procedureName : 'SimpleProceedureTest',
                      procedureParameters : """{"procedure":{"procedureName":"SimpleProceedureTest","parameters":[{"actualParameterName":"arg1","value":"${params.envtarget}"}]}}"""
                ])
            }
        }
        
    }
}
