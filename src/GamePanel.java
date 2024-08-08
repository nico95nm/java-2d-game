

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

    // FPS
    int FPS = 60;


    // Set players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;




public GamePanel() {
    // SCREEN SETTINGS
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
}
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
    }

    /*
    @Override
    public void run() {
        // sleep method nanosecond - precise calculation
        double drawInterval = 1000000000/FPS; // 0.016666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread !=null){
            // long currentTime = System.nanoTime();
            // System.out.println("Current Time" + currentTime);
            // This is also good but we dont use it
            // long currentTime2 = System.currentTimeMillis();

            System.out.println("This game loop is running");
            // 1 Update: update information such as character position
            update();

            // 2 Draw: Draw the screen with the updated information
            repaint();

            try {
            double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;

                }

            Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
}*/
public void run() {

    double drawInterval = 1000000/FPS;
    double delta = 0;

    long lastTime = System.nanoTime();
    long currentTime;

    while (gameThread != null){
        currentTime = System.nanoTime();
        delta +=(currentTime-lastTime)/drawInterval;

        lastTime = currentTime;
        if (delta >= 1) {

update();
repaint();
          delta--;

        }


    }
}
public void update(){
    if(keyH.upPressed == true){
        playerY -= playerSpeed;
        // same
        playerY = playerY - playerSpeed;
    } else if (keyH.downPressed == true){
        playerY += playerSpeed;
    } else if (keyH.leftPressed == true) {
        playerX -= playerSpeed;
    } else if (keyH.rightPressed == true) {
        playerX += playerSpeed;
    }


}
public void paintComponent(Graphics g){
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.white);

    g2.fillRect(playerX, playerY, tileSize, tileSize);

    g2.dispose();

}


}
