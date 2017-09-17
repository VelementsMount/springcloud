#!/bin/bash


application_name=$1

function shut_down() {
    echo shutting down

    pid=$(ps -ef | grep java |grep -v grep| awk '{print $2}')
    kill -SIGTERM ${pid}
    while [ ! -z $(ps -ef | grep java |grep -v grep| awk '{print $2}') ]
    do
        sleep 1
    done
    echo shutdown
    sleep 2
    exit
}

trap "shut_down" SIGTERM SIGHUP SIGINT

java -jar ${application_name}.jar &

wait $!





