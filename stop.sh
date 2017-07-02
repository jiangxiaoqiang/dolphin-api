#!/bin/sh

#cd /opt/app/backend
PROGRAM_PATH="/opt/app/backend"
#kill "cat $PROGRAM_PATH/app.pid"
myFile="/opt/app/backend/app.pid"

if [ -f "$myFile" ]; then
    kill `cat /opt/app/backend/app.pid`
fi

