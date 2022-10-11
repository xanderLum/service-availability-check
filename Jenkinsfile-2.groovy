def splitEndpoint () {
  String list = "${params.ENDPOINT}";
    parts = list.split(","); 
    return parts;
}

def invokeEndpoint (endpoint) {
  String result
  while (currentBuild.duration<TIMER.toInteger()*1000) {
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
  def data = "Hello World\nSecond line"
  writeFile(file: '/runs/output.txt', text: data)
}

return this
