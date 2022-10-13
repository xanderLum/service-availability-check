def gv
def endpoint
pipeline {
    agent any
    //create three parameters
    parameters {
    string description: 'Timer to stop the job (minute)', name: 'TIMER', trim: true
    string defaultValue: '5', description: 'Time interval to check target endpoints availability(second)', name: 'TIME_INTERVAL', trim: true
    string description: 'List of target endpoints to monitor status', name: 'ENDPOINT', trim: true
    }
    stages {
        stage("one") {
            steps {
                script {
                    //load groovy file
                    gv=load "Jenkinsfile.groovy"
                    //split the ENDPOINT parameter and store it in an array
                    endpoint=gv.splitEndpoint("$ENDPOINT")
                    //the job will aborted if the ENDPOINT parameter is empty
                    if (ENDPOINT.isEmpty()) {
                        currentBuild.result = 'ABORTED'
                        error("ENDPOINT LIST SHOULD NOT BE EMPTY!!")
                    }
                }
            }
        }
    
        stage("CheckEndpoint") {
            steps {
                script {
                    def deployments = [:]
                    //create stages according to endpoint list and run parallel
                    endpoint.each { e ->
                        deployments[e] = {
                            stage("Endpoint") {      
                                gv.invokeEndpoint(e)
                            }
                        }
                    }
        parallel deployments
                }
            }
        }
  
    }
}
