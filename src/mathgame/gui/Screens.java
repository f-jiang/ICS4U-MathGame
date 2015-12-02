/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Timer;
import mathgame.game.GameMode;
import mathgame.questions.Answer;
import mathgame.util.calculator.Calculator;
import mathgame.mediator.MathGameMediator;

/**
 *
 * @author Feilan
 */
public class Screens extends javax.swing.JFrame /*implements PropertyChangeListener*/ {
    
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
        
        healthProgressBar.setMaximum(mediator.getStartingHealth());
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
        finalScoreLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        screens = new javax.swing.JPanel();
        startScreen = new javax.swing.JPanel();
        algebraButton = new javax.swing.JButton();
        trigButton = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        gameScreen = new javax.swing.JPanel();
        questionSplitPane = new javax.swing.JSplitPane();
        answerContent = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        calculatorTextField = new javax.swing.JTextField();
        healthProgressBar = new javax.swing.JProgressBar();
        timeLeftLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        scoreDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        scoreDialog.setTitle("Game Over");
        scoreDialog.setMinimumSize(new java.awt.Dimension(200, 150));
        scoreDialog.setName("scoreDialog"); // NOI18N

        finalScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finalScoreLabel.setText("jLabel1");
        finalScoreLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        finalScoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scoreDialog.getContentPane().add(finalScoreLabel, java.awt.BorderLayout.CENTER);

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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        startScreen.add(algebraButton, gridBagConstraints);

        trigButton.setText("Trigonometry");
        trigButton.setPreferredSize(new java.awt.Dimension(100, 31));
        trigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trigButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        startScreen.add(trigButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        startScreen.add(filler11, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Math Binge");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        startScreen.add(jLabel1, gridBagConstraints);

        screens.add(startScreen, "startScreen");

        gameScreen.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gameScreen.setLayout(new java.awt.GridBagLayout());

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
            .addGap(0, 46, Short.MAX_VALUE)
        );

        questionSplitPane.setRightComponent(answerContent);

        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionLabel.setText("jLabel2");
        questionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        questionSplitPane.setLeftComponent(questionLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.9;
        gameScreen.add(questionSplitPane, gridBagConstraints);

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.weighty = 0.1;
        gameScreen.add(quitButton, gridBagConstraints);

        calculatorTextField.setToolTipText("Calculator");
        calculatorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calculatorTextFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.85;
        gridBagConstraints.weighty = 0.1;
        gameScreen.add(calculatorTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gameScreen.add(healthProgressBar, gridBagConstraints);

        timeLeftLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLeftLabel.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.weighty = 0.1;
        gameScreen.add(timeLeftLabel, gridBagConstraints);

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0.1;
        gameScreen.add(scoreLabel, gridBagConstraints);

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

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        mediator.gameQuit();
        showStartScreen();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void calculatorTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calculatorTextFieldKeyTyped
        JTextField textField = (JTextField) evt.getSource();
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !textField.getText().equals("")) {
            String answer = Calculator.eval(textField.getText(), false);                    
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
        questionLabel.setText(question.getPrompt());        
                
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
            answerTextField.setText("");
            answerContentGridLayout.setRows(1);
            answerContent.add(answerTextField);            
        }            

        this.revalidate();    
    }
    
    public void endGame() {
        finalScoreLabel.setText("Your score: " + mediator.getScore());
        this.setEnabled(false);
        scoreDialog.setVisible(true);         
    }
    
    public void updateHealthBar() {
        healthProgressBar.setValue(mediator.getCurrentHealth());
    }
    
    public void updateTimeLabel() {
        int time = (int) mediator.getTimeLeftForQuestion();
        timeLeftLabel.setText(String.valueOf(time / 1000));
    }
    
    public void updateScoreLabel() {
        int score = mediator.getScore();
        scoreLabel.setText("Score: " + score);
    }
    
    private void showGameScreen() {        
        CardLayout card = (CardLayout) screens.getLayout();
        card.show(screens, "gameScreen");
        calculatorTextField.setText("");
        scoreLabel.setText("Score: 0");
        healthProgressBar.setValue(healthProgressBar.getMaximum());
    }
    
    private void showStartScreen() {
        CardLayout card = (CardLayout) screens.getLayout();
        card.show(screens, "startScreen");                        
    }

    private MathGameMediator mediator;
    private JLabel promptLabel;
    private JButton answerButton;
    private JTextField answerTextField;
    private GridLayout answerContentGridLayout;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton algebraButton;
    private javax.swing.JPanel answerContent;
    private javax.swing.JTextField calculatorTextField;
    private javax.swing.Box.Filler filler11;
    private javax.swing.JLabel finalScoreLabel;
    private javax.swing.JPanel gameScreen;
    private javax.swing.JProgressBar healthProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JSplitPane questionSplitPane;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JDialog scoreDialog;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JPanel screens;
    private javax.swing.JPanel startScreen;
    private javax.swing.JLabel timeLeftLabel;
    private javax.swing.JButton trigButton;
    // End of variables declaration//GEN-END:variables
}
