### Iniciando um banco de dados oracle "local" via docker
---
more info: https://registry.hub.docker.com/u/alexeiled/docker-oracle-xe-11g/

###### Baixando a imagem e iniciando o serviço:
```
$ docker pull alexeiled/docker-oracle-xe-11g
$ docker run -d -p 2223:22 -p 1521:1521 -p 8080:8080 alexeiled/docker-oracle-xe-11g
```

###### Dados para conexão com o banco de dados:
```
hostname: localhost
port:     1521
sid:      xe
username: system
password: oracle
```
PS: Caso na primeira vez que você se conectar ao banco aparecer uma mensagem dizendo que a senha do usuário irá expirar, execute o comando baixo para alterar a senha para `oracle`
```sql
ALTER USER system IDENTIFIED BY oracle
```

###### Conectando no `Oracle Application Express web management console`:
```
url:       http://machine_ip_dev:8080/apex
workspace: INTERNAL
user:      ADMIN
password:  oracle
```

###### Login via SSH na máquina
```sh
ssh root@localhost -p 2223
password: admin
```
