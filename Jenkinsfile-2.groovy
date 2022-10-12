import objectFolder.*;
import java.io.File;

def splitEndpoint () {
  String list = "${params.ENDPOINT}";
    parts = list.split(","); 
    return parts;
}

def invokeEndpoint (endpoint) {
  List<ObjectName> list = new ArrayList<>();
  String result
  while (currentBuild.duration<TIMER.toInteger()*60000) {  
   Date date = new Date(); 
   
   echo "Executed at - $date"
  int time=TIME_INTERVAL.toInteger()
       for (String values:endpoint) {
        ObjectName object = new ObjectName();
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
 // def data = "First line\nSecond line"
 // writeFile(file: '/run/report.txt', text: data)
}

def report(objectList){
  //print to file
 
   File file = new File('E:/','report.txt').withWriter('utf-8') { 
         writer -> writer.writeLine "\tendpoint\t|\tstart time|\t|end time|\tstatus"
      }  
  
  //loop the objectList
  for(def object: objectList){
    file.write("\t"+object.getEndpoint()+"\t|\t"+object.getStartTime()+"\t|"+object.getEndTime()+"\t|"+object.getStatus()")
  }
  
    //commit/push to repo in /runs/ folder
}

// report () {
//   def data = "yahoo"
//   writeFile (file: 'report.txt',text:data)
//   sh "git add * "
//   sh "git commit -m "Added report file" "
//   sh "git push"
// }

return this
