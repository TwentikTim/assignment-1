public class Rectangle {

    
    private double width;
    private double height;
    private static int idGen = 0;
    private int id;


    public Rectangle() {
        this.id = idGen++;
        this.width = 1.0;
        this.height = 1.0;
    }


    public Rectangle(double width, double height) {
        this();
        setWidth(width);
        setHeight(height);
    }


    public int getId() {
        return id;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be > 0");
        }
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be > 0");
        }
        this.height = height;
    }


    public double area() {
        return width * height;
    }


    public double perimeter() {
        return 2 * (width + height);
    }
}
