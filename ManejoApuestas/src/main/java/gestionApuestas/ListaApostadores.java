
package gestionApuestas;

/**
 *
 * @author CIROSS
 */
public class ListaApostadores {
    
    private Participante raiz, ultimo;
    private int totalParticipantes;
    
    public ListaApostadores() {
        raiz = null;
        ultimo = null;
        totalParticipantes = 0;
    }
    
    public void agregar(Participante nuevoP) {
        
        if (raiz==null) {
            nuevoP.setAnterior(null);
            nuevoP.setSiguiente(null);
            raiz = nuevoP;
            ultimo = nuevoP;
            
        } else {
            ultimo.setSiguiente(nuevoP);
            nuevoP.setAnterior(ultimo);
            nuevoP.setSiguiente(null);
            ultimo = nuevoP;
        }
        
        totalParticipantes++;
    }
    
    public void insertarAntes(Participante insertar, Participante antesDe) {
        
        if (antesDe.equals(this.raiz)) {
            this.setRaiz(insertar);
        } 
        
        insertar.getAnterior().setSiguiente(insertar.getSiguiente());
        insertar.getSiguiente().setAnterior(insertar.getAnterior());
        
        insertar.setSiguiente(antesDe);
        insertar.setAnterior(antesDe.getAnterior());
        antesDe.setAnterior(insertar);
    }

    public void insertarDespues(Participante insertar, Participante despuesDe) {
        
        if (despuesDe.equals(this.ultimo)) {
            this.setUltimo(insertar);
        } 
        
        insertar.getAnterior().setSiguiente(insertar.getSiguiente());
        insertar.getSiguiente().setAnterior(insertar.getAnterior());
        
        insertar.setSiguiente(despuesDe.getSiguiente());
        insertar.setAnterior(despuesDe);
        despuesDe.setSiguiente(insertar);
    }

    public void listar() {
        Participante part = getRaiz();
        imprimir(part);
    }
    
    public void imprimir(Participante p) {
        if (p != null) {
            System.out.println(p.toString());
            imprimir(p.getSiguiente());
        } 
    }
    public Participante getRaiz() {
        return raiz;
    }

    public void setRaiz(Participante raiz) {
        this.raiz = raiz;
    }

    public Participante getUltimo() {
        return ultimo;
    }

    public void setUltimo(Participante ultimo) {
        this.ultimo = ultimo;
    }

    public int getTotalParticipantes() {
        return totalParticipantes;
    }

    public void setTotalParticipantes(int totalParticipantes) {
        this.totalParticipantes = totalParticipantes;
    }
    
}
