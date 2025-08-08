#!/bin/sh
if [ $? -eq 0 ]; then 
	java -jar /usr/local/rest-outbound/rest-outbound-0.0.1-SNAPSHOT.jar
fi