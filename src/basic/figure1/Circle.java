package basic.figure1;

//正円クラス
class Circle {
    //フィールド
    private double radius;//半径

    //コンストラクタ
    public Circle(double radius) {
        this.radius = radius;
    }

    //ゲッター
    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String toString() {
        //https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/lang/String.html#format(java.lang.String,java.lang.Object...)
        //https://java-code.jp/173
        return String.format("円 半径:%.2f 面積:%.2f",
                radius,getArea());
    }
}
