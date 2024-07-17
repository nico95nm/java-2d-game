

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;


    final int tileSize= originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenRow; // 768px
    final int screenHeight = tileSize * maxScreenRow; // 576px

public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
}
    Thread gameThread;

public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread !=null){

            System.out.println("This game loop is running");
            // 1 Update: update information such as character position
            update();

            // 2 Draw: Draw the screen with the updated information
            repaint();
        }
}

public void update(){}
public void paintComponent(Graphics g){
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.white);

    g2.fillRect(100, 100, tileSize, tileSize);

    g2.dispose();

}


}
