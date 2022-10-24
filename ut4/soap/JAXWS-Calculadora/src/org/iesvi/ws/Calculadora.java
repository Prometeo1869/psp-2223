package org.iesvi.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculadora {
    //Exponemos métodos para que sea accesible

    @WebMethod
    public double operacion(int opcion, int valor1, int valor2);

}
