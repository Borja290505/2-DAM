package iesch.org.servicio;

import iesch.org.modelo.Cliente;
import iesch.org.modelo.Coche;
import iesch.org.repositorio.ClienteRepositorio;
import iesch.org.repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ConsultaServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private CocheRepositorio cocheRepositorio;

    public List<Cliente> clientesPorColor(String color){
        return clienteRepositorio.findDistincByCochesColorIgnoreCase(color);
    }

    public List<Cliente> clientesPorPrecioMayorQue(BigDecimal precio){
        return clienteRepositorio.findDistincByCochesPrecioGreaterThan(precio);
    }

    public  Cliente clienteConMasCoches(){
        return clienteRepositorio.clienteConMasCoches();

    }
}
