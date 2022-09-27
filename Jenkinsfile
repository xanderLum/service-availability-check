def check
pipeline {
    agent any

    parameters {
        string description: 'Timer to stop the job', name: 'TIMER', trim: true
        string defaultValue: '5', description: 'Time interval to check target endpoint\'s availability', name: 'TIME_INTERVAL', trim: true
        string description: 'List of target endpoints to monitor status', name: 'ENDPOINT', trim: true
    }
    stages {
        stage('check parameter') {
            steps {
                script {
                    check = load "serviceCheck.groovy"
                    if (params.ENDPOINT.isEmpty()) { 
                    currentBuild.result = 'ABORTED'
                    error("ENDPOINT LIST SHOULD NOT BE EMPTY!!")
                    } 
                }
            }
        }
         stage('Hello') {
            steps {
                script {
                    check.timer();
                }
            }
        }
    }
}
