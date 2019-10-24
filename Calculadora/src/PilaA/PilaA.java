/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PilaA;

public class PilaA <T> implements PilaADT<T> {
    private T[] pila;
    private int tope;
    public PilaA(){
        pila=(T[]) new Object [20];
        tope=-1;
    }
    public boolean isEmpty(){
        return tope==-1;
    }
    private void expande(){
        T nuevo[]=(T[]) new Object[pila.length*2];
        for(int i=0;i<=tope;i++)
            nuevo[i]=pila[i];
        pila=nuevo;
    }
    public void push(T dato){
        if(tope+1 == pila.length)//¿está llena?
            expande();
        tope++;
        pila[tope]=dato;
    }
    public T pop(){
        T res = null;
        if(!isEmpty()){
            res=pila[tope];
            pila[tope]=null;
            tope--;
        }
        return res;
    }
    /*Opción B
    */
    /*public T pop(){
        if(!isEmpty()){
            T res;
            res=pila[tope];
            pila[tope]=null;
            tope--;
            return res;
        }
        else
            throw new ExceptionColecVacia();
    }*/
    public T peek(){
        T res = null;
        if(!isEmpty())
            res=pila[tope];
        return res;
    }
    /*public T peek(){
        if(!isEmpty()){
            T res;
            res=pila[tope];
            return res;
        }
        else
            throw new ExceptionColecVacia();
    }*/
}
