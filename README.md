# MyMusic

Aplicação utilizando microsserviços simulando uma Playlist

# Pré-requisitos!

  - Java 8
  - Maven
  - Angular-cli

### Iniciando a Aplicação
Se necessário, alterar o aplication.yml com as configurações de cada serviço, ou, utilizar configuração externa do spring-boot

Para subir essa aplicação de exemplo, é necessário subir as aplicação _registry-server_ e _gateway_, e depois (não importando a ordem) subir as aplicações _musica-service_ e _playlist-service_.

Para acessar a página de dashboard do _registry-server_, basta acessar: _http://localhost:8761/_

No fim da página, é possível pegar o link do servidor para acesso. Por exemplo: _192.168.15.16_

Utilizando o ip de exemplo, podemos acessar os outros sevidores (playlist-service e musica-service).
Ambos estão com o swagger habilitado individualmente.
_http://192.168.15.16:8081/swagger-ui.html_
_http://192.168.15.16:8082/swagger-ui.html_

Para acesso da aplicação web, após instalar as dependências (npm install), basta executar ng serve.
O path dos servidores encontram-se dentro do arquivo environment, se necessário.
Para acessa-lo, acesse o link: _http://localhost:4200/_
