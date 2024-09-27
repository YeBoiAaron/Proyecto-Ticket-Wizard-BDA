/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.BoletoDTO;
import interfaces.IBoletoBO;
import interfaces.IBoletosDAO;
import java.util.ArrayList;
import java.util.List;
import objetos.Boleto;

/**
 *
 * @author Aaron
 */
public class BoletoBO implements IBoletoBO{
    
    private IBoletosDAO boletosDAO;

    public BoletoBO(IBoletosDAO boletosDAO) {
        this.boletosDAO = boletosDAO;
    }

    @Override
    public void agregarBoleto(BoletoDTO boleto) {
        boletosDAO.agregarBoleto(boleto);
    }

    @Override
    public void actualizarBoleto(BoletoDTO boleto) {
        boletosDAO.actualizarBoleto(boleto);
    }

    @Override
    public BoletoDTO consultarBoletoId(int idBoleto) {
        return convertirBoletoDTO(boletosDAO.consultarBoletoId(idBoleto));
    }

    @Override
    public List<BoletoDTO> consultarBoletosUsuario(int idUsuario) {
        List<BoletoDTO> consulta = new ArrayList<BoletoDTO>();
        if(boletosDAO.consultarBoletosUsuario(idUsuario) != null) {
            for (int i = 0; i < boletosDAO.consultarBoletosUsuario(idUsuario).size(); i++) {
                consulta.add(convertirBoletoDTO(boletosDAO.consultarBoletosUsuario(idUsuario).get(i)));
            }
            return consulta;
        }
        return null;
    }
    
    private BoletoDTO convertirBoletoDTO(Boleto boleto) {
        BoletoDTO boletoDTO = new BoletoDTO(boleto.getId_boleto(), 
                boleto.getId_evento(), 
                boleto.getId_usuario(), 
                boleto.getNumero_serie(), 
                boleto.getPrecio(), 
                boleto.getFila(), 
                boleto.getAsiento(), 
                boleto.isEs_reventa());
        return boletoDTO;
    }
    
}
