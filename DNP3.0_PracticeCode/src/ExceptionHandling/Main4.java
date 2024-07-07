package ExceptionHandling;

import java.io.IOException;

// Exception Propagation
public class Main4
{
    void m() throws IOException {
        throw new java.io.IOException("device error");//checked exception
    }
    void n() throws IOException {
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handeled");}
    }
    public static void main(String args[]){
        Main4 obj=new Main4();
        obj.p();
        System.out.println("normal flow");
    }
}
