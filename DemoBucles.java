import java.util.Random;
/**
 *    @author - Sergio Garrués Aizcorbe
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';

    private Random generador;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int potencia = 1;
        while (potencia <= numero / 2)   
        {
            potencia *= 2;
        }
        return potencia;

    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int potencia = mayorPotencia2(numero);
        int total = potencia;

        System.out.printf("\n%6d= %6d", numero, potencia);
        while (potencia > 1)    {
            potencia = potencia / 2;
            total += potencia;
            if (total <= numero)   {
                System.out.printf("%6d", potencia);
            }
            else {
                total -= potencia;
            }

        }

    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int aleatorio = 1;
        int veces = 1;

        System.out.println("Nºs aleatorios como suma de potencias de 2");
        while (aleatorio > 0 && veces <= n) 
        {
            aleatorio = generador.nextInt(256);
            escribirSumaPotencias(aleatorio);
            veces++;
        }
        if (aleatorio == 0)
        {
            System.out.println("Bucle terminado porque se ha generado un 0");
        }
        else    
        {
            System.out.println("\nBucle terminado porque se han generado ya " + n + " aleatorios");
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        char strCaracter = caracter;

        for (int contador = 1; contador <= n; contador++)
        {

            System.out.print(caracter);
        }

    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        int blancos = 0;
        for (int contadorEs = 1; contadorEs <= escalones; contadorEs++)
        {
            for (int numBlancos = 1; numBlancos <= alto; numBlancos++)
            {
                escribirCaracter(blancos, ' ');
                escribirCaracter(ancho, '*');
                System.out.println("");
            }

            blancos += ancho;
        }

    }
} 
