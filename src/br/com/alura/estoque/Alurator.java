package br.com.alura.estoque;

public class Alurator {
    private String pacoteBase;

    public Alurator(String pacoteBase) {

        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        // /produto/lista (método lista da class produtoController

        String[] partesUrl = url.replaceFirst("/", "")
                .split("/");

        String nomeControle = partesUrl[0] + "Controller";

        try {
            Class.forName(pacoteBase + nomeControle);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return null;
    }
}
