@CompraMaquina @CIELO @CPF
Feature: Compra de maquininha CPF CIELO
  Eu quero efetuar a compra de uma maquininha
  
  Scenario: Compra da maquina por CPF
    Given Usuario acessa o site de compra de maquininha CIELO
	And Escolher a opcao vender
    And Escolher a maquina MOB
    And Informar o endereco
    And Informar dados do meu negocio CPF
    When Informar dados bancarios
    Then Deve acessar a tela de pagamento
    
