package optional;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try {
            // Code here
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
//            https://dantri.com.vn/the-gioi.htm
            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("aria-label=\"video-(.*?)\"");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
