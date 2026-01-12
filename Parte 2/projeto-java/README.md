# VS17-JediMastersCodigo
Repositório Projeto Final Java

# Etapa 1

## História e universo do jogo

Nos primórdios do mundo de Elements, todas as criaturas eram moldadas pela dança dos quatro elementos: Água, Fogo, Ar e Terra. Durante séculos, esses elementos coexistiram em equilíbrio, cada qual sustentado por espíritos-guardiões conhecidos como Monarcas Elementais.

Mas a harmonia foi quebrada quando uma quinta força nasceu espontaneamente do caos: Systerma. Invisível, imprevisível e faminto por energia, Systerma começou a corromper as criaturas do mundo, distorcendo sua essência elemental e ameaçando devorar tudo o que existe.

Para impedir o avanço dessa escuridão, os Monarcas Elementais criaram um artefato proibido: o Baralho do Destino, um conjunto de cartas imbuídas de fragmentos do futuro. Cada carta carrega um vislumbre de mudança — bênção ou desastre — capaz de virar o rumo de qualquer batalha. Porém, ninguém pode prever qual destino será sorteado.

Com Systerma crescendo, os Monarcas convocaram os maiores domadores de monstros do mundo para formar a Ordem dos Convergentes. Esses domadores controlam criaturas elementais em combate, canalizando poções místicas e usando a sorte das cartas para enfrentar monstros corrompidos e campeões rivais.

Cada batalha é uma tentativa de manter a balança de Elements equilibrada:

* Poções de Cura recuperam a força vital dos monstros.
* Poções de Dano drenam a essência elemental do inimigo.
* Poções de Sono invocam sonhos ancestrais, adormecendo o oponente e oferecendo ao domador um momento precioso de vantagem.

Com cada vitória, novas rotas se abrem no tabuleiro invisível do destino. Mas com cada derrota, Systerma devora um pouco mais da fronteira entre os elementos.

Agora, o seu papel é claro:
escolher seus monstros, dominar os elementos e desafiar Systerma — antes que o mundo de Elements se torne apenas silêncio.

## Guia do usuário

### I. O Menu Inicial
O jogador começa no menuView principal, com as seguintes opções:
1. Iniciar Partida: (Avança para a Fase de Montagem de Equipe.)
2. Ver Regras: (Exibe um resumo sobre os Elementos, Monstros e o Baralho do Destino.)
3. Sair: (Encerra o jogo.)

### II. Montagem de Equipe
Após escolher "Iniciar Partida", o jogador é solicitado que digite seu nome, e após isso é levado ao Inventário de Monstros.
O jogador deve escolher três (3) Monstros da sua coleção para formar sua equipe de batalha.
Aviso: Uma vez que os 3 Monstros são escolhidos, a equipe não pode ser alterada.
O primeiro Monstro escolhido será automaticamente o Monstro Ativo (aquele que inicia a luta).
Regra do Oponente: O sistema também montará uma equipe de 3 Monstros, escolhidos aleatoriamente.
Sera solicitado ao jogador que confirme suas escolhas.

### III. A Batalha e a Estrutura de Turnos
Além das fraquezas e resistências aos elementos e do caos das Cartas Mágicas, as batalhas em Elements são definidas pelas características intrínsecas dos Monstros, que vão além de seus ataques.
#### Passivas Elementais:
Cada Monstro não só pertence a um elemento, como também carrega uma Habilidade Passiva única ligada à sua natureza elemental. Essa passiva está sempre ativa enquanto o Etto estiver em campo.
O Convocador deve levar em consideração a Habilidade Passiva de seu Monstro Ativo, pois ela pode ser o fator decisivo para ganhar a batalha.
Essa camada de profundidade estratégica garante que o sucesso não dependa apenas do ataque mais forte, mas também de como as habilidades elementais do seu Monstro interagem com a sorte e o azar do campo de batalha.

### 1. Fase da Carta Mágica (Automática)
Sorteio: No início do turno de um jogador, uma carta é sorteada aleatoriamente do seu Baralho do Destino.
Efeito: O efeito da carta é imediatamente aplicado a todos os Monstros em campo do jogador, conforme a descrição da carta.
Exemplo: Se o jogador sorteia "Rajada da Sorte", o Monstro do jogador ganham 20% de bônus de dano para o turno.
Duração: Os efeitos de sorte e azar duram apenas o turno atual, a menos que a carta especifique uma duração de 2 ou mais turnos (como no caso de uma "Chuvarada" de cura).

### 2. Fase de Ação (Escolha do Jogador)
O jogador  deve escolher uma das seguintes ações para o seu Monstro Ativo:
1. Atacar: O Monstro Ativo executa seu ataque principal contra o Monstro Ativo do oponente.
Regra de Dano: O dano é calculado levando em conta a vantagem/desvantagem elemental e qualquer modificador da Carta Mágica ativa.
2. Atacar de olhos fechados: O Monstro Ativo executa seu ataque principal contra um Monstro qualquer do oponente.
Regra de Dano: O dano é calculado levando em conta a vantagem/desvantagem elemental e qualquer modificador da Carta Mágica ativa.
3. Regenerar: O Monstro Ativo tenta se curar.
Efeito: A vida regenerada é completamente aleatória, podendo ser qualquer valor entre 1 e 100.
4. Bolsa de poções: O jogador escolhe uma das 3 poções que lhe é concedida ao iniciar a partida.
Regra: No início da partida o jogador recebe três poções, e poderá utilizá-las ao decorrer dos turnos. O Jogador pode utilizar apenas uma vez cada poção!
5. Correr da luta: o jogador desiste da luta e foge dela!

