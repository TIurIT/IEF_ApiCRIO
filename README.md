## Documentação da API de Gerenciamento de Eventos
 
Esta documentação fornece um guia passo a passo para configurar e executar a API de gerenciamento de eventos utilizando Docker.
 
### Pré-requisitos
Antes de começar, você precisará ter os seguintes itens instalados em seu ambiente:
 
1. **Docker**: Certifique-se de ter o Docker instalado. Você pode baixá-lo em [docker.com](https://www.docker.com/get-started).
2. **Docker Compose** (opcional): Para gerenciar serviços multi-containers, é recomendado ter o Docker Compose instalado. Normalmente, ele já vem com o Docker Desktop.

### Passo a Passo para Configuração
 
1. **Clone o repositório**
    ```bash
    git clone https://github.com/seu_usuario/seu_repositorio.git
    cd seu_repositorio
    ```
 
2. **Crie um arquivo `.env`**
    - No diretório raiz do projeto, crie um arquivo chamado `.env` e defina suas variáveis de ambiente necessárias. Exemplo:
      ```dotenv
      DATABASE_URL=postgres://usuario:senha@db:5432/seu_banco
      PORT=3000
      ```

3. **Construa a imagem Docker**
    ```bash
    docker-compose build
    ```
 
 4. **Inicie os containers**
    ```bash
    docker-compose up
    ```
    - Isso irá iniciar a API e o banco de dados. Você pode acessar a API em `http://localhost:3000`.
 
5. **Testar a API**
    - Utilize ferramentas como Postman ou cURL para testar os endpoints da API. Abaixo estão alguns exemplos:
      - **Listar eventos**: `GET http://localhost:3000/api/events`
      - **Criar evento**: `POST http://localhost:3000/api/events` com um corpo JSON apropriado.
 
### Notas Finais
 - Certifique-se de consultar a documentação dos endpoints da API para obter detalhes sobre como utilizá-los.
 - Se você encontrar problemas, verifique os logs do Docker para diagnóstico:
   ```bash
   docker-compose logs
   ```
 
Para mais informações sobre como contribuir ou sobre o projeto, consulte a seção de Contribuição no README.
