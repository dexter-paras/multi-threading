package interf;

import com.google.inject.ImplementedBy;
import interfImpl.LWATokenGenerator;

// Another way of injecting dependency to interface rather than using Module
@ImplementedBy(LWATokenGenerator.class)
public interface TokenGenerator {
    String getToken();
}