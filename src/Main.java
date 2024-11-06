public class Main {

    public static void  main(String[] args) {
        Cliente rodrigo = new Cliente();
        rodrigo.setNome("Rodrigo");

        Conta cc = new ContaCorrente(rodrigo);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(rodrigo);
        cc.transferir(150, poupanca);

        cc.sacar(150);

        cc.transferir(90, poupanca);

        cc.sacar(7);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
