package e2;

import e2.logic.Logics;
import e2.logic.LogicsImpl;
import e2.model.WorldFactoryImpl;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size) {
        this.logics = new LogicsImpl(new WorldFactoryImpl().createWorldWithRandomMines(size, size));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);
        
        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        ActionListener onClick = e -> {
            final JButton bt = (JButton) e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            // call the logic here to tell it that cell at 'pos' has been selected
            boolean aMineWasFound = logics.explore(pos);
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = this.logics.isWin(); // call the logic here to ask if there is victory
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    // call the logic here to put/remove a flag
                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
        List<Pair<Integer, Integer>> bombCells = this.logics.getWorld().getPositionsFromType(e2.model.Type.MINE);
    	for (var entry : this.buttons.entrySet()) {
            if (entry.getKey().isEnabled() && bombCells.contains(entry.getValue())) {
                entry.getKey().setText("*");
            }
    	}
        this.getContentPane().setEnabled(false);
    }

    private void drawBoard() {
        for (var entry : this.buttons.entrySet()) {
            if (this.logics.getWorld().getCellFromPosition(entry.getValue()).getState().equals(State.DISABLED)) {
                Optional<Integer> optNumBombs =
                        this.logics.getWorld().getCellFromPosition(entry.getValue()).getNumber();
                if (optNumBombs.isPresent()) {
                    int numBombs = optNumBombs.get();
                    if (numBombs > 0) {
                        entry.getKey().setText(String.valueOf(numBombs));
                    }
                } else {
                    entry.getKey().setText("*");
                }
                entry.getKey().setEnabled(false);
            }
    	}


    }
    
}
