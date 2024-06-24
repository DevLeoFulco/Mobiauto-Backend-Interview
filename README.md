### Introdução

A Mobiauto é uma empresa líder no setor automotivo, dedicada a proporcionar soluções inovadoras para melhorar a experiência de compra e venda de veículos no Brasil. Com uma visão centrada no cliente e uma cultura de inovação, estamos comprometidos em revolucionar a forma como as pessoas compram e vendem carros, tornando o processo mais transparente, seguro e conveniente.
O sistema Mobiauto é uma ferramenta robusta desenvolvida para a gestão de revendas de veículos, oferecendo funcionalidades essenciais para a administração eficiente de usuários, veículos, oportunidades de vendas e revendas. Desenvolvida com foco em segurança, eficiência e facilidade de uso, este sistema atende a diversos requisitos técnicos essenciais para garantir uma operação fluida e segura.

#### Principais Funcionalidades

1. **Gestão de Revendas**:
   - Cadastro e manutenção de revendas com identificador único e CNPJ válido e único.
   - Cada revenda possui um nome social.

2. **Autenticação e Autorização**:
   - Login seguro seguindo as melhores práticas de segurança.
   - Usuários possuem identificador, nome, e-mail único e senha.
   - Perfis de usuários associados às revendas com cargos específicos (Proprietário, Gerente, Assistente).
   - Apenas administradores podem cadastrar novos usuários, exceto proprietários e gerentes que podem cadastrar usuários em suas respectivas lojas.

3. **Permissões de Usuários**:
   - Edição e manutenção de perfis somente por administradores ou proprietários da loja.
   - Administradores possuem permissão para todas as ações em todas as revendas.
   - Usuários têm acesso restrito às lojas onde estão vinculados com seus respectivos cargos.

4. **Gestão de Oportunidades**:
   - Cada loja pode gerenciar uma lista de oportunidades para atendimento e negociação.
   - Cada oportunidade possui um identificador único e status (novo, em atendimento, concluído).
   - Registro de dados do cliente (nome, e-mail, telefone) e veículo de interesse (marca, modelo, versão, ano modelo).

5. **Atendimento e Edição de Oportunidades**:
   - Distribuição inteligente de oportunidades para assistentes da loja com base na fila, considerando a menor quantidade de oportunidades em andamento e maior tempo sem receber uma nova oportunidade.
   - Proprietários e gerentes podem transferir oportunidades para outros assistentes.
   - Apenas o usuário associado à oportunidade pode editá-la, exceto gerentes e proprietários que podem editar todas as oportunidades de sua loja.
   - Registro da data de atribuição e conclusão da oportunidade.

#### Objetivos

- **Segurança**: Implementar autenticação e autorização robustas usando JWT (JSON Web Token).
- **Eficiência**: Facilitar a gestão de revendas, usuários e oportunidades de forma centralizada e eficiente.
- **Facilidade de Uso**: Proporcionar uma interface de API RESTful bem documentada para fácil integração com sistemas externos.

### Visão Geral

#### Pré-requisitos de Software, Bibliotecas e Serviços Externos

Para garantir o funcionamento adequado do sistema Mobiauto, os seguintes pré-requisitos de software, bibliotecas e serviços externos são necessários:

1. **Software**
   - **Java 17**
   - **Maven 3.8.1** ou superior
   - **Docker**
   - **Docker Compose**

2. **Bibliotecas**
   - **Spring Boot 2.6.4**
   - **Spring Security**
   - **Spring Data JPA**
   - **H2 Database**: Utilizado para fins de teste, mas o sistema esta programado para receber MySQL, Postgres, etc.
   - **Springdoc OpenAPI 1.6.6**
   - **JWT (JSON Web Token)**
   - **Lombok**

3. **Serviços Externos**
   - **Swagger UI**

#### Componentes da Arquitetura e Suas Responsabilidades

A arquitetura do sistema Mobiauto é composta pelos seguintes componentes principais:

1. **Controladores (Controllers)**:
   - **AuthController**: Para gerenciar operações de autenticação e registro de usuários.
   - **RevendaController**: Para manipular operações relacionadas a revendas, como criação e atualização.
   - **UsuarioController**: Para gerenciar operações de usuário, como criação, atualização e listagem.
   - **OportunidadeController**: Para lidar com operações de oportunidades de venda, como criação, atualização e atribuição.

2. **Serviços (Services)**:
   - **AuthService**: Implementa a lógica de autenticação e gera os tokens JWT.
   - **RevendaService**: Contém a lógica de negócios para operações de revendas.
   - **UsuarioService**: Implementa a lógica de negócios relacionada a usuários.
   - **OportunidadeService**: Gerencia a lógica de negócios para oportunidades de venda.

