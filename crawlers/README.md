# Desafio 2: Crawlers

[Descrição aqui](https://github.com/idwall/desafios/tree/master/crawlers)

O desenvolvimento da solução para o desafio proposto foi muito bom para adquirir conhecimento sobre as bibliotecas JSoup e a API do Telegram, onde apenas possuia conhecimento de leitura e nunca implementado, e para adquirir experiencia. Até o momento só foi enviado a solução da primeira parte devido ao tempo que foi disponibilizado. A integração com o Telegram esta sendo desenvolvida e sera postada em breve junto com melhorias de saida.

## Instruções

Após clonar o repositorio, acesse a pasta do desafio 

> pasta_projeto_clonado/crawlers/      :file_folder:

Execute a aplicação pelo terminal com o comando:   

> java -jar desafio-crawlers-reddit.jar | (String args[])

A aplicação espera receber uma string contendo nome de subreddits separados por ponto e virgula ";" e uma pontuação minima que as threads dessas subreddits devem possuir para serem localizadas como parametros. 

> Exemplo: java -jar desafio-crawlers-reddit.jar "brazil;dog;cat;worldnews" 5000

Se não existir parametros, será utilizado o default da aplicação que irá procurar as threads top do dia com upvotes acima de 5000 nas subreddits "dog;cat;funny;worldnews".

## Autor

**Lucas Lacerda** - [Linkedin](https://www.linkedin.com/in/lucaaslb/) :boy:



