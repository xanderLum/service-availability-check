def split () {
  String list = "${params.ENDPOINT}";
            String[] parts = list.split(","); 
}

// def timer(){
//     if (!params.TIMER.isEmpty()) 
//     { 
//         environment {
//             timeout_mins = "${params.TIMER}"
//                  } 
//             timeout(time: env.timeout_mins.toInteger(), unit: 'MINUTES')     
//         {
//             echo 'success'
//         }
//     }    
// }

// def endpoint1 (web) {
//   final String url = web
//   int status = sh(script: "curl -sLI -w '%{http_code}' $url -o /dev/null", returnStdout: true)
//   if (status != 200 && status != 201) {
//     error("Returned status code = $status when calling $url")
// }
//   else {
//     echo "OK"
//   }
  
// }


return this
