import java.awt.*;
import java.util.Arrays;

public class HouseLightsGrid {
    private boolean[][] lightsGrid;
    private int totalCountLightsOn;
    public HouseLightsGrid(int numberOfLights) {
        this.lightsGrid = new boolean[numberOfLights][numberOfLights];
        Arrays.stream(this.lightsGrid).forEach(row -> Arrays.fill(row, false));
        this.totalCountLightsOn = 0;
    }

    public boolean[][] getLightsGrid() {
        return this.lightsGrid;
    }

    public void turnOnLight(Point point) {
        this.lightsGrid[point.x][point.y] = true;
        this.totalCountLightsOn++;
    }

    public void turnOffLight(Point point) {
        if (this.lightsGrid[point.x][point.y]) {
            this.lightsGrid[point.x][point.y] = false;
            this.totalCountLightsOn--;
        }
    }

    public void turnOnMultipleLights(Point fromPoint, Point toPoint) {
        this.switchMultipleLights(fromPoint, toPoint, true);
    }


    public void turnOffMultipleLights(Point fromPoint, Point toPoint) {
        this.switchMultipleLights(fromPoint, toPoint, false);
    }

    public void toggleMultipleLights(Point fromPoint, Point toPoint) {
        int untilWhichRow = fromPoint.x + (toPoint.x - fromPoint.x + 1);
        int untilWhichColumn = fromPoint.y + (toPoint.y - fromPoint.y + 1);
        for (int x = fromPoint.x; x < untilWhichRow; x++) {
            for (int y = fromPoint.y; y < untilWhichColumn; y++) {
                this.lightsGrid[x][y] = !this.lightsGrid[x][y];
                this.totalCountLightsOn += (this.lightsGrid[x][y]) ? 1 : -1;
            }
        }
    }

    public int getTotalCountLightsOn() {
        return this.totalCountLightsOn;
    }
    private void switchMultipleLights(Point fromPoint, Point toPoint, boolean setLightsTo) {
        int untilWhichRow = fromPoint.x + (toPoint.x - fromPoint.x + 1);
        int untilWhichColumn = fromPoint.y + (toPoint.y - fromPoint.y + 1);
        for (int x = fromPoint.x; x < untilWhichRow; x++) {
            for (int y = fromPoint.y; y < untilWhichColumn; y++) {
                if (this.lightsGrid[x][y] != setLightsTo) {
                    this.lightsGrid[x][y] = setLightsTo;
                    this.totalCountLightsOn += (setLightsTo) ? 1 : -1;
                }
            }
        }
    }
}
