package br.com.cammarota.alex.ifittrack.usecase.enums;

public enum Sexo {

    MASCULINO('M'),
    FEMININO('F');

    private final Character genero;

    Sexo(Character valor) {
        this.genero = valor;
    }

    public Character getGenero() {
        return genero;
    }

    public static Sexo fromCharacter(Character genero) {
        for (Sexo type : values()) {
            if (type.getGenero() == genero) {
                return type;
            }
        }
        return null;
    }
}
