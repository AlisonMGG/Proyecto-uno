
package proyecto.pkg1.b4;

import java.util.Scanner;


public class Proyecto1B4 {

    
    public static void main(String[] args) {
       
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        Mascota datos[] = new Mascota[15];
        
         int op = 0;
        while (op != 5) {
            System.out.println(" ");
            System.out.println("-------Menu--------");

            System.out.println("1. nueva mascota");
            System.out.println("2. ver todas las mascotas");
            System.out.println("3. buscar mascota");
            System.out.println("4. modificar mascota");
            System.out.println("5. Salir");
            System.out.println("--------------------");
            System.out.println(" ");
            System.out.println("ingrese el numero de opcion");
            System.out.println(" ");
            op = teclado.nextInt();
            System.out.println(" ");
            
            
            
             if (op == 1) {
                System.out.println("--------------------");
                System.out.println("Ingrese el numero de Id");
                int id = teclado.nextInt();
                System.out.println("Ingrese el nombre");
                String nombre = letras.nextLine();
                System.out.println("Igresa el tipo de mascota");
                String tipo = letras.nextLine();
                System.out.println(nuevoMascota(id, nombre, tipo, datos));
                System.out.println("--------------------");

            } else if (op == 2) {
                System.out.println(imprimirTodo(datos));
            } else if (op == 3) {

                System.out.println("Ingrese el Id ");
                int id = teclado.nextInt();

                System.out.println(buscarMascota(id, datos));
            } else if (op == 4) {
                System.out.println("Ingrese el Id de la mascota a modificar");
                int id = teclado.nextInt();

                if (buscarMascotaBooleano(id, datos)) {
                    System.out.println("Ingrese el nuevo Nombre de la mascota");
                    String nombre = letras.nextLine();
                    System.out.println("Ingrese el nuevo tipo de la mascota");
                    String tipo = letras.nextLine();
                    System.out.println(modificarDatos(id, nombre, tipo, datos));
                } else {
                    System.out.println("El Id no existe en el registro de datos");
                }
            }

        }
    }

    public static String nuevoMascota(int id, String nombre, String tipo, Mascota arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new Mascota(id, nombre, tipo);
                lleno = false;
                break;
            } else if (arreglo[i].getId()== id) {
                System.out.println("  ");
                return "Ya existe el Id";

            }
        }

        if (!lleno) {

            return "\n Se guardo con exito \n";

        } else {
            return "Ya no hay espacio";

        }
    }

    public static String imprimirTodo(Mascota arreglo[]) {

        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
//            if (arreglo[i] == null) {
//                cadena = cadena + arreglo[i].getClave() + " | " + arreglo[i].getNombre() + " | " + arreglo[i].getGrado() + "\n";

            if (arreglo[i] != null) {
                 cadena = cadena+ "Su Id es " + arreglo[i].getId()+ ",se llama " + arreglo[i].getNombre() + " y es de tipo " + arreglo[i].getTipo()+ "\n";



            }

        }
        return cadena;
    }

    public static String buscarMascota(int id, Mascota arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getId() == id) {

                return "\n Los datos son \n Id: " + arreglo[i].getId() + "\n nombre: " + arreglo[i].getNombre() + "\n Tipo: " + arreglo[i].getTipo();

            }
        }
        return "No existe el Id ingresado";
    }

    public static boolean buscarMascotaBooleano(int clave, Mascota arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getId() == clave) {
                return true;
            }

        }
        return false;
    }

    public static String modificarDatos(int clave, String nombre, String grado, Mascota arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getId() == clave) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setTipo(grado);
                return "\n Se guardo exitosamente \n";
            }
        }
        return " ";
            
          
    }
    
}
