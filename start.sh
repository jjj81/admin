#!/bin/bash

mvn install
cd target/
java -jar adm*
