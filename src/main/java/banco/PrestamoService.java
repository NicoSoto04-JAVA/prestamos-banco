package banco;

public class PrestamoService {

    private ClienteRepository clienteRepository;

    public PrestamoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String registrarPrestamo(String clienteId, double monto,
                                    int plazoMeses, double cuotaMensual) {

        Cliente cliente = clienteRepository.buscarPorId(clienteId);

        if (cliente.getScoreCrediticio() < 600) {
            return "Préstamo rechazado: score crediticio insuficiente";
        }

        if (cliente.isTieneDeudas()) {
            return "Préstamo rechazado: el cliente tiene deudas pendientes";
        }

        return "Préstamo aprobado";
    }
}

