# **FlowAPI – Desafio Técnico Itaú Unibanco**

API REST desenvolvida em **Java + Spring Boot** para resolver o desafio técnico do **Itaú Unibanco**.
A aplicação gerencia **transações financeiras** em memória e retorna **estatísticas** em tempo real, respeitando as regras e restrições propostas no desafio.

---

## **📋 Objetivo**

O sistema foi projetado para:

* Receber e validar transações financeiras
* Calcular estatísticas das transações dos últimos 60 segundos
* Permitir a limpeza de todas as transações registradas

---

## **🛠️ Requisitos Técnicos**

* **Java 21+**
* **Spring Boot 3+**
* Build com **Gradle**
* Armazenamento **apenas em memória**
* Comunicação via **JSON**
* Endpoints e campos **exatamente conforme especificado** no desafio

---

## **🚀 Funcionalidades da API**

### **1. Criar Transação** – `POST /transacao`

Recebe uma transação contendo:

* **valor**: decimal (≥ 0)
* **dataHora**: no formato ISO 8601, não podendo ser no futuro

**Regras de Aceite:**

* Valor e dataHora obrigatórios
* Valor não pode ser negativo
* Data não pode estar no futuro

**Respostas:**

* `201 Created` → Transação aceita
* `422 Unprocessable Entity` → Violação das regras
* `400 Bad Request` → JSON inválido

---

### **2. Limpar Transações** – `DELETE /transacao`

Remove todas as transações armazenadas em memória.

**Resposta:**

* `200 OK` → Todas as transações foram removidas

---

### **3. Estatísticas** – `GET /estatistica`

Retorna estatísticas das transações dos últimos 60 segundos:

```json
{
  "count": 0,
  "sum": 0,
  "avg": 0,
  "min": 0,
  "max": 0
}
```

* **count**: quantidade de transações
* **sum**: soma dos valores
* **avg**: média dos valores
* **min**: menor valor
* **max**: maior valor

Quando não houver transações no período, todos os valores retornam **0**.

---

## **📈 Boas Práticas Aplicadas**

* Separação de responsabilidades (**Controller**, **Service**, **DTOs**, **Exceptions**)
* Validação de entrada rigorosa
* Tratamento consistente de erros
* Cálculos otimizados para alto desempenho
* Código limpo e fácil de manter

---

## **👤 Autor**

**Raimundos Neto**
💻 Desenvolvedor Back-End | Java | Spring Boot

