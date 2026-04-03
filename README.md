# 🏧 FIAP Bank ATM — Sistema de Caixa Eletrônico

> Checkpoint 1 — Disciplina: Domain-Driven Design com Java  
> Curso: Engenharia de Software — FIAP

---

## 📋 Descrição

Simulação de um terminal de autoatendimento (ATM) bancário desenvolvido em Java puro, rodando inteiramente via console e em memória. O sistema cobre o fluxo completo de um cliente: desde o cadastro de nome e senha até as operações bancárias de consulta de saldo, depósito e saque.

---

## ⚙️ Funcionalidades

### Fase A — Cadastro e Autenticação
- Solicita o **nome completo** do cliente (com remoção de espaços extras via `.trim()`)
- Exibe mensagem de boas-vindas usando o **primeiro nome**
- Realiza **cadastro de senha forte**, validando os seguintes critérios:
  - Mínimo de 8 caracteres
  - Ao menos um número
  - Ao menos uma letra maiúscula
  - Ao menos um caractere especial (`!@#$%^&*()-_+=?><`)
- Solicita **autenticação** com limite de **3 tentativas**
- Exibe `*ACESSO BLOQUEADO*` e encerra o sistema em caso de falha

### Fase B — Menu Principal
- Exibe um menu em loop com as opções:
  - `[1]` Consultar Saldo
  - `[2]` Fazer Depósito
  - `[3]` Fazer Saque
  - `[4]` Sair
- Trata entradas inválidas sem quebrar o fluxo do programa

### Fase C — Operações Bancárias
- **Saldo inicial:** R$ 0,00
- **Consultar Saldo:** exibe o valor formatado com duas casas decimais
- **Depósito:** valida que o valor seja maior que zero
- **Saque:** valida valor positivo e saldo suficiente
- **Sair:** exibe mensagem de agradecimento e encerra

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal / CMD / PowerShell

### Compilar
```bash
javac FiapBankAtm.java
```

### Executar
```bash
java FiapBankAtm
```

---

## 🖥️ Exemplo de Uso

```
============================================
   Bem-vindo ao FIAP Bank ATM - Alpha v1.0  
============================================
Por favor, informe seu Nome Completo: João Silva
Olá, João! Seja bem-vindo(a) ao FIAP Bank.

--- Cadastro de Senha ---
Crie sua senha: Fiap@2024
Senha cadastrada com sucesso!

--- Autenticação ---
Digite sua senha: Fiap@2024
Acesso liberado! Bem-vindo(a), João.

============================================
              MENU PRINCIPAL                
============================================
  [ 1 ] Consultar Saldo
  [ 2 ] Fazer Depósito
  [ 3 ] Fazer Saque
  [ 4 ] Sair
============================================
```

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Java (JDK 8+) | Linguagem principal |
| `Scanner` | Leitura de entradas do usuário |
| `String.matches()` + Regex | Validação de senha forte |
| `String.equals()` | Comparação segura de Strings |
| `double` | Armazenamento do saldo financeiro |

---

## 📐 Restrições Técnicas Aplicadas

- ✅ Uso obrigatório da classe `Scanner` para entrada de dados
- ✅ Strings comparadas com `.equals()` — nunca com `==`
- ✅ Tipo primitivo `double` utilizado para o saldo (não `String`)
- ✅ Nomes de variáveis descritivos (`valorSaque`, `senhaCadastrada`, `primeiroNome`)
- ✅ Código indentado e estruturado (Clean Code)

---

## 📁 Estrutura do Projeto

```
fiap-ddd-java-checkpoint1-atm/
│
└── src/
    └── FiapBankAtm.java
```

---

## 👨‍💻 Autor

Desenvolvido como parte do Checkpoint 1 da disciplina de **Domain-Driven Design com Java** — FIAP.
