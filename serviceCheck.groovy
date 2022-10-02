def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        echo 'onestep success'
        environment {
            TIMEOUT_MINS = ${params.TIMER}.toInteger()
                 } 
        echo "The job will stop at ${params.TIMER}"
         echo "The job will stop at ${TIMEOUT_MINS}"
        echo 'twostep success'
            timeout(time: ${TIMEOUT_MINS}, unit: 'MINUTES')     
    }    
}

return this
