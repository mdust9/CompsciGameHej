package GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import GUI.GamePanel;
import Keys.Keys;
import Objects.Location;
import Objects.Obstacle;
import Objects.Platform;
import Objects.Player;

//FOR PLAYER UPDATE - CHECK IF FALLING
//create method that generates objects
public class Level1AState extends GameState {
	
	//private Background ???
	
	private Player player;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Platform> platforms;
	
	Platform p1;
	Platform p2;
	Platform p3;
	Platform p4;
	
	private double oldTime;
	
	private Location end = new Location(1,5);
	//private HUD hud;
	//private BufferedImage hageonText;
	//private Title title;
	//private Title subtitle;
	//private Teleport teleport;
	
	// old events
	private boolean blockInput = false;
	private int eventCount = 0;
	private boolean eventFinish;
	private boolean eventDead;
	
	//NEW EVENTS
	private boolean eventStart;
	private ArrayList<Rectangle> tb;
	
	public Level1AState(GameStateManager gsm) {
		super(gsm);
		init();
	}
	
	public void init() {
		
		// backgrounds(initiate here)
		
		p1 = new Platform(new Location(0,0), 1, 5);
		p2 = new Platform(new Location(0,2), 0, 5);
		p3 = new Platform(new Location(1,3), 2, 5);
		p4 = new Platform(new Location(1,5), 0, 5);
		
		player = new Player(p1);
		
		obstacles.add(new Obstacle(new Location(5,5), p4));
		
		oldTime = System.currentTimeMillis()/1000;
		
		//hud = new HUD(player);
		
		/*try {
			hageonText = ImageIO.read(
				getClass().getResourceAsStream("/HUD/HageonTemple.gif")
			);
			title = new Title(hageonText.getSubimage(0, 0, 178, 20));
			title.sety(60);
			subtitle = new Title(hageonText.getSubimage(0, 20, 82, 13));
			subtitle.sety(85);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		// start event
		eventStart = true;
		tb = new ArrayList<Rectangle>();
		eventStart();
	}
	
	
	public void update() {
		
		// check keys
		handleInput();
		
		checkCollisions();
		
		// check if end of level event should start
		if(player.getLocation().equals(end)) {//NEED .EQUALS METHOD
			eventFinish = blockInput = true;
		}
		
		// check if player dead event should start
		if(player.getLives() == 0) {
			eventDead = blockInput = true;
		}
		
		// play events
		if(eventStart) eventStart();
		if(eventDead) eventDead();
		if(eventFinish) eventFinish();
		/*
		// move title and subtitle
		if(title != null) {
			title.update();
			if(title.shouldRemove()) title = null;
		}
		if(subtitle != null) {
			subtitle.update();
			if(subtitle.shouldRemove()) subtitle = null;
		}
		
		// move backgrounds
		clouds.setPosition(tileMap.getx(), tileMap.gety());
		mountains.setPosition(tileMap.getx(), tileMap.gety());
		*/
		
		// update enemies
		updateEnemies();
		
		// update player
		updatePlayer();
	}
	
	
	public void draw(Graphics2D g) {
		/*
		// draw background
		sky.draw(g);
		clouds.draw(g);
		mountains.draw(g);
		
		// draw tilemap
		tileMap.draw(g);
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		// draw enemy projectiles
		for(int i = 0; i < eprojectiles.size(); i++) {
			eprojectiles.get(i).draw(g);
		}
		
		// draw explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).draw(g);
		}
		
		// draw player
		player.draw(g);
		
		// draw teleport
		teleport.draw(g);
		
		// draw hud
		hud.draw(g);
		
		// draw title
		if(title != null) title.draw(g);
		if(subtitle != null) subtitle.draw(g);
		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		for(int i = 0; i < tb.size(); i++) {
			g.fill(tb.get(i));
		}
		*/
	}
	
	//LOOK AT THIS STUFFS
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) gsm.setPaused(true);
		if(blockInput || player.getLives() == 0) return;
		if(Keys.keyState[Keys.UP]) player.climb();
		if(Keys.keyState[Keys.LEFT]) player.moveLeft();
		if(Keys.keyState[Keys.RIGHT]) player.moveLeft();
		if(Keys.keyState[Keys.SPACE]) player.jump();
	}

///////////////////////////////////////////////////////
//////////////////// EVENTS
///////////////////////////////////////////////////////
	
	// reset level
	/*private void reset() {
		player.reset();
		player.setPosition(300, 161);
		populateEnemies();
		blockInput = true;
		eventCount = 0;
		eventStart = true;
		eventStart();
		title = new Title(hageonText.getSubimage(0, 0, 178, 20));
		title.sety(60);
		subtitle = new Title(hageonText.getSubimage(0, 33, 91, 13));
		subtitle.sety(85);
	}*/
	
	// level started
	private void eventStart() {
		eventCount++;
		if(eventCount == 1) {
			tb.clear();
			tb.add(new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT / 2));
			tb.add(new Rectangle(0, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT));
			tb.add(new Rectangle(0, GamePanel.HEIGHT / 2, GamePanel.WIDTH, GamePanel.HEIGHT / 2));
			tb.add(new Rectangle(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT));
		}
		if(eventCount > 1 && eventCount < 60) {
			tb.get(0).height -= 4;
			tb.get(1).width -= 6;
			tb.get(2).y += 4;
			tb.get(3).x += 6;
		}
		/*if(eventCount == 30) title.begin();
		if(eventCount == 60) {
			eventStart = blockInput = false;
			eventCount = 0;
			subtitle.begin();
			tb.clear();
		}*/
	}
	
	// player has died
	private void eventDead() {
		gsm.setState(GameStateManager.MENUSTATE);
	}
	
	// finished level
	private void eventFinish() {
		gsm.setState(GameStateManager.MENUSTATE);
	}
	
	public void checkCollisions(){
		for(Obstacle o: obstacles){
			if (o.getPolygon().intersects(player.getLocation().getX(), player.getLocation().getY(), 1, 1)){
				player.loseLife();//check
			}
		}
	}
	
	public void updateEnemies(){
		if(((System.currentTimeMillis()/1000)-oldTime)%5==0){
			obstacles.add(new Obstacle(new Location(5,5), p4));
		}
		for(Obstacle o: obstacles){
			o.move();
		}
	}
	
	public void updatePlayer(){
		player.setPlatform(null);
		for(Platform p: platforms){
			if (p.getPolygon().intersects(player.getLocation().getX(), player.getLocation().getY(), 1, 1)){
				player.setPlatform(p);
			}
		}	
	}
}
