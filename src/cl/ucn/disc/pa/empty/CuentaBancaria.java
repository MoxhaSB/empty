package cl.ucn.disc.pa.empty;
import edu.princeton.cs.stdlib.StdOut;

public class CuentaBancaria {

    private int saldo;

    public void CuentaBancaria(int saldo){
        this.saldo = saldo;
    }

    /**
     * Se retorna el saldo
     * @return
     */
    public int getSaldo(){
        return getSaldo();
    }

    /**
     * Se saca dinero
     * @param monto
     */
    public void girar(int monto){
        while (true) {
            if (monto > 0 && monto <= saldo) {
                this.saldo -= monto;
                break;
            } else {
                StdOut.println("Ingrese un monto válido.");
                continue;
            }
        }
    }

    /**
     * Se deposita el dinero
     * @param monto
     */
    public void depositar(int monto) {
        while (true) {
            if (monto>0) {
                this.saldo += monto;
                break;
            }else {
                StdOut.println("Ingrese un monto válido.");
                continue;
            }
        }
    }






}
