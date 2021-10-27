# User-api
Minha primeira API em Spring Boot um simples CRUD com mysql =D

### Pré-requisitos

    - Git
    - Java
    - Spring Boot
    - Docker
    - IDE de sua preferência 

## Database/Docke   r

#### Configurando docker mysql

    $docker volume create mysql-volume
    $docker run --name container-mysql -p3306:3306 -v mysql-volume:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=sua_senha_aqui -d mysql/mysql-server:latest

#### Executando docker
    $docker exec -it container-mysql bash

#### Executando mysql
    $mysql -u root -p

#### Script mysql

    --1) crir database 
        CREATE DATABASE cadastro_db;

    --2) acessar O DATABASE
        use cadastro_db;

    --3) Criar Tabela
        CREATE TABLE cadastro (
        id BIGINT NOT NULL,
        nome VARCHAR(255) NOT NULL,
        CONSTRAINT pk_cadastro PRIMARY KEY (id)
        );

    --4) Dar permissao caso precise
        CREATE USER 'root'@'ip_address' IDENTIFIED BY 'sua_senha_aqui';
        GRANT ALL PRIVILEGES ON *.* TO 'root'@'ip_address';

## Start da aplicação
### Application.properties - arquivo com as configurações do projeto como: datasource, usuário e senha de BD
        Variaveis de ambiente 

        DATA_SOURCE_URL=jdbc:mysql://localhost:3306/cadastro_db?allowPublicKeyRetrieval=true&useSSL=false
        DATA_SOURCE_USER=seu_usuario_aqui
        DATA_SOURCE_PASSWORD=sua_senha_aqui
