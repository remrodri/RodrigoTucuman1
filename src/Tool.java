class Tool {
    private String tipo;
    private String nombre;
    private String tipoNombre1;
    private String tipoNombre2;

    Tool(String tipo, String nombre, String tipoNombre1, String tipoNombre2) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.tipoNombre1 = tipoNombre1;
        this.tipoNombre2 = tipoNombre2;
    }

    String getNombre() {
        return nombre;
    }

    String getTipo() {
        return tipo;
    }

    String getTipoNombre1() {
        return tipoNombre1;
    }

    String getTipoNombre2() {
        return tipoNombre2;
    }
}
