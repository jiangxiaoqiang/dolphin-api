#!/bin/sh

#cd /opt/app/backend
PROGRAM_PATH="/opt/dolphin/backend"
#kill "cat $PROGRAM_PATH/app.pid"
myFile="/opt/dolphin/backend/app.pid"

if [ -f "$myFile" ]; then
    kill `cat /opt/dolphin/backend/app.pid`
fi

