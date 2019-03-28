package ETC;

class Shape{
    int x,y;
    Shape(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int area(){
        return x*y;
    }

    public static void main(String[] args) {
        Shape shape = new Shape(3,2);
        Shape shape2 = shape;
        shape2.x = 1;
        shape2.y = 1;
        System.out.println(shape.area());
        System.out.println(shape2.area());

    }
}
