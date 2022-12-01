package ch.makery.examen.model.repositoy;

import ch.makery.examen.model.ModeloVO;

import java.util.ArrayList;

public interface MyRepository {
    ArrayList<ModeloVO> ObtenerListaBD();
}
