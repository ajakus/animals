import java.io.Serializable;

public class Wall  implements Serializable {

    private double width;
    private double height;

    public Wall(double width, double height) throws BadWidthException, BadHeightException {
        this.width = width;

        if (width <= 0) {
            throw new BadWidthException("Width must be greater than zero!");
        }

        this.height = height;

        if (height <= 0) {
            throw new BadHeightException("Height must be greater than zero!");
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return "Wall{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
