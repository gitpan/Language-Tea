//package pt.v1.tea.testapp;

class MainProgram {

    public static void main(String[] args) {
        try {
            Vector a = new Vector();
            a.add(new Integer(1));
            a.add(new Integer(2));
            System.out.println((a.size()));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
