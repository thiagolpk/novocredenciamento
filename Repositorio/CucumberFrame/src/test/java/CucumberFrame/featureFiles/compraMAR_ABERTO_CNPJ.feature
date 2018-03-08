@CompraMaquina @MARABERTO
Feature: Compra de maquininha CNPJ MAR ABERTO
  Eu quero efetuar a compra de uma maquininha

  @CNPJ @MARABERTO
  Scenario: Compra da maquina por CNPJ
    Given Usuario acessa o site de compra de maquininha
    And Escolher a maquina MOB
    And Informar o endereco
    And Informar dados do meu negocio CNPJ
    When Informar dados bancarios
    Then Deve acessar a tela de pagamento
    



