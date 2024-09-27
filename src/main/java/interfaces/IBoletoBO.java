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
public interface IBoletoBO {
    public void agregarBoleto(BoletoDTO boleto);
    
    public void actualizarBoleto(BoletoDTO boleto);
    
    public BoletoDTO consultarBoletoId(int idBoleto);
    
    public List<BoletoDTO> consultarBoletosUsuario(int idUsuario);
}
