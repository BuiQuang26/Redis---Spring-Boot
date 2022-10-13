# Spring-Boot-Redis-Cache

## Install Redis

### Install Redis on linux

1. Update package

```shell
sudo apt update
```

2. Install redis

```shell
sudo apt install redis
```

3. Run Redis

```shell
sudo service redis-server start

# Redis-server running on port: 6379
```

4. Access Redis by Redis-cli

```shell
$ redis-cli
127.0.0.1:6379> ping
PONG
127.0.0.1:6379>

# Set data
# $ set <key> <data>
$ set my-key "my-data"

# Get all keys
$ keys "*"

# Get data
# $ get <key>
$ get my-key

```
## Get started Spring boot redis cache
[https://www.digitalocean.com/community/tutorials/spring-boot-redis-cache](https://www.digitalocean.com/community/tutorials/spring-boot-redis-cache)
