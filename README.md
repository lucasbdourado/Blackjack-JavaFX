# Baralho Java

**Author:** Lucas Barbosa Dourado - @lucasbdourado

Jogo de baralho desenvolvido em Java. Blackjack é um simples jogo de cartas onde o objetivo é alcançar um total de 21 pontos ou o mais próximo disso, sem ultrapassar esse valor. O jogo é jogado contra um dealer (CPU desenvolvida em código baseada em condições), que também está tentando chegar o mais próximo possível de 21 pontos.

## Estrutura do Código

O código-fonte do jogo está organizado da seguinte forma:

+ **Application.java:** Contém a função main que inicia o jogo para V1 sendo utilizado para jogo executado no terminal de comando.
+ **BlackJack.java:** Contém a função main que inicia a interface Gráfica do Jogo V2, com JavaFX.
+ **GameController.java:** Contém o controle das funções e elementos graficos da Interface Gráfica em JavaFX.
+ **Deck.java:** Implementa a lógica das cartas, embaralhamento, Getter e Setter do Baralho.
+ **Card.java:** Define a estrutura de dados para uma carta individual.
+ **Player.java:** Define a estrutura de dados e as ações de um jogador.
+ **Dealer.java:** Estende a classe Player e implementa a lógica do dealer baseada em condições.
+ **Game.java:** Gerencia os dados do jogo, incluindo a lista de jogadores, itens de interface, e gerenciamento de turnos dos jogadores. Essa classe foi desenvolvida no padrão de projeto Singleton garantindo assim somente uma instância durante a execução do código.

## Customizações futuras
- [x] Desenvolver uma interface gráfica para tornar a experiência mais envolvente com JavaFX.
- [ ] Funcionalidades adicionais, como divisão de cartas, apostas, contagem de cartas, etc.
- [ ] Melhorar a estratégia do dealer aumentando condições e tomadas de decições baseado em probabilidades.
- [ ] Criar e hospedar preview do projeto.

Aviso: Este é um projeto de aprendizado e entretenimento, não é destinado ao uso comercial ou de cassino real.

## Preview do Projeto
<center><img src="https://github.com/lucasbdourado/Baralho-Java/assets/44330434/c72ef582-5ff3-4c40-9f04-4bbc9c00dd7b"></center>
