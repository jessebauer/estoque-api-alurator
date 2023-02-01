package br.com.alura.estoque;

public class Alurator {
    private String pacoteBase;

    public Alurator(String pacoteBase) {

        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        // /produto/lista (método lista da class produtoController

        String[] partesUrl = url.replaceFirst("/", "").split("/");

        String nomeControle = Character.toUpperCase(partesUrl[0].charAt (0)) + partesUrl[0].substring(1) + "Controller";

        try {
            Class<?> classeControle = Class.forName(pacoteBase + nomeControle);
            Object instanciaControle = classeControle.newInstance();

            System.out.println(instanciaControle);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}