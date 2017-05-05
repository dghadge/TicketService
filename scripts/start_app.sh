#!/bin/bash

nohup java -jar /usr/javaapp/ticketingservice-1.0.1-RELEASE.war -Dmaven.test.skip=true &

exit 0;
