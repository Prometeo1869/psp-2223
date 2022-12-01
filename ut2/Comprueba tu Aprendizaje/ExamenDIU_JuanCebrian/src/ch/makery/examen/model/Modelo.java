package ch.makery.examen.model;

import ch.makery.examen.model.repositoy.MyRepository;

import java.util.ArrayList;

public class Modelo {

    MyRepository rep;
    public MyRepository getRep() {
        return rep;
    }
    public void setRep(MyRepository rep) {
        this.rep = rep;
    }

    public ArrayList<ModeloVO> obtenerLista() throws MyException {
        return this.rep.ObtenerListaBD();
    }
}
