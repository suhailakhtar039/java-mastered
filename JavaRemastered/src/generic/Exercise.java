package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface IMappable {
    void render();

    static double[] stringToLatLon(String location) {
        String[] splits = location.split(",");
        double lat = Double.parseDouble(splits[0]);
        double lng = Double.parseDouble(splits[1]);
        return new double[]{lat, lng};
    }

}

abstract class Point implements IMappable {

    private double[] location = new double[2];

    public Point(String location) {
        this.location = IMappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT ( " + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}

abstract class Line implements IMappable {

    private double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int idx = 0;
        for (var l : locations) {
            this.locations[idx++] = IMappable.stringToLatLon(l);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + "as Line ( " + locations() + " )");
    }

    private String locations() {
        return Arrays.deepToString(locations);
    }

}

class Park extends Point {
    private String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " National Park";
    }
}

class River extends Line {
    private String name;

    public River(String name, String... location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " River";
    }
}

class Layer<T extends IMappable> {
    private List<T> layerElements;

    public Layer(T[] layerElements) {
        this.layerElements = new ArrayList<T>(List.of(layerElements));
    }

    public void addElements(T... elements) {
        layerElements.addAll(List.of(elements));
    }

    public void renderLayer() {
        for (T element : layerElements) {
            element.render();
        }
    }

}


public class Exercise {
    public static void main(String[] args) {
        var nationalPark = new Park[]{
                new Park("YellowStone", "44.5, 22.89"),
                new Park("Grand Canyon", "-33.4, -12.4"),
                new Park("Yosemite", "56.3, 51.2")
        };

        Layer<Park> parkLayer = new Layer<>(nationalPark);
        parkLayer.renderLayer();
    }
}
