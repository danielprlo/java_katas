import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasLightKataTest {
    private HouseLightsGrid houseLightsGrid;
    @BeforeEach
    void init() {
        this.houseLightsGrid = new HouseLightsGrid(1000);
    }
    @Test
    void test_example_1() {
        // turn on 0,0 through 999,999 would turn on (or leave on) every light.
        this.houseLightsGrid.turnOnMultipleLights(new Point(0,0),new Point(999,999));
        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(1000000);
    }

    @Test
    void test_example_2() {
        /*
            toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off
            the ones that were on, and turning on the ones that were off.
        */

        this.houseLightsGrid.toggleMultipleLights(new Point(0,0),new Point(999,0));
        assertThat(this.houseLightsGrid.getTotalCountLightsOn()).isEqualTo(1000);
        for (boolean[] row: this.houseLightsGrid.getLightsGrid()) {
            assertThat(row[0]).isEqualTo(true);
        }
    }

    @Test
    void test_example_3() {
        // turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
        this.houseLightsGrid.turnOnMultipleLights(new Point(0,0),new Point(999,999));
        this.houseLightsGrid.turnOffMultipleLights(new Point(499,499),new Point(500,500));
        assertThat(this.houseLightsGrid.getTotalCountLightsOn()).isEqualTo(999996);
    }

    @Test
    void instructions_example() {
        // turn on 887,9 through 959,629
        this.houseLightsGrid.turnOnMultipleLights(new Point(887,9), new Point(959,629));
        // turn on 454,398 through 844,448
        this.houseLightsGrid.turnOnMultipleLights(new Point(454,398),new Point(844,448));
        // turn off 539,243 through 559,965
        this.houseLightsGrid.turnOffMultipleLights(new Point(539, 243), new Point(559,965));
        // turn off 370,819 through 676,868
        this.houseLightsGrid.turnOffMultipleLights(new Point(370,819), new Point(676, 868));
        // turn off 145,40 through 370,997
        this.houseLightsGrid.turnOffMultipleLights(new Point(145,40), new Point(370, 997));
        // turn off 301,3 through 808,453
        this.houseLightsGrid.turnOffMultipleLights(new Point(301,3), new Point(808,453));
        // turn on 351,678 through 951,908
        this.houseLightsGrid.turnOnMultipleLights(new Point(351,678), new Point(951,908));
        // toggle 720,196 through 897,994
        this.houseLightsGrid.toggleMultipleLights(new Point(720,196), new Point(897,994));
        // toggle 831,394 through 904,860
        this.houseLightsGrid.toggleMultipleLights(new Point(831,394), new Point(904,860));

        assertThat(this.houseLightsGrid.getTotalCountLightsOn()).isEqualTo(230022);
    }
}
