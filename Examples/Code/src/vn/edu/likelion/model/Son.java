package vn.edu.likelion.model;

public class Son extends Father {
    String address;


        @Override
        public void goiAnCom() {
            System.out.println("Ko an com");
        }

        public void abc() {
            super.goiAnCom();
        }
}