### 3. Fim do Turno
Após a ação do jogador ser resolvida (ataque, ataque de olhos fechados, regeneração, bolsa de poções ou correr da luta), o turno passa para o oponente (sistema).
O oponente segue as mesmas regras: sorteia uma carta, recebe os efeitos e escolhe uma das 5 ações (ataque, ataque de olhos fechados, regeneração, bolsa de poções ou correr da luta).

### Condição de Vitória
A partida termina quando um jogador derrota os três (3) Monstros da equipe adversária.

# Etapa 2

### Mudanças:
- Adições de atributos e métodos nas classes GerenciamentoPartida, Jogador, Partida, Monstro e Poção
- Criação da classe ValidarEntrada
- Implementação dos métodos de GerenciamentoPartida:
  - iniciarPartida()
  - atacar(Monstro atacante)
  - atacar(Monstro atacante, Monstro defensor)
  - sortearCartas()
  - iniciarPartida()
  - iniciarTurno()
  
- Implementação dos métodos de Jogador:
  - setMonstroAtivo()
  - Jogador(String nome, Monstro monstro1, Monstro monstro2, Monstro monstro3)

- Implementação dos métodos de Inicializador:
  - criarMonstros()
  - criarBaralho()

- Implementação dos métodos de Monstro:
  - Monstro(int vida, String nome, int danoBase)

- Implementação dos métodos de Partida:
  - Partida(Jogador jogador1, Jogador jogador2)

- Implementação dos métodos de PocaoCura/PocaoDano/PocaoSono:
  - usarPocao(Jogador jogador)

- Implementação dos métodos de ValidarEntrada:
  - validarInt()
  - validarExistencia(int input, int sizeArray)

# Etapa 3
### Mapeamento de Arquivos:
- Criação da classe Menu
- Criação do Enum TipoMonstro
  
### Funcionalidades Implementadas:
  #### Atualizações:
  - Atualização da classe GerenciamentoPartida
    - Restruturação de código 
    - Implementação de novos métodos (Listados em **Mudanças**)
  - Atualização da classe Monstro
    - Adicionar enum TipoMonstro listar na criação o tipo que foi criado
  - Atualização da classe Main
    - Remoção do menuView para movê-lo para classe menuView
  #### Mudanças:
  - Implementação da atualização de novos métodos de GerenciamentoPartida:
    - regenerar()
    - usarPocao()
    - removerEfeitoPocao(int pocaoUsada)
      #### Implementação do CRUD:
        - criarMonstro() : Permite que o jogador crie um novo monstro
        - verMonstros() : Lista todos os monstros
        - atualizarMonstro() : Permite que o jogador edite um monstro existente
        - deletarMonstro() : Permite que o jogador apague um monstro 

### Instruções de Execução:
#### Executa a classe Main
##### Escolhe opções:
1. Iniciar nova partida - Começa uma partida
    - Solicita nome e escolha de monstros
    - Confirma escolha (Sim/Não)
    - Escolhe opções (Partida iniciada):
        - Atacar!
        - Atacar de olhos fechados!
        - Regenerar(+)
        - Bolsa de poções
        - Correr da luta
2. Ver regras
    - Lista Regras (Ainda será implementado)
3. Criar Monstro
    - Solicita nome, vida, dano e elemento do monstro
    - Cria o monstro
4. Editar Monstro
    - Lista todos os monstros
    - Solicita monstro a ser atualizado
    - Solicita nome, vida e dano do monstro
    - Edita monstro
5. Remover Monstro
    - Lista todos os monstros
    - Solicita monstro a ser deletado
    - Apaga monstro
6. Sair
    - Encerra o jogo

# Etapa 4
### Funcionalidades Implementadas:
#### Atualizações:
- Reorganização do projeto para seguir o padrão da arquitetura MVC.
- Resolução de bugs.
- Atualização da classe EntradaValidada
    - Criação do método validarRecorrenciaMonstro:
        - Impede que o mesmo monstro seja selecionado mais de uma vez.

#### Mudanças:
- Criação do ENUM TipoPrint:
    - Facilita a controle das mensagens exibidas pelo GerenciamentoPartida.
- Implementação da classe PrintsJogo, com os seguintes métodos:
    - PrintPartida(numMonstro: int, tipoPrint: TipoPrint): void
    - SortCarta(cartaSorteada: Carta): void
    - PrintInicioTurno(nome: String): void
    - PrintAtaque(atacante: Monstro, defensor: Monstro, tipoPrint: TipoPrint): void
    - NomeFuncao(tipoPrint: TipoPrint): void
    - EfeitoPorcao(tipoPrint: TipoPrint): void
    - ArquivoNaoEncontrado(): void

- Adição de trilha sonora:
    - Implementação da classe PlayMusic, com os seguintes métodos:
        - PlayMusic()
        - CarregarMusicaFundo(): void
        - TocarSom(location: String): void
        - SomInicioPartida(): void
        - PararSom(): void
        - SomFimPartida(): void
        - SomAtaque(): void
        - SomRegenerar(): void
        - SomUsarPocao(): void
        - SomSono(): void

- Adição de cores:
    - Criação da classe Cores, com as seguintes opções:
        - RESET (traz de volta a cor original)
        - RED
        - GREEN
        - YELLOW
        - BLUE
        - LIGHT_BLUE
        - PURPLE
        - LIGHT_PURPLE
        - CYAN
        - WHITE

- Inclusão de Tutorial no menuView inicial do jogo.