package lili.generic;

/**
 * Created by lili on 15/3/12.
 *
 * ? 通配符，可以接受任意类型的泛型
 */
public class GenericsDemo14 {
    public static void main(String args[]){
        Info<String> i = new Info<String>() ;       // 使用String为泛型类型
        i.setVar("it") ;                            // 设置内容
        fun(i) ;
    }
    public static void fun(Info<?> temp){     // 可以接收任意的泛型对象
        System.out.println("内容：" + temp) ;
    }

}
class Info<T>{
    private T var ;     // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    public String toString(){   // 直接打印
        return this.var.toString() ;
    }
}
