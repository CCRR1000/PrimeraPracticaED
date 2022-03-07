
package gestionApuestas;

/**
 *
 * @author CIROSS
 */
public class Participante {
    
    private String nombre;
    private String monto;
    private int puntuacionFinal;
    private int[] orden;
    
    private Participante siguiente, anterior;
    

    public Participante() {
    }
    
    public Participante(String nombre, String monto, int[] orden) {
        this.nombre = nombre;
        this.monto = monto;
        this.orden = orden;
        puntuacionFinal = 0;
    }
    
    public Object[] getArray() {
        Object[] campos = new Object[13];
        campos[0] = this.nombre;
        campos[1] = this.monto;
        campos[12] = this.puntuacionFinal;
        
        for (int i = 2; i < (campos.length-1); i++) {
            campos[i] = orden[i-2];
        }
        
        return campos;
    }

    public Participante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Participante siguiente) {
        this.siguiente = siguiente;
    }

    public Participante getAnterior() {
        return anterior;
    }

    public void setAnterior(Participante anterior) {
        this.anterior = anterior;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public int[] getOrden() {
        return orden;
    }

    public void setOrden(int[] orden) {
        this.orden = orden;
    }

    public int getPuntuacionFinal() {
        return puntuacionFinal;
    }

    public void sumarPuntos(int puntos) {
        this.puntuacionFinal += puntos;
    }

    @Override
    public String toString() {
        return "Participante{ " + "nombre=" + this.nombre + ", monto=" + this.monto 
                + ", 1o=" + orden[0] + ", 2o=" + orden[1] + ", 3o=" + orden[2] 
                + ", 4o=" + orden[3] + ", 5o=" + orden[4] + ", 6o=" + orden[5] 
                + ", 7o=" + orden[6] + ", 8o=" + orden[7] + ", 9o=" + orden[8]
                + ", 10o=" + orden[9] + ", puntos=" + this.puntuacionFinal  + " }";
    }

    
    
}
