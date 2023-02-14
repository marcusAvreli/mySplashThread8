package mySplashThread8.events;

public class OnLoadPaneView extends Event {

    
    
    public OnLoadPaneView(Object source,Object payload) {
        super(source,Event.TYPE_LOAD_PANE_VIEW,payload);
    
        
    }

    

    @Override
    public boolean isUiUpdateTrigger() {
        return true;
    }


}