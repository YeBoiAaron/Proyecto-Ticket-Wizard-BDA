/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.BoletoDTO;
import java.util.List;
import objetos.Boleto;

/**
 *
 * @author Aaron
 */
public interface IBoletosDAO {
    
    public Boleto agregarBoleto(BoletoDTO boleto);
    
    public Boleto actualizarBoleto(BoletoDTO boleto);
    
    public Boleto consultarBoletoId(int idBoleto);
    
    public List<Boleto> consultarBoletosUsuario(int idUsuario);
}
