# Rest Outbound

## Descrição
O **Rest Outbound** é um worker que consome mensagens de uma fila RabbitMQ e realiza chamadas REST para uma API configurada no Apigee. Ele utiliza autenticação OAuth2, suporta retries configuráveis e encaminha mensagens com erro para uma exchange específica no RabbitMQ.

### Funcionalidades
1. **Consumo de Mensagens**:
   - Consome mensagens de uma fila RabbitMQ configurada via ConfigMap.
2. **Extração de Dados**:
   - Extrai o payload e todos os headers da mensagem.
3. **Chamada REST**:
   - Realiza uma requisição REST para o endpoint Apigee configurado, usando:
     - Método HTTP (PUT, GET, POST, DELETE) definido no ConfigMap.
     - Payload e headers da mensagem RabbitMQ.
     - Autenticação OAuth2 para obter token antes da requisição.
4. **Mecanismo de Retry**:
   - Configurável via ConfigMap (quantidade de retentativas e status codes).
   - Status codes iniciais para retry: 429, 404.
   - Usa fila Quorum para retries e Classic para processamento sem retry.
   - Header `x-delivery-count` rastreia tentativas de retry.
5. **Fluxo de Erro**:
   - Mensagens que atingem o limite de retries ou com erros fora da lista de status codes são enviadas para a exchange de erro com o seguinte formato:
     ```json
     {
       "message": "<mensagem de erro>",
       "headers": { "header1": "valor1", "header2": "valor2" },
       "payload": { "campo1": "valor1", "campo2": "valor2" }
     }
     ```
     Headers RabbitMQ:
     - `queue`: Nome da fila.
     - `event`: Nome do evento.
     - `app-id`: `rest.outbound.<valor>` (ConfigMap).
     - `consumer-id`: Nome do pod.
     - `published`: Horário do evento.
     - `level`: Nível de risco (Panic, Critical, High, Moderate, Low, Warning, via ConfigMap).
6. **Confirmação (ACK)**:
   - ACK enviado ao RabbitMQ após sucesso ou erro não sujeito a retry.
   - Sem ACK em caso de retry, permitindo reprocessamento.

## Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.4.2
- **Mensageria**: RabbitMQ
- **Outras Dependências**:
  - Jackson (JSON/XML processing)
  - Logstash/Logback (logging)
  - Micrometer Prometheus (métricas)
  - Spring WebFlux (chamadas REST)
- **Ferramentas de DevOps**: Docker, Kubernetes, Maven

## Pré-requisitos
- Java 17
- Maven (configurado com o arquivo `settings.xml` na raiz do projeto)
- Docker (para build e deploy)
- Acesso ao RabbitMQ e Apigee (configurados via variáveis de ambiente)
- ConfigMap com endpoint Apigee, método HTTP, parâmetros de retry e configurações de fila

## Instalação
1. Clone o repositório:
   ```bash
   git clone https://gitlab.claro.com.br/Claro-Brasil/gitops/k8s/integracao-streaming/eventbus/flows/rest-outbound
   cd rest-outbound
   ```

2. Configure o Maven:
   - Certifique-se de que o arquivo `settings.xml` está na raiz do projeto e configurado para acessar os repositórios necessários.

3. Instale as dependências:
   ```bash
   mvn clean install
   ```

