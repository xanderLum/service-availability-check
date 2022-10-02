def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        def TIME_OUT = params.TEST_DURATION.toInteger()
//         environment {
//             TIMEOUT_MINS = 19
//                  } 
//             timeout(time: TIME_OUT, unit: 'MINUTES')    
//         {
           echo "timeout minute : ${TIME_OUT} "
//         }
    }    
}

return this
