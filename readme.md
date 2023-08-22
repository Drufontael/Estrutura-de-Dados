# Estrutura de Dados
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
Inicialmente comecei pelas estruturas estáticas, ou lista baseadas em vetores(arrays), onde o seu tamanho é fixo até chegarmos
ao limite, e aí realocamos mais memória. Essa foi a base para as estruturas mais simples:
- ListaVetor: nossa versão do ArrayList, com a maioria de seus métodos, nela podemos acessar seus elementos diretamente
por um indice, inserir elementos e remover também de qualquer posição.
- Pilha: estrutura que obedece o príncipio LiFo( last in, first out) ou último a entrar e primeiro a sair. Poderiamos
exemplificar como uma pilha de pratos, onde podemos acessar apenas àquele que está no topo.
- Fila: o inverso da pilha, este usa o sistema FiFo( first in, first out), primeiro a entrar, primeiro a sair, ou seja um
conceito que estamos bem habituados no nosso dia a dia, como filas de banco, de caixas de mercados, etc. Nele você está na 
posição do caixa, então você tem acesso ao próximo, ou primeiro da fila.
- Fila com Prioridade: segue o conceito da fila, sendo que nesse caso existe uma forma organizada de enfileirar, onde nem 
sempre o elemento enfileirado vai para o fim da fila, fazendo valer seu nível de prioridade em relação aos outros elementos 
da fila. Compare com prioridades de embarque em aviões ou caixas de banco.

### Estruturas Dinâmicas
Ou estruturas de elementos linkados, um conceito totalmente novo para mim, onde, diferente das estruturas estáticas, o conjunto
de elementos não possui um tamanho fixo, e também não se tem acesso diretamente a eles, sendo que um da referência ao outro, sendo 
portanto necessário percorrer seus itens. A vantagem desse tipo de estrutura é que ele aloca apenas o espaço necessário para seus
elementos.
