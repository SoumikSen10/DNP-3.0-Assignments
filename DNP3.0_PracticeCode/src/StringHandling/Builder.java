package StringHandling;
//StringBuilder is not thread-safe and synchronized
public class Builder
{
    public static void main(String[] args)
    {
        StringBuilder sb=new StringBuilder("Hello ");
        sb.append("Java"); //original string is changed
        System.out.println(sb);
        sb.insert(5," from");
        System.out.println(sb);
        sb.replace(5,10," there");
        System.out.println(sb);
        sb.delete(5,11);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb.capacity()); //now 21
        sb.insert(5," there from my favourite language"); //now (21*2)+2 = 44  i.e. (oldcapacity*2)+2
        System.out.println(sb.capacity());
        sb.ensureCapacity(50);
        System.out.println(sb.capacity());
    }
}
