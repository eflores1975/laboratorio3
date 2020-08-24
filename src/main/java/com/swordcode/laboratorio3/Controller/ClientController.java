package com.swordcode.laboratorio3.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.swordcode.laboratorio3.Cliente;
import com.swordcode.laboratorio3.ClienteRepository;
import com.swordcode.laboratorio3.FacturaRepository;
import com.swordcode.laboratorio3.OCFactura;
import com.swordcode.laboratorio3.OCFacturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClientController {
    @Autowired
    private ClienteRepository       cRepository;

    @Autowired
    private OCFacturaRepository     ocRepository;

    @Autowired
    private FacturaRepository       fRepository;


    @RequestMapping("/presentarCliente")
    // public String showCustomer(@RequestParam("searchTerm")String searchTerm, Model model) {
    public String showCustomer(Model model) {
        Iterable<Cliente> it = cRepository.findAll();
        List<Cliente> clientes = new ArrayList<>();
        // it.forEach(clientes::add);
        Iterator<Cliente> iterator = it.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = (Cliente)iterator.next();
            List<OCFactura> ocList = ocRepository.findByCliente(cliente);
            cliente.setCLtotalFacturas(ocList.size());
            clientes.add(cliente);
        }

        model.addAttribute("clientes", clientes);
        return "presentarCliente";
    }

	@RequestMapping("/actualizarCliente")
    public String updateCustomer(@RequestParam(value = "deleteCLnumero", defaultValue = "0")int deleteCLnumero, @RequestParam(value = "updateCLnumero", defaultValue = "0")int updateCLnumero, Model model) {		
        Cliente cliente = null;
        String result = "";
		if (deleteCLnumero != 0) {
			cliente = cRepository.findById(deleteCLnumero).get();
			String customerFullName = String.format("%s %s", cliente.getCLnombre(), cliente.getCLapellido());
			List<OCFactura> ocList = ocRepository.findByCliente(cliente);
			for (OCFactura ocFactura : ocList) {
				ocRepository.delete(ocFactura);
				fRepository.delete(ocFactura.getFactura());
			}
			cRepository.delete(cliente);
			model.addAttribute("customerFullName", customerFullName);
			result = "eliminarCliente";
		} else {
			if (updateCLnumero != 0) {
				cliente = cRepository.findById(updateCLnumero).get();
				model.addAttribute("cliente", cliente);
				model.addAttribute("title", "Actualizar cliente");
			} else {
				cliente = new Cliente();
				model.addAttribute("cliente", cliente);
				model.addAttribute("title", "Crear cliente");
			}				
			result = "actualizaCrearCliente";
		}

		return result;
	}

	@PostMapping("/salvarCliente")
	public String displayTemperature(@ModelAttribute("cliente") Cliente cliente, Model model) {
		System.out.println("Cliente actualizando es " + cliente.getCLnombre());
		cRepository.save(cliente);
		return "clienteActualizado";
	}
}