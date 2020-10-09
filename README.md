<h2>Questionário</h2>

<h3>Os modelos das questões 2 e 4 se encontram na pasta "models"</h3>

<h3>1. Qual exercício você considerou o mais difícil de ser resolvido e quais foram as dificuldades encontradas?</h3>
<p>O exercício 1. Teve momentos que me confundi pela quantidade de dados que estava lidando e tive certa dificuldade em determinar os valores e características de cada tipo de veículo.</p>

<h3>3. De que forma os atributos de classe foram usados no exercício 1, e porque essa seria uma boa escolha?</h3>
<p>A classe Veiculo contém todos os atributos enquanto os filhos não contém nenhum. É uma boa escolha pois os atributos são os mesmos para todo tipo de veículo (Mudando apenas o valor de cada um, mas assinaturas iguais).</p>

<h3>5. Qual foi a abordagem usada para inicializar o tabuleiro do exercício 2?</h3>
<ul>
<li>Primeiro gera um tabuleiro 10x10 de Tile (Qualquer coisa que possa estar em uma célula)</li>
	
<li>Os muros são adicionados a cada 2 fileiras, assim é impossível qualquer célula estar presa por muros. Para cada 2 fileiras são gerados 2 números aleatórios, correspondendo às 2 casas em que terão muros. Caso os números sejam iguais, significa que há apenas 1 muro na fileira</li>
	
<li>São colocados sempre 8 inimigos, sendo 2 de cada tipo. Cada um segue a fórmula hp+atk=60 e seus hps possuem um intervalo diferente de valores possíveis. Após serem instanciados, são colocados em um lugar aleatório do tabuleiro que esteja vazio</li>

<li>São instanciadas 4 poções (Pois é metade do número de inimigos) com cura de 1% a 80%, também são colocadas em lugares aleatórios vazios</li>

<li>Por fim, o player é instanciado em uma outra posição aleatória vazia</li>
</ul>

<h3>6. Como a dificuldade do jogo pode ser controlada e como garantir que o jogador seja capaz de vencer no jogo?</h3>
<p>A dificuldade pode ser aumentada: Aumentando o limite dos inimigos (HP + ATK = 60), aumentando o número de inimigos.</p>
<p>A dificuldade pode ser diminuída: Aumentando o número de poções, aumentando sua cura, aumentando o limite do jogador (HP + ATK = 100), mostrando o mapa.</p>
<p>Para garantir que seja capaz de vencer é preciso um equilíbrio entre esses parâmetros. Também é possível encontrar umas fórmulas, como comparar a vida do jogador com o ataque de cada monstro e estimar a quantidade de vida perdida por combate.</p>