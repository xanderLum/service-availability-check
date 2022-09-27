def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        environment {
            timeout_mins = "${params.TIMER}"
                 } 
            timeout(time: env.timeout_mins.toInteger(), unit: 'MINUTES')       
            echo 'success'
    }    
}

return this
