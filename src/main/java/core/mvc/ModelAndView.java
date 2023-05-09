package core.mvc;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private View view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view){
        this.view = view;
    }

    public ModelAndView addObject(String key, Object value){
        model.put(key, value);
        // ModelAndView을 반환하게 하여
        // chain이 가능하게! model.addObject(~).addObject(~).addObject(~)...
        return this;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
