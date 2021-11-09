import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel guessLabel;
  JLabel highLowLabel;
  JLabel previousGuessLabel;
  Random r = new Random();
  int randomNum;

  GuessingGame() {
    randomNum = r.nextInt(100) + 1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    guessLabel = new JLabel("Enter your guess: ");
    highLowLabel = new JLabel("");
    previousGuessLabel = new JLabel("");

    frame.add(guessLabel);
    frame.add(userGuess);
  
    frame.add(highLowLabel);
    frame.add(guessButton);

    frame.add(previousGuessLabel);
    frame.add(playAgainButton);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
      
      if (guess < randomNum) {
        highLowLabel.setText("Too low!");
        previousGuessLabel.setText("Last guess was: " + guess);
      }
      else if (guess > randomNum) {
        highLowLabel.setText("Too high!");
        previousGuessLabel.setText("Last guess was: " + guess);
      }
      else {
        highLowLabel.setText("You got it!");
        previousGuessLabel.setText("Last guess was: " + guess);
      }
    }

    else if(ae.getActionCommand().equals("Play Again")) {
      randomNum = r.nextInt(100) + 1;

      previousGuessLabel.setText("");
      highLowLabel.setText("");
      guessLabel.setText("");
      userGuess.setText("");
    }
    else {
      highLowLabel.setText("You pressed Enter. Please press the Guess Button.");
    }
  } 
}

