package banco;

public class PrestamoService {

    private ClienteRepository clienteRepository;

    public PrestamoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String registrarPrestamo(String clienteId, double monto,
                                    int plazoMeses, double cuotaMensual) {

        Cliente cliente = clienteRepository.buscarPorId(clienteId);

        if (!tieneScoreSuficiente(cliente)) {
            return "Préstamo rechazado: score crediticio insuficiente";
        }

        if (tieneDeudas(cliente)) {
            return "Préstamo rechazado: el cliente tiene deudas pendientes";
        }

        return "Préstamo aprobado";
    }

    private boolean tieneScoreSuficiente(Cliente cliente) {
        return cliente.getScoreCrediticio() >= 600;
    }

    private boolean tieneDeudas(Cliente cliente) {
        return cliente.isTieneDeudas();
    }
}