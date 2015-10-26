package workshop.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class BookRemover {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRemover.class);
    private File baseDir;

    public BookRemover(File baseDir) {
        this.baseDir = baseDir;
    }

    public void remove(Long id) {
        File file = new File(baseDir, "book_" + id + ".json");
        LOGGER.info("Removing file={}", file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
    }

}
