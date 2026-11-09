package ORG.IESCH.AD.demoCarga.servicios;

import ORG.IESCH.AD.demoCarga.modelo.Cliente;
import ORG.IESCH.AD.demoCarga.repositorio.ClienteRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static javax.print.attribute.standard.MediaSizeName.D;

@RequiredArgsConstructor
@Service        //Logica del negocio
public class ClienteServicio {

    @Transactional
    public void mostrarDatos(long id) {
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getId());
            System.out.println(cliente);
        }else {
            System.out.println("El cliente no existe");
        }

    }

    private final ClienteRepositorio clienteRepositorio;

    private static final Logger logger = LoggerFactory.getLogger(ClienteServicio.class);

    @Transactional
    public void mostrarTodos() {
        logger.trace("#".repeat(20));
        List<Cliente> clienteList = clienteRepositorio.findAll();
        for (Cliente cliente : clienteList){
            logger.trace("Cliente" + cliente.getId() + " " + cliente.getPedidos().size());
        }
        logger.trace("Sale de mostrar datos");
    }

    public void arregloN1() {
        List<Cliente> clienteList = clienteRepositorio.findAllConPedidos();
        System.out.println(clienteList);
    }
}
