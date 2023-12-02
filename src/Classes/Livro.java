package Classes;

import Classes.Autor;
import Classes.AutorDAO;
import Classes.LivroDAO;

public class Livro {

    private int id;
    private String titulo;
    private boolean situacao;
    private String lancamento;
    private String editora;
    private String genero;
    private int num_paginas;
    private String idioma_original;
    private String idioma_atual;
    public int id_autor;
    public int id_funcionario;
    Autor autor;

    public Livro(String titulo, boolean situacao, String lancamento, String editora, String genero, int num_paginas, String idioma_original, String idioma_atual, int id_autor, String pseudonimo, String nacionalidade, String nascimento, int id_funcionario) {
        LivroDAO livroNovo = new LivroDAO();
        setTitulo(titulo);
        setSituacao(situacao);
        setLancamento(lancamento);
        setEditora(editora);
        setGenero(genero);
        setNum_paginas(num_paginas);
        setIdioma_original(idioma_original);
        setIdioma_atual(idioma_atual);
        setId_autor(id_autor);
        setId_funcionario(id_funcionario);
        autor = new Autor(id_autor, pseudonimo, nacionalidade, nascimento);

        boolean existe = false;

        AutorDAO autorNovo = new AutorDAO();

        for (int i = 0; i < autorNovo.quantidadeAutores(); i++) {
            if (autorNovo.pegarInfos(i).equals(autor)) {
                existe = true;
                break;
            }
        }
        //caso não exista um autor a gente cria um
        if (!existe) {
            autorNovo.inserirAutor(autor);
        } else {
            //se existir ele não cria, só avisa 
            System.out.println("O AUTOR JÁ EXISTE");
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public String getIdioma_original() {
        return idioma_original;
    }

    public void setIdioma_original(String idioma_original) {
        this.idioma_original = idioma_original;
    }

    public String getIdioma_atual() {
        return idioma_atual;
    }

    public void setIdioma_atual(String idioma_atual) {
        this.idioma_atual = idioma_atual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    
}
