#!/bin/bash
mvn clean
mvn install
cd target/
java -jar adm*
