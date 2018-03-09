@CompraMaquina @BB @CNPJ
Feature: Compra de maquininha CNPJ BB
  Eu quero efetuar a compra de uma maquininha
  
  Scenario: Compra da maquina por CNPJ
    Given Usuario acessa o site de compra de maquininha BB
   	And Escolher a opcao vender
    And Escolher a maquina MOB
    And Informar o endereco
    And Informar dados do meu negocio CNPJ
    When Informar dados bancarios BB
    Then Deve acessar a tela de pagamento