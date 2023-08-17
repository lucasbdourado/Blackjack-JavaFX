# Baralho Java

**Author:** Lucas Barbosa Dourado - @lucasbdourado

Jogo de baralho desenvolvido em Java. Blackjack é um simples jogo de cartas onde o objetivo é alcançar um total de 21 pontos ou o mais próximo disso, sem ultrapassar esse valor. O jogo é jogado contra um dealer (CPU desenvolvida em código baseada em condições), que também está tentando chegar o mais próximo possível de 21 pontos.

## Estrutura do Código
O código-fonte do jogo está organizado da seguinte forma:

**Application.java:** Contém a função main que inicia o jogo.
**Deck.java:** Implementa a lógica das cartas, embaralhamento, Getter e Setter do Baralho.
**Card.java:** Define a estrutura de dados para uma carta individual.
**Player.java:** Define a estrutura de dados e as ações de um jogador.
**Dealer.java:** Estende a classe Player e implementa a lógica do dealer baseada em condições.
**Game.java:** Gerencia os dados do jogo, incluindo a lista de jogadores, desenvolvida no padrão de projeto Singleton garantindo assim somente uma instância durante a execução do código.

## Customizações futuras
- Desenvolver uma interface gráfica para tornar a experiência mais envolvente com JavaFX.
- Funcionalidades adicionais, como divisão de cartas, apostas, contagem de cartas, etc.
- Melhorar a estratégia do dealer aumentando condições e tomadas de decições baseado em probabilidades.
- Criar e hospedar preview do projeto.

Aviso: Este é um projeto de aprendizado e entretenimento, não é destinado ao uso comercial ou de cassino real.
