# LikeMovie

Explore o emocionante universo cinematográfico de forma simples e personalizada com o nosso aplicativo! Desfrute dos filmes mais populares da atualidade com base na poderosa API The Movie Database, garantindo uma seleção atualizada e envolvente. Além disso, torne a experiência ainda mais única marcando seus filmes favoritos e mantendo-os sempre à mão. Com a capacidade de salvar suas escolhas localmente, você pode criar sua própria lista de filmes personalizada. Deixe-se envolver pelo mundo do cinema com facilidade e praticidade, tornando cada sessão de filme uma experiência inesquecível.


# Aplicativo

O propósito inicial deste aplicativo era realizar a integração com uma API contendo informações sobre filmes e apresentá-los em uma lista. Posteriormente, a abrangência do projeto foi expandida, visando a capacidade de armazenar localmente os filmes favoritos do usuário, além de implementar um sistema de login para associar o perfil do usuário aos filmes salvos.

A seguir, serão destacados os progressos já realizados no desenvolvimento do aplicativo, as tarefas pendentes e as funcionalidades planejadas para o futuro.

## Desenvolvido

* Listagem dos filmes populares.
* Paginação dos filmes populares.
* Salvar, listar e remover filmes favoritos.


https://github.com/pierresousa/LikeMovie/assets/45207673/dd6468ad-3967-4b03-a9d0-76b4d9658785

https://github.com/pierresousa/LikeMovie/assets/45207673/57bde2ee-39fc-4062-a9dc-dd610290c6d1


Para isso, foram utilizadas as seguintes tecnologias:

### API TMDB
> API The Movie Database (https://developer.themoviedb.org/reference/intro/getting-started).

### Retrofit
> Dependência para consumir API.

### Moshi
> Conversor JSON para utilizar no consumo da API.

### Coil
> Dependência para o carregamento de imagens da internet.

### Coroutines
> Dependência que simplifica execução assíncrona.

### Paging3
> Dependência para realizar a paginação dos dados.

### Room
> Dependência para salvar dados localmente.

## Não desenvolvido

* Cadastro e login de usuário.
* Paginação dos filmes favoritos.
* Mostrar todas as informações sobre o filme.
* Teste unitário.

## Desenvolvimento futuro

* Tratar as exceções.
* Injeção de dependências com o Hilt.
* Cadastro e login com Google.
* Armazenar filmes favoritos online.
* Animar o "botão" de salvar/remover.
* Dar informações sobre erro e sucesso ao usuário (pode ser usando Toast).
