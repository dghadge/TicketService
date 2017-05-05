#!/bin/bash

ln -s /usr/javaapp/ticketingservice-1.0.1-RELEASE.war /etc/init.d/ticketserver

/etc/init.d/ticketservice start
