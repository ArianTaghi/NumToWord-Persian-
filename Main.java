import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
    public static String NTW (Long number) {
        String arr2[] = new String[]{"", " هزار ", " میلیون ", " میلیارد ",
                " تریلیون ", " کوادریلیون ", " کویینتیلیون "};

        String ans = "";
        if (number == 0)                        //بررسی صفر
            ans += "صفر";
        else {
            if (number < 0) {                   //بررسی منفی
                ans += "منفی ";
                number *= -1;
            }
            int arr[] = new int[7];
            for (int i = 0; i <= 6; i++) {
                arr[i] = (int) (number % 1000L);    //تقسیم عدد به گروه رقم های سه تایی
                number /= 1000L;
            }
            for (int i = 6; i >= 0; i--)            //چاپ هر گروه سه تایی از ارقام
                if (arr[i] != 0) {
                    ans += Main.method1(arr[i]);
                    ans += arr2[i];      //افزودن پسوند مناسب هر گروه
                    for (int j = 0; j < i; j++)         //افزودن و در صورت نیاز
                        if (arr[j] != 0) {
                            ans += "و ";
                            break;
                        }
                }
        }
        return ans;
    }
    public static String method1 (int a) {

        String ans = "";
        int hundred = a / 100;       //محاسبه صدگان
        int ten = (a / 10) % 10;     //محاسبه دهگان
        int one = a % 10;            //محاسبه یکان
        Boolean exeptionMode = false;      //اثتثنا برای دهگان در صورتی که یک باشد
        String hunndredArr[] = new String[]{"", "یکصد", "دویست", "سیصد", "چهارصد",
                "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد"};     //آرایه صدگان ها
        String tenArr[] = new String[]{"", "", "بیست", "سی", "چهل",
                "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};       //آرایه دهگان ها
        String ten2Arr[] = new String[]{"ده", "یازده", "دوازده", "سیزده", "چهارده",
                "پانزده", "شانزده", "هفده", "هیجده", "نوزده"};  //آرایه ده تا نوزده
        String oneArr[] = new String[]{"", "یک", "دو", "سه", "چهار",
                "پنج", "شش", "هفت", "هشت", "نه"};               //آرایه یکان ها
        ans += hunndredArr[hundred];
        if (ten != 0 && hundred != 0)     //افزودن و در صورت نیاز
            ans  += " و ";
        if (ten == 1) {
            ans += ten2Arr[one];
            exeptionMode = true;
        } else
            ans += tenArr[ten];
        if (!exeptionMode) {       //اگر استثنا فعال باشد یکان دوباره محاسبه نمیگردد

            if (one != 0 && (hundred != 0 || ten != 0))      //افزودن و در صورت نیاز
                ans += " و ";
            ans += oneArr[one];
        }
        return ans;
    }
}
