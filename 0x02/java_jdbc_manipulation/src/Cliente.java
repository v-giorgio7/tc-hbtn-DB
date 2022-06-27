public class Cliente {
    private Integer id;
    private String nome;
    private Integer idade;
    private String CPF;
    private String RG;

    public Cliente () {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return CPF;
    }
    public void setCpf(String Cpf) {
        this.CPF = Cpf;
    }
    public String getRg() {
        return RG;
    }
    public void setRg(String Rg) {
        this.RG = Rg;
    }
}
