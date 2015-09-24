#!/bin/bash
javac -d . -cp ./code: code/createMetadata.java
java createMetadata $1 > metadata.txt
javac -d . -cp ./code: code/Comp.java
javac -d . -cp ./code: code/container.java
javac -d . -cp ./code: code/mergeFiles.java
javac -d . -cp ./code: code/myOwn.java
javac -d . -cp ./code: code/TwoWaySort.java
java TwoWaySort $1 outputTemp11.txt 50 asc col1
java createMetadata $2 > metadata.txt
java TwoWaySort $2 outputTemp22.txt 50 asc col0
if [[ $3 == "sort" ]]
then
javac -d . -cp ./code: code/sortAndJoinVersion2.java
java sortAndJoinVersion2 > mainOutput.txt
else
javac -d . -cp ./code: code/joinUsingHash.java
javac -d . -cp ./code: code/joining.java
java joinUsingHash P $4
java joinUsingHash S $4
java joining $4 > mainOutput.txt
fi
