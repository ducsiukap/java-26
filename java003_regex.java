import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class java003_regex {
    // java.util.regex package throw PatternSyntaxException
    public static void main(String[] args) throws PatternSyntaxException {
        System.out.println();

        String regex = ".*\\.java";
        String[] files = { "AX.java", "app.java", "server.py", "app.js" };
        // 1. Pattern class
        // ---------------
        // Pattern static method
        // .matches(String regex, CharSequence input) // full-string match
        for (String f : files) {
            System.out.print(Pattern.matches(regex, f) + "\t");
            // or
            // str.matches(regex)
            // System.out.println(f.matches(regex));
        }
        System.out.println();
        // or
        // ---------------
        // Object method
        // .compile(regex) -> create pattern object
        Pattern pattern = Pattern.compile(regex);
        // or compile with flag:
        // .compile(regex, int flag)
        // - flag=Pattern.CASE_INSENSITIVE => case insensitve
        // - flag=Pattern.MULTILINE => ^ and $ applied for each line
        // - flag=Pattern.DOTALL => . match cả \n
        // - flag=Pattern.UNICODE_CASE => unicode case insensitive
        // - flag=Pattern.COMMENT => allow comment in regex
        // - flag=Pattern.LITERAL => regex được hiểu như chuỗi thông thường

        // .pattern() -> to get the regex string
        System.out.printf("pattern: %s%n", pattern.pattern());
        // .matcher(CharSequence input) // returns a Matcher object
        // .split(CharSequence input) // splits input based on the pattern
        // ---------------
        // String classs method:
        // .maches(regex)
        // .replaceFirst(regex, str) / .replaceAll(regex, str)

        // ---------------
        // espace in regex:
        // "." for any one-character
        // "\n", "\t" => newline / tab

        // [abc], [a-z], [A-Z], [0-9] => 1 ký tự bất kỳ trong abc / a-z / A-Z/ 0-9
        // [^abc] => không phải 1 trong các ký tự a, b, c

        // "\\" for \
        // "\\d" / "\\D" for \d / \D => a number / not a number
        // "\\w" => a character [a-zA-Z0-9_] // number, character or _
        // "\\W" => not a character [a-zA-Z0-9_]
        // "\s" => space / tab/ newline // whitespace
        // "\\S" => not a whitespace

        // "*" => 0 or more
        // "+" => 1 or more
        // "?" => 0 or 1
        // {n} => exact n time
        // {n,} => ít nhất n lần
        // {n, m} => từ n -> m lần

        // "^" => begin of string
        // "$" => end of string
        // "\b" => đầu/cuối ký tự // ex: \bcat\b chỉ match cat chứ không match scatter
        // "\B" => ko phải đầu/cuối ký tự // ex cat\B chỉ match scatter, không match cat

        // escape
        // . ^ $ * + ? ( ) [ ] { } | \
        // => phải thêm "\" phía trước nếu muốn nó thực sự là các ký tự đó trong string
        // ex: "\.", "\("

        // group => using ()
        // () => capturing group // có thể dùng với group() / groupCount()
        // (?:) => non-capturing group // ko thể dùng với group() / groupCount()
        // (?<name>) => named group => matcher.group("name")
        // \1, \2 => tham chiếu lại nội dung .group(1), .group(2) vừa match
        // ex: (\w+)\s\1:
        // - "hi hi" => match
        // - "hi world" => no-match
        // - "java java" => match

        // "|" for or
        // ex: (?:jpg|png|gif) => jpg or png or gif

        // lookaround
        // (?=abc) => phía sau là abc
        // (?!abc) => phía sau không là abc
        // (?<=abc) => phía trước là abc
        // (?<!abc) => phía trước không là abc

        String images = "a.gif b.tif c.svg d.png e.svg";
        String acceptableImage = "\\w+\\.(?:png|jpg|gif)";
        Matcher m = Pattern.compile(acceptableImage).matcher(images);
        System.out.println("\nmatched image: ");
        while (m.find()) {
            System.out.println(m.group());
        }

        // ---------------
        System.out.println();
        // 2. Matcher class
        // using pattern.matcher(input) to create Matcher object
        String test = "A.java b.py c.java server.java client.js";
        Matcher matcher = pattern.matcher(test);
        // methods
        // .usePattern(Pattern newPattern) => change the pattern
        // .reset() => re-match / reset matcher
        // .region(start, end) => match in range

        // .lookingAt() => kiểm tra khớp regex từ đầu chuỗi (không cần hết chuỗi)
        System.out.println(matcher.lookingAt());
        // .find() => tìm đoạn con khớp regex
        // .start(), .end() => return start/end index of a match
        // .group() or group(0) => lấy kết quả của match hiện tại (toàn bộ match)
        // .group(n) => kết quả group nhóm thứ n // nhóm là pattern được đặt trong ()
        // ex: (\\d{4})-(\\d{2})-(\\d{2}) => 3 nhóm
        // .groupCount() => đếm số group trong pattern
        // note: // không tính group(0) / non-capturing group (?:...)
        matcher.reset();
        while (matcher.find()) {
            int start = matcher.start(), end = matcher.end();
            System.out.printf("Match found from index %d to index %d:%n\tmatched string: %s%n\tgroup count: %d%n",
                    start, end, matcher.group(), matcher.groupCount());
        }
        // System.out.println(matcher.find());
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
