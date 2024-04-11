# 使用官方的 OpenJDK 8 镜像作为基础镜像
FROM openjdk:8

# 设置工作目录
WORKDIR /app

# 复制当前目录下的 JAR 文件到容器中的 /app 目录
COPY target/mall-pay.jar /app/

# 设置容器启动时执行的命令
CMD ["java", "-jar", "mall-pay.jar"]