3. **Repositórios (Repositories)**:
   - **RevendaRepository**: Interface para acesso e manipulação de dados de revendas.
   - **UsuarioRepository**: Interface para acesso e manipulação de dados de usuários.
   - **OportunidadeRepository**: Interface para acesso e manipulação de dados de oportunidades.

4. **Filtros (Filters)**:
   - **JwtRequestFilter**: Filtro que intercepta requisições HTTP para validar o token JWT.

5. **Configurações (Configurations)**:
   - **SecurityConfig**: Configuração de segurança da aplicação, incluindo regras de autorização e autenticação.
   - **OpenApiConfig**: Configuração do Swagger/OpenAPI para documentação da API.

6. **Modelos (Models)**:
   - **Usuario**: Entidade que representa um usuário no sistema.
   - **Revenda**: Entidade que representa uma revenda.
   - **Oportunidade**: Entidade que representa uma oportunidade de venda.
   - **Cargo**: Enum que representa os cargos possíveis de um usuário.

#### Diagrama de Arquitetura

A seguir, um diagrama representando a arquitetura da aplicação:

```plaintext
+------------------+          +-------------------+
|                  |          |                   |
|    Controllers   +---------->     Services      |
|                  |          |                   |
+---+--------------+          +---------+---------+
    |                                   |
    |                                   |
    |                                   |
    v                                   v
+---+--------------+          +---------+---------+
|                  |          |                   |
|    Repositories  +<---------+      Models       |
|                  |          |                   |
+---+--------------+          +-------------------+
    ^
    |
    |
    v
+---+--------------+
|                  |
|      Filters     |
|                  |
+------------------+
```

#### Detalhes dos Componentes

1. **Controllers**: Essa é a camada responsável por receber e responder às requisições HTTP. Traduzem as operações para chamadas aos serviços correspondentes.
   
2. **Services**: Aqui contêm a lógica de negócios da aplicação. São responsáveis por implementar as regras e operações do sistema.

3. **Repositories**: São as interfaces que gerenciam a persistência dos dados, realizando operações de CRUD (Create, Read, Update, Delete) no banco de dados.

4. **Filters**: São os componentes que interceptam e manipulam as requisições HTTP antes de chegarem aos controladores. No caso, o filtro JwtRequestFilter valida tokens JWT para autenticação.

5. **Configurations**: Arquivos de configuração que definem comportamentos e integrações da aplicação, como segurança e documentação da API.

6. **Models**: São as classes que representam as entidades do sistema e são usadas para mapear objetos para o banco de dados.

### Configuração e Variáveis de Ambiente

#### Arquivo docker-compose.yml

O arquivo `docker-compose.yml` facilita a execução da aplicação em um ambiente contêinerizado. Aqui está a configuração para que você possa usar:

```yaml
version: '3.8'
services:
  app:
    image: mobiauto-app
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
      - SPRING_DATASOURCE_USERNAME=sa
      - SPRING_DATASOURCE_PASSWORD=
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
      - JWT_SECRET=mysecretkey
      - JWT_EXPIRATION=3600
    networks:
      - mobiauto-network

networks:
  mobiauto-network:
    driver: bridge
```

#### Dockerfile

O `Dockerfile` foi usado aqui para definir como a imagem Docker da aplicação será construída:

```dockerfile
# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR gerado para o diretório de trabalho
COPY target/mobiauto-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Define o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
```

#### Dependências Necessárias

Para executar a aplicação, são necessárias as seguintes dependências:

- **Java 17**
- **Maven**
- **Docker**
- **Docker Compose**

Além disso, a aplicação depende das seguintes bibliotecas e frameworks:

- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI**
- **JWT**
- **Lombok**

#### Variáveis de Ambiente

O sistema utiliza as seguintes variáveis de ambiente, que podem ser configuradas no `docker-compose.yml` ou em um arquivo `.env`:

- **SPRING_DATASOURCE_URL**: URL do banco de dados. Exemplo: `jdbc:h2:mem:testdb`.
- **SPRING_DATASOURCE_USERNAME**: Nome de usuário do banco de dados. Exemplo: `sa`.
- **SPRING_DATASOURCE_PASSWORD**: Senha do banco de dados. Exemplo: vazio para H2 em memória ja que foi usado para teste.
- **SPRING_JPA_HIBERNATE_DDL_AUTO**: Propriedade para gerenciar o esquema do banco de dados. Exemplo: `update`.
- **JWT_SECRET**: Chave secreta usada para assinar tokens JWT. Exemplo: `mysecretkey`.
- **JWT_EXPIRATION**: Tempo de expiração do token JWT em segundos. Exemplo: `3600`.

#### Passos para Executar a Aplicação

1. **Clonar o Repositório**: Você deve clonar o repositório do projeto para sua máquina local.
   ```sh
   git clone https://github.com/seu-usuario/mobiauto.git
   cd mobiauto
   ```

