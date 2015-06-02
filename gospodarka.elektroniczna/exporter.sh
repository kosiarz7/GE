#!/bin/bash

mvn clean install

cp target/GE.war "${WILDFLY_DIR}/standalone/deployments/GE.war"
