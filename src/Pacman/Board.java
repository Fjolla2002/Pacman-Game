package Pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	Image titleScreen = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\titleScreen1.jpg");
	Image over = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\over.jpg");
	Image win = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\win.jpg");
	
	//Ghosts:
	Image red_ghost1 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost10.jpg");	
	Image red_ghost2 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost11.jpg");
	Image[] G_red = {red_ghost1, red_ghost2};
	
	Image yellow_ghost1 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost20.jpg");	
	Image yellow_ghost2 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost21.jpg");
	Image[] G_yellow = {yellow_ghost1, yellow_ghost2};
	
	Image blue_ghost1 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost30.jpg");	
	Image blue_ghost2 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost31.jpg");
	Image[] G_blue = {blue_ghost1, blue_ghost2};
	
	Image pink_ghost1 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost40.jpg");	
	Image pink_ghost2 = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\ghost41.jpg");
	Image[] G_pink = {pink_ghost1, pink_ghost2};
	
	Ghost ghost1 = new Ghost(10 * Component.cellSize, 8 * Component.cellSize);
	Ghost ghost2 = new Ghost(10 * Component.cellSize, 9 * Component.cellSize);
	Ghost ghost3 = new Ghost(11 * Component.cellSize, 9 * Component.cellSize);
	Ghost ghost4 = new Ghost(9 * Component.cellSize, 9 * Component.cellSize);
	
	
	//Pacman:
	Image Pacman = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\pacman.jpg");
	
	Image Pacman_left = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\pacmanleft.jpg");	
	Image Pacman_right = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\pacmanright.jpg");	
	Image Pacman_up = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\pacmanup.jpg");	
	Image Pacman_down = Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\pacmandown.jpg");	
	Image[] Pacman_images = {Pacman_left, Pacman_right, Pacman_up, Pacman_down};
	
	Pacman pacman = new Pacman(10 * Component.cellSize, 15 * Component.cellSize);

   boolean title;
   boolean balls[][];
   boolean states[][];
   int lives = 3;
  int score;

   
   public void drawLives(Graphics g) {
	   g.setColor(Color.YELLOW);
	   for(int i = 0; i < lives; i++)
		   g.drawImage(Pacman_left,(Component.cellSize + 5) *i + 30, Component.max + 10, null);
   }
   
   public void init() {
	   for(int i = 0; i < Component.cellSize; i++) {
		   for(int j = 0; j < Component.cellSize; j++) {
			   balls[i][j] = true;
			   states[i][j] = true;
			   
		   }
	   }
	   
	   balls[10][8] = false;
	   balls[10][9] = false;
	   balls[11][9] = false;
	   balls[9][9] = false;
	   balls[10][15] = false;
	   balls[9][6] = false;
	   balls[11][6] = false;
	   balls[6][9] = false;
	   balls[14][9] = false;
	   balls[7][7] = false;
	   balls[7][8] = false;
	   balls[7][9] = false;
	   balls[7][10] = false;
	   balls[7][11] = false;
	   balls[7][12] = false;
	   balls[8][7] = false;
	   balls[9][7] = false;
	   balls[10][7] = false;   
	   balls[11][7] = false;
	   balls[12][7] = false;
	   balls[13][7] = false;
	   balls[8][11] = false;
	   balls[9][11] = false;
	   balls[10][11] = false;   
	   balls[11][11] = false;
	   balls[12][11] = false;
	   balls[13][11] = false;
	   balls[13][8] = false;
	   balls[13][9] = false;
	   balls[13][10] = false;
	   balls[13][12] = false;
	   
   }
	public Board() {
		title = true;
		balls = new boolean[Component.cellSize][Component.cellSize];
		states = new boolean[Component.cellSize][Component.cellSize];
		init();
	}
	
	public void update(Graphics g, int x, int y, int gjeresia, int gjatesia) {
		g.drawRect(x, y, gjeresia, gjatesia);
		
		for(int i = x/20; i < x/20 + gjeresia/20; i++) {
	 		   for(int j = y/20; j <y/20 + gjatesia/20; j++) {
	 			  balls[i][j] = false;
	 			  states[i - 1][j - 1] = false; 
	 		   }
	 		}
		
	}
	
	public void reset() {
		if(lives > 0)
			lives--;
		
		ghost1.x = 10 * Component.cellSize;
		ghost1.y = 8 * Component.cellSize;
		
		ghost2.x = 10 * Component.cellSize;
		ghost2.y = 9 * Component.cellSize;
		
		ghost3.x = 11 * Component.cellSize;
		ghost3.y = 9 * Component.cellSize;
		
		ghost4.x = 9 * Component.cellSize;
		ghost4.y = 9 * Component.cellSize;
		
		pacman.x = 10 * Component.cellSize;
		pacman.y = 15 * Component.cellSize;
		
		Game.flag = true;
		
	}
	
	public void drawBalls(Graphics g) {
        g.setColor(Color.YELLOW);
        for(int i = 1; i < Component.cellSize; i++) {
 		   for(int j = 1; j < Component.cellSize; j++) {
 			  if(balls[i][j])
 			   g.fillOval(i * 20 + 8, j * 20 + 8, 4, 4);
 			   
 		   }
 	   }
        
	}
	
	public void drawBoard(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(19, 19, 382, 382);
		
		update(g,40,40,60,20);
		update(g,120,40,60,20);
		update(g,200,20,20,40);
		update(g,240,40,60,20);
		update(g,320,40,60,20);
		update(g,40,80,60,20);
		update(g,160,80,100,20);
		update(g,200,100,20,40);
		update(g,320,80,60,20);
		update(g,20,120,80,60);
		update(g,320,120,80,60);
		update(g,20,200,80,60);
		update(g,320,200,80,60);
		update(g,160,160,40,20);
		update(g,220,160,40,20);
		update(g,160,180,20,40);
		update(g,180,200,60,20);
		update(g,240,180,20,40);
		update(g,140,120,40,20);
		update(g,120,80,20,100);
		update(g,280,80,20,100);
		update(g,240,120, 40,20);
		update(g,280,200,20,60);    
		update(g,120,200,20,60); 
		update(g,160,240,100,20);
		update(g,200,260,20,40);
		update(g,120,280,60,20);
		update(g,240,280,60,20);
		update(g,40,280,40,20);
		update(g,80,280,20,60);
		update(g,340,280,40,20);
		update(g,320,280,20,60);
		update(g,20,320,40,20);
		update(g,360,320,40,20);
		update(g,160,320,100,20);
		update(g,200,340,20,40);
		update(g,40,360,140,20);
		update(g,240,360,140,20);
		update(g,280,320,20,40);
		update(g,120,320,20,40);
		
		
		
		repaint();
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 438, 500);
		
		drawBoard(g);
		drawBalls(g);
		drawLives(g);
		
		Font f = new Font("Arial", Font.BOLD, 20);
		g.setFont(f);
		g.setColor(Color.YELLOW);
		g.drawString("Score: " + score, Component.max/2 + 80, Component.max/2 + 230);
		Font f2 = new Font("Arial", Font.BOLD, 10);
		g.setFont(f2);
		g.drawString("Press Space to go to the main menu ", 30, 450);
		
		
		g.drawImage(G_red[ghost1.index], ghost1.x, ghost1.y, null);
		g.drawImage(G_yellow[ghost2.index], ghost2.x, ghost2.y, null);
		g.drawImage(G_pink[ghost3.index], ghost3.x, ghost3.y, null);
		g.drawImage(G_blue[ghost4.index], ghost4.x, ghost4.y, null);
		
		g.drawImage(Pacman_images[pacman.index], pacman.x, pacman.y, null);
		
		Font f1 = new Font("Arial", Font.BOLD, 40);
        g.setFont(f);
		if(title) {
			g.drawImage(titleScreen, 0, 0, null);
			g.setColor(Color.WHITE);
			g.drawString("Press enter to start", 125, 360);
			g.drawString("Press arrow keys to move", 100, 380);
			
		}
		g.setColor(Color.RED);
		g.setFont(f1);
		if(lives == 0)
			//g.drawImage(over, 0, 0, null);
			g.drawString("Game Over:(", 100, 215);
		
		g.setColor(Color.GREEN);
		if(check())
			//g.drawImage(win, 0, 0, null);
			g.drawString("You Won!", 120, 215);
	}
	
	public boolean check() {
		 for(int i = 1; i < Component.cellSize; i++) {
			   for(int j = 1; j < Component.cellSize; j++) {
				   if(balls[i][j])
					   return false;
			   }
			  
	        }
		 return true;
	}

}