2. **Construir a Imagem Docker**: Construa a imagem Docker da aplicação.
   ```sh
   docker-compose build
   ```

3. **Iniciar a Aplicação**: Use o Docker Compose para iniciar a aplicação.
   ```sh
   docker-compose up
   ```

4. **Acessar a Aplicação**: Acesse a aplicação via navegador no endereço `http://localhost:8080`.

5. **Documentação da API**: Acesse a documentação da API no Swagger UI em `http://localhost:8080/swagger-ui.html`.

### Suporte e Contato

#### Canais de Comunicação

Para suporte e contato, utilize os seguintes canais:

- **E-mail**: devleofulco@gmail.com
- **Whatsapp**: (81) 9-9670-2190

Esses canais estão disponíveis para responder dúvidas, solucionar problemas e receber feedback sobre o sistema Mobiauto.

#### Soluções para Problemas Comuns ou Erros Conhecidos

Aqui estão algumas soluções para problemas comuns que podem ser encontrados ao usar o sistema:

##### 1. Problemas ao Iniciar a Aplicação

**Erro**: A aplicação não inicia corretamente ou retorna um erro HTTP 403 ao acessar a documentação da API.

**Solução**:
- Verifique se as variáveis de ambiente estão corretamente configuradas no `docker-compose.yml`.
- Certifique-se de que o JWT_SECRET foi definido corretamente.
- Confirme se a configuração de segurança no arquivo `SecurityConfig` está permitindo o acesso aos endpoints de documentação (`/v3/api-docs/**`, `/swagger-ui/**`, `/swagger-ui.html`).

##### 2. Problemas de Conexão com o Banco de Dados

**Erro**: A aplicação não consegue conectar ao banco de dados.

**Solução**:
- Verifique se a URL do banco de dados está correta nas variáveis de ambiente (`SPRING_DATASOURCE_URL`).
- Certifique-se de que o banco de dados está ativo e acessível.
- Verifique se o nome de usuário e senha do banco de dados estão corretos (`SPRING_DATASOURCE_USERNAME` e `SPRING_DATASOURCE_PASSWORD`).

##### 3. Erros de Autenticação

**Erro**: Usuários não conseguem fazer login ou recebem erros de autenticação.

**Solução**:
- Verifique se o serviço de autenticação está corretamente configurado.
- Confirme se os usuários estão registrados corretamente na base de dados.
- Certifique-se de que os tokens JWT estão sendo gerados e enviados corretamente.

##### 4. Problemas na Construção da Imagem Docker

**Erro**: Erros ao construir a imagem Docker, como "failed to solve" ou "no such file or directory".

**Solução**:
- Certifique-se de que o arquivo `Dockerfile` e o diretório `target` estão presentes e corretos.
- Verifique se o comando `./mvnw clean package` foi executado corretamente para gerar o arquivo JAR.
- Confirme se a imagem base especificada no `Dockerfile` é válida e acessível.

##### 5. Problemas com Permissões de Usuário

**Erro**: Usuários não conseguem acessar determinadas funcionalidades ou revendas.

**Solução**:
- Verifique se os usuários têm os papéis corretos atribuídos (Proprietário, Gerente, Assistente).
- Confirme se as permissões de usuário estão configuradas corretamente na aplicação.
- Certifique-se de que a lógica de distribuição de oportunidades e transferência está funcionando conforme esperado.

#### Passos Adicionais para Solução de Problemas

1. **Verificar Logs**: Sempre verifique os logs da aplicação para mensagens de erro detalhadas que possam ajudar a diagnosticar o problema.
   ```sh
   docker logs <container_id>
   ```

2. **Debugging**: Utilize ferramentas de debugging para investigar problemas de configuração ou lógica na aplicação.

3. **Reinstalação**: Em casos extremos, tente remover os contêineres e imagens Docker e reconstruir a aplicação.
   ```sh
   docker-compose down
   docker-compose build
   docker-compose up
   ```

4. **Documentação**: Consulte a documentação oficial das bibliotecas e ferramentas utilizadas (Spring Boot, Spring Security, Docker, etc.) para obter mais informações e soluções.

### Mensagem de Satisfação

Agradeço pela leitura e interesse nesse projeto e gostaria de expressar minhas sincera gratidão por demonstrar os conhecimentos que tenho adquirido em minha trajetória como desenvolvedor, especificamente com a linguagem Java. 

Este projeto me proporcionou a oportunidade de:

- Aplicar práticas avançadas de segurança e autenticação com JWT.
- Demonstrar proficiência em Spring Boot, Spring Security e Hibernate.
- Configurar e gerenciar um ambiente de desenvolvimento usando Docker e Docker Compose.
- Documentar a aplicação de forma clara e detalhada, garantindo uma fácil compreensão e manutenção do código.

