public class Point {
    private double x;
    private double y;
    private double z;


    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(String str){
        String[] xyz = str.split(", ");
        this.x = Float.parseFloat(xyz[0]);
        this.y = Float.parseFloat(xyz[1]);
        this.z = Integer.parseInt(xyz[2]);
    }

    public double getZ() {
        return z;
    }

    public Point scale(double scaleFactor){
        return new Point(this.x * scaleFactor, this.y * scaleFactor, this.z * scaleFactor);
    }

    public Point translate(double x, double y){
        return new Point(this.x + x, this.y + y, this.z);
    }

    @Override
    public String toString(){
        return x + ", " + y + ", " + z;
    }
}
