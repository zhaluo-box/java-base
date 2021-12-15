package com.example.test.file;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.jar.JarFile;

/**
 *
 */
public class JarFileTest {

    @Test
    public void listJarFile() {
        var filePath = "C:\\workspace\\encoding\\201\\yibao-coordinator\\sync-task-app\\target\\yibao-coordinator-sync-task-app-2.0.0.jar";

        try {
            var jarFile = new JarFile(filePath);
            var entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                var jarEntry = entries.nextElement();
                if (!jarEntry.isDirectory()) {
                    System.out.println(jarEntry.getName());
                }
            }
            var entry = jarFile.getEntry("META-INF/nest/config.json");
            var inputStream = jarFile.getInputStream(entry);

            System.out.println(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
