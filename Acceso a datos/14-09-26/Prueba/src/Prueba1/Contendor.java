package Prueba1;

public class Contendor <T>{
    private T objecto;

    public Contendor(T objecto) {
        this.objecto = objecto;
    }

    public T getObjecto() {
        return objecto;
    }

    public void setObjecto(T objecto) {
        this.objecto = objecto;
    }
}
