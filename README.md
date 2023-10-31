  # Como executar : 

  ## Como acessar o banco : 


O banco de dados está incluído em um arquivo H2 para que não seja necessário fazer uma instalação, após a applicação subir o banco em si pode ser acessado da seguinte url: http://localhost:8080/h2-console

O arquivo de banco está incluído na pasta root do projeto : 
O JDBC url deve apontar para esse arquivo, caso queira visualizar as tabelas via a interface web do HD, por exemplo : 

jdbc:h2:file:C:/Users/vito/IdeaProjects/votacao/votacaodb


<img width="345" alt="image" src="https://github.com/fvitorlopesdev/desafio-tecnico-sicredi-francisco-vitor/assets/149488344/5f713f7f-cd27-4fbc-a102-f070be25734e">


  ## Executar a aplicação :

  - rodar mvn -install para instalar localmente as biliotecas necessárias para rodar a aplicação
  - A aplicação foi construida com spring-boot, ou seja, não é necessário um servidor a parte , bastando executar a class VotacaoApplication

  Exemplo das requisições da aplicação.

### Adcionar associado

  curl --location 'localhost:8080/associado' \
--header 'Content-Type: application/json' \
--data '{"nome": "nome associado", "cpf": "15605380079"}'


### Criar pauta

 curl --location 'localhost:8080/pauta' \
--header 'Content-Type: application/json' \
--data '{"nome": "pautanome", "descricao": "pautadescricao"}'

### Abrir sessão

curl --location 'localhost:8080/abrirSessao' \
--header 'Content-Type: application/json' \
--data '{"dataInicio": "2023-10-28T11:00:00.000",  "pautaId": 1}'

### Votar

curl --location 'localhost:8080/votar' \
--header 'Content-Type: application/json' \
--data '{"voto": true, "associadoid": 1, "sessaoId": 1}'

### Contabilizar votos
    
curl --location 'localhost:8080/contabilizarVotos/1'


  

