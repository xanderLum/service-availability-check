def check
def TIME_OUT = params.TIMER.toInteger()
pipeline {
    agent any
    parameters {
        string description: 'Timer to stop the job', name: 'TIMER', trim: true
        string defaultValue: '5', description: 'Time interval to check target endpoint\'s availability', name: 'TIME_INTERVAL', trim: true
        string description: 'List of target endpoints to monitor status', name: 'ENDPOINT1', trim: true
        string description: 'List of target endpoints to monitor status', name: 'ENDPOINT2', trim: true
        string description: 'List of target endpoints to monitor status', name: 'ENDPOINT3', trim: true
    }
    stages {
        stage(“init”) {
            steps {
                script {
                    check = load "serviceCheck.groovy"
                }
            }
        }
        stage(“parameter”) {
            steps {
                script{
            if (params.ENDPOINT.isEmpty()) { 
                currentBuild.result = 'ABORTED'
                    error("ENDPOINT LIST SHOULD NOT BE EMPTY!!")
                  } 
            else {
                check.split()
                }
                }
            }
        } 
         stage(“Timeout”) {
            options {
                timeout(time: TIME_OUT, unit: 'MINUTES') 
            } 
             steps {
                 echo 'success'
                 sleep(time: 5, unit: "SECONDS")
             }
        }
        
        stage(“checkendpoints”) {
            parallel {
                stage ("youtube") {
                       steps {
                        script {
                int status = sh(script: "curl -sLI -w '%{http_code}' $params.ENDPOINT1 -o /dev/null", returnStdout: true)
                             if (status != 200 && status != 201) {
                                error("Returned status code = $status when calling $url")
                             }
                            else {
                                echo "OK"
                            }
                        }
                       }
                }
                stage ("facebook") {
                       steps {
                        script {
                            int status = sh(script: "curl -sLI -w '%{http_code}' $params.ENDPOINT2 -o /dev/null", returnStdout: true)
                             if (status != 200 && status != 201) {
                                error("Returned status code = $status when calling $url")
                             }
                            else {
                                echo "OK"
                            }
                        }
                       }
                }
                stage ("google") {
                       steps {
                        script {
                             int status = sh(script: "curl -sLI -w '%{http_code}' $params.ENDPOINT3 -o /dev/null", returnStdout: true)
                             if (status != 200 && status != 201) {
                                error("Returned status code = $status when calling $url")
                             }
                            else {
                                echo "OK"
                            }
                        }
                       }
                }
            }
        }
    }
}
