import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarProdutos(); // Chamando o método para preencher a tabela ao abrir
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Status"
            }
        ));
        jScrollPane1.setViewportView(listaProdutos);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel1.setText("Itens Vendidos");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnVoltar)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>                        

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose(); // Fecha apenas esta tela
    }                                         

    private void listarProdutos(){
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            
            DefaultTableModel model = (DefaultTableModel) listaProdutos.getModel();
            model.setNumRows(0);
            
            // AQUI ESTÁ O SEGREDO: chama o método de filtrados!
            ArrayList<ProdutosDTO> listagem = produtosdao.listarProdutosVendidos();
            
            for(int i = 0; i < listagem.size(); i++){
                model.addRow(new Object[]{
                    listagem.get(i).getId(),
                    listagem.get(i).getNome(),
                    listagem.get(i).getValor(),
                    listagem.get(i).getStatus()
                });
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar vendidos: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProdutos;
    // End of variables declaration   
    
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new vendasVIEW().setVisible(true);
        }
    });
}
}