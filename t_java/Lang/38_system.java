//package pt.v1.tea.testapp;

class MainProgram {

    public static void main(String[] args) {
        try {
            Lang.system("ls -l");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
