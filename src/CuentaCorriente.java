
import java.util.ArrayList;

public class CuentaCorriente {
    int id = (int) (Math.random() * Math.random() * Math.random() * 14718123);
    int saldo;
    ArrayList<String> movimientos = new ArrayList<>();

    CuentaCorriente() {

    }

    CuentaCorriente(int saldo) {
        this.saldo = saldo;
    }

    public void ingreso(int dinero) {
        saldo += dinero;
        movimientos.add(String.format("Ingreso de %s € Saldo: %s", dinero, saldo));
    }

    public void cargo(int dinero) {
        saldo -= dinero;
        movimientos.add(String.format("Cargo de %s € Saldo: %s", dinero, saldo));
    }

    public void transferencia(CuentaCorriente cuenta, int dinero) {
        cuenta.saldo += dinero;
        this.saldo -= dinero;
        movimientos.add(String.format("Transf. recibida de %s € de la cuenta %s Saldo: %s", dinero, cuenta.id, saldo));
        cuenta.movimientos
                .add(String.format("Transf. emitida de %s € a la cuenta %s Saldo: %s", dinero, id, cuenta.saldo));
    }

    public void movimientos() {
        System.out.printf("""
                Movimientos de la cuenta %s
                -----------------------------------
                    """, id);
        for (String string : movimientos) {
            System.out.println(string);
        }
    }

}
