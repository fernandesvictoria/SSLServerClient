# SSLServerClient

Este repositório contém uma implementação de um servidor e cliente SSL/TLS em Java, que utiliza certificados gerados via shell script para garantir uma comunicação segura. O projeto foi desenvolvido como parte de uma atividade acadêmica, focando em boas práticas de segurança na comunicação de dados.

## Descrição do Projeto

O projeto visa estabelecer uma conexão segura entre um cliente e um servidor, utilizando a tecnologia SSL/TLS. O servidor é responsável por aceitar conexões de clientes, enquanto o cliente se conecta ao servidor e troca mensagens de forma criptografada. A comunicação é protegida por um certificado digital, que é validado pelo cliente para garantir a autenticidade do servidor.

### Funcionalidades

- **Comunicação Segura**: Utiliza SSL/TLS para garantir que todas as mensagens trocadas entre o cliente e o servidor sejam criptografadas.
- **Validação de Certificados**: O cliente verifica o certificado do servidor para garantir que está se conectando ao servidor legítimo.
- **Shell Script para Geração de Certificados**: Um script em shell é fornecido para gerar os certificados necessários para a comunicação segura.
- **Tratamento de Erros**: O código implementa tratamento de exceções para garantir que os erros sejam gerenciados de maneira adequada.

### Estrutura do Projeto

- `certificado.sh`: Script em shell responsável pela geração dos certificados digitais.
- `SecureServer.java`: Implementação do servidor SSL/TLS que aceita conexões e gerencia a comunicação com os clientes.
- `SecureClient.java`: Implementação do cliente SSL/TLS que se conecta ao servidor e troca mensagens criptografadas.
- `server.keystore`: Armazena o certificado digital e a chave privada do servidor (gerado pelo script).
