package org.tallerjava.moduloGestion.infraestructura.persistencia;

import org.tallerjava.moduloGestion.dominio.*;
import org.tallerjava.moduloGestion.dominio.repo.UsuarioRepositorio;
import org.tallerjava.moduloPeaje.dominio.Identificador;

import java.util.ArrayList;
import java.util.List;


public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    @Override
    public Usuario findByTag(int tag) {
        PrePaga prePaga = new PrePaga(1000);
        ClienteTelepeaje cliTelepeaje = new ClienteTelepeaje(prePaga, null);
        List<Vehiculo> listVehiculos = new ArrayList<>();
        Identificador identificador = new Identificador(1, "BAA 2222", 2001);
        listVehiculos.add(new Vehiculo(1, identificador, cliTelepeaje));
        Usuario usuario = new
                Nacional(1, "pepe","pepe@gmail.com",listVehiculos, cliTelepeaje);

        return usuario;
    }

}
