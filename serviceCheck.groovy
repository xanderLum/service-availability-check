def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        environment {
            TIMEOUT_MINS = 19
                 } 
            timeout(time: env.TIMEOUT_MINS.toInteger(), unit: 'MINUTES')    
        {
            echo "timeout minute : ${env.TIMEOUT_MINS} "
        }
    }    
}

return this
