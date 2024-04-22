/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bocetos
 */

import java.util.Scanner;

public class Cola<T> {
    private Object[] elementos;
    private int tamano;
    private int frente;
    private int capacidad;

    // Constructor
    public Cola(int capacidad) {
        this.elementos = new Object[capacidad];
        this.tamano = 0;
        this.frente = 0;
        this.capacidad = capacidad;
    }

    // M�todos
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Men� de Cola ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Verificar si la cola est� vac�a");
            System.out.println("4. Verificar si la cola est� llena");
            System.out.println("5. Ver el primer elemento de la cola");
            System.out.println("6. Ver el tama�o de la cola");
            System.out.println("7. Ver todos los elementos de la cola");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opci�n: ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    T elemento = (T) scanner.next(); // Se asume que los elementos son de tipo T
                    push(elemento);
                    break;
                case 2:
                    T elementoExtraido = pop();
                    System.out.println("Elemento extra�do: " + elementoExtraido);
                    break;
                case 3:
                    System.out.println("La cola est� vac�a: " + vacia());
                    break;
                case 4:
                    System.out.println("La cola est� llena: " + llena());
                    break;
                case 5:
                    System.out.println("Primer elemento de la cola: " + primero());
                    break;
                case 6:
                    System.out.println("Tama�o de la cola: " + tama�o());
                    break;
                case 7:
                    actual();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opci�n no v�lida. Int�ntelo de nuevo.");
            }
        } while(opcion != 0);
        
        scanner.close();
    }

    public void push(T elemento) {
    if (llena()) {
        System.out.println("La cola est� llena. No se puede agregar m�s elementos.");
        return;
    }
    int indice = (frente + tamano) % capacidad; //modular para tratar la tabla como un circulo
    elementos[indice] = elemento;
    tamano++;
}

    public T pop() {
        if (vacia()) {
            System.out.println("La cola est� vac�a. No se puede extraer ning�n elemento.");
            return null; // Valor de retorno para indicar que la cola est� vac�a
        }
        T elementoExtraido = (T) elementos[frente]; //modular para tratar la tabla como un circulo
        frente = (frente + 1) % capacidad;
        tamano--;
        return elementoExtraido;
    }

    public boolean vacia() {
        return tamano == 0;
    }

    public boolean llena() {
        return tamano == capacidad;
    }

    public T primero() {
        if (vacia()) {
            System.out.println("La cola est� vac�a. No hay elemento en el frente.");
            return null; // Valor de retorno para indicar que la cola est� vac�a
        }
        return (T) elementos[frente];
    }

    public int tama�o() {
        return capacidad;
    }

    public void actual() {
        if (vacia()) {
            System.out.println("La cola est� vac�a.");
            return;
        }
        System.out.print("Cola: ");
        for (int i = 0; i < tamano; i++) {
            int �ndice = (frente + i) % capacidad;
            System.out.print(elementos[�ndice] + " ");
        }
        System.out.println();
    }
    
}
