docker run --name mysql-container --rm -e MYSQL_ROOT_PASSWORD=admin -d mysql

winpty docker run -it  --name rest-container --rm -p 8091:8091 -v  /var/lib/mysql/data  --link mysql-container pcisse200/rest-image:1.0




