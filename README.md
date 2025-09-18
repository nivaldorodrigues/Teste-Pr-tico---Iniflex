# TESTE PRÁTICO -  INIFLEX
----------------------------------------------------------------------------------------------------------------------------------
O QUE FOI PEDIDO:
TESTE PRÁTICO PROGRAMAÇÃO.

Considerando que uma indústria possui as pessoas/funcionários abaixo:

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3 – Deve conter uma classe Principal para executar as seguintes ações:
3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
3.2 – Remover o funcionário “João” da lista.
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
• informação de data deve ser exibido no formato dd/mm/aaaa;
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
3.6 – Imprimir os funcionários, agrupados por função.
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
3.10 – Imprimir a lista de funcionários por ordem alfabética.
3.11 – Imprimir o total dos salários dos funcionários.
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

Orientações gerais:
• você poderá utilizar a ferramenta que tem maior domínio (exemplos: eclipse, netbeans etc);
• após finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa Mão na Massa 🖐.
Basta Colar o link ainda aqui nessa etapa.
• Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.

Esperamos que você use todo seu conhecimento e criatividade nesse teste.

Caso você não souber resolver determinado requisito comente no código que aquele item você não sabe como desenvolver, e vá para o próximo. Avaliaremos o que você conseguiu desenvolver e como foi desenvolvido.

-------------------------------------------------------------------------------------------------------------------------
# TESTE PRÁTICO PROGRAMAÇÃO - INIFLEX

Este projeto Java foi desenvolvido como solução para o teste prático de programação solicitado pela Iniflex.

## Descrição

O objetivo é manipular uma lista de funcionários de uma indústria, realizando diversas operações como cadastro, remoção, agrupamento, ordenação, cálculos de salários e filtragem por aniversário.

## Estrutura do Projeto

- **Pessoa**: Classe base com os atributos `nome` (String) e `dataNascimento` (LocalDate).
- **Funcionario**: Herda de Pessoa e adiciona os atributos `salario` (BigDecimal) e `funcao` (String).
- **Principal**: Classe responsável pela execução das operações solicitadas.

## Funcionalidades Implementadas

1. Cadastro dos funcionários conforme tabela fornecida.
2. Remoção do funcionário "João".
3. Impressão de todos os funcionários com:
   - Data no formato `dd/MM/yyyy`
   - Valores numéricos formatados (milhar com ponto, decimal com vírgula)
4. Aplicação de aumento salarial de 10% para todos os funcionários.
5. Agrupamento dos funcionários por função em um `Map`.
6. Impressão dos funcionários agrupados por função.
7. Filtragem e impressão dos funcionários que fazem aniversário nos meses 10 (outubro) e 12 (dezembro).
8. Identificação e impressão do funcionário com maior idade (nome e idade).
9. Impressão da lista de funcionários em ordem alfabética.
10. Cálculo e impressão do total dos salários dos funcionários.
11. Cálculo e impressão de quantos salários mínimos cada funcionário recebe (considerando salário mínimo de R$ 1212,00).

## Como Executar

1. Certifique-se de ter o Java instalado (Java 17 ou superior recomendado).
2. Compile e execute o arquivo `principal.java`.
3. Todas as operações serão exibidas no console.

## Observações

- O projeto utiliza as bibliotecas padrão do Java.
- Datas e valores são exibidos conforme solicitado.
- O código está pronto para avaliação técnica.

---

EsperO que este projeto demonstre todo o meu conhecimento e criatividade!
