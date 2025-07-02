
# 📝 Teste Técnico - Prover Tecnologia

Este projeto é uma aplicação web desenvolvida como parte de um teste técnico solicitado pela **Prover Tecnologia**. O sistema realiza a análise de uma frase fornecida pelo usuário, retornando a quantidade de palavras distintas e a quantidade de ocorrências de cada palavra.

## ✅ Objetivo

Desenvolver um sistema web que:

- Permita a entrada de uma frase pelo usuário.
- Analise a frase informada.
- Retorne:
  - A quantidade de palavras distintas.
  - A quantidade de ocorrências de cada palavra.

## ⚙️ Requisitos Funcionais

### Interface Gráfica

- Campo para o usuário inserir uma frase.
- Botão para acionar a análise.
- Exibição do resultado com:
  - Número de palavras distintas.
  - Lista com a contagem de ocorrências de cada palavra.

### Backend

- Responsável por processar a frase enviada.
- O processamento deve ser síncrono, aceitando uma requisição por vez.

### Fluxo da Aplicação

1. O usuário digita uma frase.
2. Clica para analisar.
3. A frase é enviada ao backend.
4. O backend analisa e conta as palavras.
5. O resultado é devolvido à interface.
6. A interface exibe os dados ao usuário.

## 📌 Premissas

- Comunicação entre frontend e backend via **binding de componentes para beans (EL)**.
- Projeto construído com **Maven**.
- Compatível com o servidor **WildFly 10**
- Navegadores compatíveis: **Google Chrome** e **Microsoft Edge**.

## 💻 Tecnologias Utilizadas

| Camada       | Tecnologia                  |
|--------------|-----------------------------|
| Backend      | Java 8                      |
| View         | JSF 2.x                     |
| UI Components| PrimeFaces (ou RichFaces)   |
| Build Tool   | Maven                       |
| Servidor     | WildFly 10                  |

## 🚀 Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/adamis/ProjectExemplo.git
```

### 2. Importar o projeto na IDE

Importe como projeto Maven (`pom.xml` já incluso).

### 3. Construir o projeto

```bash
mvn clean install
```

### 4. Implantar no WildFly

- Copie o arquivo `.war` gerado para a pasta `standalone/deployments/` do WildFly 10 ou envia o arquivo via interface na porta 9990.

### 5. Acessar a aplicação

Abra o navegador e acesse:

```
http://localhost:8080/ProjectExemplo
```

## 📄 Exemplo de Uso

Entrada:
```
"A vida é bela e a vida é única"
```

Saída:
- Palavras distintas: **6**
- Ocorrências:
  - a: 2  
  - vida: 2  
  - é: 2  
  - bela: 1  
  - única: 1  

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
         └── br/com/adamis/exemplo
                └──IndexMB.java	 
     ├── resources/
     └── webapp/
          ├── index.xhtml
          └── WEB-INF/
               └── web.xml
```

## 🔗 Repositório

Disponível em: [https://github.com/adamis/ProjectExemplo](https://github.com/adamis/ProjectExemplo)

---

Desenvolvido por **Adamis Starling da Rocha**.
