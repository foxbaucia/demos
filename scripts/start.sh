#!/bin/bash
./scripts/deploy.sh
echo --------------------------------------------
echo STARTING APP
echo --------------------------------------------

java -jar target/demos-api-1.0.0.war
