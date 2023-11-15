/**
 * @author chibuzo okpara
 */

import java.util.EventObject;

public class UnoGameEvent extends EventObject {
    public enum EventType {
        CARD_PLAYED,
        TURN_CHANGED,
        CARD_DRAWN,
        GAME_STARTED,
        GAME_ENDED,
        DIRECTION_CHANGED
    }

    private final EventType eventType;
    private final Object eventData; // General-purpose field to hold event data

    public UnoGameEvent(Game model, EventType eventType, Object eventData) {
        super(model);
        this.eventType = eventType;
        this.eventData = eventData;
    }

    /**
     *
     * @return
     */
    public EventType getEventType() {
        return eventType;
    }

    public Object getEventData() {
        return eventData;
    }
}
