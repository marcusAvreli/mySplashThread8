package mySplashThread8.events;

public class EventAllRowsSelected extends Event {

    
    
    public EventAllRowsSelected(Object source,Integer type) {
        super(source,Event.TYPE_ALL_ROWS_SELECTED);
    
        
    }

    

    @Override
    public boolean isUiUpdateTrigger() {
        return true;
    }


}
