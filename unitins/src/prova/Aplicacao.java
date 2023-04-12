package prova;

import java.util.ArrayList;


public class Aplicacao {


	public static void ordenarBaralhoMergeSort(ArrayList<Carta> baralho) {
	    if (baralho.size() <= 1) {
	        return; // Não há nada a fazer, o baralho já está ordenado
	    }
	    
	    // Divide o baralho em duas metades
	    int meio = baralho.size() / 2;
	    ArrayList<Carta> metade1 = new ArrayList<>(baralho.subList(0, meio));
	    ArrayList<Carta> metade2 = new ArrayList<>(baralho.subList(meio, baralho.size()));

	    // Ordena as metades de forma recursiva
	    ordenarBaralhoMergeSort(metade1);
	    ordenarBaralhoMergeSort(metade2);

	    // Combina as duas metades ordenadas em um único baralho ordenado
	    int i = 0, j = 0;
	    while (i < metade1.size() && j < metade2.size()) {
	        if (metade1.get(i).compareTo(metade2.get(j)) < 0) {
	            baralho.set(i + j, metade1.get(i));
	            i++;
	        } else {
	            baralho.set(i + j, metade2.get(j));
	            j++;
	        }
	    }
	    while (i < metade1.size()) {
	        baralho.set(i + j, metade1.get(i));
	        i++;
	    }
	    while (j < metade2.size()) {
	        baralho.set(i + j, metade2.get(j));
	        j++;
	    }
	}
	
	public static void ordenarBaralho(ArrayList<Carta> baralho) {
	    if (baralho.size() <= 1) {
	        return; // Não há nada a fazer, o baralho já está ordenado
	    }
	    
	    // Divide o baralho em quatro grupos: copas, ouros, espadas e paus
	    ArrayList<Carta> copas = new ArrayList<>();
	    ArrayList<Carta> ouros = new ArrayList<>();
	    ArrayList<Carta> espadas = new ArrayList<>();
	    ArrayList<Carta> paus = new ArrayList<>();
	    for (int i=0; i<baralho.size();i++) {
	        String naipe = baralho.get(i).getNaipe();
	        if (naipe.equals("Copas")) {
	            copas.add(baralho.get(i));
	        } else if (naipe.equals("Ouro")) {
	            ouros.add(baralho.get(i));
	        } else if (naipe.equals("Espadas")) {
	            espadas.add(baralho.get(i));
	        } else {
	            paus.add(baralho.get(i));
	        }
	    }

	    // Ordena os quatro grupos de forma recursiva
	    ordenarBaralhoMergeSort(copas);
	    ordenarBaralhoMergeSort(ouros);
	    ordenarBaralhoMergeSort(espadas);
	    ordenarBaralhoMergeSort(paus);

	    // Combina os quatro grupos ordenados em um único baralho ordenado
	    baralho.clear();
	    baralho.addAll(copas);
	    baralho.addAll(ouros);
	    baralho.addAll(espadas);
	    baralho.addAll(paus);
	}
	
	public static void main(String [] args){ 
	    
		ArrayList<Carta> baralho = new ArrayList<>();
        
        baralho.add(new Carta(1, "Copas"));
        baralho.add(new Carta(1, "Paus"));
        baralho.add(new Carta(1, "Espadas"));
        baralho.add(new Carta(9, "Copas"));
        baralho.add(new Carta(4, "Copas"));
        baralho.add(new Carta(2, "Paus"));
        baralho.add(new Carta(3, "Copas"));
        baralho.add(new Carta(12, "Ouro"));
        baralho.add(new Carta(13, "Paus"));
        baralho.add(new Carta(11, "Copas"));
        baralho.add(new Carta(7, "Ouro"));
        baralho.add(new Carta(8, "Espadas"));
        baralho.add(new Carta(6, "Copas"));
        
        ordenarBaralho(baralho);
        
        System.out.println("  Cartas :");
        
        System.out.println(baralho.toString());
        
       // System.out.println(ordenarBaralho(baralho));
	    
	}
	
}
