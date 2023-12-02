package Classes;


public class Autor {

    private int id;
    private String pseudonimo;
    private String nacionalidade;
    private String nascimento;

    public Autor(
            int id,
            String pseudonimo,
            String nacionalidade,
            String nascimento
    ) {
        setId(id);
        setPseudonimo(pseudonimo);
        setNacionalidade(nacionalidade);
        setNascimento(nascimento);
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
