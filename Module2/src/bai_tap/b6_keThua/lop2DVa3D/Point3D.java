package b6_keThua.lop2DVa3D;

public class Point3D extends Point2D {
    private float z;

    public Point3D(){
        super();
        this.z=0;
    };

    public Point3D(float x,float y,float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX() +
                "y=" + getY() +
                "z=" + z +
                '}';
    }
}

