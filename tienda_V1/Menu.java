package tienda_V1;

import java.util.Scanner;

/**Clase que crea un menu
 * @author José Javier Herrera Torres
 *
 */
public class Menu {
    private static ColeccionLibros coleccionLibros = new ColeccionLibros(5);

    /**Método estatico que muestra el menu por pantalla para que el usuario pueda operar con el array de libros
     *
     */
    public static void mostrarMenu(){
        String opcion,codigo;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("""
                ---------------Tienda------------
                1.Insertar un libro.
                2.Eliminar un libro.
                3.Modificar un libro.
                4.Mostrar un libro.
                5.Mostar la posición de un libro por el código.
                6.Mostar todos los libros.
                7.Salir.
                -----------------------------------""");
            System.out.print("Introduce una opción: ");
            opcion = s.nextLine();

            switch (opcion){
                case "1":
                    coleccionLibros.insertar();
                    break;
                case "2":
                    coleccionLibros.eliminar();
                    break;
                case "3":
                    coleccionLibros.modificar();
                    break;
                case "4":
                    coleccionLibros.mostrarLibro();
                    break;
                case "5":
                    System.out.print("Introduce el codigo: ");
                    codigo = s.nextLine();
                    if (coleccionLibros.mostrarPosicion(codigo) == 0)
                        System.out.println("No tienes ningún libro con este código");
                    else
                        System.out.println("El libro esta en la posición " + coleccionLibros.mostrarPosicion(codigo));
                    break;
                case "6":
                    System.out.println(coleccionLibros);
                    break;
                case "7":
                    System.out.print("Adios");
                    break;
                default:
                    System.out.println("Error: Opción no válida");
            }
        }while (!opcion.equals("7"));
        System.exit(0);
    }
}
