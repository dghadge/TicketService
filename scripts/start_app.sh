#!/bin/bash

#!/bin/bash

java -jar /usr/javaapp/ticketingservice-1.0.1-RELEASE.war -Dmaven.test.skip=true > /dev/null 2> /dev/null < /dev/null &

exit 0
