/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.gui;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import mathgame.game.GameMode;
import mathgame.questions.Answer;
import mathgame.util.calculator.Calculator;
import mathgame.mediator.MathGameMediator;

/**
 *
 * @author Feilan
 */
public class Screens extends javax.swing.JFrame {

    /**
     * Creates new form Screens
     * @param mediator
     */
    public Screens(MathGameMediator mediator) {        
        this.mediator = mediator;
        
        // TODO: pick a nicer look and feel
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>                
        
        //</editor-fold>
        
        initComponents();
                
        answerContentGridLayout = new GridLayout(1, 1);
        answerContent.setLayout(answerContentGridLayout);
        
        answerTextField = new JTextField();
        answerTextField.setToolTipText("Answer here");
        answerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                answerTextFieldKeyTyped(evt);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scoreDialog = new javax.swing.JDialog();
        scoreLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        screens = new javax.swing.JPanel();
        startScreen = new javax.swing.JPanel();
        algebraButton = new javax.swing.JButton();
        algebraStatsLabel = new javax.swing.JLabel();
        trigButton = new javax.swing.JButton();
        eraseStatsButton = new javax.swing.JButton();
        trigStatsLabel = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        gameScreen = new javax.swing.JPanel();
        questionSplitPane = new javax.swing.JSplitPane();
        answerContent = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        calculatorTextField = new javax.swing.JTextField();

        scoreDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        scoreDialog.setMinimumSize(new java.awt.Dimension(200, 150));
        scoreDialog.setName("scoreDialog"); // NOI18N

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("jLabel1");
        scoreLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scoreDialog.getContentPane().add(scoreLabel, java.awt.BorderLayout.CENTER);

        returnButton.setText("Return to Main Menu");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        scoreDialog.getContentPane().add(returnButton, java.awt.BorderLayout.PAGE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));

        screens.setAutoscrolls(true);
        screens.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        screens.setLayout(new java.awt.CardLayout());

        startScreen.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        startScreen.setLayout(new java.awt.GridBagLayout());

        algebraButton.setText("Algebra/Functions");
        algebraButton.setPreferredSize(new java.awt.Dimension(100, 31));
        algebraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algebraButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        startScreen.add(algebraButton, gridBagConstraints);

        algebraStatsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        algebraStatsLabel.setText("jLabel1");
        algebraStatsLabel.setFocusable(false);
        algebraStatsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        startScreen.add(algebraStatsLabel, gridBagConstraints);

        trigButton.setText("Trigonometry");
        trigButton.setPreferredSize(new java.awt.Dimension(100, 31));
        trigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trigButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        startScreen.add(trigButton, gridBagConstraints);

        eraseStatsButton.setText("Erase Stats");
        eraseStatsButton.setPreferredSize(new java.awt.Dimension(100, 31));
        eraseStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseStatsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        startScreen.add(eraseStatsButton, gridBagConstraints);

        trigStatsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trigStatsLabel.setText("jLabel3");
        trigStatsLabel.setFocusable(false);
        trigStatsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        startScreen.add(trigStatsLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        startScreen.add(filler11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        startScreen.add(filler12, gridBagConstraints);

        screens.add(startScreen, "startScreen");

        gameScreen.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gameScreen.setLayout(new java.awt.BorderLayout(0, 10));

        questionSplitPane.setResizeWeight(0.5);
        questionSplitPane.setToolTipText("");
        questionSplitPane.setEnabled(false);

        javax.swing.GroupLayout answerContentLayout = new javax.swing.GroupLayout(answerContent);
        answerContent.setLayout(answerContentLayout);
        answerContentLayout.setHorizontalGroup(
            answerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        answerContentLayout.setVerticalGroup(
            answerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        questionSplitPane.setRightComponent(answerContent);

        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionLabel.setText("jLabel2");
        questionSplitPane.setLeftComponent(questionLabel);

        gameScreen.add(questionSplitPane, java.awt.BorderLayout.CENTER);

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        gameScreen.add(quitButton, java.awt.BorderLayout.PAGE_END);

        calculatorTextField.setToolTipText("Calculator");
        calculatorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calculatorTextFieldKeyTyped(evt);
            }
        });
        gameScreen.add(calculatorTextField, java.awt.BorderLayout.PAGE_START);

        screens.add(gameScreen, "gameScreen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void algebraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algebraButtonActionPerformed
        mediator.gameStarted(GameMode.ALGEBRA);
        showGameScreen();
    }//GEN-LAST:event_algebraButtonActionPerformed

    private void eraseStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseStatsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eraseStatsButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        mediator.gameQuit();
        showStartScreen();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void calculatorTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calculatorTextFieldKeyTyped
        JTextField textField = (JTextField) evt.getSource();
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !textField.getText().equals("")) {
            String answer = Calculator.eval(textField.getText(), false);
            
            // temp code
            /*JFreeChart lineChart = ChartFactory.createXYLineChart(
                "f(x) = " + textField.getText(),
                "x", "f(x)",
                createDataset(textField.getText(), -10.0, 10.0),
                PlotOrientation.VERTICAL,
                true, true, false);
            ChartPanel chartPanel = new ChartPanel(lineChart);
            questionContent.add(chartPanel, BorderLayout.CENTER);*/
                    
            textField.setText((answer == null) ? "Error" : answer);
        }
    }//GEN-LAST:event_calculatorTextFieldKeyTyped

    private void trigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trigButtonActionPerformed
        mediator.gameStarted(GameMode.TRIGONOMETRY);
        showGameScreen();
    }//GEN-LAST:event_trigButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        this.setEnabled(true);
        scoreDialog.setVisible(false);
        showStartScreen();
    }//GEN-LAST:event_returnButtonActionPerformed
    
    //TODO: implement health bar
    //TODO: implement timer display
    
    private void answerTextFieldKeyTyped(KeyEvent evt) {
        JTextField textField = (JTextField) evt.getSource();
        String answer = textField.getText();
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !answer.equals("")) {        
            mediator.questionAnswered(answer);            
        }
    }
    
    private void answerButtonActionPerformed(ActionEvent evt) {
        JButton button = (JButton) evt.getSource();
        mediator.questionAnswered(button.getText());
    }
    
    public void loadQuestion(Answer question) {        
        answerContent.removeAll();
        questionLabel.setText(question.getPrompt()); // TODO: or is it getSolution()?

        if (question.isMultipleChoice()) {            
            int numButtons = question.getMultipleChoiceAnswers().length;
            answerContentGridLayout.setRows(numButtons);
            
            for (String answer : question.getMultipleChoiceAnswers()) {
                answerButton = new JButton();
                answerButton.setText(answer);
                answerButton.addActionListener((ActionEvent evt) -> {
                    answerButtonActionPerformed(evt);
                });
                answerContent.add(answerButton);
            }
        } else {
            answerContentGridLayout.setRows(1);
            answerContent.add(answerTextField);            
        }
        this.revalidate();
    }
    
    public void endGame() {
        scoreLabel.setText("Your score: "); // TODO: show an actual score
        this.setEnabled(false);
        scoreDialog.setVisible(true);        
    }
    
    private void showGameScreen() {
        CardLayout card = (CardLayout) screens.getLayout();
        card.show(screens, "gameScreen");
        calculatorTextField.setText("");
    }
    
    private void showStartScreen() {
        CardLayout card = (CardLayout) screens.getLayout();
        card.show(screens, "startScreen");                
    }

    /*private XYDataset createDataset(String function, double xmin, double xmax) {
        final double tickValue = 0.1;
        int numData = (int) Math.round((xmax - xmin) / tickValue);
        double[][] data = new double[2][numData];
        DefaultXYDataset dataset = new DefaultXYDataset();
        
        for (int i = 0; i < numData; i++, xmin += tickValue) {
            data[0][i] = xmin;            
            Calculator.storeVariable("x", xmin);
            data[1][i] = Double.parseDouble(Calculator.eval(function, false)); //null for small values
        }
        
        dataset.addSeries(function, data);
        
        return dataset;
    }*/
    
    private MathGameMediator mediator;
    private JLabel promptLabel;
//    private ChartPanel promptChartPanel;
    private JButton answerButton;
    private JTextField answerTextField;
    private GridLayout answerContentGridLayout;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton algebraButton;
    private javax.swing.JLabel algebraStatsLabel;
    private javax.swing.JPanel answerContent;
    private javax.swing.JTextField calculatorTextField;
    private javax.swing.JButton eraseStatsButton;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.JPanel gameScreen;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JSplitPane questionSplitPane;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JDialog scoreDialog;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JPanel screens;
    private javax.swing.JPanel startScreen;
    private javax.swing.JButton trigButton;
    private javax.swing.JLabel trigStatsLabel;
    // End of variables declaration//GEN-END:variables
}
