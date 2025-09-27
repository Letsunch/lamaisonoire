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

        // Repeat while the bot is running
        while (isRunning()) {
            // Tell the game that when we take move, we'll also want to turn right... a lot
            setTurnRight(20_000);
            // Limit our speed to 5
            setMaxSpeed(10);
            // Start moving (and turning)
            forward(8_000);
        }
    }

    // We scanned another bot -> fire hard!
    @Override
    public void onScannedBot(ScannedBotEvent e) {
        fire(5);
    }
}