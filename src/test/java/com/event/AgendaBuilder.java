package com.event;
import com.event.bean.Event;
import com.event.bean.Agenda;

public class AgendaBuilder {
  private Agenda agenda = new Agenda();
  private Event event;
  
  public AgendaBuilder id(Long id) {
	 agenda.setId(id);
    return this;
  }
  
  public AgendaBuilder time(String time) {
	agenda.setaTime(time);
    return this;
  }

   public AgendaBuilder desc(String desc) {
	agenda.setA_desc(desc);
    return this;
  }

   public AgendaBuilder ins(String ins) {
	agenda.setA_ins(ins);
    return this;
  }
   
  
   public Agenda build() {
    return agenda;
  }
}
