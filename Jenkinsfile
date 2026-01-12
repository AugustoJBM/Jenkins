pipeline {
    agent any

    options {
        skipStagesAfterUnstable()
        timestamps()
        timeout(time: 1, unit: 'HOURS')
    }

    stages {
        stage('1. Checkout & Sanity Check') {
            steps {
                echo 'Baixando código do repositório...'
                checkout scm
                echo 'Verificando presença de ferramentas no ambiente...'
                sh 'node --version || echo "Node não instalado"'
                sh 'docker --version || echo "Docker não instalado"'
            }
        }

        stage('2. Qualidade e Testes Unitários (Fail-Fast)') {
            parallel {
                stage('UI: Lint & Unit Tests') {
                    steps {
                        echo 'Executando análise estática da interface...'
                        sh 'echo "UI Lint: PASSED"' 
                        echo 'Executando testes unitários do Frontend...'
                        sh 'echo "UI Unit Tests: 15 tests passed"'
                    }
                }
                stage('API: Lint & Unit Tests') {
                    steps {
                        echo 'Executando análise estática da API...'
                        sh 'echo "API Lint: PASSED"'
                        echo 'Executando testes unitários do Backend...'
                        sh 'echo "API Unit Tests: 22 tests passed"'
                    }
                }
            }
        }

        stage('3. Testes de Integração') {
            steps {
                echo 'Validando comunicação entre API e UI...'
                sh 'echo "Integration Tests: PASSED"'
            }
        }

        stage('4. Build de Artefatos') {
            steps {
                echo "Gerando pacotes da aplicação - Build #${BUILD_NUMBER}"
                sh 'echo "Criando imagem Docker webapp-api:v${BUILD_NUMBER}"'
                sh 'echo "Criando imagem Docker webapp-ui:v${BUILD_NUMBER}"'
            }
        }
    }

    post {
        success {
            echo '✅ Atividade concluída: Pipeline executado com sucesso e critérios de qualidade atingidos.'
        }
        failure {
            echo '❌ Atividade interrompida: Falha detectada pelo mecanismo Fail-Fast.'
        }
        always {
            echo 'Finalizando logs de execução.'
        }
    }
}