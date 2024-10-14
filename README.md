SSLServerClient
Este repositório contém uma implementação de um servidor e cliente SSL/TLS em Java, que utiliza certificados gerados via shell script para garantir uma comunicação segura. O projeto foi desenvolvido como parte de uma atividade acadêmica, focando em boas práticas de segurança na comunicação de dados.

Descrição do Projeto
O projeto visa estabelecer uma conexão segura entre um cliente e um servidor, utilizando a tecnologia SSL/TLS. O servidor é responsável por aceitar conexões de clientes, enquanto o cliente se conecta ao servidor e troca mensagens de forma criptografada. A comunicação é protegida por um certificado digital, que é validado pelo cliente para garantir a autenticidade do servidor.

Funcionalidades
Comunicação Segura: Utiliza SSL/TLS para garantir que todas as mensagens trocadas entre o cliente e o servidor sejam criptografadas.
Validação de Certificados: O cliente verifica o certificado do servidor para garantir que está se conectando ao servidor legítimo.
Shell Script para Geração de Certificados: Um script em shell é fornecido para gerar os certificados necessários para a comunicação segura.
Tratamento de Erros: O código implementa tratamento de exceções para garantir que os erros sejam gerenciados de maneira adequada.
Estrutura do Projeto
certificado.sh: Script em shell responsável pela geração dos certificados digitais.
SecureServer.java: Implementação do servidor SSL/TLS que aceita conexões e gerencia a comunicação com os clientes.
SecureClient.java: Implementação do cliente SSL/TLS que se conecta ao servidor e troca mensagens criptografadas.
server.keystore: Armazena o certificado digital e a chave privada do servidor (gerado pelo script).
Como Executar o Projeto
Clone o Repositório:

bash
Copiar código
git clone https://github.com/fernandesvictoria/SSLServerClient.git
cd SSLServerClient
Execute o Script para Gerar Certificados:

bash
Copiar código
chmod +x certificado.sh
./certificado.sh
Compile o Código Java:

bash
Copiar código
javac SecureServer.java SecureClient.java
Inicie o Servidor: Em uma janela de terminal separada, execute:

bash
Copiar código
java SecureServer
Conecte o Cliente ao Servidor: Em outra janela de terminal, execute:

bash
Copiar código
java SecureClient
Ferramentas Utilizadas
Java 17
OpenSSL
Bash
Conclusão
Este projeto é um exemplo prático de como implementar comunicação segura em aplicações Java, utilizando SSL/TLS e boas práticas de segurança. Através deste trabalho, foi possível entender melhor a importância da segurança na troca de dados em redes, bem como as técnicas disponíveis para garantir essa segurança.

