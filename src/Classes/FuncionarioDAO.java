package Classes;

import java.sql.*;

/**
 *
 * @author JULIO
 *
 */
public class FuncionarioDAO {

    Connection conexao = new Conexao().getConexao();

    public void inserirFuncionario(Funcionario funcionarioNovo) {
        try {
            PreparedStatement banco = conexao.prepareStatement(
                    "insert into funcionario ( nome, codigo, senha, salario ) values (?, ?, ?, ?)"
            );
            banco.setString(1, funcionarioNovo.getNome());
            banco.setString(2, funcionarioNovo.getCodigo());
            banco.setString(3, funcionarioNovo.getSenha());
            banco.setDouble(4, funcionarioNovo.getSalario());
            banco.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public int validarFuncionario(int codigo, int senha) {
        try (
                PreparedStatement banco = conexao.prepareStatement(
                        "SELECT id FROM funcionario WHERE codigo = ? AND senha = ?"
                )) {
                    banco.setInt(1, codigo);
                    banco.setInt(2, senha);

                    try (ResultSet rs = banco.executeQuery()) {
                        if (rs.next()) {
                            return rs.getInt("id");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1;
    }

    public int procurarFuncionarioCodigo(String codigo) {
        try (
                PreparedStatement banco = conexao.prepareStatement(
                        "SELECT id FROM funcionario WHERE codigo = ?"
                )) {
                    banco.setString(1, codigo);

                    try (ResultSet rs = banco.executeQuery()) {
                        if (rs.next()) {
                            return rs.getInt("id");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1;
    }

    public int deletarFuncionario(int id) {
        try (
                PreparedStatement banco = conexao.prepareStatement(
                        "DELETE FROM funcionario WHERE id = ?"
                )) {
                    banco.setInt(1, id);
                    banco.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1;
    }

    public boolean atualizarFuncionario(Funcionario f_atualizado, int id) {
        try {
            PreparedStatement banco = conexao.prepareStatement(
                    "update funcionario set nome = ? , codigo = ? , senha = ? , salario = ?  WHERE id = ?"
            );
            banco.setString(1, f_atualizado.getNome());
            banco.setString(2, f_atualizado.getCodigo());
            banco.setString(3, f_atualizado.getSenha());
            banco.setDouble(4, f_atualizado.getSalario());
            banco.setInt(5, id);
            banco.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return false;
    }

    public Funcionario pegarFuncionario(int id) {
        Funcionario funcionario;
        try (
                PreparedStatement banco = conexao.prepareStatement(
                        "select * from funcionario where id = ?"
                )) {
                    /*
            busca pelo funcionário pelo id
                     */
                    banco.setInt(1, id);
                    try (ResultSet resultado = banco.executeQuery()) {
                        if (resultado.next()) {
                            String nome = resultado.getString("nome");
                            String codigo = resultado.getString("codigo");
                            String senha = resultado.getString("senha");
                            float salario = resultado.getFloat("salario");
                            /*
                    tome retornoo
                             */
                            funcionario = new Funcionario(nome, salario, codigo, senha);
                            return funcionario;
                            /*
                    atualizar para retornar umm arraylist
                             */
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
    }
}
