<div align="center">

# 📚 **Livraria**

[![Java](https://img.shields.io/badge/Java-24%2B-blue?logo=java&logoColor=white)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](./LICENSE)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)]()
[![Contribuições](https://img.shields.io/badge/Contribuições-Bem--vindas-blueviolet)]()

💡 *Sistema de gerenciamento de clientes e operações básicas de uma livraria, desenvolvido em Java, com foco em boas práticas de POO e tratamento de exceções personalizadas.*

---

</div>

## 📖 Sumário
- [Descrição](#descrição)
- [Motivação](#motivação)
- [Funcionalidades](#funcionalidades)
- [Arquitetura e Estrutura](#arquitetura-e-estrutura)
- [Diagrama UML Simplificado](#diagrama-uml-simplificado)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação e Execução](#instalação-e-execução)
- [Exemplo de Uso](#exemplo-de-uso)
- [Tratamento de Exceções](#tratamento-de-exceções)
- [Contribuindo](#contribuindo)
- [Licença](#licença)
- [Autor](#autor)

---

## 🧩 Descrição

O projeto **Livraria** é uma aplicação desenvolvida em **Java** que simula o gerenciamento de **clientes** em uma livraria.  
Inclui operações básicas de CRUD (Create, Read, Update, Delete), **validação de duplicidades**, e **tratamento de exceções personalizadas**.  
A estrutura modular facilita a expansão do projeto, permitindo o acréscimo futuro de módulos de estoque, vendas ou pagamentos.

---

## 💡 Motivação

Este projeto foi criado com o objetivo de **praticar conceitos de Programação Orientada a Objetos (POO)**, incluindo:
- Organização por camadas (modelo, serviço, repositório e exceções);
- Encapsulamento, abstração e responsabilidade única;
- Criação e uso de exceções personalizadas para erros de domínio;
- Estrutura de código limpa e extensível.

---

## ⚙️ Funcionalidades

| Função | Descrição |
|--------|------------|
| ➕ **Cadastrar cliente** | Adiciona um novo cliente no sistema |
| 🔍 **Buscar cliente** | Pesquisa cliente pelo identificador |
| ✏️ **Atualizar cliente** | Modifica informações de clientes existentes |
| ❌ **Remover cliente** | Exclui cliente do sistema |
| ⚠️ **Validação de duplicidade** | Impede cadastro duplicado de clientes |
| 🧱 **Tratamento de exceções** | Garante integridade e controle de erros |

---

## 🏗️ Arquitetura e Estrutura

O projeto segue uma arquitetura modular simples e bem organizada:

Livraria/
├── exception/
│ ├── DadoDuplicadoException.java
│ └── EntidadeNaoEncontradaException.java
│
├── repository/
│ └── UsuarioRepositorio.java
│
├── service/
│ └── ClienteCadastroService.java
│
├── model/
│ └── Cliente.java
│
└── Livraria.java # Classe principal (ponto de entrada)


---
## 🧠 Exemplo de Uso

ClienteCadastroService service = new ClienteCadastroService();

// Cadastrar novo cliente
service.cadastrar(new Cliente(1, "João Silva", "joao@email.com"));

// Buscar cliente
Cliente c = service.buscarPorId(1);
System.out.println("Cliente encontrado: " + c.getNome());

// Atualizar cliente
service.atualizar(1, new Cliente(1, "João S. Oliveira", "joao.oliveira@email.com"));

// Remover cliente
service.remover(1);

---

| Exceção                          | Descrição                                                  |
| -------------------------------- | ---------------------------------------------------------- |
| `DadoDuplicadoException`         | Lançada ao tentar cadastrar um cliente já existente        |
| `EntidadeNaoEncontradaException` | Lançada ao tentar buscar ou remover um cliente inexistente |

---

## 🧬 Diagrama UML Simplificado

```mermaid
classDiagram
    class Cliente {
        - int id
        - String nome
        - String email
        + getId()
        + getNome()
        + getEmail()
    }

    class ClienteCadastroService {
        - UsuarioRepositorio repositorio
        + cadastrar(Cliente c)
        + buscarPorId(int id)
        + atualizar(int id, Cliente c)
        + remover(int id)
    }

    class UsuarioRepositorio {
        + salvar(Cliente c)
        + buscar(int id)
        + remover(int id)
    }

    class DadoDuplicadoException
    class EntidadeNaoEncontradaException

    ClienteCadastroService --> UsuarioRepositorio
    ClienteCadastroService --> Cliente
    ClienteCadastroService --> DadoDuplicadoException
    ClienteCadastroService --> EntidadeNaoEncontradaException
