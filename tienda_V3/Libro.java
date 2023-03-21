package tienda_V3;

/**Clase que almacena los datos de un libro
 * @author José Javier Herrera Torres
 *
 */
public class Libro {
    private String codigo,autor,titulo,genero;
    private int numPaginas;

    /**Constructor de la clase libro que inicializa todos los atributos con los parámetros que se le pase
     * @param codigo cadena de caracteres pasada como parámetro
     * @param autor cadena de caracteres pasada como parámetro
     * @param titulo cadena de caracteres pasada como parámetro
     * @param genero cadena de caracteres pasada como parámetro
     * @param numPaginas número entero pasada como parámetro
     */
    public Libro(String codigo, String autor, String titulo, String genero, int numPaginas){
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.numPaginas = numPaginas;
    }

    /**Método que devuelve el atributo codigo del objeto
     * @return devuelve una cadena de caracteres
     */
    public String getCodigo() {
        return codigo;
    }

    /**Método que cambia el atributo codigo del objeto al pasado como parámetro
     * @param codigo cadena de caracteres pasada como parámetro
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**Método que devuelve el atributo Autor del objeto
     * @return devuelve una cadena de caracteres
     */
    public String getAutor() {
        return autor;
    }

    /**Método que cambia el atributo autor del objeto al pasado como parámetro
     * @param autor cadena de caracteres pasada como parámetro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**Método que devuelve el atributo título del objeto
     * @return devuelve una cadena de caracteres
     */
    public String getTitulo() {
        return titulo;
    }

    /**Método que cambia el atributo titulo del objeto al pasado como parámetro
     * @param titulo cadena de caracteres pasada como parámetro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**Método que devuelve el atributo género del objeto
     * @return devuelve una cadena de caracteres
     */
    public String getGenero() {
        return genero;
    }

    /**Método que cambia el genero codigo del objeto al pasado como parámetro
     * @param genero cadena de caracteres pasada como parámetro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**Método que devuelve el atributo numPaginas del objeto
     * @return devuelve un número entero
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**Método que cambia el atributo numPaginas del objeto al pasado como parámetro
     * @param numPaginas número entero pasada como parámetro
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**Método que devuelve el objeto como una cadena de caracteres
     * @return devuelve una cadena de caracteres
     */
    @Override
    public String toString() {
        return "-----------" + this.titulo + "-----------\n\t" + "Código: " + this.codigo + "\n\t" + "Autor: " +this.autor
                + "\n\t" + "Genero: " +this.genero + "\n\t" + "Número de páginas: " +this.numPaginas + "\n------------------------------";
    }
}
