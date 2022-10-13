import java.io.File
def splitEndpoint (endpoint) {
    //function which will split the string according to comma
    String[] str= endpoint.split(","); 
    return str;
}

def invokeEndpoint (endpoint) {
  String result
  
  String log= "Endpoint\t\tStartTime\tEndTime\t\tStatus\n"
  //if job run time is less than timer, it will run again and again
  while (currentBuild.duration<TIMER.toInteger()*60000) {  
  //create date to record start time and format into hour:minute:second
  Date sdate = new Date();  
  String startTime=sdate.format("HH:mm:ss")
  int time=TIME_INTERVAL.toInteger()
        int status = sh(script: "curl -sLI -w '%{http_code}' $endpoint -o /dev/null", returnStdout: true)
        if (status == 200 ) {
            result="OK"
        }
        else {
            result="FAIL"
        }
        echo "${result}"
        //create date to record start time and format into hour:minute:second
        Date edate = new Date();
        String endTime=edate.format("HH:mm:ss")
        log+=endpoint+"\t"+startTime+"\t"+endTime+"\t"+result+"\n"
        //the job will delay according to parameter before checking url again
        sleep time
  }
  println(log)
}

return this
