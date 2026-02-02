package com.eventvol.util;

public class ActiveAssignmentsExistException extends Exception {
    public String toString() {
        return "Active assignments exist. Cannot delete.";
    }
}
