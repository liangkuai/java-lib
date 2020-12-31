/opt/souche/java/bin/java
-Djava.util.logging.config.file=/home/souche/projects/slowpoke/.base/conf/logging.properties
-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
-Djdk.tls.ephemeralDHKeySize=2048
-Djava.protocol.handler.pkgs=org.apache.catalina.webresources
-server
-Xms4g
-Xmx4g
-XX:MetaspaceSize=1024m
-XX:MaxMetaspaceSize=1024m
-Xmn1536m
-XX:MaxDirectMemorySize=1024m
-XX:SurvivorRatio=6
-XX:+UseConcMarkSweepGC
-XX:+UseCMSCompactAtFullCollection
-XX:CMSMaxAbortablePrecleanTime=5000
-XX:+CMSClassUnloadingEnabled
-XX:CMSInitiatingOccupancyFraction=80
-XX:+UseCMSInitiatingOccupancyOnly
-XX:+ExplicitGCInvokesConcurrent
-Dsun.rmi.dgc.server.gcInterval=2592000000
-Dsun.rmi.dgc.client.gcInterval=2592000000
-Xloggc:/home/souche/projects/slowpoke/logs/gc.log
-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
-Dfile.encoding=UTF-8
-Dcom.alibaba.rocketmq.client.sendSmartMsg=false
-Djava.security.egd=file:/dev/./urandom
-javaagent:/home/souche/bin/transmittable-thread-local-2.7.0-SNAPSHOT.jar
-javaagent:/home/souche/bin/souche-agent/slowpoke/scTracer/agent/souche-agent.jar
-DAPP_NAME=slowpoke
-DAPP_HOME=/home/souche/projects/slowpoke
-Ddubbo.op_token=wNFubf4ZcEgBq26V
-Dignore.endorsed.dirs=
-classpath /opt/souche/tomcat/bin/bootstrap.jar:/opt/souche/tomcat/bin/tomcat-juli.jar
-Dcatalina.base=/home/souche/projects/slowpoke/.base
-Dcatalina.home=/opt/souche/tomcat
-Djava.io.tmpdir=/home/souche/projects/slowpoke/.base/temp org.apache.catalina.startup.Bootstrap start







/opt/souche/java/bin/java -Djava.util.logging.config.file=/home/souche/projects/slowpoke/.ba
se/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=o
rg.apache.catalina.webresources -server -Xms4g -Xmx4g -XX:MetaspaceSize=1024m -XX:MaxMetaspaceSize=1024m -Xmn1536m -XX:MaxDirectMemorySize=1024m -XX:Survivor
Ratio=6 -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupa
ncyFraction=80 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval
=2592000000 -Xloggc:/home/souche/projects/slowpoke/logs/gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Dfile.encoding=UTF-8 -Dcom.alibaba.rocketmq.client
.sendSmartMsg=false -Djava.security.egd=file:/dev/./urandom -javaagent:/home/souche/bin/transmittable-thread-local-2.7.0-SNAPSHOT.jar -javaagent:/home/souche
/bin/souche-agent/slowpoke/scTracer/agent/souche-agent.jar -DAPP_NAME=slowpoke -DAPP_HOME=/home/souche/projects/slowpoke -Ddubbo.op_token=2K8TnbISa7cw8zDR -D
ignore.endorsed.dirs= -classpath /opt/souche/tomcat/bin/bootstrap.jar:/opt/souche/tomcat/bin/tomcat-juli.jar -Dcatalina.base=/home/souche/projects/slowpoke/.
base -Dcatalina.home=/opt/souche/tomcat -Djava.io.tmpdir=/home/souche/projects/slowpoke/.base/temp org.apache.catalina.startup.Bootstrap start





