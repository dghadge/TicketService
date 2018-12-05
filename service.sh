#!/bin/bash

start_app() {
   mvn spring-boot:run &
}

start_web() {
   cd dynamic-webui
   mvn spring-boot:run &
}

case "$1" in 
start)
   start_app 
   echo $!>ticketservice_app.pid
   start_web 
   echo $!>ticketservice_web.pid
   ;;
stop)
   kill `cat ticketservice_app.pid`
   rm ticketservice_app.pid
   kill `cat dynamic-webui/ticketservice_web.pid`
   rm dynamic-webui/ticketservice_web.pid
   ;;
restart)
   $0 stop
   $0 start
   ;;
status)
   if [ -e ticketservice_app.pid ]; then
      echo ticketservice app is running, pid=`cat ticketservice_app.pid`
      echo ticketservice web is running, pid=`cat dynamic-webui/ticketservice_web.pid`
   else
      echo ticketservice is NOT running
      exit 1
   fi
   ;;
*)
   echo "Usage: $0 {start|stop|status|restart}"
esac

exit 0 