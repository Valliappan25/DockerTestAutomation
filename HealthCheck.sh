#!/usr/bin/env bash

#ENVIRONMENT VARIABLE
#HUB_HOST
#MODULE
#BROWSER

echo "Checking if Hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done 

#start Java Command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
