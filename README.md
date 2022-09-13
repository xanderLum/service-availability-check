# service-availability-check

#Purpose
To create a service availability job that monitors target endpoints 
reachability of HTTP 200 OK success response code.

#Tasks
Create a Jenkins declarative pipeline groovy script with the ff. stages
    
    workspace clean up stage 
    checkout scm stage

    stage1: accept and validate required parameters
            a. timer to stop the job (optional)
            b. time interval to check target endpoint's availability (default 5secs)
            c. list of target endpoints to monitor status (required)
   
    stage2: start monitoring target endpoints' availability
            a. check reachability of url for every time interval param (1b)
            b. allow parallel availability check for all target endpoints in the list param (1c)

    stage3: generate summary report of the monitoring runtime to be made available 
            once this service availability job stops (via timer or manual stop)
            a. capture the availability of each target endpoints in the list (1c)
            eg. format
                endpoint    |   start time   |  end time    |    status
                serviceA    |    9:00        |    9:15      |      UP
                serviceA    |    9:15        |    9:30      |      DOWN
                serviceB    |    9:00        |    9:04      |      UP
                serviceB    |    9:05        |    9:06      |      DOWN
                serviceB    |    9:07        |    9:30      |      UP