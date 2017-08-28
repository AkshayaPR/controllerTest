package com.event;
import com.event.bean.Event;
import com.event.bean.Agenda;
import java.util.*;

public class EventBuilder {
  private Event event = new Event();
  private List<Agenda> agenda;

  public EventBuilder id(Long id) {
	  event.seteId(id);
    return this;
  }
  
  public EventBuilder edition(int edition) {
	  event.seteEdition(edition);
    return this;
  }
   public EventBuilder fulldate(String fulldate) {
	  event.seteFullDte(fulldate);
    return this;
  }
   public EventBuilder date(String date) {
	  event.seteDate(date);
    return this;
  }
   public EventBuilder month(String month) {
	  event.seteMonth(month);
    return this;
  }
   public EventBuilder location(String location) {
	  event.seteLocation(location);
    return this;
  }
   public EventBuilder active(boolean active) {
	  event.seteIsActive(active);
    return this;
  }
   public EventBuilder agenda(List<Agenda> agenda) {
	  event.setAgenda(agenda);
    return this;
  }
  
  
  public Event build() {
    return event;
  }
}
