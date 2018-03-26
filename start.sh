#!/bin/sh
#cd /opt/app/backend/
#nohup java -Xmx8192M -Xms4096M -jar credit-system-web-boot-1.0.0.jar --spring.config.location=application-jjxxzx-test.properties >/dev/null &

readonly JAVA_HOME='/opt/dolphin/jdk1.8.0_161'
readonly APP_PATH='/opt/dolphin/app/backend'

source ${APP_PATH}/version.properties

count=`ps -ef | grep dolphin-web-${VERSION} | grep -v "grep" | wc -l`
if [ $count -lt 1 ]; then
	setsid ${JAVA_HOME}/bin/java -Xmx512M -Xms256M \
	-jar -Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=5005	\
	${APP_PATH}/dolphin-web-${VERSION}.jar \
	--spring.config.location=${APP_PATH}/application.properties>/dev/null &
else
	echo "process aready exists!"
fi
