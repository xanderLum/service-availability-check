def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        def TIME_OUT = params.TIMER.toInteger()
        options {
            timeout(time:TIME_OUT, unit: 'MINUTES')    
        }

    }    
}

return this
