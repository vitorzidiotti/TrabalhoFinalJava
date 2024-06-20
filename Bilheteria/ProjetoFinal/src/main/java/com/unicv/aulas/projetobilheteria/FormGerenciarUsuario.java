/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unicv.aulas.projetobilheteria;

import com.unicv.aulas.projetobilheteria.classes.Usuario;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class FormGerenciarUsuario extends javax.swing.JFrame {
   private int id;
    private FormListaUsuario formPai;
    
    public FormGerenciarUsuario() {
        initComponents();
    }
     public void setConfiguracoes(int id, FormListaUsuario pai) {
        this.id = id;
        this.formPai = pai;
    }

    public void carregarDados() {   
        
     // Configurando a requisição básica
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-eventos-unicv.azurewebsites.net/api/usuarios"))
            .GET()
            .build();

    // declarando a lista de estados
    ArrayList<Usuario> FormListaUsuario = new ArrayList<Usuario>();

    try {
        // Chamar a API para trazer os dados
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar o código de retorno
        if (response.statusCode() == 200) {
            FormListaUsuario = parseJsonArray(response.body());
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao listar Usuario");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    }
     private static ArrayList<Usuario> parseJsonArray(String jsonArrayString) {
        ArrayList<Usuario> Usuario = new ArrayList<>();

        // Ler os dados do response
        JsonReader jsonReader = Json.createReader(new StringReader(jsonArrayString));
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();

        // Mapear cada objeto para a classe Estado
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject json = jsonArray.getJsonObject(i);
            Usuario objUsuario = new Usuario();
            objUsuario.id = json.getInt("id");
            objUsuario.nome = json.getString("name");
            objUsuario.email = json.getString("email");
            objUsuario.cpf = json.getString("cpf");

            // Adiciono o retorno na lista
            Usuario.add(objUsuario);
        }

        return Usuario;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textcpf = new javax.swing.JTextField();
        textemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setText("Id");

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        labelId.setText("00000");

        textemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textemailActionPerformed(evt);
            }
        });

        jLabel4.setText("E-mail");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome)
                    .addComponent(textcpf)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 157, Short.MAX_VALUE))
                    .addComponent(textemail))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textemailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        var form = new FormListaUsuario();
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);

        System.out.println("OnclickFechar");

        this.dispose(); // Fechar
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selecionado = this.id;
        String nome = textNome.getText();
        String cpf = textcpf.getText();
        String email = textemail.getText();
        

        // Verificando se a sigla e o nome estão vazios
        if (nome.isEmpty()) {
            // Exibir mensagem de erro e não salvar
            JOptionPane.showMessageDialog(this, "A sigla e o nome não podem estar vazios.");
            return;
        }

        // Verificando se a sigla possui exatamente 2 caracteres e são letras
       
        
        if (id == 0){
            adicionarUsuario(nome, cpf, email);
            System.out.println("POST"); // chamar a API de POST
        }
        else{
            editarUsario(nome,cpf , email, selecionado);
            System.out.println("PUT"); // chamar a API de PUT
        }

        
        // Exibindo os valores no console
      
         
        
        // Enviando o estado para a API
       

        var form = new FormListaUsuario();
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);

        System.out.println("OnclickSalvar");
        this.dispose(); // Fechar
    
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

     public void adicionarUsuario(String nome, String cpf, String email) {
    try {
        // Construir o JSON com os dados do novo estado
        JsonObject estadoJson = Json.createObjectBuilder()
                .add("Name", nome)
                .add("cpf", cpf)
                .add("email", email)
                .build();

        // Criar o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir a requisição HTTP PUT
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-eventos-unicv.azurewebsites.net/api/usuarios"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(estadoJson.toString()))
                .build();

        // Enviar a requisição e capturar a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar o código de resposta
        if (response.statusCode() == 200) {
            // Estado adicionado com sucesso
            JOptionPane.showMessageDialog(this, "Estado adicionado com sucesso!");
        } else {
            // Exibir mensagem de erro se a resposta não for bem-sucedida
            JOptionPane.showMessageDialog(this, "Erro ao adicionar estado: " + response.body());
        }
    } catch (Exception e) {
        // Capturar e tratar exceções
        JOptionPane.showMessageDialog(this, "Erro ao comunicar com a API: " + e.getMessage());
        e.printStackTrace(); // Isso pode ser alterado para um tratamento mais adequado de exceções
    }
    }
    
    public void editarUsario(String nome, String cpf,String email, int id) {
    try {
        // Construir o JSON com os dados do novo estado
        JsonObject estadoJson = Json.createObjectBuilder()
                .add("Name", nome)
                .add("cpf", cpf)
                .add("email", email)
                .build();

        // Criar o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir a requisição HTTP PUT
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-eventos-unicv.azurewebsites.net/api/usuarios?id=" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(estadoJson.toString()))
                .build();

        // Enviar a requisição e capturar a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar o código de resposta
        if (response.statusCode() == 200) {
            // Estado adicionado com sucesso
            JOptionPane.showMessageDialog(this, "Estado editado com sucesso!");
        } else {
            // Exibir mensagem de erro se a resposta não for bem-sucedida
            JOptionPane.showMessageDialog(this, "Erro ao editar estado: " + response.body());
        }
    } catch (Exception e) {
        // Capturar e tratar exceções
        JOptionPane.showMessageDialog(this, "Erro ao comunicar com a API: " + e.getMessage());
        e.printStackTrace(); // Isso pode ser alterado para um tratamento mais adequado de exceções
    }
    }
    
    
    
    
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
            java.util.logging.Logger.getLogger(FormGerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGerenciarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGerenciarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelId;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textcpf;
    private javax.swing.JTextField textemail;
    // End of variables declaration//GEN-END:variables
}
