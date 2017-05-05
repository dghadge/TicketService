#!/bin/bash

ln -s /usr/javaapp/ticketingservice-1.0.1-RELEASE.war /etc/init.d/ticketservice

service ticketservice start
