import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class HouseLightsGridTest {
    @Test
    void instantiation_class() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(10);
    }

    @Test
    void all_lights_are_set_to_off_on_instantiation() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(2);
        boolean[][] lightsGrid = houseLightsGrid.getLightsGrid();
        assertThat(lightsGrid).isEqualTo(new boolean[][] {{false,false}, {false,false}});
    }

    @Test
    void light_one_light() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(2);
        houseLightsGrid.turnOnLight(new Point(0,0));
        assertThat(houseLightsGrid.getLightsGrid()).isEqualTo(new boolean[][] {{true,false}, {false,false}});
    }

    @Test
    void light_multiple_lights() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(5);
        houseLightsGrid.turnOnMultipleLights(new Point(1,2), new Point(3,4));
        assertThat(houseLightsGrid.getLightsGrid()).isEqualTo(
            new boolean[][] {
                {false,false,false,false,false},
                {false,false,true,true,true},
                {false,false,true,true,true},
                {false,false,true,true,true},
                {false,false,false,false,false},
            }
        );
    }

    @Test
    void get_total_count_lights_on() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(5);
        houseLightsGrid.turnOnMultipleLights(new Point(1,2), new Point(3,4));
        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(9);
    }

    @Test
    void switch_off_one_light() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(4);
        houseLightsGrid.turnOnMultipleLights(new Point(0,0), new Point(3,3));

        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(16);
        houseLightsGrid.turnOffLight(new Point(0,0));
        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(15);
        assertThat(houseLightsGrid.getLightsGrid()[0][0]).isEqualTo(false);
    }

    @Test
    void switch_off_multiple_lights() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(4);
        houseLightsGrid.turnOnMultipleLights(new Point(0,0), new Point(3,3));

        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(16);

        houseLightsGrid.turnOffMultipleLights(new Point(0,0), new Point(2,2));
        System.out.println("Probando");
        System.out.println(Arrays.deepToString(houseLightsGrid.getLightsGrid()));
        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(7);
    }

    @Test
    void toggleMultipleLights() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(4);
        houseLightsGrid.turnOnMultipleLights(new Point(0,0), new Point(2,2));
        houseLightsGrid.toggleMultipleLights(new Point(0,0), new Point(3,3));
        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(7);
    }

    @Test
    void on_and_toggle_combinations() {
        HouseLightsGrid houseLightsGrid = new HouseLightsGrid(4);
        houseLightsGrid = new HouseLightsGrid(5);
        houseLightsGrid.turnOnMultipleLights(new Point(0,0),new Point(2,2));
        houseLightsGrid.turnOnLight(new Point(3,3));
        houseLightsGrid.toggleMultipleLights(new Point(0,0), new Point(3,3));
        assertThat(houseLightsGrid.getTotalCountLightsOn()).isEqualTo(6);
    }
}
