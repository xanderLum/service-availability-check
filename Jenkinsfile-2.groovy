def splitEndpoint () {
  String list = "${params.ENDPOINT}";
    parts = list.split(","); 
    return parts;
}

def invokeEndpoint (endpoint) {
  String result
  while (currentBuild.duration<TIMER.toInteger()*60000) {
   Date date = new Date(); 
   echo "Executed at - $date"
  int time=TIME_INTERVAL.toInteger()
  for (String values:endpoint) {
      int status = sh(script: "curl -sLI -w '%{http_code}' $values -o /dev/null", returnStdout: true)
  if (status == 200 ) {
    result="OK"
  }
  else {
    result="FAIL"
  }
    echo "${result}"
  }
     sleep time
  }
 // def data = "First line\nSecond line"
 // writeFile(file: '/run/report.txt', text: data)
}

// report () {
//   def data = "yahoo"
//   writeFile (file: 'report.txt',text:data)
//   sh "git add * "
//   sh "git commit -m "Added report file" "
//   sh "git push"
// }

return this
