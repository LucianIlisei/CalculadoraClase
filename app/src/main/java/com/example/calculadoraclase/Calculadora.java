package com.example.calculadoraclase;

public class Calculadora {
    private static final Calculadora instancia = new Calculadora();

    private String contenido;
    private double memoria;
    private char operacion;

    public String getContenido() {
        return contenido;
    }

    private Calculadora() {
        this.contenido = "";
    }

    public static Calculadora getInstance() {
        return instancia;
    }

    public void añadirNumero(int numero) {
        this.contenido += numero;
    }

    public void añadirPunto() {
        if(!this.contenido.contains(".")) {
            this.contenido += ".";
        }
    }

    public void operacion(char operacion) {
        if (this.contenido.isEmpty()) return;

        this.operacion = operacion;
        this.memoria = Double.parseDouble(this.contenido);
        this.contenido = "";
    }

    public void igual () {
        double segundo;
        if (this.contenido.isEmpty()) {
            return;
        }
        try {
            segundo = Double.parseDouble(this.contenido);
        } catch (NumberFormatException e) {
            this.contenido = "Error";
            return;
        }

        switch (this.operacion) {
            case '+':
                this.contenido = formatear(this.memoria + segundo);
                break;
            case '-':
                this.contenido = formatear(this.memoria - segundo);
                break;
            case '*':
                this.contenido = formatear(this.memoria * segundo);
                break;
            case '/':
                if (segundo == 0) {
                    this.contenido = "∞";
                } else {
                    this.contenido = String.valueOf(this.memoria / segundo);
                }
                break;
            default:
                return;
        }

        try {
            this.memoria = Double.parseDouble(this.contenido);
        } catch (NumberFormatException e) {
            this.memoria = 0.0;
        }

        this.operacion = ' ';
    }

    private String formatear(double resultado) {
        if (resultado == Math.rint(resultado)) {
            return String.valueOf((int) resultado);
        }
        return String.valueOf(resultado);
    }

    public void limpiar() {
        this.contenido = "";
        this.memoria = 0.0;
        this.operacion = ' ';
    }
}
