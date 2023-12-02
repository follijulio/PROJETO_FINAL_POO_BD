package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author JULIO
 */
public class LivroDAO {

    Connection conexao = new Conexao().getConexao();

    public void inserirLivro(Livro livroNovo) {

        try {
            PreparedStatement banco = conexao.prepareStatement(
                    "insert into livro ( titulo, situacao, lancamento, editora, genero, numero_paginas, idioma_original, idioma_atual, id_do_autor, id_do_funcionario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            banco.setString(1, livroNovo.getTitulo());
            banco.setBoolean(2, livroNovo.isSituacao());
            banco.setString(3, livroNovo.getLancamento());
            banco.setString(4, livroNovo.getEditora());
            banco.setString(5, livroNovo.getGenero());
            banco.setInt(6, livroNovo.getNum_paginas());
            banco.setString(7, livroNovo.getIdioma_original());
            banco.setString(8, livroNovo.getIdioma_atual());
            banco.setInt(9, livroNovo.getId_autor());
            banco.setInt(10, livroNovo.getId_funcionario());
            banco.executeUpdate();
            System.out.println("\nLIVRO INSERIDO");
        } catch (Exception e) {
            System.out.println("Erro ao inserir livro: " + e.getMessage());
        }
    }

    public boolean emprestarLivro(int id_livro) {
        try {
            PreparedStatement banco = conexao.prepareStatement("UPDATE livro SET situacao = ? WHERE id = ?");
            banco.setBoolean(1, true);
            banco.setInt(2, id_livro);
            banco.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao emprestar livro: " + e.getMessage());
        }

        return false;
    }

    public boolean devolverLivro(int id_livro) {
        try {
            PreparedStatement banco = conexao.prepareStatement("UPDATE livro SET situacao = ? WHERE id = ?");
            banco.setBoolean(1, false);
            banco.setInt(2, id_livro);
            banco.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }

        return false;
    }

    public boolean removerLivro(int id_livro) {
        try {
            PreparedStatement banco = conexao.prepareStatement("DELETE FROM livro WHERE id = ?");
            banco.setInt(1, id_livro);
            banco.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }
        return false;
    }
}
