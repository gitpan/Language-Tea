//package pt.v1.tea.testapp;

class MainProgram {

    public static void main(String[] args) {
        try {
            java.util.Vector a = (new java.util.Vector());
            Util.append(a, new Object[] {new Integer(1), new Integer(2), new Integer(3), new Integer(4)});
            System.out.println((a.size()));
            Vector b = (Util.getElements(a));
            System.out.println((b.size()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
