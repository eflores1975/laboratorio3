package com.swordcode.laboratorio3;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.math.BigDecimal;

@SpringBootApplication
public class Laboratorio3Application {

	public static void main(String[] args) {
		SpringApplication.run(Laboratorio3Application.class, args);
	}

	// Initialise data - Cliente - Facturas
	@Bean
	ApplicationRunner initCliente1(OCFacturaRepository repository, FacturaRepository fRepository, ClienteRepository cRepository) {
		final Cliente cliente = cRepository.save(new Cliente(110101, "Juan", "Perez", "Calle 12 Este, Edif. Doña Perla, Apto 12, Calidonia", "66120302", "Abogado"));
		String[][] facturas = {
			{"Samsung Electronics Panamá", "01/02/2020", "Lavadora", "5", "550.5", "206.44", "2958.93"},
			{"Samsung Electronics Panamá", "15/02/2020", "Celular", "1", "750.00", "56.25", "806.25"},
			{"Apple", "28/03/2020", "Tablet", "2", "550.00", "82.5", "1100.00"}
		};

		return args -> {			
			Stream.of(facturas).forEach(array -> {
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[1]);
					Factura factura = fRepository.save(new Factura(
						array[0], date, array[2], Integer.parseInt(array[3]), array[4], new BigDecimal(array[5]), new BigDecimal(array[6])
					));

					repository.save(new OCFactura(cliente, factura));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}				
			});
				repository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner initCliente2(OCFacturaRepository repository, FacturaRepository fRepository, ClienteRepository cRepository) {
		Cliente cliente = cRepository.save(new Cliente(10201, "Olmedo", "Jaen", "La Rotonda, Las Cumbres casa #12", "3201178", "Vendedor de autos"));
		String[][] facturas = {
			{"Sankey", "12/03/2020", "TV LCD 47 pulg", "1", "1", "33.75", "450.00"},
			{"LG", "12/03/2020", "A/C 9000 BTU Modelo XYZ", "2", "2", "112.5", "1500.00"},
			{"LG", "17/03/2020", "Tablet", "2", "1", "82.5", "1100.00"},
			{"Pioneer", "01/04/2020", "Audio Auto modelo ABC", "1", "3", "15.52", "207.00"},
			{"Bose", "15/05/2020", "Audifonos 700", "1", "4", "22.42", "299.00"}
		};

		return args -> {			
			Stream.of(facturas).forEach(array -> {
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(array[1]);
					Factura factura = fRepository.save(new Factura(
						array[0], date, array[2], Integer.parseInt(array[3]), array[4], new BigDecimal(array[5]), new BigDecimal(array[6])
					));

					repository.save(new OCFactura(cliente, factura));
				} catch (ParseException pe) {
					pe.printStackTrace();
				}				
			});
				repository.findAll().forEach(System.out::println);
		};
	}
}