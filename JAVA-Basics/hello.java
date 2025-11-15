public class hello{

    public static void main(String[] args){
        String name = "pinga";
        boolean casado= false;
        int edad = 22;
        float peso= 189.72f;
        double altura = 1.77;


        //tipos de datos numericos

        byte tipoByte =127;
        System.out.println("tipoByte = " + tipoByte);
        short tipoShort = (short)32000;
        System.out.println("tipoShort = " + tipoShort);
        int tipoInt = 2;
        System.out.println("tipoInt = " + tipoInt); //por defecto valor 0
        long tipoLong = 92399999982l;
        System.out.println("tipoLong = " + tipoLong);
        float tipoFloat = 3.14f; //32bits
        System.out.println("tipoFloat = " + tipoFloat);
        double tipoDoble = 22.22;//64bits
        System.out.println("tipoDoble= " + tipoDoble);



        //tipos de datos de cadena
        char tipoChar = 'A'; //un solo caracter
        System.out.println("tipoChar = " + tipoChar); // por defecto caracter ('\u0000')
        //si le pones un numero convertira ese valor a la letra
        // o caracter que corresponde en unicode 
        tipoChar = 101; // en este caso sera el caracter "e"  que es una letra minuscula
        System.out.println("tipoChar = " + tipoChar);
        boolean tipoBol = false;
        System.out.println("tipoBol = " + tipoBol); //por default es False

        //tipos de objetos de referencia
        String cadenaExample = null; //por default string sera null
        
        //JAVA es sensible a las mayusculas y minusculas (como casi todo idioma)

        
        



        

        
        



    }

// comentarios

//el public principal debe tener el nombre del archivo en este caso hello.java  -> public class hello
}