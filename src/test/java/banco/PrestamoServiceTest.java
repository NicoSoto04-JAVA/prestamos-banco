package banco;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private PrestamoService prestamoService;


    @Test
    void testRechazar_scoreBajo() {
        Cliente cliente = new Cliente("C001", 550, 3000.0, false);
        when(clienteRepository.buscarPorId("C001")).thenReturn(cliente);

        String resultado = prestamoService.registrarPrestamo("C001", 5000.0, 12, 500.0);

        assertEquals("Préstamo rechazado: score crediticio insuficiente", resultado);
    }


    @Test
    void testRechazar_clienteConDeudas() {
        Cliente cliente = new Cliente("C002", 700, 4000.0, true);
        when(clienteRepository.buscarPorId("C002")).thenReturn(cliente);

        String resultado = prestamoService.registrarPrestamo("C002", 5000.0, 12, 500.0);

        assertEquals("Préstamo rechazado: el cliente tiene deudas pendientes", resultado);
    }
}
