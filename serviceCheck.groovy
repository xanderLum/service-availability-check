def timer(){
    if (!params.TIMER.isEmpty()) 
    { 
//         environment {
//             timeout_mins = "${params.TIMER}"
//                  } 
            timeout(time: 4, unit: 'MINUTES')       
            echo 'success'
    }    
}

return this
