
package vista;

import java.util.ArrayList;

public abstract class Util {
    /**
     * Identifica si un caracter es operador.
     * @param a Un caracter dentro de la expresión dada.
     * @return <ul>
     * <li> true: es un operador </li>
     * <li> false: no es un operador </li>
     * </ul>
     */
    public static boolean esOperador(char a){
        return a=='+'||a=='-'||a=='*'||a=='/';
    }
    /**
     * <pre>
     * Elimina los espacios de determinada cadena.
     * @param cadena Expresión generado a partir de los datos que ingresó 
     * el usuario
     * </pre>
     * @return String de la cadena sin los espacios
     */
    public static String eliminarEspacios(String cadena){
        String operacion="";
        for(int i=0;i<cadena.length();i++){
            if(cadena.charAt(i)==' '){
                i++;
            }
            operacion=operacion+cadena.charAt(i);
        }
        return operacion;
    }
    /**
     * Determina la prioridad de algún operador.
     * @param operador Caracter que es un operador.
     * @return <ul>
     *      <li> 1: mayor jerarquía </li>
     *      <li> 0: menor jerarquía
     * </ul>
     */
     public static int getPrioridad(char operador){
        int jerarquia;
        switch(operador){
            case '*':
                jerarquia=1;
                break;
            case '/':
                jerarquia=1;
                break;
            case '+':
                jerarquia=0;
                break;
            case '-':
                jerarquia=0;
                break;
            default:
                jerarquia=0;
                break;
        }
        return jerarquia;
     }
    /**
     *<pre>
     * Convierte los numeros que tengan asociado un signo negativo
     * en su inverso aditivo.
     * @param cadena String que quiere ser evaluado.
     * @return String con los valores negativos expresados en 
     * términos de su inverso aditivo.
     * </pre>
     */
    public static String addInversoAditivo(String cadena){
        
        StringBuilder expresion = new StringBuilder();
        ArrayList inFijaIA = new ArrayList();
        for(int i=0; i<cadena.length();i++){
            if(cadena.charAt(i)=='-'){
                expresion.append("+( -1 )*");
            }
            else{
                expresion.append(cadena.charAt(i));
            }
        }
        return expresion.toString();
    }
    /**
     * <pre>
     * Quita los signos positivos que se encuentren al inicio
     * de la expresión.
     * </pre>
     * @param cad String que se desea evaluar
     * @return String de la cadena corregida
     */
    public static String quitaSignosMas(String cad){
        int n,i;
        char x;
        String cadCorregida;
        cadCorregida="";
        n=cad.length();
        i=0;
        
        while(i<n){
            x=cad.charAt(i);
            //si no es un signo de suma
            if(x!= '+' )
                cadCorregida+=x;
            //si es un simbolo de suma
            else
                //en caso de que la expresion empiece con un simbolo de suma
                if(i!=0)
                    if(cad.charAt(i-1)!='(' && cad.charAt(i-1)!='*' && cad.charAt(i-1)!='/')
                        cadCorregida+=x;
            
            i++;      
        }
        return cadCorregida;
    }
}
