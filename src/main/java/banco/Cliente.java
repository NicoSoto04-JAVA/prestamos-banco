package banco;

public class Cliente {
    private String id;
    private int scoreCrediticio;
    private double ingreso;
    private boolean tieneDeudas;

    public Cliente(String id, int scoreCrediticio, double ingreso, boolean tieneDeudas) {
        this.id = id;
        this.scoreCrediticio = scoreCrediticio;
        this.ingreso = ingreso;
        this.tieneDeudas = tieneDeudas;
    }

    public String getId() { return id; }
    public int getScoreCrediticio() { return scoreCrediticio; }
    public double getIngreso() { return ingreso; }
    public boolean isTieneDeudas() { return tieneDeudas; }
}

