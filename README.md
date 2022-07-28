# POO
 Repositório destinado aos projetos que eu julgo interessantes desenvolvidos na disciplina de Programação Orientada a Objetos e na disciplina de Laboratório de Programação.
 
 |   Nome Projeto  |  Linguagem + IDE  |    Descrição   |
| :---         |     :---:      |          ---: |
| Ex2   | Java + Eclipse     | Projeto que implementa o controle de uma fila, temos uma fila normal e uma fila preferencial, o atendimento é intercalado entre as filas.     |
| Ex4    | Java + Eclipse      | Projeto que possibilita o controle de contas bancárias de um banco(imaginário), tem uso de interfaces e possibilita o usuário de cadastrar contas, sacar e depositar de contas existentes, etc.      |
| Ex5   | Java + Eclipse    | Projeto que estende o projeto Ex4, porém não utiliza interface e sim classe abstrata, para não utilizar uma lista para cada tipo de conta, tem o uso de polimorfismo.    |
| Prova1PedroGarbossa   | Java & JaKarta Faces + Eclipse    | Projeto Maven + Java Web que funcionava como um mercado online, divido em dois escopos: Admin e Usuario Comum, para o admin o mercado disponibilizava as 4 funcionalidades de um projeto CRUD, criar um produto, ler produtos existentes no mercado, atualizar um produto existente e deletar um produto existente, como banco de dados foi usado um MySql disponibilizado pelo professor, para conexão com banco foi usado a dependência no maven, Connection Factory e um DAO para realizar as operações envolvendo o banco. Para hospedar a aplicação, foi utilizado um servidor Apache Tomcat, tomee versão 8.0, a página aberta por padrão ao acessar a aplicação é a página de usuário comum, já para acessar a pagina de admin a url é: localhost:8080/Prova1PedroGarbossa/admin.xhtml.    |
| MusicApp   | JavaScript & React Native + VsCode    | Projeto que tem como funcionalidade para o usuário a opção de adicionar em uma lista suas bandas favoritas e para cada banda adicionar em uma lista as suas músicas favoritas para aquela banda. OBS: Utiliza as bibliotecas externas. |
| Calculadora   | JavaScript & React Native + VsCode    | Projeto de uma calculadora com design _vintage_ que disponibiliza para o usuário as 4 operações básicas de matemática envolvendo números reais.   |

OBS: Os projetos de JavaScript foram desenvolvidos utilizando o Expo que é uma ferramenta usada para o aprendizado de desenvolvimento mobile, tendo o node.js instalado na sua máquina, basta instalar o expo com o comando:
```npm install -g expo-cli```, após a instalação, vá em um diretório onde deseja criar um projeto e utilize o comando: ```expo init ${Nome_Projeto}```, será baixado as dependências necessárias para rodar o projeto, dessa forma basta mover os códigos .js para o projeto e rodá-lo com o comando: ```expo start```.

Bibliotecas Externas: Existem várias bibliotecas externas tanto do expo, quanto do react-native que fornece uma alta gama de possibilidades para desenvolvimento, utilizei as seguintes:
```
npm install @react-navigation/native
expo install react-native-screens react-native-safe-area-context
npm install @react-navigation/stack
expo install react-native-gesture-handler
npm install @react-navigation/material-bottom-tabs react-native-paper react-native-vector-icons
expo install expo-random
```
