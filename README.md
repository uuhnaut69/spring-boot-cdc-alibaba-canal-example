# CDC from MySQL to Elasticsearch using Canal

- Canal is a high performance data synchronization system based on MySQL binary log. 

- Canal Server is capable of parsing MySQL binlog and subscribe to the data change, while Canal Client can be implemented to broadcast the change to anywhere, e.g. database and Apache Kafka.

# Start Environment

Start elasticsearch + kibana service

```bash
docker-compose up -d
```

Enable binlog MySql via edit my.cnf

```bash
server-id         = 223344
log_bin           = mysql-bin
binlog_format     = row
binlog_row_image  = full
expire_logs_days  = 10

#optional
gtid_mode                 = on
enforce_gtid_consistency  = on
```

Authorize the canal link to the MySQL account as a MySQL slave, if you already have an account, you can directly grant

```sql
CREATE USER canal IDENTIFIED BY 'canal';  
GRANT SELECT, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'canal'@'%';
-- GRANT ALL PRIVILEGES ON *.* TO 'canal'@'%' ;
FLUSH PRIVILEGES;
```

Download Alibaba Canal

```bash
wget https://github.com/alibaba/canal/releases/download/canal-1.1.4/canal.deployer-1.1.4.tar.gz
```

Unzip

```bash
mkdir /tmp/canal
tar zxvf canal.deployer-$version.tar.gz  -C /tmp/canal
```

Configuration

```bash
vi conf/example/instance.properties
```

Rename to database info

```bash
canal.instance.dbUsername = ${USER_NAME}  
canal.instance.dbPassword = ${PASSWORD}  
```

Start 

```bash
sh bin/startup.sh
```

Verify server is started

```bash
vi logs/canal/canal.log
```

# References
https://github.com/alibaba/canal/wiki/QuickStart

https://github.com/NormanGyllenhaal/canal-client