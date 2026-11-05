public class registro {
    String fecha;
    String nombre;
    String provincia;
    Float tmin;
    Float tmax;
    String horaTmin;
    String horaTmax;

    String mesYano;

    public void calcularFecha(){
        mesYano = fecha.substring(0,5).concat(fecha.substring(5,7));
    }

    public registro(String fecha, String nombre, String provincia, Float tmin, Float tmax, String horaTmin, String horaTmax) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.provincia = provincia;
        this.tmin = tmin;
        this.tmax = tmax;
        this.horaTmin = horaTmin;
        this.horaTmax = horaTmax;
        calcularFecha();
    }

    public registro() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Float getTmin() {
        return tmin;
    }

    public void setTmin(Float tmin) {
        this.tmin = tmin;
    }

    public Float getTmax() {
        return tmax;
    }

    public void setTmax(Float tmax) {
        this.tmax = tmax;
    }

    public String getHoraTmin() {
        return horaTmin;
    }

    public void setHoraTmin(String horaTmin) {
        this.horaTmin = horaTmin;
    }

    public String getHoraTmax() {
        return horaTmax;
    }

    public void setHoraTmax(String horaTmax) {
        this.horaTmax = horaTmax;
    }

    public String getMesYano() {
        return mesYano;
    }

    public void setMesYano(String mesYano) {
        this.mesYano = mesYano;
    }

    @Override
    public String toString() {
        return "registro{" +
                "fecha='" + fecha + '\'' +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", tmin=" + tmin +
                ", tmax=" + tmax +
                ", horaTmin='" + horaTmin + '\'' +
                ", horaTmax='" + horaTmax + '\'' +
                ", mesYano='" + mesYano + '\'' +
                '}';
    }
}