/opt/souche/java/bin/java -Djava.util.logging.config.file=/home/souche/projects/muk/.base/co
nf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.ap
ache.catalina.webresources -server -Xms1g -Xmx1g -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -Xmn384m -XX:MaxDirectMemorySize=256m -XX:SurvivorRatio=8 -
XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFracti
on=80 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=25920000
00 -Xloggc:/home/souche/projects/muk/logs/gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Dfile.encoding=UTF-8 -Dcom.alibaba.rocketmq.client.sendSmartMsg=
false -Djava.security.egd=file:/dev/./urandom -javaagent:/home/souche/bin/transmittable-thread-local-2.7.0-SNAPSHOT.jar -javaagent:/home/souche/bin/souche-ag
ent/muk/scTracer/agent/souche-agent.jar -DAPP_NAME=muk -DAPP_HOME=/home/souche/projects/muk -Ddubbo.op_token=B08xxO2Jyd6cTi1b -Dignore.endorsed.dirs= -classp
ath /opt/souche/tomcat/bin/bootstrap.jar:/opt/souche/tomcat/bin/tomcat-juli.jar -Dcatalina.base=/home/souche/projects/muk/.base -Dcatalina.home=/opt/souche/t
omcat -Djava.io.tmpdir=/home/souche/projects/muk/.base/temp org.apache.catalina.startup.Bootstrap start







/opt/souche/java/bin/java -Djava.util.logging.config.file=/home/souche/projects/eevee/.base/
conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.
apache.catalina.webresources -agentlib:jdwp=transport=dt_socket,address=13000,server=y,suspend=n -server -Xms256m -Xmx512m -XX:MetaspaceSize=128m -XX:MaxMeta
spaceSize=128m -Xmn192m -XX:MaxDirectMemorySize=128m -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecle
anTime=5000 -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFraction=80 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi
.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=2592000000 -Xloggc:/home/souche/projects/eevee/logs/gc.log -XX:+PrintGCDetails -XX:+PrintGC
DateStamps -Dfile.encoding=UTF-8 -Dcom.alibaba.rocketmq.client.sendSmartMsg=false -Djava.security.egd=file:/dev/./urandom -javaagent:/home/souche/bin/transmi
ttable-thread-local-2.7.0-SNAPSHOT.jar -javaagent:/home/souche/bin/souche-agent/eevee/scTracer/agent/souche-agent.jar -javaagent:/home/souche/bin/sandbox/lib
/sandbox-agent.jar -DAPP_NAME=eevee -DAPP_HOME=/home/souche/projects/eevee -Ddubbo.op_token=bSJt5jbdbNqExcB3 -Dignore.endorsed.dirs= -classpath /opt/souche/t
omcat/bin/bootstrap.jar:/opt/souche/tomcat/bin/tomcat-juli.jar -Dcatalina.base=/home/souche/projects/eevee/.base -Dcatalina.home=/opt/souche/tomcat -Djava.io
.tmpdir=/home/souche/projects/eevee/.base/temp org.apache.catalina.startup.Bootstrap start





/opt/souche/java/bin/java -Djava.util.logging.config.file=/home/souche/projects/eevee/.base
/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org
.apache.catalina.webresources -server -Xms3g -Xmx3g -Xmn1024m -XX:MetaspaceSize=1024m -XX:MaxMetaspaceSize=1024m -XX:MaxDirectMemorySize=512m -XX:SurvivorRat
io=6 -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancy
Fraction=80 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=25
92000000 -Xloggc:/home/souche/projects/eevee/logs/gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Dfile.encoding=UTF-8 -Dcom.alibaba.rocketmq.client.sendS
martMsg=false -Djava.security.egd=file:/dev/./urandom -javaagent:/home/souche/bin/transmittable-thread-local-2.7.0-SNAPSHOT.jar -javaagent:/home/souche/bin/s
ouche-agent/eevee/scTracer/agent/souche-agent.jar -DAPP_NAME=eevee -DAPP_HOME=/home/souche/projects/eevee -Ddubbo.op_token=L7hlqn3SAcVCfrqW -Dignore.endorsed
.dirs= -classpath /opt/souche/tomcat/bin/bootstrap.jar:/opt/souche/tomcat/bin/tomcat-juli.jar -Dcatalina.base=/home/souche/projects/eevee/.base -Dcatalina.ho
me=/opt/souche/tomcat -Djava.io.tmpdir=/home/souche/projects/eevee/.base/temp org.apache.catalina.startup.Bootstrap start