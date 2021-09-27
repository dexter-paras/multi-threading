package part4_mapbinder;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Map;

/* Instead of using if-else factory method behavior, it keeps run-time bindings in mapBinder */
public class FileValidatorProvider implements Provider<FileValidator> {

    private final Map<String, FileValidator> mapBinder;

    @Inject
    public FileValidatorProvider(Map<String, FileValidator> mapBinder) {
        this.mapBinder = mapBinder;
    }

    @Override
    public FileValidator get() {
        return mapBinder.get("PerformanceFile");
    }

}
