import utils.ServiceDetails

import java.io.File

def splitEndpoint () {
  String list = "${params.ENDPOINT}";
    parts = list.split(",");
    return parts;
}

def invokeEndpoint (endpoint) {
  List<ServiceDetails> list = new ArrayList<>();
  String result
  while (currentBuild.duration<TIMER.toInteger()*60000) {  
   Date date = new Date(); 
   
   echo "Executed at - $date"
  int time=TIME_INTERVAL.toInteger()
       for (String values:endpoint) {
        def object = new ServiceDetails();
        object.setStartTime(date);
        object.setEndpointName(values)
        object.setEndTime(date+time);
          int status = sh(script: "curl -sLI -w '%{http_code}' $values -o /dev/null", returnStdout: true)
          if (status == 200 ) {
            result="OK"
            object.setStatus(result);
          }
          else {
            result="FAIL"
            object.setStatus(result);
          }
            echo "${result}"
         list.add(object)
      }
     sleep time
    return list;
  }

}

def report(objectList){
  //print to file
   File file = new File('run/','report.txt').withWriter('utf-8') { 
         writer -> writer.writeLine "\tendpoint\t|\tstart time|\t|end time|\tstatus"
      }  
  
  //loop the objectList
  for(def object: objectList){
    file.write("\t"+object.getEndpoint()+"\t|\t"+object.getStartTime()+"\t|"+object.getEndTime()+"\t|"+object.getStatus())
  }
  
    //commit/push to repo in /runs/ folder
    sh "git add /run/report.txt"
    sh "git commit -m "Add report file" "
    sh "git push"
}


return this
