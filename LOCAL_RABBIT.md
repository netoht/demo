### Iniciando uma fila rabbitmq "local" via docker
---
more info: https://registry.hub.docker.com/u/tutum/rabbitmq/

###### Baixando a imagem e iniciando o serviço:
```sh
$ docker run -d -p 5672:5672 -p 15672:15672 -e RABBITMQ_PASS="pass" tutum/rabbitmq
```

###### Dados para conexão via api:
```sh
curl --user admin:mypass  http://<host>:<port>/api/vhosts
```
