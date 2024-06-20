/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unicv.aulas.projetobilheteria;

import com.unicv.aulas.projetobilheteria.classes.Usuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;


public class FormListaUsuario extends javax.swing.JFrame {

    public ArrayList<Usuario> linhas = null;

    public FormListaUsuario() {
        initComponents();
        atualizarDados();
    }    
    
    public void atualizarDados(){
        this.linhas = carregarLinhas();
    }

    private ArrayList<Usuario> carregarLinhas() {
        // Configurando a requisição básica
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-eventos-unicv.azurewebsites.net/api/usuarios"))
                .GET()
                .build();

        // declarando a lista de estados
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

        try {
            // Chamar a API para trazer os dados
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar o código de retorno
            if (response.statusCode() == 200) {
                listaUsuario = parseJsonArray(response.body());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao listar usuarios");
            }
            
            System.out.println("Codigo de resposta: " + response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaUsuario;
    }

    private static ArrayList<Usuario> parseJsonArray(String jsonArrayString) {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();

        // Ler os dados do response
        JsonReader jsonReader = Json.createReader(new StringReader(jsonArrayString));
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();

        // Mapear cada objeto para a classe Usuario
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject json = jsonArray.getJsonObject(i);
            Usuario objUsuario = new Usuario();
            objUsuario.id = json.getInt("id");
            objUsuario.nome = json.getString("name");
            objUsuario.cpf = json.getString("cpf");
            objUsuario.email = json.getString("email");

            // Adiciono o retorno na lista
            listaUsuario.add(objUsuario);
        }
        
        return listaUsuario;
    }

    public void recarregarTabela() {
        
                
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nome");
        modelo.addColumn("cpf");
        modelo.addColumn("email");
        

        // popular o modelo de dados [linhas]
        for (Usuario metodo : linhas) {
            modelo.addRow(new Object[]{metodo.id, metodo.nome,metodo.cpf,metodo.email});
        }

        this.tabelaDados.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens cadastrados"));

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "CPF", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnClickExcluir(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnClickEditar(evt);
            }
        });

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnClickNovo(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(28, 28, 28)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OnClickEditar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnClickEditar
        var linhasSelecionadas = this.tabelaDados.getSelectedRowCount();

        if (linhasSelecionadas != 1) {
            JOptionPane.showMessageDialog(this, "Selecione apenas um item para editar");
            return;
        }

        var linha = this.tabelaDados.getSelectedRow();
        var id = this.tabelaDados.getValueAt(linha, 0);

        var form = new FormGerenciarUsuario();
        form.setConfiguracoes((int) id, this);
        form.carregarDados();
        form.setVisible(true);
                                               // TODO add your handling code here:
    }//GEN-LAST:event_OnClickEditar

    private void OnClickNovo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnClickNovo
        var form = new FormGerenciarUsuario();
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);    }//GEN-LAST:event_OnClickNovo

    private void OnClickExcluir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnClickExcluir
               int linhasSelecionadas = this.tabelaDados.getSelectedRowCount();

    if (linhasSelecionadas != 1) {
        JOptionPane.showMessageDialog(this, "Selecione apenas um item para excluir");
        return;
    }

    int confirmaExclusao = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro?", "Confirmação", JOptionPane.YES_NO_OPTION);
    if (confirmaExclusao == JOptionPane.YES_OPTION) {
        int linha = this.tabelaDados.getSelectedRow();
        int id = (int) this.tabelaDados.getValueAt(linha, 0);

        // Chama a API para exclusão
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-eventos-unicv.azurewebsites.net/api/metodos-pagamento?id=" + id))
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JOptionPane.showMessageDialog(this, "Usuario excluído com sucesso!");

                // Remover o estado da lista
                for (Usuario metodo : linhas) {
                    if (metodo.id == id) {
                        linhas.remove(metodo);
                        break;
                    }
                }

                recarregarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir Usuario: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Erro ao comunicar com a API: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_OnClickExcluir

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        recarregarTabela();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}
