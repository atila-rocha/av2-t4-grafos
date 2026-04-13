# av2-t4-grafos

## Contexto do repositório

## Como rodar

### Usando InteliJ
1. Clone o repositório usando o comando `git clone`
2. Abra a sua IDE de preferência (No caso recomendamos o IntelliJ)
3. Abra o arquivo `Main.java`, localizado no diretório ´src´
4. Aperte o botão "Run" ou use o atalho `Ctrl + F5`

### Usando o terminal
1. Clone o repositório usando o comando `git clone`
2. Abra o teminal e acesse o diretório do repositório
3. Use o comando `cd` para acessar o diretório `src`
4. No diretório `src`, use o seguinte comando para compilar:
    1. `javac Main.java`
5. Em seguida, ainda no diretório `src`, execute o seguinte comando para rodar:
    1. `java Main`

## Perguntas Frequentes (FAQ)/Troubleshooting

> Estou tendo problemas para rodar o IntelliJ

- Verifique se você está usando o JDK 25 (25.0.1)
    - No IntellJ, clique no botão menu (4 linhas na horizontal empilhadas uma em cima da outra) no canto superior esquerdo
    - Após isso clique em `File`
    - Em seguida clique em `Project Structure`
    - Ao clicar, vai abrir uma janela, depois clique em `project`, no canto esquerdo da janela
    - Altere o JDK para o JDK requisitado
    - Teste rodar
- Veja se a IDE (IntelliJ) está reconhecendo o source
    - No IntellJ, clique no botão menu (4 linhas na horizontal empilhadas uma em cima da outra) no canto superior esquerdo
        - Após isso clique em `File`
        - Em seguida clique em `Project Structure`
        - Ao clicar, vai abrir uma janela, depois clique em `Modules`, no canto esquerdo da janela
        - Após isso, no centro da janela haverá os diretórios do projeto, selecione a pasta `src`
        - Em cima desses diretórios tem uns um texto chamado `Mark as`, depois de localizar, selecione `Sources`, ao lado de "Mark as"
        - Teste rodar

### Soluções genéricas
1. Rebuild seu preojeto
2. Pressione `Ctrl + Alt + Y` para fazer o Reload de tudo do Disk
3. Use o botão `Repair IDE`, localizado no menu File, no menu principal

> - No IntellJ, clique no botão menu (4 linhas na horizontal empilhadas uma em cima da outra) no canto superior esquerdo
    - Após isso clique em `File` e selecione `Repair IDE`