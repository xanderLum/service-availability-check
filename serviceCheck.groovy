def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        echo 'onestep success'
        environment {
            TIMEOUT_MINS = ${params.TIMER}
                 } 
        echo "The job will stop at ${params.TIMER}"
        echo 'twostep success'
            timeout(time: ${TIMEOUT_MINS}.toInteger(), unit: 'MINUTES')     
    }    
}

return this
