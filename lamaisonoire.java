import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;
import dev.robocode.tankroyale.botapi.graphics.Color;

// ------------------------------------------------------------------
// lanaisonoire
// ------------------------------------------------------------------
// A sample bot original made for Robocode by Kea Mothapo
//
// Continuously moves in a circle while firing at maximum power when
// detecting enemies.
// ------------------------------------------------------------------
public class lanaisonoire extends Bot {

    // The main method starts our bot
    public static void main(String[] args) {
        new lanaisonoire().start();
    }

    // Called when a new round is started -> initialize and do some movement
    @Override
    public void run() {
        setBodyColor(Color.PURPLE);
        setTurretColor(Color.PURPLE);
        setRadarColor(Color.PURPLE);
        setScanColor(Color.PURPLE);

        // Repeat while the bot is running - Gray bot style movement
        while (isRunning()) {
            // Move in circles like Gray bot - turn right a lot
            setTurnRight(10_000);
            // Set speed similar to Gray bot
            setMaxSpeed(6);
            // Start moving and turning in circles
            forward(10_000);
        }
    }

    // Simple enemy detection and firing like Gray bot
    @Override
    public void onScannedBot(ScannedBotEvent e) {
        // Fire maximum power like Gray bot - simple and effective
        fire(5);
    }
    
    // Wall avoidance - turn away when hitting walls
    @Override
    public void onHitWall(HitWallEvent e) {
        // Turn away from wall and move back
        back(50);
        turnRight(90);
    }
    
    // Bot collision handling similar to Gray bot
    @Override
    public void onHitBot(HitBotEvent e) {
        // Gray bot style collision handling
        var direction = directionTo(e.getX(), e.getY());
        var bearing = calcBearing(direction);
        
        // Fire if enemy is in front
        if (bearing > -10 && bearing < 10) {
            fire(5);
        }
        
        // Turn to continue spinning if we rammed
        if (e.isRammed()) {
            turnRight(10);
        }
    }
}