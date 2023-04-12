package prova;

public class Carta implements Comparable<Carta> {
    private int numero;
    private String naipe;

    public Carta(int numero, String naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public int getNumero() {
        return numero;
    }

    public String getNaipe() {
        return naipe;
    }

    public int compareTo(Carta outraCarta) {
        int compNaipe = naipe.compareTo(outraCarta.naipe);
        if (compNaipe == 0) {
            return Integer.compare(numero, outraCarta.numero);
        } else {
            return compNaipe;
        }
    }

    @Override
    public String toString() {
        return naipe + " " + numero;
    }
}