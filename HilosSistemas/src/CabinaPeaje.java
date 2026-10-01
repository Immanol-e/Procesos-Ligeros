import java.util.Random;

// Alumno: Immanol Dagoberto Espinoza Mendoza

public class CabinaPeaje implements Runnable {
    public static int totalRecaudadoGlobal = 0;

    private String nombre;
    private int vehiculosAtendidos;
    private int vehiculosPorAtender;
    private Random random = new Random();

    public CabinaPeaje(String nombre, int vehiculosPorAtender) {
        this.nombre = nombre;
        this.vehiculosPorAtender = vehiculosPorAtender;
        this.vehiculosAtendidos = 0;
    }

    @Override
    public void run() {
        for (int i = 1; i <= vehiculosPorAtender; i++) {
            try {
                int tiempo = 500 + random.nextInt(1001);
                System.out.println(nombre + " cobrando al vehiculo " + i + " (" + tiempo + " ms)");
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpida");
            }

            vehiculosAtendidos++;
            totalRecaudadoGlobal += 50;
            System.out.println(nombre + " termino con el vehiculo " + i);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }
}