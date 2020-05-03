#基础镜像
FROM tomcat:7.0.86

#作者
LABEL maintainer="zhoufei<1498747727@qq.com>"


#TOMCAT环境变量
ENV CATALINA_BASE:   /usr/local/tomcat \
    CATALINA_HOME:   /usr/local/tomcat \
    CATALINA_TMPDIR: /usr/local/tomcat/temp \
    JAVA_HOME /jdk \
    PATH $JAVA_HOME/bin:$PATH

#启动入口
ENTRYPOINT ["catalina.sh","run"]

#健康检查
# HEALTHCHECK --interval=10s --timeout=3s \
#   CMD nc -z localhost 5198 >/dev/null || exit 1

#拷贝war包到tomcat
COPY target/fei-test.war ${CATALINA_HOME}/webapps/
