
public class SimuladorPeaje {

    public static void main(String[] args) {
        int totalVehiculos = 30;
        int numCabinas = 3;

        CabinaPeaje[] cabinas = new CabinaPeaje[numCabinas];
        Thread[] hilos = new Thread[numCabinas];

        for (int i = 0; i < numCabinas; i++) {
            int vehiculos = totalVehiculos / numCabinas;
            if (i < totalVehiculos % numCabinas) {
                vehiculos++;
            }

            String nombre;
            if (i == 0) {
                nombre = "Cabina Espinoza";
            } else {
                nombre = "Cabina " + (i + 1);
            }

            cabinas[i] = new CabinaPeaje(nombre, vehiculos);
            hilos[i] = new Thread(cabinas[i]);
        }

        System.out.println("ABRIENDO ESTACION DE PEAJE");
        for (int i = 0; i < numCabinas; i++) {
            hilos[i].start();
        }

        for (int i = 0; i < numCabinas; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                System.out.println("Error esperando a " + cabinas[i].getNombre());
            }
        }

        System.out.println();
        System.out.println("REPORTE FINAL ");
        for (int i = 0; i < numCabinas; i++) {
            System.out.println(cabinas[i].getNombre() + ": " + cabinas[i].getVehiculosAtendidos() + " vehiculos atendidos");
        }
        System.out.println("Total recaudado (esperado): $" + (totalVehiculos * 50));
        System.out.println("Total recaudado global: $" + CabinaPeaje.totalRecaudadoGlobal);
        System.out.println("=====================================");
    }
}