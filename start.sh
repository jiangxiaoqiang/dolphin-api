#!/bin/sh
#cd /opt/app/backend/
#nohup java -Xmx8192M -Xms4096M -jar credit-system-web-boot-1.0.0.jar --spring.config.location=application-jjxxzx-test.properties >/dev/null &

source version.properties

count=`ps -ef | grep dolphin-web | grep -v "grep" | wc -l`
if [ $count -lt 1 ]; then
	nohup java -Xmx512M -Xms256M -jar -Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=5005	/opt/dolphin/backend/dolphin-web.jar --spring.config.location=application.properties>/dev/null &
else
	echo "process aready exists!"
fi
