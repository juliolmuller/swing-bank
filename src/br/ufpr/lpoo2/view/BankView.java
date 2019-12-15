package br.ufpr.lpoo2.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import br.ufpr.lpoo2.model.Customer;

@SuppressWarnings("serial")
public class BankView extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton assignBtn;
    private JButton cleanFormBtn;
    private JButton clenaBtn;
    private JButton deleteBtn;
    private JButton depositBtn;
    private JButton disassignBtn;
    private JButton insertBtn;
    private JButton listBtn;
    private JButton sortFirstNameBtn;
    private JButton sortLastNameBtn;
    private JButton paymentBtn;
    private JButton updateBtn;
    private JButton withdrawalBtn;
    private JComboBox<String> accountCombo;
    private JComboBox<String> cpfCombo;
    private JComboBox<String> cpfCombo2;
    private JLabel label01;
    private JLabel label02;
    private JLabel label03;
    private JLabel label04;
    private JLabel label05;
    private JLabel label06;
    private JLabel label07;
    private JLabel label08;
    private JLabel label09;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JLabel label28;
    private JLabel label29;
    private JLabel label30;
    private JLabel label31;
    private JLabel label32;
    private JPanel checkingAccountsPanel;
    private JPanel investmentAccountsPanel;
    private JPanel label33;
    private JPanel label34;
    private JPanel label35;
    private JScrollPane scrollPanel01;
    private JScrollPane scrollPanel02;
    private JScrollPane scrollPanel03;
    private JScrollPane scrollPanel04;
    private JTabbedPane accountPanel;
    private JTable customersTable;
    private JTextArea assignmentStatusField;
    private JTextArea formStatusField;
    private JTextArea generalStatusField;
    private JTextField accNumberField;
    private JTextField accNumberField2;
    private JTextField accNumberToAssignField;
    private JTextField accTypeField;
    private JTextField accTypeToAssignField;
    private JTextField addressField;
    private JTextField balanceField;
    private JTextField cpfField;
    private JTextField depositField;
    private JTextField firstNameField;
    private JTextField firstNameField2;
    private JTextField firstNameToAssignField;
    private JTextField initialDepositField;
    private JTextField lastNameField;
    private JTextField lastNameField2;
    private JTextField lastNameToassignField;
    private JTextField maxLimitField;
    private JTextField minBalanceField;
    private JTextField minDepositField;
    private JTextField rgField;
    private JTextField withdrawalField;
    // End of variables declaration//GEN-END:variables

    public BankView() {
        initComponents();
    }

    @Deprecated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        accNumberField = new JTextField();
        accNumberField2 = new JTextField();
        accNumberToAssignField = new JTextField();
        accountCombo = new JComboBox<>();
        accountPanel = new JTabbedPane();
        accTypeField = new JTextField();
        accTypeToAssignField = new JTextField();
        addressField = new JTextField();
        assignBtn = new JButton();
        assignmentStatusField = new JTextArea();
        balanceField = new JTextField();
        checkingAccountsPanel = new JPanel();
        cleanFormBtn = new JButton();
        clenaBtn = new JButton();
        cpfCombo = new JComboBox<>();
        cpfCombo2 = new JComboBox<>();
        cpfField = new JTextField();
        customersTable = new JTable();
        deleteBtn = new JButton();
        depositBtn = new JButton();
        depositField = new JTextField();
        disassignBtn = new JButton();
        firstNameField = new JTextField();
        firstNameField2 = new JTextField();
        firstNameToAssignField = new JTextField();
        formStatusField = new JTextArea();
        generalStatusField = new JTextArea();
        initialDepositField = new JTextField();
        insertBtn = new JButton();
        investmentAccountsPanel = new JPanel();
        label01 = new JLabel();
        label02 = new JLabel();
        label03 = new JLabel();
        label04 = new JLabel();
        label05 = new JLabel();
        label06 = new JLabel();
        label07 = new JLabel();
        label08 = new JLabel();
        label09 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        label31 = new JLabel();
        label32 = new JLabel();
        label33 = new JPanel();
        label34 = new JPanel();
        label35 = new JPanel();
        lastNameField = new JTextField();
        lastNameField2 = new JTextField();
        lastNameToassignField = new JTextField();
        listBtn = new JButton();
        maxLimitField = new JTextField();
        minBalanceField = new JTextField();
        minDepositField = new JTextField();
        paymentBtn = new JButton();
        rgField = new JTextField();
        scrollPanel01 = new JScrollPane();
        scrollPanel02 = new JScrollPane();
        scrollPanel03 = new JScrollPane();
        scrollPanel04 = new JScrollPane();
        sortFirstNameBtn = new JButton();
        sortLastNameBtn = new JButton();
        updateBtn = new JButton();
        withdrawalBtn = new JButton();
        withdrawalField = new JTextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        accountPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                manipularContaPanelMouseClicked(evt);
            }
        });
        customersTable.setModel(new DefaultTableModel(new Object[][] {
            {}, {}, {}, {}
        }, new String[] {}));
        scrollPanel01.setViewportView(customersTable);
        label01.setFont(new Font("Dialog", 1, 18));
        label01.setText("Clientes do Banco");
        insertBtn.setText("Incluir");
        insertBtn.setNextFocusableComponent(updateBtn);
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                incluirButtonActionPerformed(evt);
            }
        });
        updateBtn.setText("Atualizar");
        updateBtn.setNextFocusableComponent(listBtn);
        updateBtn.setPreferredSize(new Dimension(100, 25));
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                atualizarButtonActionPerformed(evt);
            }
        });
        deleteBtn.setText("Excluir");
        deleteBtn.setNextFocusableComponent(firstNameField);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                excluirButtonActionPerformed(evt);
            }
        });
        label12.setText("Nome :");
        label23.setText("Sobrenome :");
        label27.setText("RG :");
        label28.setText("CPF :");
        label29.setText("Endereço :");
        firstNameField.setNextFocusableComponent(lastNameField);
        firstNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                firstNameFieldKeyTyped(evt);
            }
        });
        lastNameField.setNextFocusableComponent(addressField);
        lastNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                lastNameFieldKeyTyped(evt);
            }
        });
        addressField.setNextFocusableComponent(rgField);
        addressField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                endereçoFieldActionPerformed(evt);
            }
        });
        addressField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                addressFieldKeyTyped(evt);
            }
        });
        rgField.setNextFocusableComponent(cpfField);
        rgField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                rgFieldKeyTyped(evt);
            }
        });
        cpfField.setNextFocusableComponent(insertBtn);
        cpfField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                cpfFieldKeyTyped(evt);
            }
        });
        listBtn.setText("Listar");
        listBtn.setNextFocusableComponent(clenaBtn);
        listBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                listarButtonActionPerformed(evt);
            }
        });
        clenaBtn.setText("Limpar");
        clenaBtn.setNextFocusableComponent(deleteBtn);
        clenaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });
        label20.setText("Status");
        formStatusField.setColumns(20);
        formStatusField.setRows(5);
        scrollPanel03.setViewportView(formStatusField);
        cleanFormBtn.setText("Limpar Campos");
        sortFirstNameBtn.setText("Nome");
        sortLastNameBtn.setText("Sobrenome");
        label26.setText("Ordenar");
        GroupLayout groupLayout1 = new GroupLayout(label33);
        label33.setLayout(groupLayout1);
        groupLayout1.setHorizontalGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(groupLayout1.createSequentialGroup()
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(groupLayout1.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clenaBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(label26)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortFirstNameBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addGroup(groupLayout1.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(label12)
                            .addComponent(label23)
                            .addComponent(label29))
                        .addGap(28, 28, 28)
                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(groupLayout1.createSequentialGroup()
                        .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(groupLayout1.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGroup(groupLayout1.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGroup(groupLayout1.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(cleanFormBtn)))
                        .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(groupLayout1.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(groupLayout1.createSequentialGroup()
                                        .addComponent(label28)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cpfField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(groupLayout1.createSequentialGroup()
                                        .addComponent(label27)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(sortLastNameBtn)
                                            .addComponent(rgField,GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE))
                            .addGroup(groupLayout1.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label20)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPanel03)))))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, groupLayout1.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label01)
                .addGap(257, 257, 257))
            .addGroup(groupLayout1.createSequentialGroup()
                .addContainerGap()
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel01)
                    .addGroup(groupLayout1.createSequentialGroup()
                        .addComponent(insertBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        groupLayout1.setVerticalGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, groupLayout1.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label01)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanel01, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(listBtn)
                    .addComponent(clenaBtn)
                    .addComponent(label26)
                    .addComponent(sortFirstNameBtn)
                    .addComponent(sortLastNameBtn))
                .addGap(18, 18, 18)
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label27)
                    .addComponent(rgField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label12))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label23)
                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label28)
                        .addComponent(cpfField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label20)
                    .addComponent(scrollPanel03, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout1.createSequentialGroup()
                        .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(label29)
                            .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(insertBtn)
                            .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cleanFormBtn)))
                .addGap(62, 62, 62)));
        accountPanel.addTab("Manter Clientes", label33);
        label31.setText("Tipo de Conta:");
        accountCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                contaComboActionPerformed(evt);
            }
        });
        assignBtn.setText("Vincular");
        label02.setText("Limite");
        maxLimitField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                maxLimitFieldKeyTyped(evt);
            }
        });
        GroupLayout painelContaCorrenteLayout = new GroupLayout(checkingAccountsPanel);
        checkingAccountsPanel.setLayout(painelContaCorrenteLayout);
        painelContaCorrenteLayout.setHorizontalGroup(painelContaCorrenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelContaCorrenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label02, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxLimitField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        painelContaCorrenteLayout.setVerticalGroup(painelContaCorrenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelContaCorrenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelContaCorrenteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label02)
                    .addComponent(maxLimitField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE)));
        initialDepositField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                initialDepositFieldActionPerformed(evt);
            }
        });
        initialDepositField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                initialDepositFieldKeyTyped(evt);
            }
        });
        label32.setText("Deposito Inicial");
        label04.setText("Montante Mínimo");
        label05.setText("Deposito Mínimo");
        minBalanceField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                montanteMinimoFieldActionPerformed(evt);
            }
        });
        minBalanceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                minBalanceFieldKeyTyped(evt);
            }
        });

        minDepositField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                minDepositFieldKeyTyped(evt);
            }
        });
        GroupLayout painelContaInvestimentoLayout = new GroupLayout(investmentAccountsPanel);
        investmentAccountsPanel.setLayout(painelContaInvestimentoLayout);
        painelContaInvestimentoLayout.setHorizontalGroup(painelContaInvestimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelContaInvestimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelContaInvestimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(painelContaInvestimentoLayout.createSequentialGroup()
                        .addComponent(label04, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minBalanceField))
                    .addGroup(painelContaInvestimentoLayout.createSequentialGroup()
                        .addComponent(label05, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minDepositField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        painelContaInvestimentoLayout.setVerticalGroup(painelContaInvestimentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelContaInvestimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelContaInvestimentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label04)
                    .addComponent(minBalanceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelContaInvestimentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label05)
                    .addComponent(minDepositField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        label06.setText("CPF");
        cpfCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cpfComboActionPerformed(evt);
            }
        });
        label21.setText("Primeiro nome");
        label22.setText("Último nome");
        label24.setText("Número conta");
        label25.setText("Tipo de conta");
        assignmentStatusField.setColumns(20);
        assignmentStatusField.setRows(5);
        scrollPanel02.setViewportView(assignmentStatusField);
        label30.setText("Status");
        label03.setText("Nova Conta");
        disassignBtn.setText("Desvincular");
        GroupLayout jPanel2Layout = new GroupLayout(label34);
        label34.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label06, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(cpfCombo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label03, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label31, GroupLayout.Alignment.LEADING))
                                    .addComponent(label32, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(initialDepositField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountCombo, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accNumberField2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(label22)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameToassignField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(label21)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameToAssignField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
                                .createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label25)
                                    .addComponent(label24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(accNumberToAssignField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(accTypeToAssignField, GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(checkingAccountsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(84, 84, 84).addComponent(assignBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                            .addComponent(investmentAccountsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPanel02, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label30))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(disassignBtn)
                                .addGap(43, 43, 43)))))
                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label06)
                    .addComponent(firstNameToAssignField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label21))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameToassignField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label22))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(accTypeToAssignField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label25))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(accNumberField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label03))
                            .addGap(15, 15, 15)))
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(accNumberToAssignField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label24)
                            .addComponent(accountCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label31))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label32)
                    .addComponent(initialDepositField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label30))
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(checkingAccountsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(investmentAccountsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanel02, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(assignBtn)
                            .addComponent(disassignBtn))
                .addContainerGap(34, Short.MAX_VALUE)));
        accountPanel.addTab("Vincular Conta", label34);
        cpfCombo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cpfCombo2ActionPerformed(evt);
            }
        });
        label07.setText("CPF");
        firstNameField2.setNextFocusableComponent(lastNameField);
        lastNameField2.setNextFocusableComponent(addressField);
        label08.setText("Sobrenome :");
        label09.setText("Nome :");
        label10.setText("Cliente");
        label11.setText("Número conta:");
        accNumberField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                numContaFieldActionPerformed(evt);
            }
        });
        label13.setText("Tipo de conta:");
        label14.setText("Saldo:");
        depositBtn.setText("Depositar");
        label15.setText("Realizar Depósito");
        depositField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                depositFieldKeyTyped(evt);
            }
        });
        label16.setText("Valor:");
        label17.setText("Realizar Saque");
        label18.setText("Valor:");
        withdrawalField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                withdrawalFieldKeyTyped(evt);
            }
        });
        withdrawalBtn.setText("Sacar");
        withdrawalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                withdrawalBtnActionPerformed(evt);
            }
        });
        paymentBtn.setText("Remunerar");
        paymentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                remunerarBtnActionPerformed(evt);
            }
        });
        label19.setText("Status:");
        generalStatusField.setColumns(20);
        generalStatusField.setRows(5);
        scrollPanel04.setViewportView(generalStatusField);
        GroupLayout jPanel3Layout = new GroupLayout(label35);
        label35.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label10)
                .addGap(136, 136, 136))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label07, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cpfCombo2, 0, 183, Short.MAX_VALUE)
                            .addComponent(balanceField))
                        .addGap(139, 139, 139)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label09)
                            .addComponent(label08)
                            .addComponent(label11)
                            .addComponent(label13)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(label16)
                                .addGap(18, 18, 18)
                                .addComponent(depositField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(label18)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(withdrawalField, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 96, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(label15)
                                .addGap(138, 138, 138)
                                .addComponent(label17)
                                .addGap(28, 129, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(depositBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(withdrawalBtn, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(firstNameField2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addComponent(lastNameField2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addComponent(accNumberField)
                        .addComponent(accTypeField))
                    .addComponent(paymentBtn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup().addComponent(label19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPanel04))
                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label10)
                    .addComponent(cpfCombo2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label07))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label09))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label08)
                    .addComponent(balanceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label14))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(accNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(accTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(paymentBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label15)
                            .addComponent(label17))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(depositField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label16)
                            .addComponent(withdrawalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label18))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(withdrawalBtn)
                            .addComponent(depositBtn))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label19)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel04, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)));
        accountPanel.addTab("Manipular Conta", label35);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(accountPanel, GroupLayout.PREFERRED_SIZE, 736, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(accountPanel, GroupLayout.PREFERRED_SIZE, 475, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirButtonActionPerformed(ActionEvent evt) {}

    private void listarButtonActionPerformed(ActionEvent evt) {}

    private void limparButtonActionPerformed(ActionEvent evt) {}

    private void incluirButtonActionPerformed(ActionEvent evt) {}

    private void atualizarButtonActionPerformed(ActionEvent evt) {}

    private void endereçoFieldActionPerformed(ActionEvent evt) {}

    private void initialDepositFieldActionPerformed(ActionEvent evt) {}

    private void manipularContaPanelMouseClicked(MouseEvent evt) {}

    private void montanteMinimoFieldActionPerformed(ActionEvent evt) {}

    private void contaComboActionPerformed(ActionEvent evt) {}

    private void cpfComboActionPerformed(ActionEvent evt) {}

    private void cpfCombo2ActionPerformed(ActionEvent evt) {}

    private void numContaFieldActionPerformed(ActionEvent evt) {}

    private void withdrawalBtnActionPerformed(ActionEvent evt) {}

    private void remunerarBtnActionPerformed(ActionEvent evt) {}

    private void firstNameFieldKeyTyped(KeyEvent evt) {
        final int MAX_FIELD_LENGTH = 50;
        String firstName = firstNameField.getText();
        if (firstName.length() >= MAX_FIELD_LENGTH)
            evt.consume();
    }

    private void lastNameFieldKeyTyped(KeyEvent evt) {
        final int MAX_FIELD_LENGTH = 100;
        String lastName = lastNameField.getText();
        if (lastName.length() >= MAX_FIELD_LENGTH)
            evt.consume();
    }

    private void addressFieldKeyTyped(KeyEvent evt) {
        final int MAX_FIELD_LENGTH = 200;
        String address = addressField.getText();
        if (address.length() >= MAX_FIELD_LENGTH)
            evt.consume();
    }

    private void rgFieldKeyTyped(KeyEvent evt) {
        final int MAX_FIELD_LENGTH = 11;
        char key = evt.getKeyChar();
        String rg = rgField.getText();
        if (!(key == KeyEvent.VK_DELETE || Character.isDigit(key)) || rg.length() >= MAX_FIELD_LENGTH)
            evt.consume();
    }

    private void cpfFieldKeyTyped(KeyEvent evt) {
        final int MAX_FIELD_LENGTH = 11;
        char key = evt.getKeyChar();
        String cpf = cpfField.getText();
        if (!(key == KeyEvent.VK_DELETE || Character.isDigit(key)) || cpf.length() >= MAX_FIELD_LENGTH)
            evt.consume();
    }

    private void initialDepositFieldKeyTyped(KeyEvent evt) {
        char key = evt.getKeyChar();
        String initialDeposit = initialDepositField.getText();
        if (
            !(
                key == KeyEvent.VK_DELETE ||
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA ||
                Character.isDigit(key)
            ) ||
            initialDeposit.length() >= 11 ||
            (
                initialDeposit.length() - initialDeposit.indexOf('.') > 2 &&
                initialDeposit.contains(".")
            )
        )
            evt.consume();
        if (
            (
                initialDeposit.contains(".") ||
                initialDeposit.contains(",")
            ) &&
            (
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA
            )
        )
            evt.consume();
        else if (key == KeyEvent.VK_COMMA) {
            evt.consume();
            initialDepositField.setText(initialDeposit + '.');
        }
    }

    private void maxLimitFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        String maxLimit = maxLimitField.getText();
        if (
            !(
                key == KeyEvent.VK_DELETE ||
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA ||
                Character.isDigit(key)
            ) ||
            maxLimit.length() >= 11 ||
            maxLimit.length() - maxLimit.indexOf('.') > 2 && maxLimit.contains(".")
        )
            evt.consume();
        if (
            (
                maxLimit.contains(".") ||
                maxLimit.contains(",")
            ) &&
            (
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA
            )
        )
            evt.consume();
        else if (key == KeyEvent.VK_COMMA) {
            evt.consume();
            maxLimitField.setText(maxLimit + '.');
        }
    }

    private void minBalanceFieldKeyTyped(KeyEvent evt) {
        char key = evt.getKeyChar();
        String minBalance = minBalanceField.getText();
        if (
            !(
                key == KeyEvent.VK_DELETE ||
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA ||
                Character.isDigit(key)
            ) ||
            minBalance.length() >= 11 ||
            (
                minBalance.length() - minBalance.indexOf('.') > 2 &&
                minBalance.contains(".")
            )
        )
            evt.consume();
        if (
            (
                minBalance.contains(".") ||
                minBalance.contains(",")
            ) &&
            (
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA
            )
        )
            evt.consume();
        else if (key == KeyEvent.VK_COMMA) {
            evt.consume();
            minBalanceField.setText(minBalance + '.');
        }
    }

    private void minDepositFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        String minDeposit = minDepositField.getText();
        if (
            !(
                key == KeyEvent.VK_DELETE ||
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA ||
                Character.isDigit(key)
            ) ||
            minDeposit.length() >= 11 ||
            (
                minDeposit.length() - minDeposit.indexOf('.') > 2 &&
                minDeposit.contains(".")
            )
        )
            evt.consume();
        if (
            (
                minDeposit.contains(".") ||
                minDeposit.contains(",")
            ) &&
            (
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA
            )
        )
            evt.consume();
        else if (key == KeyEvent.VK_COMMA) {
            evt.consume();
            minDepositField.setText(minDeposit + '.');
        }
    }

    private void depositFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        String deposit = depositField.getText();
        if (
            !(
                key == KeyEvent.VK_DELETE ||
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA ||
                Character.isDigit(key)
            ) ||
            deposit.length() >= 11 ||
            (
                deposit.length() - deposit.indexOf('.') > 2 &&
                deposit.contains(".")
            )
        )
            evt.consume();
        if (
            (
                deposit.contains(".") ||
                deposit.contains(",")
            ) &&
            (
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA
            )
        )
            evt.consume();
        else if (key == KeyEvent.VK_COMMA) {
            evt.consume();
            depositField.setText(deposit + '.');
        }
    }

    private void withdrawalFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        String withdrawal = withdrawalField.getText();
        if (
            !(
                key == KeyEvent.VK_DELETE ||
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA ||
                Character.isDigit(key)
            ) ||
            withdrawal.length() >= 11 ||
            (
                withdrawal.length() - withdrawal.indexOf('.') > 2 &&
                withdrawal.contains(".")
            )
        )
            evt.consume();
        if (
            (
                withdrawal.contains(".") ||
                withdrawal.contains(",")
            ) &&
            (
                key == KeyEvent.VK_PERIOD ||
                key == KeyEvent.VK_COMMA
            )
        )
            evt.consume();
        else if (key == KeyEvent.VK_COMMA) {
            evt.consume();
            withdrawalField.setText(withdrawal + '.');
        }
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public Customer getCliente() {
        return new Customer(null,
            this.firstNameField.getText(),
            this.lastNameField.getText(),
            this.rgField.getText(),
            this.cpfField.getText(),
            this.addressField.getText()
        );
    }

    public void setCliente(Customer customer) {
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        rgField.setText(customer.getRG());
        cpfField.setText(customer.getCPF());
        addressField.setText(customer.getAddress());
    }

    public int getSelectedLine(MouseEvent evt) {
        return this.getTable().rowAtPoint(evt.getPoint());
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BankView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BankView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BankView.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankView().setVisible(true);
            }
        });
    }

    public JButton getUpdateBtn() {
        return this.updateBtn;
    }

    public JButton getDeleteBtn() {
        return this.deleteBtn;
    }

    public JButton getClenaBtn() {
        return this.clenaBtn;
    }

    public JButton getListBtn() {
        return this.listBtn;
    }

    public JButton getAssignBtn() {
        return this.assignBtn;
    }

    public JButton getInsertBtn() {
        return this.insertBtn;
    }

    public JTextField getFirstNameField() {
        return this.firstNameField;
    }

    public JTextField getLastNameField() {
        return this.lastNameField;
    }

    public JTextField getRgField() {
        return this.rgField;
    }

    public JTextField getCpfField() {
        return this.cpfField;
    }

    public JTextField getAddressField() {
        return this.addressField;
    }

    public JTable getTable() {
        return this.customersTable;
    }

    public JComboBox<String> getCpfCombo() {
        return this.cpfCombo;
    }

    public JComboBox<String> getCpfCombo2() {
        return this.cpfCombo2;
    }

    public JButton getDepositBtn() {
        return this.depositBtn;
    }

    public JTextField getFirstNameField2() {
        return this.firstNameField2;
    }

    public JTextField getLastNameField2() {
        return this.lastNameField2;
    }

    public JTextField getAccNumberField() {
        return this.accNumberField;
    }

    public JButton getPaymentBtn() {
        return this.paymentBtn;
    }

    public JButton getWithdrawalBtn() {
        return this.withdrawalBtn;
    }

    public JTextField getBalanceField() {
        return this.balanceField;
    }

    public JTextArea getGeneralStatusField() {
        return this.generalStatusField;
    }

    public JTextField getAccTypeField() {
        return this.accTypeField;
    }

    public JComboBox<String> getAccountCombo() {
        return this.accountCombo;
    }

    public JPanel getInvestmentAccountsPanel() {
        return this.investmentAccountsPanel;
    }

    public JPanel getCheckingAccountsPanel() {
        return this.checkingAccountsPanel;
    }

    public JTextField getAccNumberField2() {
        return this.accNumberField2;
    }

    public JTextField getInitialDepositField() {
        return this.initialDepositField;
    }

    public JTextField getMaxLimitField() {
        return this.maxLimitField;
    }

    public JTextField getMinBalanceField() {
        return this.minBalanceField;
    }

    public JTextField getMinDepositField() {
        return this.minDepositField;
    }

    public JTextField getDepositField() {
        return this.depositField;
    }

    public JTextField getWithdrawalField() {
        return this.withdrawalField;
    }

    public JTextField getAccNameToAssignField() {
        return this.accNumberToAssignField;
    }

    public JTextField getFirstNameToAssignField() {
        return this.firstNameToAssignField;
    }

    public JTextArea getFormStatusField() {
        return this.formStatusField;
    }

    public JTextArea getAssignmentStatusField() {
        return this.assignmentStatusField;
    }

    public JTextField getAccTypeToAssignField() {
        return this.accTypeToAssignField;
    }

    public JTextField getLastNameToassignField() {
        return this.lastNameToassignField;
    }

    public JButton getCleanFormBtn() {
        return this.cleanFormBtn;
    }

    public JButton getDisassignBtn() {
        return this.disassignBtn;
    }

    public JButton getSortFirstNameBtn() {
        return this.sortFirstNameBtn;
    }

    public JButton getSortLastNameBtn() {
        return this.sortLastNameBtn;
    }
}
