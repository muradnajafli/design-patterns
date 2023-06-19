package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class CommitToBranchWebHook implements WebHook{
    private String branchName;
    private final List<Event> caughEvents = new ArrayList<>();

    public CommitToBranchWebHook(String branchName) {
        this.branchName = branchName;
    }
    @Override
    public String branch() {
        return branchName;
    }

    @Override
    public Event.Type type() {
        return Event.Type.COMMIT;
    }

    @Override
    public List<Event> caughtEvents() {
        return caughEvents;
    }

    @Override
    public void onEvent(Event event) {
        caughEvents.add(event);

    }

    @Override
    public String toString() {
        return caughEvents.toString();
    }
}
