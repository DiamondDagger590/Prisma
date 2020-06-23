package us.eunoians.prisma;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class IOUtil {
  
  public static void saveResource(Prisma prisma, String resourcePath, boolean replace) {
    if (resourcePath != null && !resourcePath.equals("")) {
      resourcePath = resourcePath.replace('\\', '/');
      InputStream in = prisma.getResource(resourcePath);
      if (in == null) {
        throw new IllegalArgumentException("The embedded resource \'" + resourcePath + "\' cannot be found");
      } else {
        File outFile = new File(prisma.getDataFolder(), resourcePath);
        int lastIndex = resourcePath.lastIndexOf(47);
        File outDir = new File(prisma.getDataFolder(), resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));
        if (!outDir.exists()) {
          outDir.mkdirs();
        }
        try {
          if (outFile.exists() && !replace) {
            prisma.getLogger().log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
          } else {
            FileOutputStream ex = new FileOutputStream(outFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
              ex.write(buf, 0, len);
            }
            ex.close();
            in.close();
          }
        } catch (IOException var10) {
          prisma.getLogger().log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, var10);
        }
        
      }
    } else {
      throw new IllegalArgumentException("ResourcePath cannot be null or empty");
    }
  }
}
