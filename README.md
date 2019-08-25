# Desafio Java EE

## Objetivo   
O objetivo desse desafio é que você mostre suas habilidades de codificação e o que você valoriza na engenharia de software. Acreditamos que um bom código é um código bem limpo e bem testado.   

Você poderá adicionar e estender a vontade os requisitos da aplicação. A aplicação deverá permitir um cadastro de usuários onde teremos as seguintes funcionalidades:   
1. Listar todos os usuários
2. Incluir um novo usuário
3. Alterar um usuário existente
4. Remover um usuário existente

## Tabela de usuários
| Coluna         | Tipo           | Obrigatório |
| :------------- | :------------- | :---------- |
| login          | String         | Sim         |
| nome           | String         | Sim         |
| email          | String         | Sim         |
| senha          | String         | Sim         |
| telefones      | List           | Ao menos 1  |

## Tabela de telefones do usuários
| Coluna         | Tipo           | Obrigatório |
| :------------- | :------------- | :---------- |
| tipo           | String         | Sim         |
| ddd            | Integer        | Sim         |
| numero         | String         | Sim         |

O tipo do telefone pode ser: 
* **R** para *residencial*
* **P** para *pessoal*
* **C** para *comercial*
* **T** para *contato*
* **O** para outro

### **IMPORTANTE:**
> * **Cada tabela deverá possuir um ID com auto incremento gerado automaticamente.**
> * **O campo login deverá ser único.**      
> * **A senha deve ser validada observando as seguintes regras:**   
>   possuir no mínimo 6 caracteres   
>   possuir ao menos **um** número e **uma** letra       

## Tela de Listagem

Ao entrar na tela:
* Devem ser listados o *ID*, *login*, *nome* e *email* do usuário ordenados pelo nome
* Para cada registro listado, deve haver um botão para **Atualizar** e outro para **Excluir** o registro
* Deve haver também um botão **Incluir** um novo usuário que irá acionar a tela de manutenção (inserção/edição)   

Ao alterar um registro:
* Abrir em uma janela modal ou nova janela a tela de *manutenção*

Ao excluir um registro:
* Apresentar um diálogo solicitando a confirmação para exclusão do registro   
* Apresentar a mensagem **"Usuário <nome do usuário> excluído com sucesso!"**   

## Tela de Manutenção (Inclusão/Alteração)

Ao entrar na tela para inclusão:
* Deixar o formulário vazio para a entrada de dados
* Já a tela que mantém os dados (inclui e altera o registro) pode ser desenvolvida em uma janela modal chamada a partir da tela de listagem ou em uma nova janela (saindo da tela de listagem).   

Ao entrar na tela para edição:
* Carregar os dados do usuário e popular os campos da tela.   

Ao salvar o registro:
* Validar se os campos obrigatórios foram preenchidos   
    Apresentar mensagem **indicando os campos obrigatórios**
* Validar se o usuário já existe cadastrado na base      
    Apresentar mensagem **"Usuário já cadastrado!"**
* Validar se ao menos um telefone foi informado   
    Apresentar mensagem: **"Informe ao menos um número de telefone"**
* Validar a senha informada confome a regra definida acima   
    Apresentar mensagem: **"Senha muito fraca! A senha deve possuir mais que 6 caracteres e ao menos 1 número e 1 letra"**

**Essa tela deverá ter um botão que permita voltar para a tela de listagem ou fechar o modal.**

## Requisitos Obrigatórios

* Estruturar a aplicação em camadas
* Uso de banco de dados relacional/SQL (preferencialmente HSQLDB ou H2)
* Processo de build utilizando Maven
* Persistência utilizando JPA ou JDBC
* Utilizar no mínimo Java 8
* Utilizar na interface JSF/[Primefaces](https://www.primefaces.org/showcase) que possui uma vasta [documentação](https://primefaces.github.io/primefaces/7_0/#/gettingstarted/dependencies) ou JSP com jQuery e Ajax
* Disponibilizar o código em repositório Git online (Gitlab ou Github) ou enviar o mesmo **zipado** por e-mail, GoogleDrive, OneDrive, DropBox ou outros

### **IMPORTANTE:**
> **Focar nos requisitos obrigatórios.**   
> *Tendo conseguido concluir os requisitos obrigatórios, caso haja tempo e conhecimento, pode-se implementar os requisitos abaixo.*   
> **Os requisitos desejáveis estão relacionados em ordem de relevância, do mais importante para o menos.**   

## Requisitos Desejáveis   

* Testes unitários com jUnit
* Uso de EJBs para controle transacional.
* Uso de servidor de aplicação Wildfly ou OpenLiberty.
* Disponibilizar a aplicação em serviço de hospedagem online (Heroku, AWS, Digital Ocean, etc).
* Disponibilizar a configuração do servidor de aplicação no repositório Git online junto com o código fonte.