# Estrutura de Dados


## A importância do conhecimento em estruturas de dados no desenvolvimento

No mundo do desenvolvimento de software, o conhecimento das estruturas de dados é crucial para criar soluções eficientes e escaláveis. Uma estrutura de dados é uma forma de organizar e armazenar os dados de forma a facilitar a manipulação e busca. Ao entender as diferentes estruturas de dados disponíveis e saber quando utilizá-las, os desenvolvedores podem melhorar a eficiência do código e reduzir a complexidade.

## Listas

Uma lista é uma estrutura de dados que armazena elementos sequencialmente. Os elementos podem ser de diferentes tipos e podem ser acessados por meio de um índice. A lista permite adicionar, remover e acessar elementos em qualquer posição. É uma estrutura de dados flexível e amplamente utilizada em programação.

## Conjuntos

Um conjunto é uma estrutura de dados que armazena elementos únicos, onde a ordem dos elementos geralmente não importa. Diferente das listas, conjuntos não aceitam elementos duplicados. Isso é útil para realizar operações matemáticas como união, interseção e diferença de conjuntos.

## Pilhas

Uma pilha é uma estrutura de dados baseada no princípio "último a entrar, primeiro a sair" (LIFO - Last In, First Out). Os elementos são adicionados e removidos apenas do topo da pilha. É semelhante a uma pilha de pratos, onde o último prato adicionado é o primeiro a ser retirado.

## Filas

Uma fila é uma estrutura de dados baseada no princípio "primeiro a entrar, primeiro a sair" (FIFO - First In, First Out). Os elementos são adicionados no final da fila e removidos do início da fila. É semelhante a uma fila de pessoas em uma loja, onde a primeira pessoa que entra é a primeira a ser atendida.

## Grafos

Um grafo é uma estrutura de dados que representa as relações entre os elementos. É composto por um conjunto de vértices (ou nós) e um conjunto de arestas (ou arcos) que conectam esses vértices. Grafos são utilizados para modelar uma variedade de problemas, como redes sociais, rotas em um mapa e circuitos elétricos.

## Árvores

Uma árvore é uma estrutura de dados hierárquica composta por nós. É semelhante a uma árvore real, onde os nós estão conectados por meio de arestas, formando uma estrutura em forma de árvore. As árvores são amplamente utilizadas em estruturas como árvores de busca binária, árvores de decisão e árvores de expressão matemática.

## Dicionários

Um dicionário é uma estrutura de dados que armazena pares de chave-valor. É ideal para armazenar e recuperar informações de forma rápida e eficiente. Os elementos em um dicionário são acessados por meio de suas chaves, fornecendo uma busca direta e eficiente.

O conhecimento dessas estruturas de dados é essencial para o desenvolvedor, pois permite escolher a estrutura mais adequada para cada problema e otimizar o desempenho dos algoritmos. Profundo entendimento das estruturas de dados traz inúmeros benefícios, como redução de tempo de execução, economia de recursos computacionais e melhor organização do código. Portanto, estudar e compreender as estruturas de dados é uma habilidade fundamental para todo desenvolvedor de software.




## Implementação em Java
Este repositório contem meus estudos de estruturas de dados e alguns algoritmos classicos. Inicialmente acompanhei o 
curso da [Loiane](https://github.com/loiane/loiane), depois fui pegando um pouco ali, um pouco aqui, garimpando a 
internet, até que achei os videos do [2guarinos](https://www.youtube.com/@2guarinos/about) e mudei minha metodologia que era 
acompanhar os videos implementando. Agora eu vejo o video para entender as estruturas e algoritmos e depois tento 
implentar por conta própria.

Minha intenção é criar o máximo de estruturas e algoritmos possíveis sem o uso do Collections e as interfaces List, Set 
e Map. Para isso eu vou tentar implementar o máximo das funcionalidades das bibliotecas acima citadas usando os conhecimentos 
adquiridos online.

Os nomes dos atributos e métodos estão todos em português justamente para facilitar o entendimento das funcionalidades das
estruturas e algoritmos.

### Estruturas Estáticas
Inicialmente comecei pelas [estruturas estáticas](src/estruturadados/lista/EstruturaEstatica.java), ou lista baseadas em vetores(arrays), onde o seu tamanho é fixo até chegarmos ao limite, e aí realocamos mais memória. Essa foi a base para as estruturas mais simples:
- [ListaVetor](src/estruturadados/lista/ListaVetor.java): nossa versão do ArrayList, com a maioria de seus métodos, nela podemos acessar seus elementos diretamente por um indice, inserir elementos e remover também de qualquer posição.
- [Pilha](src/estruturadados/pilha/Pilha.java): estrutura que obedece o príncipio LiFo( last in, first out) ou último a entrar e primeiro a sair. Poderiamos exemplificar como uma pilha de pratos, onde podemos acessar apenas àquele que está no topo.
- [Fila](src/estruturadados/fila/Fila.java): o inverso da pilha, este usa o sistema FiFo( first in, first out), primeiro a entrar, primeiro a sair, ou seja um conceito que estamos bem habituados no nosso dia a dia, como filas de banco, de caixas de mercados, etc. Nele você está na posição do caixa, então você tem acesso ao próximo, ou primeiro da fila.
- [Fila com Prioridade](src/estruturadados/fila/FilaComPrioridade.java): segue o conceito da fila, sendo que nesse caso existe uma forma organizada de enfileirar, onde nem sempre o elemento enfileirado vai para o fim da fila, fazendo valer seu nível de prioridade em relação aos outros elementos da fila. Compare com prioridades de embarque em aviões ou caixas de banco.

### Estruturas Dinâmicas
Ou estruturas de elementos linkados, um conceito totalmente novo para mim, onde, diferente das estruturas estáticas, o conjunto de elementos não possui um tamanho fixo, e também não se tem acesso diretamente a eles, onde um da referência ao outro, sendo portanto necessário percorrer seus itens. A vantagem desse tipo de estrutura é que ele aloca apenas o espaço necessário para seus elementos.
- [ListaEncadeada](src/estruturadados/lista/ListaEncadeada.java): a base das demais estruturas encadeadas, uma classe que possui apenas o primeiro nó, o último e seu tamanho, ficando cada elemento(nó) responsável por apontar o próximo.
- [PilhaEncadeada](src/estruturadados/pilha/PilhaEncadeada.java): usando a ListaEncadeada como super classe, apenas referenciei o topo da pilha como último nó e obtive assim um comportamento de pilha dinâmico.
- [FilaEncadeada](src/estruturadados/fila/FilaEncadeada.java): com o mesmo principio da pilha, só que ligando o próximo da fila ao primeiro nó da ListaEncadeada.
