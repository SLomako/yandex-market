package ru.lomakosv.constants;

public enum PermissionAction {

    WHILE_USING_APP("While using the app"),
    ONLY_THIS_TIME("Only this time"),
    DONT_ALLOW("Don’t allow"),
    SKIP("SKIP"),
    GOT_IT("GOT IT");

    private final String actionText;

    PermissionAction(String actionText) {
        this.actionText = actionText;
    }

    public String getActionText() {
        return this.actionText;
    }
}
