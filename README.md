# spring-rest

```shell
docker run --rm \
--name=mysql-pzn-db \
-e MYSQL_DATABASE=mysqlpzn-db \
-e MYSQL_USER=yukbelajar \
-e MYSQL_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e MYSQL_ROOT_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e TZ=Asia/Jakarta \
-p 6603:3306 \
-v "$PWD/mydata/mysql/log":/var/log/mysql \
-v "$PWD/mydata/mysql/data":/var/lib/mysql \
-v "$PWD/mydata/mysql/conf":/etc/mysql/conf.d \
mysql:8
```