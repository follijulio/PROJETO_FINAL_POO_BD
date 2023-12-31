package Telas;

import Classes.Conexao;
import Classes.AutorDAO;
import Classes.LivroDAO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class TelaEmprestimos extends javax.swing.JFrame {

    private final Connection conexao;

    public TelaEmprestimos() {

        initComponents();
        getContentPane().setBackground(new java.awt.Color(0, 0, 128));
        conexao = new Conexao().getConexao();

        try {
            PreparedStatement sttmt = conexao.prepareStatement("SELECT * FROM livro;");
            ResultSet rst = sttmt.executeQuery();
            AutorDAO autor = new AutorDAO();
            while (rst.next()) {
                int codigoLivro = rst.getInt("id");
                String nomeLivro = rst.getString("titulo");
                String lancamento = rst.getString("lancamento");
                String editora = rst.getString("editora");
                String genero = rst.getString("genero");
                int numPaginas = rst.getInt("numero_paginas");
                String idioma = rst.getString("idioma_atual");
                String situacao = "";
                boolean emprestado = rst.getBoolean("situacao");
                if (emprestado) {
                    situacao = "EMPRESTADO";
                } else {
                    situacao = "EM ESTOQUE";
                }
                int id_autor = rst.getInt("id_do_autor");

                //GAMBIARRA DA BOBA
                String[] autoria = autor.pegarInfos(id_autor);
                //                                              //TRANSFORMA O ARRAY NORMAL EM UM ARRAYLIST 
                ArrayList<String> autoria_list = new ArrayList<>(Arrays.asList(autoria));
                System.out.println("NOME DO AUTOR: "+autoria_list.get(0));
                DefaultTableModel modelo = (DefaultTableModel) tabela_de_emprestimos.getModel();
                modelo.addRow(new Object[]{codigoLivro, nomeLivro, lancamento, editora, genero, numPaginas, idioma, situacao, autoria_list.get(0)});
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta de livros: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_de_emprestimos = new javax.swing.JTable();
        sair = new javax.swing.JButton();
        botao_voltar_menu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        area_id_emprestar = new javax.swing.JFormattedTextField();
        botao_continuar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        area_id_devolver = new javax.swing.JFormattedTextField();
        botao_devolver = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        area_apagar_livro = new javax.swing.JFormattedTextField();
        botao_apagar_livro = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela_de_emprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO DO LIVRO", "TÍTULO DO LIVRO", "LANÇAMENTO", "EDITORA", "GÊNERO", "NÚMERO DE PÁGINAS", "IDIOMA", "SITUAÇÃO", "AUTOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_de_emprestimos);

        sair.setText("X");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        botao_voltar_menu.setText("<");
        botao_voltar_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltar_menuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMPRESTAR LIVRO");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LIVROS E SUAS INFORMAÇÕES");

        jLabel4.setText("QUAL O CÓDIGO DO LIVRO QUE DESEJAS EMPRESTRAR?");

        botao_continuar.setText("CONTINUAR");
        botao_continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_continuarActionPerformed(evt);
            }
        });

        jLabel5.setText("QUAL O CÓDIGO DO LIVRO QUE DESEJAS DEVOLVER?");

        area_id_devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area_id_devolverActionPerformed(evt);
            }
        });

        botao_devolver.setText("CONTINUAR");
        botao_devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_devolverActionPerformed(evt);
            }
        });

        jLabel6.setText("QUAL O CÓDIGO DO LIVRO QUE DESEJAS REMOVER?");

        area_apagar_livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area_apagar_livroActionPerformed(evt);
            }
        });

        botao_apagar_livro.setText("CONTINUAR");
        botao_apagar_livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_apagar_livroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botao_voltar_menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sair))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area_id_emprestar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(area_id_devolver, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botao_continuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botao_devolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(area_apagar_livro, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_apagar_livro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sair)
                    .addComponent(botao_voltar_menu)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area_id_emprestar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_continuar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area_id_devolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_devolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area_apagar_livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_apagar_livro))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void botao_voltar_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltar_menuActionPerformed
        // TODO add your handling code here:
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }//GEN-LAST:event_botao_voltar_menuActionPerformed

    private void botao_continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_continuarActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(area_id_emprestar.getText());
        LivroDAO livro = new LivroDAO();
        livro.emprestarLivro(codigo);
        TelaEmprestimos tela = new TelaEmprestimos();
        tela.setVisible(true);
    }//GEN-LAST:event_botao_continuarActionPerformed

    private void area_id_devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area_id_devolverActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_area_id_devolverActionPerformed

    private void botao_devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_devolverActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(area_id_devolver.getText());
        LivroDAO livro = new LivroDAO();
        livro.devolverLivro(codigo);
        TelaEmprestimos tela = new TelaEmprestimos();
        tela.setVisible(true);
    }//GEN-LAST:event_botao_devolverActionPerformed

    private void area_apagar_livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area_apagar_livroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_area_apagar_livroActionPerformed

    private void botao_apagar_livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_apagar_livroActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(area_apagar_livro.getText());
        LivroDAO livro = new LivroDAO();
        livro.removerLivro(codigo);
        TelaEmprestimos tela = new TelaEmprestimos();
        tela.setVisible(true);
    }//GEN-LAST:event_botao_apagar_livroActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField area_apagar_livro;
    private javax.swing.JFormattedTextField area_id_devolver;
    private javax.swing.JFormattedTextField area_id_emprestar;
    private javax.swing.JButton botao_apagar_livro;
    private javax.swing.JButton botao_continuar;
    private javax.swing.JButton botao_devolver;
    private javax.swing.JButton botao_voltar_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sair;
    private javax.swing.JTable tabela_de_emprestimos;
    // End of variables declaration//GEN-END:variables
}
