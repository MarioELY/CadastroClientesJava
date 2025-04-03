# Cadastro de Clientes em Java

Este projeto foi desenvolvido como parte da Missão Prática – Nível 1 | Mundo 3 da disciplina **Iniciando o Caminho Pelo Java**, no curso de **Desenvolvimento Full Stack** pela Estácio (Campus Gilberto Gil).

## 🎯 Objetivo
Criar um sistema de cadastro de clientes (pessoa física e jurídica) em **modo texto**, utilizando os conceitos de Programação Orientada a Objetos, persistência de dados em arquivos binários e controle de exceções.

## 🧱 Tecnologias Utilizadas
- Java
- VS Code
- JDK 11+
- Serialização de Objetos

## 📦 Estrutura do Projeto
- `src/model`: Classes `Pessoa`, `PessoaFisica`, `PessoaJuridica` e repositórios.
- `src/main`: Classe principal com menu de interação via terminal.
- `bin`: Arquivos compilados após `javac`.

## 🚀 Funcionalidades
- Inserção, alteração e exclusão de clientes
- Exibição por ID e listagem completa
- Salvamento e recuperação em arquivos `.bin`
- Interface via terminal

## 📚 Como Executar
1. Compile os arquivos:
   ```bash
   javac -d bin src/model/*.java src/main/*.java
