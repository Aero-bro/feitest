#基础镜像
FROM tomcat

#作者
LABEL maintainer="zhoufei<1498747727@qq.com>"


#TOMCAT环境变量
ENV CATALINA_BASE /usr/local/tomcat
ENV JAVA_HOME  /jdk
ENV PATH $JAVA_HOME/bin:$PATH

#启动入口
ENTRYPOINT ["catalina.sh","run"]

#健康检查s
# HEALTHCHECK --interval=10s --timeout=3s \
#   CMD nc -z localhost 5198 >/dev/null || exit 1

#拷贝war包到tomcat
COPY target/fei-test.war ${CATALINA_HOME}/webapps/
COPY jdk /jdk
