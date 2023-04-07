package cl.ucn.disc.pa.empty;
import edu.princeton.cs.stdlib.StdDraw;
import edu.princeton.cs.stdlib.StdOut;
import java.awt.*;

public class Taller {


    /**
     * Se guardan las posiciones de las lineas
     * @param posicionx0
     * @param posicionx1
     * @param posiciony0
     * @param posiciony1
     * @param posiLineax0
     * @param posiLineax1
     * @param posiLineay0
     * @param posiLineay1
     */
    public static void lineasHechas(double posicionx0,double posicionx1,double posiciony0,double posiciony1,double posiLineax0[],double posiLineax1[],double posiLineay0[],double posiLineay1[]){

        double aumentar = 0.05; //se le aumenta a la posicion para que tengan diferencia de altura.

        //declaro la primera posicion independiente para que no se le aumente la velocidad, esta es la primera linea y las demas la seguiran.
        posiLineax0[0] = posicionx0;
        posiLineax1[0] = posicionx1;
        posiLineay0[0] = posiciony0;
        posiLineay1[0] = posiciony1;

        for (int i = 1; i <5 ; i++) {
            posiLineax0[i] = posicionx0;
            posiLineax1[i] = posicionx1;
            posiLineay0[i] = (posiciony0 + aumentar);
            posiLineay1[i] = (posiciony1 + aumentar);
            aumentar += 0.05; //se aumentan 0.05 para que las posiciones sean aún mayores.
        }

    }

    /**
     * se ejecuta el programa
     * @param args
     */
    public static void main(String[] args) {

        //declarar variables

        //declarar lista con posiciones de las lineas
        double posiLineax0[] = new double[5];
        double posiLineax1[] = new double[5];
        double posiLineay0[] = new double[5];
        double posiLineay1[] = new double[5];


        double min = -1.0;// el limite del dibujo
        double max = 1.0;

        StdDraw.setXscale(min,max);//generar el cuadro donde se dibuja
        StdDraw.setYscale(min,max);

        StdDraw.enableDoubleBuffering(); //evitar parpadeo de la pantalla. o actualizar la pantalla

        double posicionx0 = min + (max-min) * Math.random(); //puntos iniciales de la primera linea
        double posicionx1 = min + (max-min) * Math.random();
        double posiciony0 = min + (max-min) * Math.random();
        double posiciony1 = min + (max-min) * Math.random();

        //crear colores
        Color[] colores = {Color.red,Color.orange,Color.pink,Color.yellow,Color.cyan,Color.blue};

        //velocidad
        double velocidadx = Math.random() * 0.1; //se distribuye como velocidad x,y,random1,random2.
        double velocidady = Math.random() * 0.1;
        double velocidadRandom1 = Math.random() * 0.1;
        double velocidadRandom2 = Math.random() * 0.1;

        //dibujar

        while (true) {

            //COLISION

            //si cualquiera de los 2 puntos de x toca un borde, rebotará la posicion de x
            if (Math.abs(posicionx0 + velocidadx) > max || Math.abs(posicionx1 + velocidadx) > max ) {
                velocidadx = -velocidadx;   //velocidad x
            }
            //si cualquiera de las posiciones x0 o y0 tocan el borde, se cambia la veocidad random
            if (Math.abs(posicionx0 + velocidadRandom1) > max || Math.abs(posiciony0 + velocidadRandom1) > max ) {
                velocidadRandom1 = -velocidadRandom1;   //velocidad random 1
            }

            //si cualquiera de los 2 puntos de y toca un borde, rebotará la posicion de y
            if (Math.abs(posiciony0 + velocidady) > max || Math.abs(posiciony1 + velocidady) > max) {
                velocidady = -velocidady;   //velocidad y
            }
            //si cualquiera de las posiciones x1 o y1 tocan el borde, se cambia la veocidad random
            if (Math.abs(posicionx1 + velocidadRandom2) > max || Math.abs(posiciony1 + velocidadRandom2) > max) {
                velocidadRandom2 = -velocidadRandom2;   //velocidad random 2
            }

            //actualizar la posicion
            posicionx0 += velocidadx; //velocidad normal de x0
            posicionx1 += velocidadx; //velocidad normal de x1
            posiciony0 += velocidadRandom1; //velocidad aleatoria de y0
            posiciony1 += velocidadRandom2; //velocidad aleatoria de y1

            //limpiar la pantalla para efecto de movimiento
            StdDraw.clear();

            //se invoca el metodo para que entregue las posiciones
            lineasHechas(posicionx0, posicionx1,posiciony0,posiciony1,posiLineax0,posiLineax1,posiLineay0,posiLineay1);

            //se crean las 6 lineas con los colores diferentes
            for (int i = 0; i <5 ; i++) {
                StdDraw.setPenColor(colores[i]);
                StdDraw.line(posiLineax0[i], posiLineay0[i], posiLineax1[i],posiLineay1[i]);
            }

            StdDraw.pause(60);
            StdDraw.show();
        }




    }

}
