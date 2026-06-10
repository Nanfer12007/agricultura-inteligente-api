# 🌱 Agricultura Inteligente com Dados Espaciais

# Java

## 📖 Sobre o Projeto

O projeto **Agricultura Inteligente com Dados Espaciais** é uma plataforma desenvolvida para auxiliar agricultores na tomada de decisões por meio da análise de dados satelitais e inteligência artificial.

A solução monitora indicadores ambientais importantes, como temperatura, umidade do solo, índice de vegetação e risco de seca, permitindo acompanhar a saúde das plantações e antecipar possíveis problemas climáticos.

Além disso, o sistema realiza a geração automática de dados simulados para fins acadêmicos e demonstração do funcionamento da plataforma.

---

## 🎥 Vídeo de Apresentação

- Vídeo de Java: https://www.youtube.com/watch?v=LHL9zVM_Z0E
- Vídeo de Devops: https://www.youtube.com/watch?v=HLRYTbMV9lw

---

## 📚 Documentação da API

Após executar o projeto localmente, a documentação Swagger poderá ser acessada em:

```text
http://localhost:8081/swagger
```

ou

```text
http://localhost:8081/swagger-ui/index.html
```

Principais endpoints:

### Autenticação

| Método | Endpoint    |
| ------ | ----------- |
| POST   | /auth/login |

### Plantações

| Método | Endpoint         |
| ------ | ---------------- |
| GET    | /plantacoes      |
| GET    | /plantacoes/{id} |
| POST   | /plantacoes      |
| PUT    | /plantacoes/{id} |
| DELETE | /plantacoes/{id} |

### Dados Satelitais

| Método | Endpoint               |
| ------ | ---------------------- |
| GET    | /dados-satelitais      |
| GET    | /dados-satelitais/{id} |
| POST   | /dados-satelitais      |
| PUT    | /dados-satelitais/{id} |
| DELETE | /dados-satelitais/{id} |

### Fazendas

| Método | Endpoint       |
| ------ | -------------- |
| GET    | /fazendas      |
| GET    | /fazendas/{id} |
| POST   | /fazendas      |
| PUT    | /fazendas/{id} |
| DELETE | /fazendas/{id} |

### Usuários

| Método | Endpoint       |
| ------ | -------------- |
| GET    | /usuarios      |
| GET    | /usuarios/{id} |
| POST   | /usuarios      |
| PUT    | /usuarios/{id} |
| DELETE | /usuarios/{id} |

---

## 🔐 Autenticação

A API utiliza autenticação baseada em **JWT (JSON Web Token)**.

### Login

```http
POST /auth/login
```

Exemplo:

```json
{
  "email": "admin@fiap.com",
  "senha": "123456"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Após obter o token, utilize-o nas requisições protegidas:

```text
Authorization: Bearer SEU_TOKEN
```

---

## ⚙️ Instruções de Execução

### Pré-requisitos

* Java 21
* Maven 3.9+
* PostgreSQL 16+
* Eclipse ou VS Code

### 1. Clonar o projeto

```bash
git clone URL_DO_REPOSITORIO
```

### 2. Criar banco de dados

```sql
CREATE DATABASE agricultura;
```

### 3. Configurar o application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agricultura
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

### 4. Executar a aplicação

Via Maven:

```bash
mvn spring-boot:run
```

Ou executar a classe:

```java
AgriculturaApplication.java
```

### 5. Acessar Swagger

```text
http://localhost:8081/swagger
```

---

## 🛰️ Funcionalidades Implementadas

* Cadastro de usuários
* Cadastro de fazendas
* Cadastro de plantações
* Cadastro de dados satelitais
* CRUD completo para todas as entidades principais
* Persistência em PostgreSQL
* Segurança com Spring Security
* Autenticação JWT
* Documentação Swagger/OpenAPI
* Geração automática de dados satelitais simulados
* Tratamento de exceções
* Arquitetura em camadas (Controller, Service e Repository)

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate
* JWT (JJWT)
* Docker

### Banco de Dados

* PostgreSQL

### Documentação

* Swagger/OpenAPI

### Ferramentas

* Maven
* Eclipse IDE
* Git
* GitHub

---

## 📂 Estrutura do Projeto

```text
src/main/java
│
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── enums
├── exception
├── repository
├── security
├── service
└── config
```

---

## 📈 Simulação de Dados Satelitais

O sistema possui um serviço agendado responsável por gerar automaticamente dados simulados de monitoramento agrícola.

Os dados incluem:

* Temperatura
* Umidade do Solo
* Índice de Vegetação
* Risco de Seca

Esses registros são criados periodicamente para fins acadêmicos e demonstração da plataforma.

---

## 👨‍💻 Informações Relevantes para Avaliação

### Diferenciais Implementados

* Autenticação JWT funcional
* Spring Security configurado
* Integração completa com PostgreSQL
* Swagger documentado
* CRUD completo das entidades
* Simulação automática de dados satelitais
* Arquitetura seguindo boas práticas REST
* Tratamento de exceções customizadas
* Utilização de DTOs para entrada e saída de dados

### Objetivo Acadêmico

Demonstrar como tecnologias espaciais e análise de dados podem auxiliar o setor agrícola através de monitoramento inteligente, fornecendo informações estratégicas para aumento da produtividade e redução de perdas nas plantações.

-------------------
# Devops 

## 1. Gerar o Arquivo JAR

- cd no projeto

- mvn clean package -DskipTests

Ao final será gerado o arquivo:

target/agricultura-inteligente-api-0.0.1-SNAPSHOT.jar

## 2. Containers

Na raiz do projeto execute:

- docker-compose build

Para Iniciar os Containers:

- docker-compose up -d

Verificar Containers em Execução:

- docker ps

## 3. Visualizar Logs

Logs da Aplicação:

- docker logs app-rm556588
- 
Logs do Banco de Dados:

- docker logs postgres-rm556588

## 4. API

http://localhost:8081/swagger

## 5. Acessar o Container da Aplicação

- docker exec -it app-rm556588 sh

Verificar diretório:

- pwd
- ls -l

Verificar usuário:

- whoami

## 6. Acessar o Container do Banco

- docker exec -it postgres-rm556588 psql -U postgres -d agricultura

Consultar dados:

- \dt
- SELECT * FROM tb_plantacao;
- SELECT * FROM tb_dado_satelital;

## 7. Encerrar

- exit
- docker-compose down
- docker-compose down -v

## Conteúdos

Container da Aplicação

* Aplicação Java Spring Boot
* Construído via Dockerfile
* Usuário não privilegiado
* Porta 8081 exposta
* Executa na mesma rede do 

Container do Banco de Dados

* PostgreSQL 16
* Volume persistente
* Porta 5432 exposta
* Executa na mesma rede da aplicação

--------------------

## 👥 Integrantes

* Gabriel Yuji Suzuki (RM556588)

---

## 📄 Licença

Projeto desenvolvido exclusivamente para fins acadêmicos.
