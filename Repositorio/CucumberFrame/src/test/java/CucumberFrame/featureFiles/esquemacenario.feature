@Esquemadecenario @Teste
Feature: Teste Esquema de Cenario
Eu quero testar o esquema de cenário
  
    Scenario Outline: Compra da maquina por CPF
    Given Usuario acessa o site de compra de maquininha "<canal>"
		And Escolher a opcao vender
    And Escolher a maquina MOB
    And Informar o endereco
    And Informar dados do meu negocio "<cadastroPessoa>" com "<nomeFantasia>"
    When Informar dados bancarios "<canal>"
    Then Deve acessar a tela de pagamento
    
    Examples: 
      | canal  | cadastroPessoa | nomeFantasia   |
      | CIELO  | CPF						| Loja CPF Cielo |
      | CIELO	 | CNPJ						| Loja CNPJ Cielo|
      | BRA  	 | CPF						| Loja CPF Bra 	 |
      | BRA 	 | CNPJ						| Loja CNPJ Bra	 |
      | BB  	 | CPF						| Loja CPF BB 	 |
      | BB	 	 | CNPJ						| Loja CNPJ BB	 |
      
