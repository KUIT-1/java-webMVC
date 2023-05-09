package core.mvc;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private final View view;
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view){
        this.view = view;
    }

    public ModelAndView addObject(String key, Object value){
        model.put(key, value);
        //mov.addObject().addObject()~~
        return this;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
