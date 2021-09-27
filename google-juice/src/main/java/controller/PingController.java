package controller;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;

import java.util.Map;

public class PingController {

    private final Injector injector;

    @Inject
    public PingController(Injector injector){
        this.injector=injector;
    }

    public void get(){
        Map<Key<?>, Binding<?>> map = injector.getBindings();
        for(Map.Entry<Key<?>, Binding<?>> e : map.entrySet()){
            Binding binding = e.getValue();
            System.out.println(binding.getSource());
        }
    }
}
