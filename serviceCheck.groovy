def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
        echo 'onestep success'
//         environment {
//             TIMEOUT_MINS = ${params.TIMER}
//                  } 
        echo "The job will stop at ${params.TIMER}"
        echo 'twostep success'
//             timeout(time: env.timeout_mins.toInteger(), unit: 'MINUTES')     
//         {
//             echo 'success'
//         }
    }    
}

return this
