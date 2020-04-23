package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-19 23:14
 **/
public class DirList {

    public static void main(String[] args) {
        File path = new File("./");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFileter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER); // 按照字母进行排序
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }


}

class DirFileter implements FilenameFilter{

    private Pattern pattern;

    public DirFileter(String regex){
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
