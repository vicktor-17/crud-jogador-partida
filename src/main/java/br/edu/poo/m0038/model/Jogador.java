package br.edu.poo.m0038.model;

public class Jogador {

    private int id;
    private String nome;
    private String email;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Jogador() {
    }

    public Jogador(String nome, String email, String cep) {
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }

    // Validações básicas: lança erro se algum dado estiver inválido
    public void validar() {
        if (nome == null || nome.trim().length() < 2) {
            throw new IllegalArgumentException("Nome deve ter pelo menos 2 letras.");
        }
        if (email == null || !email.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP deve ter 8 números, sem traço.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " | " + email + " | CEP " + cep
                + " | " + logradouro + ", " + bairro + " - " + cidade + "/" + uf;
    }
}