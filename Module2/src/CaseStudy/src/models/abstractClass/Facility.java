package models.abstractClass;

public abstract class Facility {
    public String name;
    public double area;
    public double price;
    public int peopleMax;
    public String styleRental;

    public Facility(){}

    public Facility(String name, double area, double price, int peopleMax, String styleRental) {
        this.name=name;
        this.area = area;
        this.price = price;
        this.peopleMax=peopleMax;
        this.styleRental=styleRental;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", people max="+ peopleMax+
                ", style rental='"+styleRental+'\''+
                '}';
    }
}
