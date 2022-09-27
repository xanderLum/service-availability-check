def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
//         environment {
//             timeout_mins = "${params.TIMER}"
//                  } 
        options{
            timeout(time: env.timeout_mins.toInteger(), unit: 'MINUTES')      }
            echo 'success'
    }    
}

return this
