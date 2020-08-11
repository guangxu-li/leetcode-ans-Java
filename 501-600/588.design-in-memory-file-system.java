import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start
class FileSystem {
    Map<String, List<String>> dirs;
    Map<String, StringBuilder> files;

    public FileSystem() {
        dirs = new HashMap<>();
        dirs.put("/", new ArrayList<>());
        files = new HashMap<>();
    }

    public List<String> ls(String path) {
        List<String> output = new ArrayList<>();

        if (dirs.containsKey(path)) {
            output = dirs.get(path);
        }

        Collections.sort(output);

        return output;
    }

    public void mkdir(String path) {
        if (dirs.containsKey(path)) {
            return;
        }

        String[] folders = path.split("/");
        if (folders.length != 0) {
            String prevFolder = new String("/");
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < folders.length; i++) {
                String str = folders[i];

                sb.append("/");
                sb.append(str);
                String curFolder = sb.toString();

                if (!dirs.containsKey(curFolder)) {
                    dirs.get(prevFolder).add(str);
                    dirs.put(curFolder.toString(), new ArrayList<>());
                }

                prevFolder = curFolder.toString();
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        if (files.containsKey(filePath)) {
            files.get(filePath).append(content);

            return;
        }

        String[] folders = filePath.split("/");

        String prevFolder = new String("/");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < folders.length - 1; i++) {
            String str = folders[i];

            sb.append("/");
            sb.append(str);
            String curFolder = sb.toString();;

            if (!dirs.containsKey(curFolder)) {
                dirs.get(prevFolder).add(str);
                dirs.put(curFolder.toString(), new ArrayList<>());
            }

            prevFolder = curFolder.toString();
        }

        sb = new StringBuilder(content);
        files.put(filePath, sb);
        dirs.get(prevFolder).add(folders[folders.length - 1]);

        List<String> list = new ArrayList<>();
        list.add(folders[folders.length - 1]);
        dirs.put(filePath, list);
    }

    public String readContentFromFile(String filePath) {
        return files.get(filePath).toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end

