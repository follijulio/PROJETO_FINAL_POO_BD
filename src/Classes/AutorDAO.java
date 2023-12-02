package Classes;

import java.sql.*;

public class AutorDAO {

    Connection conexao = new Conexao().getConexao();

    public void inserirAutor(Autor autorNovo) {
        try {
            //verificação de autor
            boolean existe = existeAutorNome(autorNovo.getPseudonimo());
            if (existe) {

            } else {

                String sql = "INSERT INTO autor (id, pseudonimo, nacionalidade, data_nascimento) VALUES (?, ?, ?, ?)";
                try (PreparedStatement banco = conexao.prepareStatement(sql)) {
                    banco.setInt(1, autorNovo.getId());
                    banco.setString(2, autorNovo.getPseudonimo());
                    banco.setString(3, autorNovo.getNacionalidade());
                    banco.setString(4, autorNovo.getNascimento());
                    banco.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println("ERRO ao inserir autor: " + e);
        }
    }

    public boolean existeAutorNome(String nome) {
        String sql = "SELECT COUNT(*) FROM autor WHERE pseudonimo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO ao verificar a existência do autor: " + e.getMessage());
        }

        return false;
    }

    public boolean existeAutorPorId(int idAutor) {
        String sql = "SELECT COUNT(*) FROM autor WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO ao verificar a existência do autor: " + e.getMessage());
        }

        return false;
    }

    public String[] pegarInfos(int id_autor) {
        String[] array = new String[]{"", "", ""};

        try (PreparedStatement banco = conexao.prepareStatement("SELECT pseudonimo, nacionalidade, data_nascimento FROM autor WHERE id = ?")) {
            banco.setInt(1, id_autor);

            try (ResultSet resultado = banco.executeQuery()) {
                if (resultado.next()) {
                    String pseudonimo = resultado.getString("pseudonimo");
                    String nacionalidade = resultado.getString("nacionalidade");
                    String nascimento = resultado.getString("data_nascimento");

                    array[0] = pseudonimo;
                    array[1] = nacionalidade;
                    array[2] = nascimento;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pegar informações do autor: " + e.getMessage());
        }

        return array;
    }

    public int quantidadeAutores() {
        try (PreparedStatement stmt = conexao.prepareStatement("SELECT COUNT(*) FROM autor")) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int valor = rs.getInt(1);
                    return valor;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao contar autores: " + e.getMessage());
        }

        return 0;
    }

    public Autor pegarAutor(int id) {
        Autor autor;
        try (PreparedStatement banco = conexao.prepareStatement("select * from autor where id = ?")) {
            /*
          buuuuuuscando o autor
             */
            banco.setInt(1, id);
            try (ResultSet resultado = banco.executeQuery()) {
                if (resultado.next()) {
                    String nome = resultado.getString("pseudonimo");
                    String nacionalidade = resultado.getString("nacionalidade");
                    String nascimento = resultado.getString("data_nascimento");
                    /*
                 tomeeee retorno 
                     */
                    autor = new Autor(id, nome, nacionalidade, nascimento);
                    return autor;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
