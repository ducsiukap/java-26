package java005_interfaces;

import java.util.LinkedHashMap;
import java.util.Map;

// ===============
// nested interface bên trong class
// -> interface chỉ liên quan tới class đó
// - modifer: public, protected, default, private
// - ALWAYS is STATIC
class Button {

    // Khác với nested class (class bên trong class)
    // - nested class / static class -> chỉ truy cập được static member của class
    // ngoài, sử dụng `static keyword`
    // - inner class / non-static class -> truy cập mọi member của classs bên ngoài,
    // no-keyword

    // Nested interface bên trong classs chỉ có duy nhất một loại: (static // ngầm
    // định) interface
    // -> chỉ truy cập được static member của class ngoài
    interface OnClickListener {
        void onClick();
    }

    // thường có 1 prop là cái interface nested
    public OnClickListener listener;

    // thường thêm 1 hàm gắn nested interface cho object
    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }
}

// ===============
// Nested interface bên trong interface
// - public modifier only
// - static only
// Mục đính: gom nhóm
// -> nested interface đóng vai trò như 1 danh mục con của cái interface to
// // // => đóng vai trò là phần tử của các class implement interface cha
// -> là phần tử phục vụ cho các method // input/output của method
// -> hoặc duyệt ..
// ex: Map vs Entry -> Map là tập hợp các Entry
// note: thường ít dùng, 90% dùng nested interface bên trong class

public class nestedInterface {
    public static void main(String[] args) {
        System.out.println();

        // nested interface in class
        Button btn = new Button();
        // ===============
        // 3 cách định nghĩa nested interface cho class
        // ---------------
        // 1. tạo class implement bên ngoài
        // class OnClickImpl implements Button.OnClickListener {
        // @Override
        // public void onClick() {
        // // TODO Auto-generated method stub
        // }}
        // ---------------
        // 2. anonymous inner class
        // btn.setListener(new Button.OnClickListener() {
        // @Override
        // public void onClick() {
        // System.out.println("Button is clicked!");
        // }
        // });
        // ---------------
        // 3. thường nested là functional interface -> sử dụng cú pháp lambda
        btn.setListener(() -> {
            System.out.println("Button btn is clicked!");
        });

        // click
        btn.listener.onClick();
        btn.listener.onClick();

        // ===============
        // nested interface bên trong interface
        System.out.println();
        Map.Entry<Integer, Integer> entry = Map.entry(3, 5);
        // các class implememnt class ngoài
        // sẽ chứa collection các instance của nested interface
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // map.entrySet().add(entry); // exception:
        // java.lang.UnsupportedOperationException
        map.put(entry.getKey(), entry.getValue());
        map.forEach((Integer k, Integer v) -> {
            System.out.println(k + " : " + v);
        });

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
