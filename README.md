# gameRandomInt
Jogo em que o usuário deve adivinhar o número escolhido aleatoriamente pelo computador.
Este jogo foi desenvolvido em sala de aula da disciplina Linguagem de Programação 2. É um jogo simples e tem o foco na serialização de arquivos. Contém alguns pontos a serem desenvolvidos pelos alunos, como tratamentos de excessões e melhora das mensagens.
<h2>Classes principais</h2>
Como o foco da aula é a criação, leitura e escrita de arquivos, foi criada a classe IOManager como gerenciador dos métodos de entrada e saída
As classes criadas são:
<h3>IOManager</h3>
Possui os seguintes métodos estáticos
<ul>
<li>readKey - recebe como parâmetro uma string a ser apresentada antes da leitura e retorna a string lida</li>
<li>writeGamer - Escreve em um arquivo um objeto do tipo Gamer (serializável). Recebe como parâmetros o objeto e o arquivo</li>
<li>readGamer - Lê um objeto do tipo Gamer em um determindao arquivo. Recebe como parâmetro o arquivo e retorna o objeto lido</li>
</ul>

<h3>MainGame</h3>
Possui o loop do jogo:
<ol>
<li>Pergunta o nome do jogador</li>
<li>Cria seu objeto Gamer</li>
<li>Lê os dados salvos do jogador em seu arquivo txt. Caso não exista, cria o arquivo</li>
<li>Repete o loop:
  <ul>
    <li>Pergunta se o jogador quer jogar</li>
    <li>Gera um número aleatório</li>
    <li>Pergunta ao usuário qual o número</li>
    <li>Compara os valores e mostra a mensagem correspondente</li>
    <li>Atualiza pontuação</li>
  </ul>
</li>
<li>Ao final, pergunta se o usuário deseja salvar o jogo</li>
</ol>

<h3>Gamer</h3>
Representação do objeto jogador. Possui os atributos name, max_score, last_score, current_score. Importante notar que esta classe deve implementar a interface java.io.Serializable
