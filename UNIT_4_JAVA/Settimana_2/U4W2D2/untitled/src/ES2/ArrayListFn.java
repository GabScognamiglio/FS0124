package ES2;

import java.util.*;

public class ArrayListFn {
    public static void main(String[] args) {
        ArrayListFn arrayListFn = new ArrayListFn();

        ArrayList<Integer> listaOrdinata = arrayListFn.listaRandomOrdinata(10);

        System.out.println("Lista ordinata di numeri casuali:");
        for (Integer numero : listaOrdinata) {
            System.out.println(numero);
        }

        ArrayList<Integer> ordineInverso = arrayListFn.ordineInverso(listaOrdinata);
        System.out.println("Lista ordinata dal più grande al più piccolo:");
        for (Integer numero : ordineInverso) {
            System.out.println(numero);
        }
        System.out.println("Pari o Dispari?!");
        arrayListFn.pariDispari(ordineInverso, true);
    }

    public ArrayList listaRandomOrdinata(int n) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            lista.add(random.nextInt(1, 11));
        }
        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        return lista;
    }

    public ArrayList ordineInverso(ArrayList<Integer> lista) {
        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }

        });
        return lista;
    }

    public void pariDispari (ArrayList<Integer> lista, boolean pari) {
        if (pari){
            for (Integer num : lista) {
                if(num%2==0){
                    System.out.println(num);
                }
            }
        } else {
            for (Integer num : lista) {
                if(num%2!=0){
                    System.out.println(num);
                }
            }
        }
    }
}