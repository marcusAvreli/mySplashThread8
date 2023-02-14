package mySplashThread8.events;

public class EventRowSelectionChanged extends Event {

    
    
    public EventRowSelectionChanged(Object source,Integer type, Object payload) {
        super(source,Event.TYPE_ROW_SELECTION_CHANGED,payload);
    
        
    }

    

    @Override
    public boolean isUiUpdateTrigger() {
        return true;
    }


}
