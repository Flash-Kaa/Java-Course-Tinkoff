package edu.hw6.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final String fileName;

    public DiskMap(String fileName) {
        this.fileName = fileName;
        var file = new File(fileName);

        if (file.exists()) {
            readFromFile();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public int size() {
        return readFromFile().size();
    }

    @Override
    public boolean isEmpty() {
        return readFromFile().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return readFromFile().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readFromFile().containsValue(value);
    }

    @Override
    public String get(Object key) {
        return readFromFile().get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        Map<String, String> map = readFromFile();
        String res = map.put(key, value);
        writeToFile(map);
        return res;
    }

    @Override
    public String remove(Object key) {
        Map<String, String> map = readFromFile();
        String res = map.remove(key);
        writeToFile(map);
        return res;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        Map<String, String> map = readFromFile();
        map.putAll(m);
        writeToFile(map);
    }

    @Override
    public void clear() {
        Map<String, String> map = readFromFile();
        map.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return readFromFile().keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return readFromFile().values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return readFromFile().entrySet();
    }

    private void writeToFile(Map<String, String> map) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String i : map.keySet()) {
                writer.write(String.format("%s:%s\n", i, map.get(i)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> readFromFile() {
        Map<String, String> map = new HashMap<>();
        try (FileInputStream reader = new FileInputStream(fileName)) {
            StringBuilder sb = new StringBuilder();
            byte[] bytes = reader.readAllBytes();

            char character;
            for (int i = 0; i < bytes.length && bytes[i] > 0; i++) {
                character = (char) bytes[i];
                sb.append(character);
            }

            String[] lines = sb.toString().split("\n");
            for (String i : lines) {
                if (i.isEmpty()) {
                    break;
                }

                String[] m = i.split(":");
                map.put(m[0], m[1]);
            }

            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
