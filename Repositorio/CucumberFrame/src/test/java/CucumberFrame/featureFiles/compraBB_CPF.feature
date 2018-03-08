@CompraMaquina @BB
Feature: Compra de maquininha CPF BB
  Eu quero efetuar a compra de uma maquininha
  
     @CPF @BB
  Scenario: Compra da maquina por CPF
    Given Usuario acessa o site de compra de maquininha BB
   	And Escolher a opcao vender
    And Escolher a maquina MOB
    And Informar o endereco
    And Informar dados do meu negocio CPF
    When Informar dados bancarios BB
    Then Deve acessar a tela de pagamento