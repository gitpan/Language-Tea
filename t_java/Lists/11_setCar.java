//package pt.v1.tea.testapp;

class MainProgram {

    public static void main(String[] args) {
        try {
            Vector a = new Vector();
            a.add(new Integer(1));
            a.add(new Integer(2));
            a.add(new Integer(3));
            System.out.println((a.get(0)));
            a.set(0, new Integer(44));
            System.out.println((a.get(0)));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
