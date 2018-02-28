#!/bin/bash
echo --------------------------------------------
echo LOCAL UPDATE
echo --------------------------------------------
git pull || exit 1

echo --------------------------------------------
echo TEST
echo --------------------------------------------
mvn test || exit 1

echo --------------------------------------------
echo COMPILE REACT FILES
echo --------------------------------------------
cd src/main/react-app/
npm run compile || exit 1

cd ../../..

echo --------------------------------------------
echo BUILD
echo --------------------------------------------
mvn clean install || exit 1

