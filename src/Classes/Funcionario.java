package Classes;

public class Funcionario {

    private String nome;
    private String codigo;
    private String senha;

    private double salario;

    public Funcionario(String nome, double salario, String codigo, String senha) {
        FuncionarioDAO funcionarioNovo;
        setNome(nome);
        setSalario(salario);
        setCodigo(codigo);
        setSenha(senha);
        funcionarioNovo = new FuncionarioDAO();
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
