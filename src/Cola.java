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

    // Métodos
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú de Cola ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Verificar si la cola está vacía");
            System.out.println("4. Verificar si la cola está llena");
            System.out.println("5. Ver el primer elemento de la cola");
            System.out.println("6. Ver el tamaño de la cola");
            System.out.println("7. Ver todos los elementos de la cola");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    T elemento = (T) scanner.next(); // Se asume que los elementos son de tipo T
                    push(elemento);
                    break;
                case 2:
                    T elementoExtraido = pop();
                    System.out.println("Elemento extraído: " + elementoExtraido);
                    break;
                case 3:
                    System.out.println("La cola está vacía: " + vacia());
                    break;
                case 4:
                    System.out.println("La cola está llena: " + llena());
                    break;
                case 5:
                    System.out.println("Primer elemento de la cola: " + primero());
                    break;
                case 6:
                    System.out.println("Tamaño de la cola: " + tamaño());
                    break;
                case 7:
                    actual();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while(opcion != 0);
        
        scanner.close();
    }

    public void push(T elemento) {
    if (llena()) {
        System.out.println("La cola está llena. No se puede agregar más elementos.");
        return;
    }
    int indice = (frente + tamano) % capacidad; //modular para tratar la tabla como un circulo
    elementos[indice] = elemento;
    tamano++;
}

    public T pop() {
        if (vacia()) {
            System.out.println("La cola está vacía. No se puede extraer ningún elemento.");
            return null; // Valor de retorno para indicar que la cola está vacía
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
            System.out.println("La cola está vacía. No hay elemento en el frente.");
            return null; // Valor de retorno para indicar que la cola está vacía
        }
        return (T) elementos[frente];
    }

    public int tamaño() {
        return capacidad;
    }

    public void actual() {
        if (vacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Cola: ");
        for (int i = 0; i < tamano; i++) {
            int índice = (frente + i) % capacidad;
            System.out.print(elementos[índice] + " ");
        }
        System.out.println();
    }
    
}
