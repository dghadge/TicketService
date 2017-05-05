#!/bin/bash

#cd /home/ec2-user/javaapp
#wget https://s3.amazonaws.com/dhqs-mirror-iad/apache-tomcat-8.0.39.tar.gz
#mkdir /opt/tomcat
#tar xvf apache-tomcat-8*tar.gz -C /opt/tomcat --strip-components=1
#cd /opt/tomcat
#sed -i 's|port="8080"|port="80"|g' conf/server.xml
#rm -rf webapps/ROOT
#mv /home/ec2-user/javaapp/ROOT.war webapps/

wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
yum install -y apache-maven

