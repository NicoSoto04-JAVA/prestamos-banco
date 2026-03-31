package banco;

public class PrestamoService {

    private ClienteRepository clienteRepository;

    public PrestamoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String registrarPrestamo(String clienteId, double monto,
                                    int plazoMeses, double cuotaMensual) {
        return "";
    }
}

