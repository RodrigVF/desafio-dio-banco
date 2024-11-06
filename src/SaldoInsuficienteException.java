public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String operacao, Double valor, Double saldo) {
      super(String.format(
              "============================================================%n" +
              "Saldo Insuficiente para realizar operação: %s%n" +
              "Valor Solicitado: %.2f%n" +
              "Valor Disponível: %.2f%n" +
              "============================================================%n",
              operacao, valor, saldo
      ));
    }
}
