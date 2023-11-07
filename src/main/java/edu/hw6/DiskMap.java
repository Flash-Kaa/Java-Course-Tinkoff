package edu.hw6;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiskMap implements Map<String, String> {
    private final HashMap<String, String> map = new HashMap<>();

    public DiskMap(String name) {
        if (new File(name + ".txt").exists()) {
            readFromFile(name);
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        return map.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    public void writeToFile(String name) {
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            for (var i : map.keySet()) {
                writer.write(String.format("%s:%s\n", i, map.get(i)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile(String name) {
        try (FileReader reader = new FileReader(name + ".txt")) {
            var sb = new StringBuilder();
            var character = reader.read();

            while (character != -1) {
                sb.append((char) character);
                character = reader.read();
            }

            var lines = sb.toString().split("\n");
            for (var i : lines) {
                if (i.isEmpty()) {
                    break;
                }

                var m = i.split(":");
                map.put(m[0], m[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
