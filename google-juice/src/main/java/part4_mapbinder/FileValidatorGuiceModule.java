package part4_mapbinder;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/* Configure impl classes based on fileName
*  Instead of using if-else factory method behavior, it keeps run-time bindings in mapBinder
*/
public class FileValidatorGuiceModule extends AbstractModule {

    @Override
    protected void configure() {

        MapBinder<String, FileValidator> mapBinder = MapBinder.newMapBinder
                (binder(), String.class, FileValidator.class);

        mapBinder.addBinding("ScoreCardFile").to(ScoreCardFileValidator.class);
        mapBinder.addBinding("PerformanceFile").to(PerformanceMetricsFileValidator.class);

        bind(FileValidator.class).toProvider(FileValidatorProvider.class);
    }

}
