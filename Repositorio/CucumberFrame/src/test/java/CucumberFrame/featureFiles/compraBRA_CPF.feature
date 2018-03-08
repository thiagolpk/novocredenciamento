@CompraMaquina @BRA
Feature: Compra de maquininha CPF BRA
  Eu quero efetuar a compra de uma maquininha
  
     @CPF @BRA
  Scenario: Compra da maquina por CPF
    Given Usuario acessa o site de compra de maquininha Bradesco
   	And Escolher a opcao vender
    And Escolher a maquina MOB
    And Informar o endereco
    And Informar dados do meu negocio CPF
    When Informar dados bancarios BRA
    Then Deve acessar a tela de pagamento