def splitparams (){
  int time=TIME_INTERVAL.toInteger();
  String a="${params.ENDPOINT}";
  String[] str=a.split(",");
  for (int i=0;i<params.TIMER.toInteger()*60;i=i+time) {
  for (String values:str) {
    echo values
    Date date = new Date(); 
   echo "Executed at - $date"
      int status = sh(script: "curl -sLI -w '%{http_code}' $values -o /dev/null", returnStdout: true)
  if (status != 200 && status != 201) {
//     error("Returned status code = $status when calling $values")
    echo "DOWN"
}
  else {
    echo "OK"
  }
  }
    sleep time
  }
//   int durationTime="${currentBuild.durationString.minus(' sec and counting')}";
//   echo "$durationTime"
  
//   int dd=currentBuild.durationString
//   echo "$dd"
//   if(${currentBuild.durationString} >10)
//   echo "greater than 10s"
//   else
//   echo "less than 10s"
}
return this
