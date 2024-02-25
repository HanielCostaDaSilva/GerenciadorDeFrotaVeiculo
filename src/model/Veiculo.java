package model;

public class Veiculo implements Comparable<Veiculo>{

    private TipoModelo marca;
    private String modelo;
    private double autonomia;
    private TipoMotorizacao tipoMotorização;
    private double tanqueLimite;
    private double combustivelDisponivel;

    public Veiculo(
                TipoModelo marca,
            String modelo,
            double autonomia,
            TipoMotorizacao tipoMotorização,
            double tanqueLimite,
            double combustivelDisponivel) throws Exception {

        this.marca = marca;
        this.setModelo(modelo);
        this.autonomia = autonomia;
        this.tipoMotorização = tipoMotorização;
        this.tanqueLimite = tanqueLimite;
        this.combustivelDisponivel = combustivelDisponivel;
    }

    public String toString(){
        return " marca: " + this.marca+ " modelo: "  + modelo+ " autonomia: "  + autonomia+ " tipo de motorização: "  + tipoMotorização+ " limite do tanque: "  + tanqueLimite+ " combustivel disponivel: "  + combustivelDisponivel;
    }

    @Override
    public int compareTo(Veiculo outroVeiculo) {
        // Ordena os veículos com base na autonomia, do maior para o menor
        return Double.compare(outroVeiculo.getAutonomia(), this.getAutonomia());
    }
    /**
     * @return String return the marca
     */
    public TipoModelo getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(TipoModelo marca) {
        this.marca = marca;
    }

    /**
     * @return String return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) throws Exception{
        if (marca.ehModeloValido(modelo)) {
            this.modelo = modelo;
        } else {
            throw new Exception("Modelo: "+ modelo +" não pertencente a marca: "+this.marca + ".");
        }
    }

    /**
     * @return String return the autonomia
     */
    public double getAutonomia() {
        return autonomia;
    }

    /**
     * @param autonomia the autonomia to set
     */
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    /**
     * @return String return the tipoMotorização
     */
    public TipoMotorizacao getTipoMotorização() {
        return tipoMotorização;
    }

    /**
     * @param tipoMotorização the tipoMotorização to set
     */
    public void setTipoMotorização(TipoMotorizacao tipoMotorização) {
        this.tipoMotorização = tipoMotorização;
    }


    /**
     * @return double return the tanqueLimite
     */
    public double getTanqueLimite() {
        return tanqueLimite;
    }

    /**
     * @param tanqueLimite the tanqueLimite to set
     */
    public void setTanqueLimite(double tanqueLimite) {
        this.tanqueLimite = tanqueLimite;
    }

    /**
     * @return double return the combustivelDisponivel
     */
    public double getCombustivelDisponivel() {
        return combustivelDisponivel;
    }

    /**
     * @param combustivelDisponivel the combustivelDisponivel to set
     */
    public void setCombustivelDisponivel(double combustivelDisponivel) {
        this.combustivelDisponivel = combustivelDisponivel;
    }

}
