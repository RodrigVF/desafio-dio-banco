public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }


    public void sacar (double valor, String operacao) throws SaldoInsuficienteException {
        if (valor <= saldo){
            saldo -= valor;
        } else {
            throw new SaldoInsuficienteException(operacao, valor, saldo);
        }
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        try {
            this.sacar(valor, "saque");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        try {
            this.sacar(valor, "transferência");
            contaDestino.depositar(valor);

        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}
