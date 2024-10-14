#!/bin/bash

# Função para verificar se a entrada está vazia
validate_input() {
  if [[ -z "$1" ]]; then
    echo "Erro: $2 não pode estar vazio."
    exit 1
  fi
}

# Solicita ao usuário as informações necessárias
read -rp "Digite o nome do domínio ou IP para o certificado: " domain
validate_input "$domain" "Domínio/IP"

read -rp "Digite o nome da organização: " organization
validate_input "$organization" "Nome da organização"

read -rp "Digite a cidade: " city
validate_input "$city" "Cidade"

read -rp "Digite o estado: " state
validate_input "$state" "Estado"

read -rp "Digite o país (código de dois dígitos, ex: BR): " country
if ! [[ "$country" =~ ^[A-Z]{2}$ ]]; then
  echo "Erro: Código de país inválido."
  exit 1
fi

# Variáveis de ambiente (boas práticas: use "local" para limitar o escopo)
CERT_DAYS=365
KEY_SIZE=2048
CERT_KEY="server.key"
CERT_CRT="server.crt"

# Gera a chave privada e o certificado autoassinado (modo interativo)
openssl req -x509 -nodes -days "$CERT_DAYS" -newkey rsa:"$KEY_SIZE" \
  -keyout "$CERT_KEY" -out "$CERT_CRT"

# Verifica se o certificado foi gerado com sucesso
if [[ -f "$CERT_CRT" && -f "$CERT_KEY" ]]; then
  echo "Certificado gerado com sucesso: $CERT_CRT"
  echo "Chave privada gerada: $CERT_KEY"
else
  echo "Erro ao gerar o certificado ou a chave privada."
  exit 1
fi

# Definindo permissões mínimas para os arquivos
chmod 600 "$CERT_KEY"
chmod 644 "$CERT_CRT"

echo "Permissões ajustadas: chave privada com permissão 600, certificado com permissão 644."
