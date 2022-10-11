def splitEndpoint () {
  String list = "${params.ENDPOINT}";
    parts = list.split(","); 
    return parts;
}

def invokeEndpoint (endpoint) {
  while (currentBuild.duration<TIMER.toInteger()*1000) {
  int time=TIME_INTERVAL.toInteger()
  for (String values:endpoint) {
    echo values
    Date date = new Date(); 
   echo "Executed at - $date"
      int status = sh(script: "curl -sLI -w '%{http_code}' $values -o /dev/null", returnStdout: true)
  if (status == 200 ) {
    echo "OK"
  }
  else {
    echo "FAIL"
  }
    sleep time
  }
  }
}

return this
