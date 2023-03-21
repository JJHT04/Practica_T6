package tienda_V3;

import java.util.Scanner;

/**Clase que crea un menu
 * @author José Javier Herrera Torres
 *
 */
public class Menu {
    private static ColeccionLibros<Libro> coleccionLibros = new ColeccionLibros(5);

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
                        String autor,titulo,genero,numPaginas;
                        System.out.print("Introduce el código: ");
                        codigo = s.nextLine();
                        System.out.print("Introduce el autor: ");
                        autor = s.nextLine();
                        System.out.print("Introduce el título: ");
                        titulo = s.nextLine();
                        System.out.print("Introduce el género: ");
                        genero = s.nextLine();
                        do {
                            do {
                                System.out.print("Introduce el número de paginas: ");
                                numPaginas = s.nextLine();
                                if (!numPaginas.matches("^\\d+$"))
                                    System.out.println("Error: Valor no válido");
                            }while (!numPaginas.matches("^\\d+$"));
                            if (Integer.parseInt(numPaginas)<=0)
                                System.out.println("Error: El valor debe ser mayor que 0");
                        }while (Integer.parseInt(numPaginas)<=0);
                        coleccionLibros.insertar(new Libro(codigo,autor,titulo,genero,Integer.parseInt(numPaginas)));
                        System.out.println("Libro insertado correctamente");
                    break;
                case "2":
                    coleccionLibros.eliminar();
                    break;
                case "3":
                    String regex = "[1-" + coleccionLibros.size() + "]",i;
                    do {
                        System.out.print("Introduce que libro quieres Modificar" + regex + ": ");
                        i = s.nextLine();
                    }while (!i.matches(regex));

                    System.out.print("Introduce el código: ");
                    codigo = s.nextLine();
                    System.out.print("Introduce el autor: ");
                    autor = s.nextLine();
                    System.out.print("Introduce el título: ");
                    titulo = s.nextLine();
                    System.out.print("Introduce el género: ");
                    genero = s.nextLine();
                    do {
                        do {
                            System.out.print("Introduce el número de paginas: ");
                            numPaginas = s.nextLine();
                            if (!numPaginas.matches("^\\d+$"))
                                System.out.println("Error: Valor no válido");
                        }while (!numPaginas.matches("^\\d+$"));
                        if (Integer.parseInt(numPaginas)<=0)
                            System.out.println("Error: El valor debe ser mayor que 0");
                    }while (Integer.parseInt(numPaginas)<=0);
                    System.out.println("Libro modificado correctamente");
                    coleccionLibros.modificar(new Libro(codigo, autor, titulo, genero, Integer.parseInt(numPaginas)),Integer.parseInt(i)-1);
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
