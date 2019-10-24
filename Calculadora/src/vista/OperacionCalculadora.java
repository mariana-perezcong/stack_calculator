
package vista;

import PilaA.PilaA;
import java.util.ArrayList;

public abstract class OperacionCalculadora {
    
    /**
     * Revisa que los paréntesis estén ordenados de forma correcta
     * @param cadena String con la expresión a verificar
     * @return <ul>
     * <li> true: los paréntesis están ordenados de forma correcta </li>
     * <li> false: existe un error en la colocación de los paréntesis </li>
     * </ul>
     */
    public static boolean revisaParentesis(String cadena){
        PilaA <Character> p= new PilaA();
        int i,n;
        Character x;
        boolean bandera=true;
        i=0;
        n=cadena.length();
        
        while(i<n && bandera){
            if(cadena.charAt(i)=='('){
                p.push(cadena.charAt(i));
            }
            else if(cadena.charAt(i)==')'){
                x=p.pop(); 
                if(x==null){ 
                    bandera=false;
                }
            } 
            i++;
        }
        return p.isEmpty() && bandera;
    }
    
    /**
     * 
     * Identifica si existen operadores repetidos
     * @param cad String que desea ser evaluado.
     * @see Util#eliminarEspacios(java.lang.String) 
     * @see Util#esOperador(char) 
     * 
     * @return <ul>
     * <li> true: tiene operadores repetidos. </li>
     * <li> false: los operadores se encuentran ordenados de forma correcta
     * </ul>
     */
    public static boolean operadoresRepetidos(String cad){
        boolean resp=false;
        int i,n;
        String cadena=Util.eliminarEspacios(cad);
        System.out.println(cadena);
        n=cadena.length();
        i=0;
        while(i<n-1 && !resp){
            if(Util.esOperador(cadena.charAt(i)) && Util.esOperador(cadena.charAt(i+1))){
                resp=true;
            }
            else
                i++;
        }
        return resp;
    }
    
   /**
    * <pre>
    * Convierte una expresión in fija a una post fija.
    * Utiliza una pila y un ciclo while, en el cual se evalúa con condicionales
    * anidados si el elemento es un paréntesis, operador u operando. En el
    * caso de paréntesis izquierdo se guarda en la pila; si es un operando
    * en la expresión hay un ciclo while, mientras la pila esté vacía y la 
    * prioridad de elementos sea igual o menor a la prioridad del tope de 
    * la pila, al finalizar ese while se guardan los elementos en la pila; si
    * el elemento es un paréntesis derecho, sacará todos los elementos de la 
    * pila hasta encontrar el paréntesis izquierdo. Posteriormente, saca los
    * elementos de la pila y los agrupa en la expresión post fija.
    * 
    * @param inFija Arreglo de caracteres que serán convertidos a 
    * notación post fija.
    * @return ArrayList que contiene la expresión post fija
    * @see Util#getPrioridad(char) 
    * </pre>
    */
    public static ArrayList convertirAPostFijo(char [] inFija){
        int i = 0;
        ArrayList postFija = new ArrayList();
        PilaA operadores = new PilaA();        
        while(i<inFija.length){
            System.out.println(i);
            if(inFija[i]=='('){
                operadores.push(inFija[i]);
            }           
            else if((inFija[i]=='*')||(inFija[i]=='/')||(inFija[i]=='+')||(inFija[i]=='-')){
                while(!operadores.isEmpty()&&(Util.getPrioridad(inFija[i])<=Util.getPrioridad((char)operadores.peek()))&&((char)operadores.peek()!='(')){   
                    postFija.add(operadores.pop());
                }
                operadores.push(inFija[i]);
            }
            else if(inFija[i]==')'){
                while((char)operadores.peek()!='('){
                    postFija.add(operadores.pop());
                }
                operadores.pop();
            }
            else if(inFija[i]==' '){
                postFija.add(inFija[i]);
                i++;
                while(i<inFija.length&&inFija[i]!=' '){
                    postFija.add(inFija[i]);
                    i++;
                }
                postFija.add(' ');
            }
            i++;
        }
       
        
        while(!operadores.isEmpty()){
            postFija.add(operadores.pop());
        }
       
        return postFija;
    }
    
    /**
     * <pre>
     * Evalúa la expresión post fija y el resultado lo agrega
     * al campo de texto. Para realizar esto, usa un ciclo for para evaluar cada
     * elemento de la expresión post fija. Guarda en una pila  los números
     * encontrados y realiza la operación que encuentra. Es importante
     * mencionar que siempre utiliza primero el segundo número que saca de 
     * la pila, lo cual es importante para la división.
     * @param postFija ArrayList que contiene la expresión postFija
     * @see convertirAPostFijo(char [] inFija)
     * @see Util#esOperador(char) 
     * @return String del resultado de la operación.
     * </pre>
     */
    public static String evaluarPostFija(ArrayList postFija){
        String numero="";
        double respuesta=0,div1, div2;
        boolean operacion=false;
        PilaA operandos = new PilaA();
        try{
           for(int i=0;i<postFija.size();i++){
               if(Util.esOperador((char)postFija.get(i))){
                   operacion = true;
                   switch((char)postFija.get(i)){
                        case '+':
                            respuesta = (double)operandos.pop()+(double)operandos.pop();
                            operandos.push(respuesta);
                           break;
                        case '*':
                            respuesta = (double)operandos.pop()*(double)operandos.pop();
                            operandos.push(respuesta);
                            break;
                        case '/':
                            div2 = (double)operandos.pop();
                            div1 = (double)operandos.pop();
                                respuesta = div1/div2;
                                operandos.push(respuesta);
                            if(div2==0){
                                return "dividing by zero!";
                            }
                            break;
                   }
               }
               else if((char)postFija.get(i)==' '){
                   i++;
                   while((char)postFija.get(i)!=' '){
                       numero=numero+(char)postFija.get(i);
                       i++;
                   }
                   if(!operacion){
                        respuesta=Double.parseDouble(numero);
                   } 
                   operandos.push(Double.parseDouble(numero));
                   numero="";
               }
           } 
        }
        catch(Exception e){
            return "Syntax error"; 
        }    
        return Double.toString(respuesta);
    } 
}
