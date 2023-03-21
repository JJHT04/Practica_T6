package tienda_V1;

import java.util.Scanner;

/**Clase CRUD que opera con un array de libros
 * @author José Javier Herrera Torres
 *
 */
public class ColeccionLibros {
    private Libro[] libros;
    private int index;

    /**Constructor de la clase que crea el array de libros con el tamaño pasado como parámetro
     * @param size de tipo entero
     */
    public ColeccionLibros(int size){
        this.libros = new Libro[size];
        this.index = 0;
    }

    /**Método que inserta Libros en el array de libros siempre que haya espacio, si no hay espacio muestra un mensaje
     * @return no devuelve nada
     */
    public void insertar(){
        if (this.index<this.libros.length) {
            String codigo,autor,titulo,genero,numPaginas;
            Scanner s = new Scanner(System.in);
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
            this.libros[index++] = new Libro(codigo, autor, titulo, genero, Integer.parseInt(numPaginas));
            System.out.println("Libro insertado correctamente");
        }else
            System.out.println("Lo siento la colección esta llena");
    }

    /**Método que elimina un libro del array, si no hay libros en el array muestra un mensaje, si solo hay uno preguntara al usuario
     * si esta seguro que quiere eliminarlo, si hay más de uno se le preguntara al usuario cual quiere eliminar, si introduce
     * el ultimo añadido se elimina, si no elige el último se reordenará el array
     * @return no devuelve nada
     */
    public void eliminar(){
        Scanner s = new Scanner(System.in);
        if (this.index>1){
            String regex = "[1-" + this.index + "]",i;
            do {
                System.out.print("Introduce que libro quieres borrar" + regex + ": ");
                i = s.nextLine();
            }while (!i.matches(regex));

            String titulo = this.libros[Integer.parseInt(i)-1].getTitulo();
                Libro tmp;
                index--;
                for (int j = Integer.parseInt(i) - 1; j < this.index; j++) {
                    tmp = this.libros[j];
                    this.libros[j] = this.libros[j+1];
                    this.libros[j+1] = tmp;
                }
            System.out.println(titulo + " borrado correctamente");
        }else if (this.index==1){
            String n;
            do {
                System.out.print("Estas seguro que quieres borrar el único libro[s/n]: ");
                n = s.nextLine();
                if(!n.equalsIgnoreCase("s") && !n.equalsIgnoreCase("n"))
                	System.out.println("Introduce n/N(no) o s/S(sí)");
            }while (!n.equalsIgnoreCase("s") && !n.equalsIgnoreCase("n"));

            if (n.equalsIgnoreCase("s")){
                String titulo = this.libros[0].getTitulo();
                this.index--;
                System.out.println(titulo + " borrado correctamente");
            }else
                System.out.println("No se ha borrado el libro");
        }else {
            System.out.println("No tienes ningún libro");
        }
    }

    /**Método que modifica un libro del array, si no hay libros mostrará un mensaje, si solo hay un libro se modificará ese
     * libro, si hay más de uno se le preguntará al usuario cuál quiere modificar
     * @return no devuelve nada
     */
    public void modificar(){
        Scanner s = new Scanner(System.in);
        String codigo,autor,titulo,genero,numPaginas;
        if (this.index>1){
            String regex = "[1-" + this.index + "]",i;
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
            this.libros[Integer.parseInt(i)-1] = new Libro(codigo, autor, titulo, genero, Integer.parseInt(numPaginas));
            System.out.println("Libro modificado correctamente");

        }else if (this.index==1){
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

            this.libros[0] = new Libro(codigo, autor, titulo, genero, Integer.parseInt(numPaginas));
            System.out.println("Libro modificado correctamente");
        }else {
            System.out.println("No tienes ningún libro");
        }
    }

    /**Método que devuelve el tamaño del array de libros
     * @return devuelve un entero
     */
    public int size(){
        return this.index;
    }

    /**Método que muestra por pantalla un libro del array, si no hay libros se mostrarán un mensaje,
     * si solo hay uno se mostrará ese libro, si hay más se le preguntará al usuario cuál libro quiere ver
     * @return no devuelve nada
     */
    public void mostrarLibro(){
        if (this.index>1){
            String regex = "[1-" + this.index + "]",i;
            Scanner s = new Scanner(System.in);
            do {
                System.out.print("Introduce que libro quieres mostrar" + regex + ": ");
                i = s.nextLine();
            }while (!i.matches(regex));

            System.out.println(this.libros[Integer.parseInt(i)]);
        }else if (this.index==1){
            System.out.println(this.libros[0]);
        }else {
            System.out.println("No tienes ningún libro");
        }
    }

    /**Método que devuelve la posición de un libro del array que coincida con el código pasado como parámetro,
     * si hay más de uno con el mismo código se devolverá la última posición donde se encontró, si no se encuentra devuelve 0
     * @param codigo cadena de caracteres pasada como parámetro
     * @return devuleve un número entero
     */
    public int mostrarPosicion(String codigo){
        if (this.index>=1) {
            int posicion = 0;
            for (int i = 0; i < this.index; i++) {
                if (this.libros[i].getCodigo().equals(codigo)) {
                    posicion = i+1;
                }
            }
            return posicion;
        }else {
            return 0;
        }
    }

    /**Método que devuelve el array como una cadena de caracteres
     * @return devuelve una cadena de caracteres
     */
    @Override
    public String toString() {
        if (this.index!=0){
            StringBuilder sb = new StringBuilder("----------Libros----------\n\n\t");
            for (int i = 0; i < this.index; i++) {
                sb.append(this.libros[i].toString()).append("\n\t");
            }
            sb.append("\n-----------------------");
            return String.valueOf(sb);
        }else
            return "No tienes ningún libro";
    }
}
