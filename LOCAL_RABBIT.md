### Iniciando uma fila rabbitmq "local" via docker
---
more info: https://registry.hub.docker.com/u/tutum/rabbitmq/

###### Baixando a imagem e iniciando o serviço:
```sh
$ docker run -d -p 5672:5672 -p 15672:15672 -e RABBITMQ_PASS="pass" tutum/rabbitmq
```

##### Cluster com duas instancias
```sh
$ docker run -d --name rabbit1 \
 -p 5672:5672 -p 15672:15672 -p 35197:35197 -p 4369:4369 -p 25672:25672 \
 -e HOSTNAME=node1.host.io \
 -e RABBITMQ_USE_LONGNAME=true \
 -e RABBITMQ_PASS="pass" \
 tutum/rabbitmq

$ docker run -d --link rabbit1:node1.host.io --name rabbit2 \
 -p 5673:5672 -p 15673:15672 -p 35193:35197 -p 4363:4369 -p 25673:25672 \
 -e HOSTNAME=node2.host.io \
 -e RABBITMQ_USE_LONGNAME=true \
 -e CLUSTER_WITH=node1.host.io \
 -e RABBITMQ_PASS="pass" \
 tutum/rabbitmq
```

###### Dados para conexão via api:
```sh
curl --user admin:mypass  http://<host>:<port>/api/vhosts
```
