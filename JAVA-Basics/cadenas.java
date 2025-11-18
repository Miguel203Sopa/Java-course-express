public class cadenas{

    public static void main(String[] args){

        var cadena1 = new String("Balatro"); //sintaxis formal
        String cadena2 ="pinguino";
        String cadena3 ="""
        Perkeo el 
        enano
        cerote
        """;
        String cadena4 = cadena1 +" "+cadena2+" "+cadena3;
        System.out.println(cadena3);
        System.out.println(cadena4);

        //indice de cadenas:
        String cadenaA = "Obstaculo";
        char caracter1; 
        
        caracter1 = cadenaA.charAt(0);
        System.out.println("primer caracter: "+caracter1);
        caracter1 = cadenaA.charAt(8);
        System.out.println("ultimor caracter: "+caracter1);
        
        //inmutabilidad de cadenas
        //las cadenas en JAVA no se pueden modificar 
        
        String cadenaB, cadenaC, cadenaD;
        cadenaC ="Hola";
        cadenaD ="Estas";
        
        
        cadenaB= cadenaC+" Como "+cadenaD;
        System.out.println(cadenaB);
        
        
    
    }


}