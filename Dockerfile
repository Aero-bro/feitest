#基础镜像
FROM aero-bro/tomcatjdk8

#作者
LABEL maintainer="zhoufei<1498747727@qq.com>"




#启动入口
ENTRYPOINT ["catalina.sh","run"]

#健康检查s
# HEALTHCHECK --interval=10s --timeout=3s \
#   CMD nc -z localhost 5198 >/dev/null || exit 1

#拷贝war包到tomcat
COPY target/fei-test.war ${CATALINA_HOME}/webapps/
