# Basket Service

Projeto em Java com Spring Boot para desenvolvimento de uma API de gerenciamento de carrinho de compras, integrando-se a uma API externa de produtos e utilizando Redis como cache para otimização de performance.

## Tecnologias, Ferramentas e Bibliotecas

- Java 17

- Spring Boot 3

- Spring Web

- Validation

- MongoDB

- Redis

- OpenFeign

- Lombok

- Docker Compose

### Configuração Inicial

1. Criar projeto no Spring Initializr

2. Importar no IntelliJ IDEA ou outro IDE

3. Renomear o arquivo application.properties para application.yml

Exemplo de configuração:

spring:  
  application:    
    name: basket-service    

  data:      
    mongodb:        
      host: localhost        
      port: 27012        
      database: basket-service      

    redis:        
      host: localhost        
      port: 6379        
      password:     

  cache:        
    redis:          
      time-to-list: 6000

🐳 Docker Compose
version: '3.8'
services:  
  mongo:    
    container_name: mongodb    
    image: mongo:4    
    ports:      
      - "27017:27017"    
    volumes:      
      - mongo-data:/data/db 

  redis:    
    container_name: redis    
    image: redis    
    environment:      
      - ALLOW_EMPTY_PASSWORD=yes    
    ports:        
      - '6379:6379'
		
volumes:  
  mongo-data:

### Funcionalidades do Basket Service
- Produtos

  - Endpoint para buscar todos os produtos

  - Endpoint para buscar produto por ID

  - Conexão com a API externa Platzi Fake Store

  - Cache com Redis para chamadas externas

- Carrinho (Basket)

  - Criar e buscar carrinho por ID

  - Atualizar carrinho

  - Deletar carrinho

- Pagamentos

  - Endpoint para realizar pagamento do carrinho

  - Definição de paymentMethod

  - Alteração de status da basket para SOLD

- Tratamento de Erros

  - Exceptions personalizadas

  - ControllerAdvice

  - CustomErrorDecoder para o PlatziStoreClient

  - BusinessException
