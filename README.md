# Projeto: Pipeline Declarativo Fail-Fast (API + UI)

Este repositório contém a estruturação de um pipeline de CI/CD desenvolvido para a atividade de DevOps. O objetivo principal é demonstrar a aplicação da filosofia **Fail-Fast**, onde falhas de qualidade e lógica são identificadas e interrompidas o mais cedo possível, economizando tempo e recursos computacionais.

## 🚀 Estrutura do Jenkinsfile

O arquivo `Jenkinsfile` utiliza a sintaxe **Declarativa** e está organizado nos seguintes estágios:

1.  **Checkout & Sanity Check**: Realiza o download do código e valida as versões das ferramentas (Node, Docker) no ambiente de execução.
2.  **Qualidade e Testes Unitários (Fail-Fast)**: Utiliza o bloco `parallel` para executar simultaneamente:
    * **UI**: Linting e Testes Unitários do Frontend.
    * **API**: Validações estáticas e lógicas do Backend.
3.  **Testes de Integração**: Valida a comunicação entre as camadas antes da fase de construção.
4.  **Build de Artefatos**: Gera as imagens Docker finais utilizando o `${BUILD_NUMBER}` para garantir o versionamento e rastreabilidade (essencial para Rollbacks).

## 🛠️ Tecnologias Utilizadas
* **Jenkins**: Orquestração do pipeline.
* **Docker**: Conteinerização e Build.
* **Git/GitHub**: Controle de versão e SCM.

## 📊 Evidência de Execução (Stage View)
Abaixo, a visualização dos estágios executados com sucesso no Jenkins:

![Pipeline Overview](pipeline-overview.png)

## 📎 Post-Actions
O pipeline está configurado para fornecer feedback imediato:
- **Success**: Notifica a conclusão bem-sucedida de todas as verificações rigorosas.
- **Failure**: Alerta sobre interrupções precoces no fluxo de qualidade.
- **Always**: Garante o fechamento de logs e processamento de resultados.

---
**Estudante:** Augusto Jorge Brandão Mendonça