4. Configure as variáveis de ambiente:
   - Crie um arquivo `.env` com base no exemplo fornecido ou configure diretamente no ambiente:

    **Variáveis de Ambiente (Comum)**
    ```
    SPRING_PROFILES_ACTIVE=<profile> # Perfil ativo (ex.: dev, prod)
    SPRING_APPLICATION_NAME=rest-outbound # Nome da aplicação
    MANAGEMENT_ENDPOINTS_WEB_EXPOSURE_INCLUDE=prometheus,health,info # Endpoints expostos
    MANAGEMENT_ENDPOINT_PROMETHEUS_ENABLED=true # Habilita Prometheus
    INFO_APP_NAME=Rest Outbound # Nome da aplicação para actuator
    INFO_APP_DESCRIPTION=Worker for RabbitMQ to Apigee REST calls # Descrição da aplicação
    INFO_APP_VERSION=0.0.1-SNAPSHOT # Versão da aplicação
    APP_APPLY_NANO_TIMESTAMP=false # Usa nanosegundos para timestamps
    APP_ZONE_ID=America/Sao_Paulo # Fuso horário
    APP_REQUEST_ENVIAR_HEADERS_BODY=true # Envia headers e body na requisição
    APIGEE_BASE_URL=<apigee-base-url> # URL base do Apigee
    APIGEE_PATH_TOKEN=<apigee-token-path> # Caminho para obtenção do token OAuth2
    APIGEE_AUTHORIZATION=<auth-value> # Credenciais para autenticação
    APIGEE_GRANT_TYPE=client_credentials # Tipo de grant OAuth2
    APIGEE_AUTH_TYPE=oauth2 # Tipo de autenticação
    APIGEE_CONNECT_TIMEOUT_MILLIS=10000 # Timeout de conexão (ms)
    APIGEE_READ_BUTTON_HANDLER_SECONDS=30 # Timeout de leitura (s)
    APIGEE_WRITE_TIMEOUT_HANDLER_SECONDS=30 # Timeout de escrita (s)
    APIGEE_MAX_MEMORY_SIZE=10485760 # Tamanho máximo de memória (bytes)
    APIGEE_MAX_CONNECTIONS=100 # Máximo de conexões
    APIGEE_MAX_IDLE_TIME=30000 # Tempo máximo ocioso (ms)
    APIGEE_MAX_LIFE_TIME=60000 # Tempo máximo de vida (ms)
    APIGEE_PENDING_ACQUIRE_TIMEOUT=30000 # Timeout de aquisição (ms)
    APIGEE_EVICT_IN_BACKGROUND_TIME=60000 # Tempo de evicção em background (ms)
    APP_REQUEST_RETRY_INTERVAL=1000 # Intervalo entre retries (ms)
    APP_REQUEST_RETRY_ENABLED=true # Habilita retry
    APP_REQUEST_ALOWED_STATUS_FOR_RETRY=429,404 # Status codes para retry
    APP_REQUEST_MAX_RETRY_ATTEMPTS=3 # Máximo de retentativas
    APP_REQUEST_METHOD=POST # Método HTTP
    APP_REQUEST_SCHEMA=https # Esquema da requisição
    APP_REQUEST_BASE_URL=<apigee-base-url> # URL base da requisição
    APP_REQUEST_PATH=<apigee-path> # Caminho da requisição
    APP_RABBITMQ_QUEUE=<queue-name> # Fila RabbitMQ
    APP_RABBITMQ_ERROR_EXANGE=<error-exchange> # Exchange de erro
    APP_RABBITMQ_HEADER_EVENT=<event-name> # Header de evento
    APP_RABBITMQ_HEADER_APP_ID=rest.outbound.<value> # Header app-id
    APP_RABBITMQ_HEADER_LEVEL=Moderate # Nível de risco do erro
    ```

    **Variáveis de Ambiente (AWS)**
    ```
    SPRING_RABBITMQ_HOST=<rabbitmq-host> # Endereços do RabbitMQ
    SPRING_RABBITMQ_PORT=5671 # Porta do RabbitMQ
    RABBITMQ_USER=<rabbitmq-user> # Usuário RabbitMQ
    PABBITMQ_PASSWORD=<rabbitmq-password> # Senha RabbitMQ
    SPRING_RABBITMQ_SSL_ENABLED=true # Habilita SSL
    ```

    **Variáveis de Ambiente (OCI)**
    ```
    SPRING_RABBITMQ_HOST=https://rabbitmq.dev.k8s.eventbus.vcp.oci.cloud.claro # Host do RabbitMQ
    SPRING_RABBITMQ_PORT=5671 # Porta do RabbitMQ
    RABBITMQ_USER=<rabbitmq-user> # Usuário RabbitMQ
    RABBITMQ_PASSWORD=<rabbitmq-password> # Senha RabbitMQ
    SPRING_RABBITMQ_SSL_ENABLED=true # Habilita SSL
    SPRING_RABBITMQ_SSL_KEY_STORE=<path> # Local do keystore SSL
    SPRING_RABBITMQ_SSL_KEY_STORE_PASSWORD=<password> # Senha do keystore SSL
    SPRING_RABBITMQ_SSL_TRUST_STORE=<path> # Local do truststore SSL
    SPRING_RABBITMQ_SSL_TRUST_STORE_PASSWORD=<password> # Senha do truststore SSL
    ```

5. Inicie o serviço localmente:
   ```bash
   mvn spring-boot:run
   ```

## Como Usar
O serviço não expõe endpoints REST, funcionando como um worker que consome mensagens RabbitMQ e realiza chamadas REST ao Apigee. Consulte a documentação interna para detalhes sobre filas e configurações do Apigee.

## Executando Testes
Os testes unitários podem ser executados com o comando padrão do Maven:
```bash
mvn test
```

Certifique-se de que as dependências de teste (JUnit, Mockito, Spring Rabbit Test) estão instaladas. Para testes de integração, configure um ambiente RabbitMQ local ou use `spring-rabbit-test`.

## Deploy
1. Crie a imagem Docker:
   ```bash
   make build
   ```

2. Envie a imagem para o repositório:
   ```bash
   make push
   ```

3. Deploy em Kubernetes:
   - Configure os arquivos de manifesto em `k8s/deployment.yaml`.
   - Aplique o deploy:
     ```bash
     kubectl apply -f 
     ```

## Monitoramento e Logs
- **Logs**: Utiliza Logback com Logstash para logs estruturados, enviados para [ex.: CloudWatch ou ELK, confirmar com a equipe].
- **Métricas**: Expostas via Prometheus (`/actuator/prometheus`). Configure um scraper Prometheus para monitoramento.
