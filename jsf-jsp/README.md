## JSF/JSP Developer   

O desafio possui uma arquitetura básica desenvolvida com uma pequena funcionalidade em JSF.   
Para os que desejarem utilizar JSP, é possível fazê-lo a partir da mesma arquitetura ou criando uma nova (observando os requisitos obrigatórios).  

Para rodar o projeto, basta executar o comando `mvn thorntail:run`   

> **IMPORTANTE:** caso, ao executar o comando acima, for apresentado um erro dizendo que a porta já está sendo usada, deveser localizar no Gerenciador de Tarefas o processo que esta usando essa porta (um processo Java) e finalizar esse processo. Isso acontece no Windows!   
Você pode matar o processo executando o seguinte comando no **Prompt de Comando** do *Windows*: `taskkill /F /FI "ImageName eq java.exe"`