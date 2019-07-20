public class DeprecatedAnnotation {

    /**
     * @deprecated Method is deprecated. Please use new method display(int x)
     */
    @Deprecated
    public void display() {
        System.out.println("display() method");
    }

    public static void main(String[] args) {
        DeprecatedAnnotation obj = new DeprecatedAnnotation();
        obj.display();
    }
}