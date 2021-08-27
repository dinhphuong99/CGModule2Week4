package exercise.validate_class;

public class ClassNameExampleTest {
    private static ClassNameExample classNameExample;

    public static final String[] validClassNameExample = new String[] { "C0318G" };
    public static final String[] invalidClassNameExample = new String[] { " M0318G, P0323A" };

    public static void main(String args[]) {
        classNameExample = new ClassNameExample();
        for (String className : validClassNameExample) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class name number is " + className +" is valid: "+ isvalid);
        }

        for (String className : invalidClassNameExample) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class name is " + className +" is valid: "+ isvalid);
        }
    }
}