import javax.swing.*;
import java.awt.*;

/**
 * this class is the panel that contains game buttons
 * @author chibuzo okpara
 */
public class UnoGameButtonPanel extends JPanel {
    public UnoGameButtonPanel(Game model, UnoGameController ctr){
        super();
        this.setPreferredSize(new Dimension(300,50));
        this.setLayout(new FlowLayout());

        JButton drawCardButton = new JButton("Draw a card");
        JButton playCardButton = new JButton("Play card");
        playCardButton.setActionCommand(String.valueOf(UnoGameEvent.EventType.CARD_PLAYED));
        drawCardButton.setActionCommand(String.valueOf(UnoGameEvent.EventType.CARD_DRAWN));


        playCardButton.addActionListener(ctr);
        drawCardButton.addActionListener(ctr);

        this.add(drawCardButton);
        this.add(playCardButton);
    }

}
