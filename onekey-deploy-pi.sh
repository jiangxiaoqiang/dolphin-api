#!/usr/bin/env bash

#
# 发布程序到生产环境
# 一键部署后端项目到远程1台或多台服务器
# 发布流程为：编译构建-打包-发布包-拷贝包到指定目录-解压包
# 注：本机需要安装Ansible并与服务器做免密登录
#
# 2017-05-25 dolphin 增加动态读取版本号，根据版本自动发布程序
#

# 当使用未初始化的变量时，程序自动退出
set -u

# 当任何一行命令执行失败时，自动退出脚本
set -e

# send=`date '+%Y-%m-%d %H:%M:%S'`
CURRENT_TIME=`date '+%Y%m%d%H%M%S'`

#constant
readonly SERVER_APP_PATH="/opt/dolphin/backend"
readonly CONFIG_FILE="application.properties"
readonly LOGIN_USER="root"
readonly LOCAL_PATH="./web/build/libs"

# Read program version number
source ./version.properties

PROGRAM_NAME="dolphin-web.jar"
echo "$PROGRAM_NAME"

echo "开始构建..."
# Build project
gradle -p web -x test build

#如果没有app-soft文件夹，创建此文件夹
#ansible piservers -m command -a "cd ~/app-soft || mkdir -p ~/app-soft"

echo "开始拷贝..."

ansible piservers -m copy -a "src=$LOCAL_PATH/$PROGRAM_NAME dest=~/app-soft"

#拷贝停止脚本
ansible piservers -m copy -a "src=./stop.sh dest=$SERVER_APP_PATH"

#拷贝启动脚本
ansible piservers -m copy -a "src=./start.sh dest=$SERVER_APP_PATH"

#拷贝主配置文件
ansible piservers -m copy -a "src=./$CONFIG_FILE dest=$SERVER_APP_PATH"

#拷贝版本配置文件
ansible piservers -m copy -a "src=./version.properties dest=$SERVER_APP_PATH"

ansible piservers -m command -a "date"

echo "停止站点..."
ansible piservers -m command -a "chdir=$SERVER_APP_PATH bash ./stop.sh"

ansible piservers -a "cp ~/app-soft/$PROGRAM_NAME $SERVER_APP_PATH"

echo "启动站点..."
ansible piservers -m shell -a "bash ./start.sh chdir=$SERVER_APP_PATH"

echo "部署完成"
