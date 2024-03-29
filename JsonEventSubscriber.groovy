def event = ''
def myCoolKey = ''
pipeline {
    agent none
    triggers {
        eventTrigger jmespathQuery("event=='helloWorld' || event=='helloWorld2'")
    }
    stages {
        stage('Example') {
            agent any
            when {
                triggeredBy "EventTriggerCause"
                beforeAgent true
            }
            steps {
                echo "****************************************"
                echo "The class type that triggered this run: " + currentBuild?.getBuildCauses()[0]?._class?.toString()
                echo "****************************************"

                echo "****************************************"
                echo "The full message received:"
                echo groovy.json.JsonOutput.prettyPrint(currentBuild?.getBuildCauses()?.toString())
                echo "****************************************"

                echo "****************************************"
                echo "Just the event part of the full message received (note the new source value added on from the JSON from publishEvent):"
                echo groovy.json.JsonOutput.prettyPrint(currentBuild?.getBuildCauses()[0]?.event?.toString())
                echo "****************************************"

                echo "****************************************"
                echo "The value of event from the publishEvent JSON: " + currentBuild?.getBuildCauses()[0]?.event?.event?.toString()
                echo "****************************************"

                script {
                    event = currentBuild.getBuildCauses()[0]?.event?.event?.toString()
                    myKey = currentBuild.getBuildCauses()[0]?.event?.MySpecificInfo?.toString()
                }

                echo "****************************************"
                echo "extracted value for event: " + event
                echo "extracted value for myKey: " + myKey
                echo "****************************************"
            }
        }
    }
}
