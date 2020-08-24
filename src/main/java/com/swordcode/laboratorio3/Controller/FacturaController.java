package com.swordcode.laboratorio3.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.swordcode.laboratorio3.Cliente;
import com.swordcode.laboratorio3.ClienteRepository;
import com.swordcode.laboratorio3.Factura;
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
public class FacturaController {
    @Autowired
    private ClienteRepository       cRepository;

    @Autowired
    private OCFacturaRepository     ocRepository;

    @Autowired
	private FacturaRepository       fRepository;

	private Cliente					_faCliente;


    @RequestMapping("/presentarFacturas/{CLnumero}")
    public String presentFacturas(@PathVariable int CLnumero, Model model) {
		Cliente cliente = cRepository.findById(CLnumero).get();
		_faCliente = cliente;
        List<OCFactura> ocFacturas = ocRepository.findByCliente(cliente);

        List<Factura> facturas = new ArrayList<>();
        ocFacturas.forEach(oc-> facturas.add(oc.getFactura()));

        model.addAttribute("cliente", cliente);
        model.addAttribute("facturas", facturas);
        return "presentarFacturas";
    }

    @RequestMapping("/eliminarFactura/{FAnumero}")
    public String deleteFactura(@PathVariable int FAnumero, Model model) {
        Factura factura = fRepository.findById(FAnumero).get();
        OCFactura ocFactura = ocRepository.findByFactura(factura);
		Cliente cliente = ocFactura.getCliente();

		// Deleting entities
		ocRepository.delete(ocFactura);
		fRepository.delete(factura);

        model.addAttribute("FAnumero", FAnumero);
        model.addAttribute("CLnumero", cliente.getCLnumero());
        return "eliminarFactura";
	}

	@RequestMapping("/actualizarCrearFactura/{FAnumero}")
    public String updateFactura(@PathVariable int FAnumero, Model model) {
		Factura factura = null;
		Cliente cliente = null;
		if (FAnumero == 0 ) {
			factura = new Factura();
			cliente = _faCliente;
		} else {
			factura = fRepository.findById(FAnumero).get();
			OCFactura ocFactura = ocRepository.findByFactura(factura);
			cliente = ocFactura.getCliente();
		}	
		
		model.addAttribute("factura", factura);
		model.addAttribute("cliente", cliente);

		return "actualizarCrearFactura";
	}

	@RequestMapping("/salvarFactura")
	// , @ModelAttribute("cliente") Cliente cliente,
	public String saveFactura(@ModelAttribute("factura") Factura factura, Model model) {
		Cliente cliente = cRepository.findById(_faCliente.getCLnumero()).get();
		factura = fRepository.save(factura);

		// if (factura.getFAnumero() == 0) 
		ocRepository.save(new OCFactura(cliente, factura));
		model.addAttribute("FAnumero", factura.getFAnumero());
        model.addAttribute("CLnumero", cliente.getCLnumero());

		return "salvarFactura";
	}

	@ModelAttribute("faCliente")
	public Cliente getFaCliente() {
		return _faCliente;
	}
}